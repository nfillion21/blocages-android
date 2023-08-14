package pgm.poolp.blocages.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject internal constructor() : ViewModel() {
    fun signInAsGuest(
        onSignInComplete: () -> Unit,
    ) {
        onSignInComplete()
    }
}