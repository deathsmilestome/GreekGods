package com.backend.greekgods

import java.sql.Connection
import java.sql.DriverManager

open class DatabaseHandler {

    private val dbHost = "localhost"
    private val dbPort = "5432"
    private val dbUser = "dstm"
    private val dbPass = "jiraf357"
    private val dbName = "GreekGods_db"

    fun getDbConnection(): Connection {
        val connect = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
        return DriverManager.getConnection(connect, dbUser, dbPass)
    }
    fun getDataForUsers(): List<List<String>> {
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

    fun getDataForUser(id: Long): List<String> {
        val result = mutableListOf<String>()
        val request = "SELECT * FROM user_info WHERE id = ?"
        val quest = getDbConnection().prepareStatement(request)
        quest.setLong(1, id)
        val answer = quest.executeQuery()
        while (answer.next()) {
            for (i in 1..8) {
                result.add(answer.getString(i))
            }
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
    fun updateUser(id: Long, data: String, newData: String ) {
            val request = "UPDATE user_info SET $data = ? WHERE id = ?"
            val statement = getDbConnection().prepareStatement(request)
            when (data) {
                "phone" ->  statement.setLong(1, newData.toLong())
                "weight" -> statement.setDouble(1, newData.toDouble())
                else -> statement.setString(1, newData)
            }
            statement.setLong(2, id)
            statement.executeUpdate()

    }

    fun allInfo(id: Long): MutableList<String> {
        val result = mutableListOf<String>()
        val request = "SELECT course_name, train_day_name, exercise_name, sets, reps, exercise.weight, description FROM user_info \n" +
                "JOIN train_course on user_info.train_course_id = train_course .id\n" +
                "JOIN train_day_to_train_course on train_course.id = train_day_to_train_course.id_train_course\n" +
                "JOIN train_day on train_day_to_train_course.id_train_day = train_day.id\n" +
                "JOIN exercise_to_train_day on train_day.id = exercise_to_train_day.id_train_day\n" +
                "JOIN exercise on exercise_to_train_day.id_exercise = exercise.id\n" +
                "WHERE user_info.id = ? ORDER BY train_day_name;"
        val statement = getDbConnection().prepareStatement(request)
        statement.setLong(1, id)
        val answer = statement.executeQuery()
        while (answer.next()) {
            for (i in 1..7)
            result.add(answer.getString(i))
        }
        return result
    }

    fun getCourses(): MutableList<String> {
        val result = mutableListOf<String>()
        val request = "SELECT course_name FROM train_course"
        val quest = getDbConnection().prepareStatement(request)
        val answer = quest.executeQuery()
        while (answer.next()) {
            result.add(answer.getString(1))

        }
        return result
    }
}


