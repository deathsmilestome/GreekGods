package com.backend.greekgods

import java.lang.Thread.sleep

class Color(var red: Int, var green: Int, var blue: Int) {

    fun getHex(): String {
        TODO()
    }

}

class Wheel(var size: Int, var type: String)
class Car(var typeBody: String, var color: Color, var wheels: Wheel, var distance: Int) {
    fun drive() {
        var speed = 0
        while (speed != 100) {
            sleep(15)
            println(speed)
            speed++

        }
        println("ebat' ti gonshik")
    }
}