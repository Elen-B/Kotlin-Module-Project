package menu

import data.MenuItem
import java.util.Scanner

abstract class Menu {
    abstract val title: String
    abstract val itemList: MutableList<MenuItem>
    val scanner = Scanner(System.`in`)

    private fun printMenu() {
        println("= $title =")
        itemList.forEachIndexed { index, item -> println("\t$index. $item") }
    }

    private fun isCorrectItem(inString: String): Pair<Boolean, String?> {
        val inInt = inString.toIntOrNull() ?: return Pair(false, "Неверное значение. Следует вводить число")
        if (!itemList.indices.contains(inInt)) return Pair(false, "Неверное значение. Элемента меню с таким номером нет")
        return Pair(true, null)
    }

    private fun selectItem(): Boolean {
        while (true) {
            printMenu()
            print("Введите номер пункта меню: ")
            val inputStr: String = scanner.nextLine()
            val (fCorrectItem, errorString) = isCorrectItem(inputStr)
            if (fCorrectItem) {
                return itemList.elementAt(inputStr.toInt()).action()
            }
            println(errorString)
        }
    }

    fun start() {
        while (true) {
            if (!selectItem()) {
                break
            }
        }
    }

    open fun exit(): Boolean {
        println("Выход в предыдущее меню..")
        return false
    }
}