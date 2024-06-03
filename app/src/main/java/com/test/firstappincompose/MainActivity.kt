package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.test.firstappincompose.ui.theme.FirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                       // DisplayOurText()
                    CircularProgressIndicatorExample()
                }
            }
        }
    }
}

@Composable
fun CircularProgressIndicatorExample(){
    Row {
        //determinate progress bar
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = Color.Red,
            strokeWidth = 6.dp
        )
        Text(text = "Loading...")

//indeterminate progress bar which show progress
        CircularProgressIndicator(
            progress = 0.2f,
            modifier = Modifier.size(64.dp),
            color = Color.Red,
            strokeWidth = 6.dp
        )
    }
}
@Preview
@Composable
fun showCircularProgressIndicator(){

}