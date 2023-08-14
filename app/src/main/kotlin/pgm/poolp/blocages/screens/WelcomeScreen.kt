package pgm.poolp.blocages.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pgm.poolp.blocages.R
import pgm.poolp.blocages.util.supportWideScreen

@Composable
fun WelcomeScreen(
    onSignInAsGuest: () -> Unit,
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            SignInCreateAccount(
                onSignInAsGuest = onSignInAsGuest,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
    }
}

@Composable
private fun SignInCreateAccount(
    onSignInAsGuest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(
            onClick = onSignInAsGuest,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 24.dp),
        ) {
            Text(text = stringResource(id = R.string.sign_in_guest))
        }
    }
}