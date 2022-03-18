package com.backend.greekgods

import java.math.BigInteger

//var id: Int
class User(var train_course_id: Int, var eat_course_id: Int, var username: String, var pas: String
,var first_name: String, var second_name: String, var phone: BigInteger, var weight: Double) {
    fun userInfo(){
        println(this.train_course_id)
        println(this.eat_course_id)
        println(this.username)
        println(this.pas)
        println(this.first_name)
        println(this.second_name)
        println(this.phone)
        println(this.weight)

    }
}
