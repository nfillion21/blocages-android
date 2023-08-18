package pgm.poolp.blocages.survey.question

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pgm.poolp.blocages.R
import pgm.poolp.blocages.survey.QuestionWrapper

@Composable
fun SingleChoiceQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    possibleAnswers: List<NumberOfDice>,
    selectedAnswer: Int?,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    QuestionWrapper(
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId,
        modifier = modifier.selectableGroup(),
    ) {
        possibleAnswers.forEachIndexed { index, numberOfDice ->
            val selected = index+1 == selectedAnswer
            RadioButtonWithImageRow(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = numberOfDice.stringResourceId),
                imageResourceId = numberOfDice.imageResourceId,
                selected = selected,
                onOptionSelected = { onOptionSelected(index+1) }
            )
        }
    }
}

@Composable
fun RadioButtonWithImageRow(
    text: String,
    @DrawableRes imageResourceId: Int,
    selected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (selected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surface
        },
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            }
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .selectable(
                selected,
                onClick = onOptionSelected,
                role = Role.RadioButton
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .padding(start = 0.dp, end = 8.dp)
            )
            Spacer(Modifier.width(8.dp))

            Text(text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Box(Modifier.padding(8.dp)) {
                RadioButton(selected, onClick = null)
            }
        }
    }
}

@Preview
@Composable
fun SingleChoiceQuestionPreview() {
    val possibleAnswers = listOf(
        NumberOfDice(R.string.one_dice, R.drawable.dice_48px),
        NumberOfDice(R.string.two_dices, R.drawable.dice_48px),
        NumberOfDice(R.string.three_dices, R.drawable.dice_48px),
    )
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }

    SingleChoiceQuestion(
        titleResourceId = R.string.pick_a_number_of_block_dice,
        directionsResourceId = R.string.select_one,
        possibleAnswers = possibleAnswers,
        selectedAnswer = selectedAnswer,
        onOptionSelected = { selectedAnswer = it },
    )
}

data class NumberOfDice(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int)
