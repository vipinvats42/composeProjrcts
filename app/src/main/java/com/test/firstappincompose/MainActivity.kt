package com.test.firstappincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
                  ScaffoldUI()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScaffoldUI(){
     var context = LocalContext.current.applicationContext
     TopAppBar(
         title = {Text(text = "Our Course")},
         navigationIcon = {
             IconButton(onClick = {
                 Toast.makeText(context,"you clicked the icon",Toast.LENGTH_SHORT).show()
             }) {
                 Icon(imageVector = Icons.Filled.Email,
                     contentDescription = "Na")

             }

         },
         actions = {
               //search ison
             IconButton(onClick = {

             }) {
                   Icon(imageVector = Icons.Filled.Search,
                       contentDescription = "Search")
             }
         },
         colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
     )
}

@Preview
@Composable
private fun showScaffoldUI(){
    ScaffoldUI()
}

