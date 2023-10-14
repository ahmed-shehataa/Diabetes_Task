package com.ashehata.diabetes_task.features.login.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.common.presentation.compose.InputText
import com.ashehata.diabetes_task.common.presentation.validation.InputWrapper

@Composable
fun LoginScreenContent(
    email: InputWrapper,
    password: InputWrapper,
    isButtonEnabled: Boolean,
    onLoginClicked: () -> Unit,
    isLoading: Boolean
) {

    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {


            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = R.drawable.login_placeholder),
                contentDescription = null
            )


            InputText(
                hint = stringResource(id = R.string.enter_email),
                inputWrapper = email,
                keyboardType = KeyboardType.Email
            ) {

            }


            InputText(
                inputWrapper = password,
                hint = stringResource(id = R.string.enter_password),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                onDone = {
                    if (isButtonEnabled)
                        onLoginClicked()
                }
            )

            Button(
                modifier = Modifier
                    .requiredHeight(50.dp)
                    .fillMaxWidth(),
                onClick = onLoginClicked,
                content = {
                    Text(text = stringResource(R.string.login))
                },
                enabled = isButtonEnabled,
                shape = MaterialTheme.shapes.medium
            )

        }

        if (isLoading) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("loading_view"),
                color = Color.Black.copy(alpha = 0.5f)
            ) {

                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
}