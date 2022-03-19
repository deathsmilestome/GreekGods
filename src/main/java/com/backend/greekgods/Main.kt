package com.backend.greekgods

fun main() {
    println("username:")
    val username = readln()
    println("pas:")
    val pas = readln()
    println("Your first name:")
    val firstName = readln()
    println("Your second name:")
    val secondName = readln()
    println("phone(without + and ():")
    val phone = readln().toBigInteger()
    println("weight like XX.X:")
    val weight = readln().toDouble()
    println("Choose your course: \n1 - strenght \n2 - flex \n3 - i am a pussy \n4 - bodybild \n5 - fullbody ")
    var trainCourseId = 0
    while (trainCourseId == 0) {
        when (readln().toInt()) {
        1 -> trainCourseId = 1
        2 -> trainCourseId = 3
        3 -> trainCourseId = 2
        4 -> trainCourseId = 4
        5 -> trainCourseId = 5
        else -> println("Выберите существующий курс")
    }
    }
    val user = User(trainCourseId, username, pas, firstName, secondName, phone, weight)
    user.userInfo()


}
