package com.test.firstappincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                    FloatingActionButtonUI()
                }
            }
        }
    }
}


@Composable
fun FloatingActionButtonUI(){
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()){
        FloatingActionButton(modifier = Modifier
            .padding(all = 16.dp)
            .align(alignment = Alignment.BottomEnd),
            onClick = {
                Toast.makeText(context,"you clicked fab",Toast.LENGTH_SHORT).show()
            }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription ="Add note" )
        }
    }
    
    Box(modifier = Modifier.fillMaxSize()){
       ExtendedFloatingActionButton(text =  {"Serach"} ,
           icon = { Icon(imageVector = Icons.Filled.Search,
               contentDescription = "Search") },
           onClick = {  Toast.makeText(context,"you clicked fab",Toast.LENGTH_SHORT).show()
           }, modifier = Modifier
               .padding(all = 16.dp)
               .align(alignment = Alignment.BottomStart))
    }

}



@Preview
@Composable
fun ShowFloatingActionButton(){
    FloatingActionButtonUI()
}