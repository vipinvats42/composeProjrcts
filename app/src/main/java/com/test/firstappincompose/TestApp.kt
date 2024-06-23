package com.test.firstappincompose

class TestApp {
    fun main(){
        val add1 :(Int , Int) -> Int = {a: Int , b: Int -> a+b}
        println(add1(2,5))

        val add2 : (Int, Int) -> Unit = {a: Int , b:Int -> println("sum is ${a+b}") }
        print(add2(8,18))


        val add3: () -> String = {"welcome to pranshee house"}
        print(add3.invoke())


        val add4 : () -> Unit = {print("Hi Astha")}
        add4.invoke()


        // Anonymous fun

        val multiply = fun(a: Int,b:Int) : Int = a*b
        println(multiply.invoke(10,30))



    }
}