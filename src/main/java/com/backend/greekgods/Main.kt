package com.backend.greekgods

fun main() {
    println("username:")
    val username = readln()
    println("pas:")
    val pas = readln()
    println("Your first name:")
    val first_name = readln()
    println("Your second name:")
    val second_name = readln()
    println("phone(without + and ():")
    val phone = readln().toBigInteger()
    println("weight like XX.X:")
    val weight = readln().toDouble()
    println("Choose your course: \n1 - strenght \n2 - flex \n3 - i am a pussy \n4 - bodybild \n5 - fullbody ")
    var train_course_id = 0
    while (train_course_id == 0) {
        when (readln().toInt()) {
        1 -> train_course_id = 1
        2 -> train_course_id = 3
        3 -> train_course_id = 2
        4 -> train_course_id = 4
        5 -> train_course_id = 5
        else -> println("Выберите существующий курс")
    }}
    var user = User(train_course_id, 1, username, pas, first_name, second_name, phone, weight)
    user.userInfo()
    var x = Eat_course()

}
