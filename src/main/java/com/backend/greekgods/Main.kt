package com.backend.greekgods

import kotlin.math.log

fun main() {
    var logReg = 0
    println("1 - log 2 - reg")
    while (logReg == 0) {
        when (readln().toInt()) {
            1 -> {
                logReg = 1
                println("Username:")
                val username = readln()
                println("Pass:")
                val pas = readln()
                DatabaseHandler().log(username, pas)
            }
            2 -> {
                logReg = 2
                reg()
            }
            else -> println("ti v porydke voobshe ?")
        }
    }
    //DatabaseHandler().updateTrainCourseForUser(10, 5)
   // DatabaseHandler().addUser(1,"ivanchik", "kto", "ffivan", "ssivan", 1234567899, 75.4)
//    for (i in DatabaseHandler().getDataForUser() ) {
//        println(i)
//    }
}
