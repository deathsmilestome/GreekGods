package com.backend.greekgods

class User(
        var trainCourseId: Int,
        var username: String,
        var pas: String,
        var firstName: String,
        var secondName: String,
        var phone: Long,
        var weight: Double
) {
    fun userInfo() {
        println(this.trainCourseId)
        println(this.username)
        println(this.pas)
        println(this.firstName)
        println(this.secondName)
        println(this.phone)
        println(this.weight)
    }
}
