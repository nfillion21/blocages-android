package pgm.poolp.blocages

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.primarySurface
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import pgm.poolp.blocages.game.utils.Dice
import pgm.poolp.blocages.ui.theme.BlocagesTheme
import pgm.poolp.blocages.viewmodels.BlocagesViewModel

class MainActivity : ComponentActivity() {

    private lateinit var blocagesViewModel: BlocagesViewModel
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            blocagesViewModel = hiltViewModel()

            BlocagesTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    floatingActionButton = {
                        androidx.compose.material.ExtendedFloatingActionButton(
                            text = { androidx.compose.material.Text(text = "Overwhelming food") },
                            icon = { androidx.compose.material.Icon(Icons.Rounded.PlayArrow, "") },
                            onClick = { increaseByTen() }
                        )
                    },
                ) {
                    //Greeting(blocagesViewModel = blocagesViewModel)
                }
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val blocagesViewModel: BlocagesViewModel = hiltViewModel()
                    Greeting(blocagesViewModel = blocagesViewModel)
                }
                */
            }
        }
    }

    private fun increaseByTen() {

        //val mutableDicesList = mutableListOf<Dice>()
        var kerrunchCount = 0
        var missCount = 0
        var shoveOneCount = 0
        var shoveTwoCount = 0
        var tacleCount = 0
        var smashCount = 0

        lifecycleScope.launch {
            blocagesViewModel.diceFlow()
                .flowOn(Dispatchers.Default)
                .onStart {
                    // button switch to stop
                }
                .onEach {
                    when (it)  {
                        Dice.KERRUNCH -> kerrunchCount++
                        Dice.MISS -> missCount++
                        Dice.SHOVE_1 -> shoveOneCount++
                        Dice.SHOVE_2 -> shoveTwoCount++
                        Dice.TACLE -> tacleCount++
                        Dice.SMASH -> smashCount++
                    }
                }
                .onCompletion {
                    // button switch to start
                }
                .collect {
                    //mutableDicesList.add(it)
                    Log.i("dice", it.description)
                }
        }
    }
}

@Composable
fun Greeting(blocagesViewModel: BlocagesViewModel) {

    // what we'll do.
    // dice launch
    // we'll launch 100_000 dices, then count for each result.
    // let's begin with that.
    //

    val composableScope = rememberCoroutineScope()
    Button(
        onClick = {
            //val mutableDicesList = mutableListOf<Dice>()
            var kerrunchCount = 0
            var missCount = 0
            var shoveOneCount = 0
            var shoveTwoCount = 0
            var tacleCount = 0
            var smashCount = 0

            composableScope.launch {
                blocagesViewModel.diceFlow()
                    .flowOn(Dispatchers.Default)
                    .onStart {
                        // button switch to stop
                    }
                    .onEach {
                        when (it) {
                            Dice.KERRUNCH -> kerrunchCount++
                            Dice.MISS -> missCount++
                            Dice.SHOVE_1 -> shoveOneCount++
                            Dice.SHOVE_2 -> shoveTwoCount++
                            Dice.TACLE -> tacleCount++
                            Dice.SMASH -> smashCount++
                        }
                    }
                    .onCompletion {
                        // button switch to start
                    }
                    .collect()

                //mutableDicesList.add(it)
                //Log.i("dice", mutableDicesList.size.toString())
                //Log.i("dice", it.description)

            }
        }
    ) { }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlocagesTheme {
    }
}