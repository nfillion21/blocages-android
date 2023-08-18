package pgm.poolp.blocages.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pgm.poolp.blocages.survey.question.NumberOfDice
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject internal constructor() : ViewModel() {

    private val questionOrder: List<SurveyQuestion> = listOf(
        SurveyQuestion.FREE_TIME,
        SurveyQuestion.NUMBER_OF_DICE,
        SurveyQuestion.FEELING_ABOUT_SELFIES
    )

    private var questionIndex = 0

    // ----- Responses exposed as State -----

    private val _freeTimeResponse = mutableStateListOf<Int>()
    val freeTimeResponse: List<Int>
        get() = _freeTimeResponse

    private val _numberOfDiceResponse = mutableStateOf<Int?>(null)
    val numberOfDiceResponse: Int?
        get() = _numberOfDiceResponse.value

    private val _feelingAboutSelfiesResponse = mutableStateOf<Float?>(null)
    val feelingAboutSelfiesResponse: Float?
        get() = _feelingAboutSelfiesResponse.value

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

    fun onFreeTimeResponse(selected: Boolean, answer: Int) {
        if (selected) {
            _freeTimeResponse.add(answer)
        } else {
            _freeTimeResponse.remove(answer)
        }
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onFeelingAboutSelfiesResponse(feeling: Float) {
        _feelingAboutSelfiesResponse.value = feeling
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onNumberOfDiceResponse(numberOfDice: Int) {
        _numberOfDiceResponse.value = numberOfDice
        _isNextEnabled.value = getIsNextEnabled()
    }

    private fun getIsNextEnabled(): Boolean {
        return when (questionOrder[questionIndex]) {
            SurveyQuestion.FREE_TIME -> _freeTimeResponse.isNotEmpty()
            SurveyQuestion.NUMBER_OF_DICE -> _numberOfDiceResponse.value != null
            SurveyQuestion.FEELING_ABOUT_SELFIES -> _feelingAboutSelfiesResponse.value != null
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
}

enum class SurveyQuestion {
    FREE_TIME,
    NUMBER_OF_DICE,
    FEELING_ABOUT_SELFIES
}

data class SurveyScreenData(
    val questionIndex: Int,
    val questionCount: Int,
    val shouldShowPreviousButton: Boolean,
    val shouldShowDoneButton: Boolean,
    val surveyQuestion: SurveyQuestion,
)