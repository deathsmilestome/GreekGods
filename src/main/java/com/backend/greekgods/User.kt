package com.backend.greekgods

import java.math.BigInteger


class User(var id: Int, var train_course_id: Int, var eat_course_id: Int, var username: String, var pas: String
,var first_name: String, var second_name: String, var phone: BigInteger, var weight: Double) {
    fun reset_eat_course(weight: Double){

    }
}
