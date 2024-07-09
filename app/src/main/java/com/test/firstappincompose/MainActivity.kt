package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
                    val osList : List<String> = listOf("java","kotlin", "android","linux","unix","python")
                    PopulateItems(osList)
                }
            }
        }
    }

    @Composable
    private fun PopulateItems(osList : List<String>) {
        LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
    content = {
        items(osList.size){
            index ->  Card(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(Color.Blue)) {
             Text(text = osList[index])
        }
        }
    })
    }

    @Preview
    @Composable
    private fun ShowPopulateItems(){
        val osList : List<String> = listOf("java","kotlin", "android")
        PopulateItems(osList)
    }
}

