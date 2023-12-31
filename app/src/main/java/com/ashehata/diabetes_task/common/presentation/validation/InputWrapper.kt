package com.ashehata.diabetes_task.common.presentation.validation


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.common.presentation.validation.Validation.validateAge
import com.ashehata.diabetes_task.common.presentation.validation.Validation.validateEmail
import com.ashehata.diabetes_task.common.presentation.validation.Validation.validateText

enum class ValidationType {
    Text, Email, Password, Age
}

data class InputWrapper(
    var text: MutableState<String> = mutableStateOf(""),
    var isValid: MutableState<Boolean> = mutableStateOf(false),
    var borderColor: MutableState<Color> = mutableStateOf(Color.Gray),
    val validationType: ValidationType? = ValidationType.Text
) {

    var validationMessageResId: Int = R.string.empty_lbl

    fun onValueChange(input: String) {
        text.value = input
        validationMessageResId = when (validationType) {
            ValidationType.Email -> input.validateEmail().toMessageRes()
            ValidationType.Age -> input.validateAge().toMessageRes()
            else -> input.validateText().toMessageRes()
        }
        isValid.value = validationMessageResId == R.string.empty_lbl && text.value.isNotEmpty()
        borderColor.value = if (isValid.value) Color.Gray else Color.Red
    }

    fun invalidate() {
        text.value = ""
        isValid.value = false
        borderColor.value = Color.Gray
    }
}

private fun ValidationMessageType.toMessageRes(): Int {
    return when (this) {
        ValidationMessageType.EmptyField -> R.string.empty_field
        is ValidationMessageType.Invalid -> {
            when (this.validationType) {
                ValidationType.Email -> R.string.invalid_email
                ValidationType.Age -> R.string.invalid_age
                else -> R.string.invalid_email
            }
        }

        ValidationMessageType.Valid -> R.string.empty_lbl
    }
}