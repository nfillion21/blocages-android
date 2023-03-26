package pgm.poolp.blocages.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
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

    fun diceFlow(): Flow<Dice> = flow {
        for (i in 0 until 100_000) {
            emit(Dice.values().random())
        }
    }
}