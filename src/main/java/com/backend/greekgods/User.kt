package com.backend.greekgods

public class User() {
    private var id = 0L
    private var trainCourseId = 0
    private var username = ""
    private var pas = ""
    private var firstName = ""
    private var secondName = ""
    private var phone = 0L
    private var weight = 0.0

    fun setUserInfo(id: Long) {
        this.id = DatabaseHandler().getDataForUser(id)[0].toLong()
        this.trainCourseId = DatabaseHandler().getDataForUser(id)[1].toInt()
        this.username = DatabaseHandler().getDataForUser(id)[2]
        this.pas = DatabaseHandler().getDataForUser(id)[3]
        this.firstName = DatabaseHandler().getDataForUser(id)[4]
        this.secondName = DatabaseHandler().getDataForUser(id)[5]
        this.phone = DatabaseHandler().getDataForUser(id)[6].toLong()
        this.weight = DatabaseHandler().getDataForUser(id)[7].toDouble()
    }

    fun userInfo() {
        println("------------------------------------")
        println("|Your ID: ${this.id}")
        println("|Your train course: ${DatabaseHandler().getCourses()[this.trainCourseId]}")
        println("|Your username: ${this.username}")
        println("|Your pass: ${ this.pas }")
        println("|Your first name: ${this.firstName}")
        println("|Your second name: ${this.secondName}")
        println("|Your phone: ${this.phone}")
        println("|Your weight: ${this.weight}")
        println("------------------------------------")
    }

    fun getWeight() = this.weight
}
