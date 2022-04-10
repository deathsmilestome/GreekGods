package com.backend.greekgods

class Menu {
    fun startMenu() {
        println("Choose:\n1 - info\n2 - change smth")
        when (readln().toInt()) {
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
            else -> println("?")
        }
    }
}