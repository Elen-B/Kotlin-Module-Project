package menu

import data.Archive
import data.MenuItem

class ArchiveMenu(archive: Archive): Menu() {
    override val title: String = "Архив '${archive.name}'. Список заметок"
    override val itemList: MutableList<MenuItem> = mutableListOf(
        MenuItem("Создать заметку", action = {archive.addNote(scanner)}),
        MenuItem("Назад", action = {super.exit()})
    )
}