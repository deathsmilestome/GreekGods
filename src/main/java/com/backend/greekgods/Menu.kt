package com.backend.greekgods

class Menu {
    private fun showMenu() {
        println("Choose:" +
                "\n1 - info" +
                "\n2 - change smth" +
                "\n3 - diet" +
                "\n4 - trains" +
                "\n0 - exit")
    }
    fun startMenu() {
        var menuStatus = 999
        showMenu()
        while (menuStatus != 0) {
            menuStatus = readln().toInt()
            when (menuStatus) {
                1 -> {
                    user.userInfo()
                    showMenu()
                }
                2 -> {
                    println("change what?" +
                            "\n1 - username" +
                            "\n2 - pass" +
                            "\n3 - first name" +
                            "\n4 - second name" +
                            "\n5 - phone" +
                            "\n6 - weight")
                    var data = ""
                    var changeColumn = 0
                    while (changeColumn !in 1..6) {
                        changeColumn = readln().toInt()
                        when (changeColumn) {
                            1 -> data = "username"
                            2 -> data = "pas"
                            3 -> data = "first_name"
                            4 -> data = "second_name"
                            5 -> data = "phone"
                            6 -> data = "weight"
                            else -> println("incorrect")
                        }
                    }
                    println("send new info")
                    val newData = readln()
                    DatabaseHandler().updateUser(id, data, newData)
                    showMenu()
                }
                3 -> {
                    val weight = user.getWeight()
                    println("------------------------------------" +
                            "\n|Your weight: $weight" +
                            "\n|kcal: ${weight * 50}" +
                            "\n|proteins: ${weight * 1.8}" +
                            "\n|carbs: ${weight * 2}" +
                            "\n|fats: ${weight * 0.9}" +
                            "\n|water: ${weight * 0.05}" +
                            "\n------------------------------------")
                    showMenu()
                }
                4 -> {
                    val temp = DatabaseHandler().allInfo(id)
                    var countDays = 0
                    println("------------------------------------" +
                            "\nTrain course: ${temp[0]}")
                    for (i in 0 until  temp.size step 7) {
                        if (i != 0 && temp[i + 1] == temp[i - 6])
                            println("-${temp[i + 2]}: ${temp[i + 3]} sets for ${temp[i + 4]} reps with ${temp[i + 5]} (${temp[i + 6]})")
                        else {
                            countDays++
                            println("Train day ${countDays}: ${temp[i + 1]}\n" +
                                    "-${temp[i + 2]}: ${temp[i + 3]} sets for ${temp[i + 4]} reps with ${temp[i + 5]} (${temp[i + 6]})")
                        }
                    }
                    println("------------------------------------")
                    showMenu()
                }
                0 -> println("Goodbye;)")
                else -> println("?")
            }
        }
    }
}