package pgm.poolp.blocages.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pgm.poolp.blocages.R
import pgm.poolp.blocages.survey.question.RowQuestion
import pgm.poolp.blocages.survey.question.SingleChoiceQuestion
import pgm.poolp.blocages.survey.question.SliderQuestion

@Composable
fun NumberOfDiceQuestion(
    selectedAnswer: Int?,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.pick_a_number_of_block_dice,
        directionsResourceId = R.string.select_one,
        stateDices = null,
        possibleAnswers = listOf(
            RowQuestion(R.string.one_dice, R.drawable.dice_48px),
            RowQuestion(R.string.two_dices, R.drawable.dice_48px),
            RowQuestion(R.string.three_dices, R.drawable.dice_48px),
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun DiceResultQuestion(
    selectedAnswer: Int?,
    onOptionSelected: (Int) -> Unit,
    dices: Map<String, Float>,
    modifier: Modifier = Modifier,
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.pick_a_block_dice_result,
        directionsResourceId = R.string.select_one,
        stateDices = dices,
        possibleAnswers = listOf(
            RowQuestion(R.string.miss_dice_result, R.drawable.miss_48px),
            RowQuestion(R.string.tackle_dice_result, R.drawable.tackle_48px),
            RowQuestion(R.string.shove_dice_result, R.drawable.shove_48px),
            RowQuestion(R.string.smash_dice_result, R.drawable.smash_48px),
            RowQuestion(R.string.kerrunch_dice_result, R.drawable.kerrunch_48px),
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}