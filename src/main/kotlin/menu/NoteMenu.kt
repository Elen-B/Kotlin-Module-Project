package menu

import data.MenuItem
import data.Note

class NoteMenu(note: Note): Menu() {
    override val title: String = "Заметка '${note.name}'"
    override val itemList: MutableList<MenuItem> = mutableListOf(
        MenuItem("Открыть заметку", action = {println(note); true}),
        MenuItem("Назад", action = {exit()})
    )
}