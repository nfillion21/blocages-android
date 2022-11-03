package pgm.poolp.blocages

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import pgm.poolp.blocages.game.builders.GameFactory
import pgm.poolp.blocages.game.interfaces.Player
import pgm.poolp.blocages.ui.theme.BlocagesTheme
import pgm.poolp.blocages.viewmodels.BlocagesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlocagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val blocagesViewModel: BlocagesViewModel = hiltViewModel()
                    Greeting(blocagesViewModel = blocagesViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(blocagesViewModel: BlocagesViewModel) {

    val composableScope = rememberCoroutineScope()
    Button(
        onClick = {
            val mutableList = mutableListOf<Player>()
            composableScope.launch {
                blocagesViewModel.blocages(GameFactory())
                    .flowOn(Dispatchers.Default)
                    .collect {
                        mutableList.add(it)
                        Log.i("player", mutableList.size.toString())
                }
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