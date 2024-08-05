package dev.syprosegwako.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Onboarding(){
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
            //logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(180.dp)
                    .height(60.dp)
                    .padding(bottom = 16.dp)
                    .background(colorResource(id = R.color.white))
                    .align(Alignment.CenterHorizontally)
            )
        //header
            Text(
                text = "Let's get to know you",
                textAlign = TextAlign.Center,
                style = displayText,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.primary1))
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
            )

        //paragraph title
        Text(
            text = "Personal Information",
            textAlign = TextAlign.Start,
            style = paragraphTitleTextStyle,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(vertical = 40.dp)

        )
        //form
        GenericTextField(
            label = "First name",
            value = firstName,
            onValueChange = { firstName = it }
        )
        GenericTextField(
            label = "Last name",
            value = lastName,
            onValueChange = { lastName = it }
        )
        GenericTextField(
            label = "Email",
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )
        // Spacer to push the button to the bottom
        Spacer(modifier = Modifier.weight(1f))
        //button
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary2)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(
                text = "Register",
                color = Color.Black,
                fontFamily = markaziTextFamily
            )
        }
    }

}

@Composable
fun GenericTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = inputFieldTextStyle()
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = inputFieldTextStyle(),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.primary1),
                cursorColor = colorResource(id = R.color.primary1)
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
    }
}
@Preview(backgroundColor = 1, showBackground = true)
@Composable
fun OnboardingPreview(){
    Onboarding()
}