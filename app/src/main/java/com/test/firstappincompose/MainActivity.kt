package com.test.firstappincompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.semantics.Role
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
                    MyCheckBoxExample()
                }
            }
        }
    }
}


@Composable
fun  MyCheckBoxExample(){
    val context = LocalContext.current

    val radioOptions = listOf("pizza","rajma","kaju kathri")

    var (selectedItem,onOptionSelected) = remember {
        mutableStateOf("")
    }

    //Grouping the radio button in one group
    Column(modifier = Modifier.selectableGroup()) {
   radioOptions.forEach{label ->
       Log.e("vipin1","onOptionSelected ${onOptionSelected.toString()}  , selectedItem : $selectedItem , label : $label" )
       Row(modifier = Modifier
           .fillMaxWidth()
           .height(56.dp)
           .selectable(
               selected = (selectedItem == label),
               onClick = { onOptionSelected(label) },
               role = Role.RadioButton
           )
           .padding(horizontal = 16.dp)
       ) {
           Log.e("vipin","onOptionSelected $onOptionSelected  , selectedItem : $selectedItem")
               RadioButton(modifier = Modifier.padding(16.dp) ,
                   onClick ={ onOptionSelected(label)},
                   selected = (selectedItem==label)
                   )
           
           Text(text = label)
       }
   }
    }

}

@Preview
@Composable
fun ShowPreview(){
    MyCheckBoxExample()
}