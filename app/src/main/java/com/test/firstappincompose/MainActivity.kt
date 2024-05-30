package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    var name by remember {
                        mutableStateOf("")
                    }
//                    StatelessFun(name =  name) {
//                        name = it
//                    }
                    Statefullfun()
                }
            }
        }
    }
}


//StateFullExample
@Composable
fun Statefullfun(){
    val context = LocalContext.current
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Text(modifier = Modifier.weight(1f),
            text = context.getString(R.string.txt_src),
            maxLines = if(!isExpanded) 4 else Int.MAX_VALUE
            )

        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { isExpanded = !isExpanded }) {
            Image(imageVector = if (isExpanded) Icons.Filled.KeyboardArrowDown
                else Icons.Filled.KeyboardArrowUp, contentDescription = "")
        }
    }
}

//stateLessExample
@Composable
fun StatelessFun(name : String, onNameChange : (String) ->Unit){
Column(modifier = Modifier.padding(16.dp)) {
    Text(text = "Hello $name",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.headlineLarge)

    OutlinedTextField(value = name,
        onValueChange = onNameChange,
        label = { Text(text = "Name")})

}
}