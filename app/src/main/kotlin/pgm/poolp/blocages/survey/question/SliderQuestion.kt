package pgm.poolp.blocages.survey.question

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pgm.poolp.blocages.survey.QuestionWrapper

@Composable
fun SliderQuestion(
    @StringRes titleResourceId: Int,
    value: Float?,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 3,
    @StringRes startTextResource: Int,
    @StringRes neutralTextResource: Int,
    @StringRes endTextResource: Int,
    modifier: Modifier = Modifier,
) {
    var sliderPosition by remember {
        mutableStateOf(value ?: ((valueRange.endInclusive - valueRange.start) / 2))
    }
    QuestionWrapper(
        titleResourceId = titleResourceId,
        modifier = modifier,
    ) {

        Row {
            Slider(
                value = sliderPosition,
                onValueChange = {
                    sliderPosition = it
                    onValueChange(it)
                },
                valueRange = valueRange,
                steps = steps,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }
        Row {
            Text(
                text = stringResource(id = startTextResource),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Text(
                text = stringResource(id = neutralTextResource),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Text(
                text = stringResource(id = endTextResource),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
        }
    }
}