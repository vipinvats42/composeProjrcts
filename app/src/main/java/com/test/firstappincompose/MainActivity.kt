package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                       // DisplayOurText()
                    var list = listOf("user1","user2","user3","user4")
                   // sayHelloToUsers(list)
                    ModifierTetDemo()
                }
            }
        }
    }
}

@Composable
fun ModifierTetDemo(){
    Column (modifier = Modifier.background(Color.Blue)){
        Text(
            text = stringResource(id = R.string.txt_welcome_to_our_course),
            modifier = Modifier.verticalScroll(state = rememberScrollState()).background(Color.Red))
    }

}

@Preview(showBackground = true)
@Composable
fun modifierTextValue(){
    FirstAppInComposeTheme {
        ModifierTetDemo()
    }
}


@Composable
fun DisplayOurText(){
    SelectionContainer {


        Text(
            text = "Hello friend \n welcome to our course",
            color = Color.Blue,
            fontSize = 22.sp,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FirstAppInComposeTheme {
//        Column {
//            DisplayOurText()
//        }
//
//    }
//}


@Composable
fun sayHelloToUsers(names : List<String>){
    Column {
        for(name in names){
            Text(text = "Hello $name",
                color=Color.Blue,
                fontSize = 32.sp)
        }
    }

}