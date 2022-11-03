package pgm.poolp.blocages.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import pgm.poolp.blocages.game.builders.GameFactory
import pgm.poolp.blocages.game.interfaces.Player
import javax.inject.Inject

@HiltViewModel
class BlocagesViewModel @Inject internal constructor() : ViewModel()
{
    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun setLoading(value:Boolean) {
        _isLoading.value = value
    }

    fun blocages(gameFactory: GameFactory): Flow<Player> = flow {

        val players = mutableListOf<Player>()
        for (i in 0 until 100_000) {
            players.add(gameFactory.randomPlayer())
        }

        players.forEach { player ->
            emit(player)
        }
    }
}