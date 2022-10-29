package com.professionalandriod.apps.kotlinbasics

// 메인 함수 생성, 시작점
fun main() {
    /*
    * var 은 중복 기재 가능
    * val : 중복 기재 불가능
    * var myName = "HY"
    * myName = "Hoyoung"
    *
    * val 의 경우 불가능.
    * */

    val myName = "호영"
   // print("Hello " + myName);

    /*
    Integer Type
    1. Byte : 8bits
    2. Int : 32 bits
    3. Long : 64 bits
    val myInt : int = 123123123;
    val myLong : Long = 39_921_231_213
     */

    /*
    Floating Point Number Types
    Float : 32bit
    val myFloat : Float 13.37F
    Double : 64bit
     */

    /*
    logical Values
    var isSunny = true;
     */

    /*
    Characters (문자 하나 초과 X)
    val letterChar = 'A'

    Strings
    val myStr = "Hello World"
    var firstCharInStr = myStr[0]
     */

    /*
    Operator
    1. +
    2. -
    3. *
    4. /
    5. %
     */

    /*
    Comparison Operator
    1. ==
    2. !=
    3. <, <=
    4. >, >=
     */

    /*
    Assignment Operators
    1. +=
    2. -=
    3. *=
    4. /=
    5. %=
     */

    /*
    Increment & Decrement Operators
    1. ++
    2. --
     */

    /*
    if practice

     var heightP1 = 160;
    var heightP2 = 160;

    if(heightP1 > heightP2) {
        print("P1 is taller than P2")
    }
    else if (heightP1 == heightP2) {
        print("same height")
    }
    else {
        print("P2 is taller than P1")
    }

    var name = "hoyoung"
    if(name.equals("hoyoung")) {
        print (1);
    }
     */

    /*
     when practice

     var season = 3;

      when(season) {
        1 -> println("SPRING");
        2 -> println("SUMMER");
        3 -> {
            println("FALL")
            println("AUTUMN")
        }
        4 -> println("WINTER")
        else -> println("Invalid Season")

        /*
        in 1..3 = 1~3까지는 이라는 의미
        in 1..4 -> println("valid Season")
        !in 1..4 역시 가능
         */
    }


    var x : Any = 13.37
    when(x) {
        is Int -> print("$x is an Int")
        is Double -> print("$x is an Double")
        else -> println("$x is none of the above")
    }
     */

    /* 반복문
    while 은 자바와 비슷
    for 문
      for(num in 1..10) {
        print("$num ")
    }

    // infix notation
    for(i in 1 until 10) {
    // Same as - for(i in 1.until(10))
        print("$i ")
    }

    for(i in 10 downTo 1) {
    // Same as - for(i in 10.downTo(1))
        print("$i ")
    }

    for(i in 1 until 10 step 2) {
    // Same as - for(i in 1.until(10).step(2))
        print("$i ")
    }
     */


    for ( i in 1..10) {
        println("현재 값은 $i ${i+1} 입니다.")
    }


}


