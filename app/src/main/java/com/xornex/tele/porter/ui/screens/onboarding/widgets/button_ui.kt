package com.xornex.tele.porter.ui.screens.onboarding.widgets

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.ButtonColor

@Composable
fun ButtonUi(
    title: String = "Start Now",
    backgroundColor: Color = ButtonColor,
    textColor: Color = Color.White,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    fontsize: Int = 16,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ), shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = title, fontSize = fontsize.sp, style = textStyle
        )


    }
}

@Preview(showBackground = true)
@Composable
fun NextButton() {
    ButtonUi(
        title = "Next"
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun BackButton() {
    ButtonUi(
        title = "Back",
        backgroundColor = Color.Transparent,
        textColor = Color.Gray,
        textStyle = MaterialTheme.typography.bodySmall,
        fontsize = 13
    ) {

    }
}

/*
 Button(
            onClick = {
                navController.navigate(Routes.onb_2)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.3f),
            colors = ButtonDefaults.buttonColors(ButtonColor),


            ) {
            Text(
                text = "Next", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
 */