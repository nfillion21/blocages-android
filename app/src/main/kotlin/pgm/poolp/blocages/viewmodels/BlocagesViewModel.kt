package pgm.poolp.blocages.viewmodels

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import okhttp3.internal.toImmutableMap
import pgm.poolp.blocages.game.builders.GameFactory
import pgm.poolp.blocages.game.interfaces.Player
import pgm.poolp.blocages.game.utils.Dice
import javax.inject.Inject

@HiltViewModel
class BlocagesViewModel @Inject internal constructor() : ViewModel()
{
    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun setLoading(value:Boolean) {
        _isLoading.value = value
    }

    fun playersFlow(gameFactory: GameFactory): Flow<Player> = flow {
        for (i in 0 until 100_000) {
            emit(gameFactory.randomPlayer())
        }
    }

    private val _dices = MutableStateFlow(mapOf<String, Float>())
    val dices: StateFlow<Map<String, Float>> = _dices

    private var results = mutableStateMapOf<String, Float>()
    val dicesFlow = flow<Map<String, Float>> {

        val count = 1_000
        var kerrunchCount = 0
        var missCount = 0
        var shoveCount = 0
        var tackleCount = 0
        var smashCount = 0

        for (i in 0 until count) {

            delay(1)

            when (Dice.values().random())  {
                Dice.KERRUNCH -> {
                    kerrunchCount++
                    results["Kerrunch"] = kerrunchCount.toFloat().div(count).times(100f)
                }
                Dice.MISS -> {
                    missCount++
                    results["Miss"] = missCount.toFloat().div(count).times(100f)
                }
                Dice.SHOVE_1 -> {
                    shoveCount++
                    results["ShoveOne"] = shoveCount.toFloat().div(count).times(100f)
                }
                Dice.SHOVE_2 -> {
                    shoveCount++
                    results["ShoveTwo"] = shoveCount.toFloat().div(count).times(100f)
                }
                Dice.TACKLE -> {
                    tackleCount++
                    results["Tackle"] = tackleCount.toFloat().div(count).times(100f)
                }
                Dice.SMASH -> {
                    smashCount++
                    results["Smash"] = smashCount.toFloat().div(count).times(100f)
                }
            }

            emit(results)
            //_dices.value = results
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, mapOf())
}