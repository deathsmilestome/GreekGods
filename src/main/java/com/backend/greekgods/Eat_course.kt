package com.backend.greekgods

import java.math.BigInteger

class Eat_course(var id: BigInteger = 0.toBigInteger(), var kilocalories: Int = 1, var proteins: Int = 1
, var carbs: Int = 1, var fats: Int = 1, var water: Double = 1.0) {
    fun reset(new_weight: Double){
        this.kilocalories = (new_weight * 10).toInt()
        this.proteins = (new_weight * 1.8).toInt()
        this.carbs = (new_weight * 2.5).toInt()
        this.fats = (new_weight * 0.7).toInt()
        this.water = new_weight * 0.05
//запрос на вставку kpcfw в бд
//из бд берем id
//this.id = новый id из бд
        //return this.id
    }
}

//class Eat_course() {
//    fun reset(new_weight: Double){
//        var kilocalories = (new_weight * 10).toInt()
//        var proteins = (new_weight * 1.8).toInt()
//        var carbs = (new_weight * 2.5).toInt()
//        var fats = (new_weight * 0.7).toInt()
//        var water = new_weight * 0.05
//
//        //запрос на вставку в бд
//        //из бд берем id
//        //this.id = новый id из бд
//    }
//}