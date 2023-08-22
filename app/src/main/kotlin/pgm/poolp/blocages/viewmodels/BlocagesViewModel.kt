package pgm.poolp.blocages.viewmodels

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

    private var secondsCounter = 0
    val secondsPassed = flow {
        while (true) {
            delay(1000)
            secondsCounter += 1
            emit(secondsCounter)
        }
    }.stateIn(viewModelScope,SharingStarted.Lazily,0)

    val dicesFlow = flow<Map<String, Float>> {

        val count = 1_000_000
        val results = mutableMapOf<String, Float>()
        var kerrunchCount = 0
        var missCount = 0
        var shoveOneCount = 0
        var shoveTwoCount = 0
        var tackleCount = 0
        var smashCount = 0

        for (i in 0 until count) {

            delay(1)

            when (Dice.values().random())  {
                Dice.KERRUNCH -> {
                    kerrunchCount++
                    //results["Kerrunch"] = kerrunchCount.toFloat().div(count).times(100f)
                    results["Kerrunch"] = kerrunchCount.toFloat()
                }
                Dice.MISS -> {
                    missCount++
                    //results["Miss"] = missCount.toFloat().div(count).times(100f)
                    results["Miss"] = missCount.toFloat()
                }
                Dice.SHOVE_1 -> {
                    shoveOneCount++
                    //results["ShoveOne"] = shoveOneCount.toFloat().div(count).times(100f)
                    results["ShoveOne"] = shoveOneCount.toFloat()
                }
                Dice.SHOVE_2 -> {
                    shoveTwoCount++
                    //results["ShoveTwo"] = shoveTwoCount.toFloat().div(count).times(100f)
                    results["ShoveTwo"] = shoveTwoCount.toFloat()
                }
                Dice.TACKLE -> {
                    tackleCount++
                    //results["Tackle"] = tackleCount.toFloat().div(count).times(100f)
                    results["Tackle"] = tackleCount.toFloat()
                }
                Dice.SMASH -> {
                    smashCount++
                    //results["Smash"] = smashCount.toFloat().div(count).times(100f)
                    results["Smash"] = smashCount.toFloat()
                }
            }
            emit(results)
        }
    }//.stateIn(viewModelScope,SharingStarted.Lazily, mapOf())
}