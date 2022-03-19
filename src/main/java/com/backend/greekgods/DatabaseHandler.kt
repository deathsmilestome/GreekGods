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

//    fun getDataForUser(): List<Long> {
//        val result = mutableListOf<Long>()
//        val request = "SELECT * FROM user_info"
//        getDbConnection().use { dbConnection ->
//            dbConnection.prepareStatement(request).use { prRequest ->
//                val answer = prRequest.executeQuery()
//                while (answer.next()) result.add(answer.getLong(1))
//                return result.toList()
//            }
//        }
//        return result
//    }

}