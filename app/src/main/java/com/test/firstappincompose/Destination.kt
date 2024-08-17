package com.test.firstappincompose

sealed class Destination(val route : String) {
    object  FirstScreen : Destination("First Screen")
    object  SecondScreen : Destination("Second Screen")
}