package data

import menu.ArchiveMenu
import java.util.Scanner

data class Archive(val name: String = "Без названия #${getNextNoNameID()}", val itemList: MutableList<Note> = mutableListOf()) {
    val archiveMenu: ArchiveMenu = ArchiveMenu(this)

    companion object {
        private var noNameID: Int = 0

        private fun getNextNoNameID(): Int {
            return ++noNameID
        }

        fun newArchive(scanner: Scanner) : Archive {
            print("Введите название архива: ")
            val inputName: String = scanner.nextLine()
            if (inputName.isEmpty()) return Archive()
            return Archive(inputName)
        }
    }

    fun addNote(scanner: Scanner): Boolean {
        val note = Note.newNote(scanner)
        itemList.add(note)
        archiveMenu.itemList.add(archiveMenu.itemList.lastIndex,
            MenuItem(note.name, action = { note.noteMenu.start(); true })
        )
        return true
    }
}
