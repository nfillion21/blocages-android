package pgm.poolp.blocages.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pgm.poolp.blocages.navigation.Destinations.SURVEY_RESULTS_ROUTE
import pgm.poolp.blocages.navigation.Destinations.SURVEY_ROUTE
import pgm.poolp.blocages.navigation.Destinations.WELCOME_ROUTE
import pgm.poolp.blocages.survey.SurveyResultScreen
import pgm.poolp.blocages.survey.SurveyRoute
import pgm.poolp.blocages.welcome.WelcomeRoute

object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val SURVEY_ROUTE = "survey"
    const val SURVEY_RESULTS_ROUTE = "surveyresults"
}

@Composable
fun JetsurveyNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE,
    ) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(
                onSignInAsGuest = {
                    navController.navigate(SURVEY_ROUTE)
                },
            )
        }

        composable(SURVEY_ROUTE) {
            SurveyRoute(
                onSurveyComplete = {
                    navController.navigate(SURVEY_RESULTS_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(SURVEY_RESULTS_ROUTE) {
            SurveyResultScreen {
                navController.popBackStack(WELCOME_ROUTE, false)
            }
        }
    }
}
