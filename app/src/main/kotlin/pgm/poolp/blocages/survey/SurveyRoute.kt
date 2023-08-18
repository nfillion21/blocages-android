package pgm.poolp.blocages.survey

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import pgm.poolp.blocages.viewmodels.SurveyQuestion
import pgm.poolp.blocages.viewmodels.SurveyViewModel

private const val CONTENT_ANIMATION_DURATION = 300

/**
 * Displays a [SurveyQuestionsScreen] tied to the passed [SurveyViewModel]
 */
@Composable
fun SurveyRoute(
    onSurveyComplete: (dice:Int) -> Unit,
    onNavUp: () -> Unit,
) {
    val viewModel: SurveyViewModel = hiltViewModel()

    val surveyScreenData = viewModel.surveyScreenData

    BackHandler {
        if (!viewModel.onBackPressed()) {
            onNavUp()
        }
    }

    SurveyQuestionsScreen(
        surveyScreenData = surveyScreenData,
        isNextEnabled = viewModel.isNextEnabled,
        onClosePressed = {
            onNavUp()
        },
        onPreviousPressed = { viewModel.onPreviousPressed() },
        onNextPressed = { viewModel.onNextPressed() },
        onDonePressed = { viewModel.onDonePressed(onSurveyComplete) }
    ) { paddingValues ->

        val modifier = Modifier.padding(paddingValues)

        AnimatedContent(
            targetState = surveyScreenData,
            transitionSpec = {
                val animationSpec: TweenSpec<IntOffset> = tween(CONTENT_ANIMATION_DURATION)

                val direction = getTransitionDirection(
                    initialIndex = initialState.questionIndex,
                    targetIndex = targetState.questionIndex,
                )

                slideIntoContainer(
                    towards = direction,
                    animationSpec = animationSpec,
                ) togetherWith slideOutOfContainer(
                    towards = direction,
                    animationSpec = animationSpec
                )
            },
            label = "surveyScreenDataAnimation"
        ) { targetState ->

            when (targetState.surveyQuestion) {
                SurveyQuestion.FREE_TIME -> {
                    FreeTimeQuestion(
                        selectedAnswers = viewModel.freeTimeResponse,
                        onOptionSelected = viewModel::onFreeTimeResponse,
                        modifier = modifier,
                    )
                }

                SurveyQuestion.NUMBER_OF_DICE -> NumberOfDiceQuestion(
                    selectedAnswer = viewModel.numberOfDiceResponse,
                    onOptionSelected = viewModel::onNumberOfDiceResponse,
                    modifier = modifier,
                )

                SurveyQuestion.FEELING_ABOUT_SELFIES ->
                    FeelingAboutSelfiesQuestion(
                        value = viewModel.feelingAboutSelfiesResponse,
                        onValueChange = viewModel::onFeelingAboutSelfiesResponse,
                        modifier = modifier,
                    )
            }
        }
    }
}

private fun getTransitionDirection(
    initialIndex: Int,
    targetIndex: Int
): AnimatedContentTransitionScope.SlideDirection {
    return if (targetIndex > initialIndex) {
        // Going forwards in the survey: Set the initial offset to start
        // at the size of the content so it slides in from right to left, and
        // slides out from the left of the screen to -fullWidth
        AnimatedContentTransitionScope.SlideDirection.Left
    } else {
        // Going back to the previous question in the set, we do the same
        // transition as above, but with different offsets - the inverse of
        // above, negative fullWidth to enter, and fullWidth to exit.
        AnimatedContentTransitionScope.SlideDirection.Right
    }
}
