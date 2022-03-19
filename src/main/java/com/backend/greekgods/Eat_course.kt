package com.backend.greekgods

object EatCourse {
    var kilocalories = 0
    var proteins = 0
    var carbs = 0
    var fats = 0
    var water = 0.0
    fun reset(new_weight: Double): Long{
        this.kilocalories = (new_weight * 10).toInt()
        this.proteins = (new_weight * 1.8).toInt()
        this.carbs = (new_weight * 2.5).toInt()
        this.fats = (new_weight * 0.7).toInt()
        this.water = new_weight * 0.05
        //coroutines kotlin.lang
//запрос на вставку kpcfw в бд
//из бд берем id
//this.id = новый id из бд
        return 1L
    }
}
