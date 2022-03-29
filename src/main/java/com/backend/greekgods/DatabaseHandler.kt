package com.backend.greekgods

import java.sql.Connection
import java.sql.DriverManager

open class DatabaseHandler {

    private val dbHost = "localhost"
    private val dbPort = "5432"
    private val dbUser = "dstm"
    private val dbPass = "jiraf357"
    private val dbName = "GreekGods_db"

    private fun getDbConnection(): Connection {
        val connect = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
        return DriverManager.getConnection(connect, dbUser, dbPass)
    }
    fun getDataForUser(): List<List<String>> {
        val result = mutableListOf<MutableList<String>>()
        val request = "SELECT * FROM user_info ORDER BY id"
        val quest = getDbConnection().prepareStatement(request)
        val answer = quest.executeQuery()
        while (answer.next()) {
            val tempResult = mutableListOf<String>()
            for (i in 1..8) {
                tempResult.add(answer.getString(i))
            }
            result.add(tempResult)
        }
        return result
    }

    fun addUser(trainCourseID: Int,
                username: String,
                pas: String,
                firstName: String,
                secondName: String,
                phone: Long,
                weight: Double)
    {
        val request = "INSERT INTO user_info(train_course_id,username,pas,first_name,second_name,phone,weight) VALUES(?,?,?,?,?,?,?)"
        val conn = getDbConnection().prepareStatement(request)
        conn.setInt(1, trainCourseID)
        conn.setString(2, username)
        conn.setString(3, pas)
        conn.setString(4, firstName)
        conn.setString(5, secondName)
        conn.setLong(6, phone)
        conn.setDouble(7, weight)
        conn.executeUpdate()
    }
    fun updateTrainCourseForUser(id: Long, trainCourseID: Int ) {
        val request = "UPDATE user_info SET train_course_id = $trainCourseID WHERE id = $id"
        getDbConnection().prepareStatement(request).execute()

    }

    fun log(username: String, pas: String) {
        val result = listOf<String>()
        val request = "SELECT username, pas FROM user_info WHERE username = '$username' AND pas = '$pas'"
        val quest = getDbConnection().prepareStatement(request)
        val answer = quest.executeQuery()
        when (answer.next()) {
            true -> println("+")
            else -> println("-")

    }
    }
}


