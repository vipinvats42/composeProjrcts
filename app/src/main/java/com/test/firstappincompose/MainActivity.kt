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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                   DisplayNavigation()
                }
            }
        }
    }
}

@Composable
fun DisplayNavigation(){
// Nav Controller
    val navController = rememberNavController()

    //Nav host : Responsible for hosting the content of the NavDestination.
    NavHost(navController = navController,
        startDestination = Destination.FirstScreen.toString()) {

        composable(route = Destination.FirstScreen.toString()) {
            FirstScreen(navController = navController)
        }

        composable(route = Destination.SecondScreen.toString() + "/{userName}") {
            val user = it.arguments?.getString("userName")
            SecondComposable(user, navController = navController)
        }

        composable("profile/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.StringType
                defaultValue = "0"
            })
        ) {
            val user = it.arguments?.getString("userId", "0")
            ThirdScreen(userId = user, navController = navController)
        }

    }
}


@Composable
fun FirstScreen(navController: NavController){
    var username by remember {
        mutableStateOf("")
    }


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to second screen", fontSize = 64.sp, color=Color.Red, lineHeight = 64.sp)
       
        TextField(value = username, onValueChange ={newUser -> username =newUser} )
       
        Button(onClick = { navController.navigate(Destination.SecondScreen.toString()+" /${username}") }) {
            Text(text = "Go to Second screen")
        }
    }
}

@Composable
fun SecondComposable(user : String?,navController: NavController){
    Column {


        Text(text = "Welcome ${user} to second screen", fontSize = 64.sp, color = Color.Green, lineHeight = 64.sp)
        Button(onClick = {/* navController.navigate(Destination.FirstScreen.toString())*/
       navController.navigate("profile/77")}) {
            Text(text = "Go to first screen",)
        }
    }

}


@Composable
fun ThirdScreen(userId : String?,navController: NavController){
  Text(text = "UserId is ${userId}")
}




