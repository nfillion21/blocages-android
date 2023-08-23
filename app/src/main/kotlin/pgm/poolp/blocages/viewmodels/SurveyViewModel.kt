package pgm.poolp.blocages.viewmodels

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import pgm.poolp.blocages.util.Dice
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject internal constructor() : ViewModel() {

    private val questionOrder: List<SurveyQuestion> = listOf(
        SurveyQuestion.NUMBER_OF_DICE,
        SurveyQuestion.DICE_RESULT
    )

    private var questionIndex = 0

    // ----- Responses exposed as State -----

    private val _numberOfDiceResponse = mutableStateOf<Int?>(null)
    val numberOfDiceResponse: Int?
        get() = _numberOfDiceResponse.value

    private val _diceResultResponse = mutableStateOf<Int?>(null)
    val diceResultResponse: Int?
        get() = _diceResultResponse.value

    // ----- Survey status exposed as State -----

    private val _surveyScreenData = mutableStateOf(createSurveyScreenData())
    val surveyScreenData: SurveyScreenData
        get() = _surveyScreenData.value

    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    /**
     * Returns true if the ViewModel handled the back press (i.e., it went back one question)
     */
    fun onBackPressed(): Boolean {
        if (questionIndex == 0) {
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }

    fun onPreviousPressed() {
        if (questionIndex == 0) {
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }

    fun onNextPressed() {
        changeQuestion(questionIndex + 1)
    }

    private fun changeQuestion(newQuestionIndex: Int) {
        questionIndex = newQuestionIndex
        _isNextEnabled.value = getIsNextEnabled()
        _surveyScreenData.value = createSurveyScreenData()
    }

    fun onDonePressed(onSurveyComplete: (dice: Int) -> Unit) {
        // Here is where you could validate that the requirements of the survey are complete
        onSurveyComplete(numberOfDiceResponse!!)
    }

    fun onNumberOfDiceResponse(numberOfDice: Int) {
        _numberOfDiceResponse.value = numberOfDice
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onDiceResultResponse(diceResult: Int) {
        _diceResultResponse.value = diceResult
        _isNextEnabled.value = getIsNextEnabled()
    }

    private fun getIsNextEnabled(): Boolean {
        return when (questionOrder[questionIndex]) {
            SurveyQuestion.NUMBER_OF_DICE -> _numberOfDiceResponse.value != null
            SurveyQuestion.DICE_RESULT -> _diceResultResponse.value != null
        }
    }

    private fun createSurveyScreenData(): SurveyScreenData {
        return SurveyScreenData(
            questionIndex = questionIndex,
            questionCount = questionOrder.size,
            shouldShowPreviousButton = questionIndex > 0,
            shouldShowDoneButton = questionIndex == questionOrder.size - 1,
            surveyQuestion = questionOrder[questionIndex],
        )
    }

    private val _dices = MutableStateFlow(mapOf<String, Float>())
    val dices: StateFlow<Map<String, Float>> = _dices

    private var results = mutableStateMapOf<String, Float>()
    val dicesFlow: Flow<Map<String, Float>>
            = flow {
        val count = 10_000
        var kerrunchCount = 0
        var missCount = 0
        var shoveCount = 0
        var tackleCount = 0
        var smashCount = 0

        for (i in 0 until count) {

            delay(1)

            when (Dice.values().random()) {
                Dice.KERRUNCH -> {
                    kerrunchCount++
                    results["Kerrunch"] = kerrunchCount.toFloat().div(count).times(100f)
                }

                Dice.MISS -> {
                    missCount++
                    results["Miss"] = missCount.toFloat().div(count).times(100f)
                }

                Dice.SHOVE_1 -> {
                    shoveCount++
                    results["ShoveOne"] = shoveCount.toFloat().div(count).times(100f)
                }

                Dice.SHOVE_2 -> {
                    shoveCount++
                    results["ShoveTwo"] = shoveCount.toFloat().div(count).times(100f)
                }

                Dice.TACKLE -> {
                    tackleCount++
                    results["Tackle"] = tackleCount.toFloat().div(count).times(100f)
                }

                Dice.SMASH -> {
                    smashCount++
                    results["Smash"] = smashCount.toFloat().div(count).times(100f)
                }
            }

            emit(results)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, mapOf())
}

enum class SurveyQuestion {
    NUMBER_OF_DICE,
    DICE_RESULT
}

data class SurveyScreenData(
    val questionIndex: Int,
    val questionCount: Int,
    val shouldShowPreviousButton: Boolean,
    val shouldShowDoneButton: Boolean,
    val surveyQuestion: SurveyQuestion,
)