package pgm.poolp.blocages

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import pgm.poolp.blocages.game.utils.Dice
import pgm.poolp.blocages.navigation.JetsurveyNavHost
import pgm.poolp.blocages.ui.theme.BlocagesTheme
import pgm.poolp.blocages.viewmodels.BlocagesViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var blocagesViewModel: BlocagesViewModel
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            blocagesViewModel = hiltViewModel()

            BlocagesTheme {
                JetsurveyNavHost()
                // A surface container using the 'background' color from the theme
                /*
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
                */
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
                    // once everything is set

                    val kerrunchPercent = kerrunchCount.toFloat().div(100_000f).times(100f)
                    val missPercent = missCount.toFloat().div(100_000f).times(100f)
                    val shoveOnePercent = shoveOneCount.toFloat().div(100_000f).times(100f)
                    val shoveTwoPercent = shoveTwoCount.toFloat().div(100_000f).times(100f)
                    val taclePercent = tacleCount.toFloat().div(100_000f).times(100f)
                    val smashCountPercent = smashCount.toFloat().div(100_000f).times(100f)

                    val results = mapOf(
                        kerrunchPercent to "Kerrunch",
                        missPercent to "Miss",
                        shoveOnePercent to "ShoveOne",
                        shoveTwoPercent to "ShoveTwo",
                        taclePercent to "Tacle",
                        smashCountPercent to "Smash"
                    )
                    val k = "hello World"
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