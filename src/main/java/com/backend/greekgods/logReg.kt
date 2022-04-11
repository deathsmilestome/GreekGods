package com.backend.greekgods

fun reg() {
    println("username:")
    val username = readln()
    println("pas:")
    val pas = readln()
    println("Your first name:")
    val firstName = readln()
    println("Your second name:")
    val secondName = readln()
    println("phone(without + and ():")
    val phone = readln().toLong()
    println("weight like XX.X:")
    val weight = readln().toDouble()
    println("Choose your course: \n1 - strenght \n2 - flex \n3 - i am a pussy \n4 - bodybild \n5 - fullbody ")//refactor
    var trainCourseId = 0
    while (trainCourseId == 0) {
        when (readln().toInt()) {
            1 -> trainCourseId = 1
            2 -> trainCourseId = 3
            3 -> trainCourseId = 2
            4 -> trainCourseId = 4
            5 -> trainCourseId = 5
            else -> println("invailid course")
        }
    }
    try {
        DatabaseHandler().addUser(trainCourseId, username, pas, firstName, secondName, phone, weight)
    } catch (e: org.postgresql.util.PSQLException) {
        println("failed, try again")
        reg()
    }
}

    fun log(): Boolean {
        println("Username:")
        val username = readln()
        println("Pass:")
        val pas = readln()
        val request = "SELECT id,username, pas FROM user_info WHERE username = ? AND pas = ?"
        val quest = DatabaseHandler().getDbConnection().prepareStatement(request)
        quest.setString(1, username)
        quest.setString(2, pas)
        val answer = quest.executeQuery()
        when (answer.next()) {
            true -> {
                id = answer.getLong(1)
                user.setUserInfo(id)
                println("nice")
                return true
            }
            else -> {
                println("nea :(")
                return false
            }
        }
    }

fun logReg() {
    var logReg = 0
    var logStatus = false
    println("1 - log 2 - reg")
    while (logReg != 1 && logStatus == false) {
        when (readln().toInt()) {
            1 -> {
                logReg = 1
                logStatus = log()
            }
            2 -> {
                reg()
                println("send 1 to login")
            }
            else -> println("ti v porydke voobshe ?")
        }
    }

}
//val user = User(trainCourseId, username, pas, firstName, secondName, phone, weight)
//    user.userInfo()


