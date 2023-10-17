package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.util.getCurrentTime


@Composable
fun WelcomeHeader(userEmail: String) {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = String.format(stringResource(id = R.string.welcome), userEmail),
                style = MaterialTheme.typography.subtitle2.copy(fontSize = 20.sp)
            )
            Text(text = userEmail, modifier = Modifier.weight(1f))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            val currentDate = remember { getCurrentTime() }

            Text(
                text = stringResource(id = R.string.login_at),
                style = MaterialTheme.typography.subtitle2.copy(
                    fontSize = 20.sp
                )
            )
            Text(text = currentDate, modifier = Modifier.weight(1f))
        }

    }


}