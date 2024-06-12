package com.test.firstappincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.test.firstappincompose.ui.theme.FirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                     BottomComposableUI()
                }
            }
        }
    }
}

@Composable
fun BottomComposableUI(){
     //items list
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current.applicationContext

    var selectedItem by remember {
        mutableStateOf("Home")
    }

    Box (modifier = Modifier.fillMaxSize()){
        BottomNavigation(modifier = Modifier.align(alignment = Alignment.BottomEnd)) {
           bottomMenuItemsList.forEach { menuItem ->
               BottomNavigationItem(selected = selectedItem == menuItem.label,
                   onClick = { selectedItem=menuItem.label
                       Toast.makeText(context,
                           menuItem.label,Toast.LENGTH_SHORT).show()
                   },
                   icon = { Icon(imageVector = menuItem.icon, contentDescription ="icons" )},
                   label = {menuItem.label},
                   enabled = true)
           }
        }
    }

}

//prepare the menu items
private fun prepareBottomMenu(): List<BottomMenuItem>{
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()

    //adding menu item
    bottomMenuItemList.add(BottomMenuItem("Home", Icons.Filled.Home))
    bottomMenuItemList.add(BottomMenuItem("Profile", Icons.Filled.Person))
    bottomMenuItemList.add(BottomMenuItem("Cart", Icons.Filled.ShoppingCart))
    bottomMenuItemList.add(BottomMenuItem("Settings", Icons.Filled.Settings))

   return  bottomMenuItemList
}

@Preview(showBackground = true)
@Composable
fun ShowBottomComposableUI(){
    FirstAppInComposeTheme {
        BottomComposableUI()
    }
}


//@Composable
//fun DisplayOurText(){
//    SelectionContainer {
//
//
//        Text(
//            text = "Hello friend \n welcome to our course",
//            color = Color.Blue,
//            fontSize = 22.sp,
//            style = TextStyle(textDecoration = TextDecoration.LineThrough),
//            fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.ExtraBold,
//            fontFamily = FontFamily.Cursive,
//            maxLines = 2
//        )
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
////@Preview(showBackground = true)
////@Composable
////fun GreetingPreview() {
////    FirstAppInComposeTheme {
////        Column {
////            DisplayOurText()
////        }
////
////    }
////}
//
//
//@Composable
//fun sayHelloToUsers(names : List<String>){
//    Column {
//        for(name in names){
//            Text(text = "Hello $name",
//                color=Color.Blue,
//                fontSize = 32.sp)
//        }
//    }
//
//}