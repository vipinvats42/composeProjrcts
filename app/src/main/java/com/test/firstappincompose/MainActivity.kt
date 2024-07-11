package com.test.firstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.test.firstappincompose.ui.theme.FirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ConstraintScreen()
                }
            }
        }
    }


    @Composable
    fun ConstraintScreen() {
        ConstraintLayout {
            val (redBox, blueBox, yellowBox,greenBox,blackBox) = createRefs()

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red)
                    .constrainAs(redBox){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width= Dimension.wrapContent
                        height= Dimension.value(100.dp)
                    }
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue)
                    .constrainAs(blueBox){
                      top.linkTo(redBox.bottom)
                      end.linkTo(redBox.end)
                    }
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Yellow)
                    .constrainAs(yellowBox){
                      top.linkTo(blueBox.bottom)
                        end.linkTo(blueBox.end)
                    }
            )



            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red)
                    .constrainAs(blackBox){
                        top.linkTo(yellowBox.bottom)
                    }
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue)
                    .constrainAs(greenBox){
                      top.linkTo(yellowBox.bottom)
                    }
            )


            //style in constraint layout.
           // createHorizontalChain(greenBox,blackBox, chainStyle = ChainStyle.Spread)
           // createHorizontalChain(greenBox,blackBox, chainStyle = ChainStyle.SpreadInside)
            createHorizontalChain(greenBox,blackBox, chainStyle = ChainStyle.Packed)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ShowConstraintLayout() {
        ConstraintScreen()
    }
}