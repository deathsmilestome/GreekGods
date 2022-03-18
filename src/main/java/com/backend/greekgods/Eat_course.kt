package com.backend.greekgods

import java.math.BigInteger

class Eat_course(var id: BigInteger, var kilocalories: Int, var proteins: Int
, var carbs: Int, var fats: Int, var water: Double) {
    fun reset(new_weight: Double){
        this.kilocalories = (new_weight * 10).toInt()
        this.proteins = (new_weight * 1.8).toInt()
        this.carbs = (new_weight * 2.5).toInt()
        this.fats = (new_weight * 0.7).toInt()
        this.water = new_weight * 0.05
    }
}