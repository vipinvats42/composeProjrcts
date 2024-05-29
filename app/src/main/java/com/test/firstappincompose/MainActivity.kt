package com.test.firstappincompose

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.firstappincompose.ui.theme.FirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppInComposeTheme {
                // A surface container using the 'background' color from the theme
                TextFieldExample()
            }
        }
    }
}

    @Composable
    private fun TextFieldExample() {

        var enteredValue by remember {
            mutableStateOf("")
        }

        var isUserBelow18 by remember {
            mutableStateOf(false)
        }


      Column(modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
      ) {
         TextField(value = enteredValue,
             onValueChange = {newText  -> enteredValue = newText},
             label = { Text(text = "Name")},
             placeholder = { Text(text = "Enter your Name")},
             leadingIcon = { Icon(imageVector = Icons.Default.Email,
                 contentDescription = "Email")},
             isError = isUserBelow18,
             keyboardOptions = KeyboardOptions(
                 keyboardType =KeyboardType.Number,
                 imeAction = ImeAction.Done
             ),
             keyboardActions = KeyboardActions(
                 onDone = {
                     isUserBelow18 = validateAge(inputText = enteredValue)
                 }
             )


         )
          if(isUserBelow18) {
              Text(text = "You should be 18 +",
                  color = MaterialTheme.colorScheme.error,
                  modifier = Modifier.padding(start =18.dp))
          }
      }
    }


      private fun validateAge(inputText : String) : Boolean{
         return inputText.toInt() <18
      }

    @Composable
    @Preview
    private fun TextFieldExamplePreview(){
        TextFieldExample()
    }



