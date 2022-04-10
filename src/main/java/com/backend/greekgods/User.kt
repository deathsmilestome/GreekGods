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
        println(this.id)
        println(this.trainCourseId)
        println(this.username)
        println(this.pas)
        println(this.firstName)
        println(this.secondName)
        println(this.phone)
        println(this.weight)
    }

    fun getWeight() = this.weight
}
