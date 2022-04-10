package com.backend.greekgods

class Menu {
    fun startMenu() {
        var menuStatus = 999
        println("Choose:\n1 - info\n2 - change smth\n3 - diet\n0 - exit")
        while (menuStatus != 0) {
            menuStatus = readln().toInt()
            when (menuStatus) {
                1 -> user.userInfo()
                2 -> {
                    println("change what?\n1 - username\n2 - pass\n3 - first name\n4 - second name\n5 - phone\n6 - weight")
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
                }
                3 -> {
                    val weight = user.getWeight()
                    println("Your weight: $weight" +
                            "\nkcal: ${weight * 50}" +
                            "\nproteins: ${weight * 1.8}" +
                            "\ncarbs: ${weight * 2}" +
                            "\nfats: ${weight * 0.9}" +
                            "\nwater: ${weight * 0.05}")
                }
                else -> println("?")
            }
        }
        println("Goodbye;)")
    }
}