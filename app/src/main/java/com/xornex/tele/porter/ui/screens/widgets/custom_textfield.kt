package com.xornex.tele.porter.ui.screens.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.SkiptxtColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTxtField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = PasswordVisualTransformation(),

            modifier = modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(
                fontSize = 18.sp,     // 👈 control input text size
                color = Color.White   // 👈 must set color again here
            ),
            label = {
                Text(
                    text = hint,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(color = SkiptxtColor)
                )
            },

            singleLine = true,

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),

//            keyboardActions = KeyboardActions(
//                onDone = {
//                    // TODO: Enter key pressed
//                }
//            ),

            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                textColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray,
                backgroundColor = Color(0xFF283339)
            )
        )
    }

}




