package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
                  var osList = listOf("Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux",
                      "Android","IOS","Windows","Linux")
                   PopulateItems(osList)
                }
            }
        }
    }
}


@Composable
private fun PopulateItems(osList: List<String> ){
LazyRow() {
 //Adding a single item
    item { 
        Text(text = "Pranshee tyagi", fontSize = 24.sp)
    }

    //adding 5 items
    items(5){
        Text(text = "Items $it",fontSize = 24.sp)
    }

    items(osList.size){ osName ->
        Text(text = "os list are ${osName}", fontSize = 24.sp)
    }
}
}

@Preview
@Composable
private fun ShowPopulateItems(){

}


@Composable
fun CreateRowItem(osName: String){
    Row {
        Text(text = osName,
            fontSize = 32.sp)
    }
}