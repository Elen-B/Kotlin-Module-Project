package data

import menu.NoteMenu
import java.util.Scanner

data class Note(val name:String = "Без названия #${getNextNoNameID()}", val value: String? = null) {
    val noteMenu: NoteMenu = NoteMenu(this)

    companion object {
        private var noNameID: Int = 0

        fun getNextNoNameID(): Int {
            return ++noNameID
        }

        fun newNote(scanner: Scanner) : Note {
            print("Введите название заметки: ")
            val inputName: String = scanner.nextLine()
            print("Введите текст заметки: ")
            val inputValue: String = scanner.nextLine()
            if (inputName.isEmpty()) return Note(value = inputValue)
            return Note(inputName, inputValue)
        }
    }

    override fun toString(): String {
        return "Заголовок заметки: $name\nТекст: $value"
    }
}
