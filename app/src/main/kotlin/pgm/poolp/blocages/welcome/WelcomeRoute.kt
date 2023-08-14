package pgm.poolp.blocages.welcome

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import pgm.poolp.blocages.screens.WelcomeScreen
import pgm.poolp.blocages.viewmodels.WelcomeViewModel

@Composable
fun WelcomeRoute(
    onSignInAsGuest: () -> Unit,
) {
    val welcomeViewModel: WelcomeViewModel = hiltViewModel()
    WelcomeScreen(
        onSignInAsGuest = {
            welcomeViewModel.signInAsGuest(onSignInAsGuest)
        },
    )
}
