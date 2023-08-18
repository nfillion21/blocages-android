package pgm.poolp.blocages.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pgm.poolp.blocages.R
import pgm.poolp.blocages.survey.question.MultipleChoiceQuestion
import pgm.poolp.blocages.survey.question.SliderQuestion
import pgm.poolp.blocages.survey.question.NumberOfDice
import pgm.poolp.blocages.survey.question.SingleChoiceQuestion

@Composable
fun FreeTimeQuestion(
    selectedAnswers: List<Int>,
    onOptionSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    MultipleChoiceQuestion(
        titleResourceId = R.string.in_my_free_time,
        directionsResourceId = R.string.select_all,
        possibleAnswers = listOf(
            R.string.read,
            R.string.work_out,
            R.string.draw,
            R.string.play_games,
            R.string.dance,
            R.string.watch_movies,
        ),
        selectedAnswers = selectedAnswers,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun NumberOfDiceQuestion(
    selectedAnswer: Int?,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.pick_a_number_of_block_dice,
        directionsResourceId = R.string.select_one,
        possibleAnswers = listOf(
            NumberOfDice(R.string.one_dice, R.drawable.dice_48px),
            NumberOfDice(R.string.two_dices, R.drawable.dice_48px),
            NumberOfDice(R.string.three_dices, R.drawable.dice_48px),
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun FeelingAboutSelfiesQuestion(
    value: Float?,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    SliderQuestion(
        titleResourceId = R.string.selfies,
        value = value,
        onValueChange = onValueChange,
        startTextResource = R.string.strongly_dislike,
        neutralTextResource = R.string.neutral,
        endTextResource = R.string.strongly_like,
        modifier = modifier,
    )
}