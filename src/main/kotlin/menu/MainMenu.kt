package menu

import ArchiveList
import data.MenuItem

class MainMenu : Menu() {
    override val title: String = "Список архивов"
    override val itemList: MutableList<MenuItem> = mutableListOf(
        MenuItem("Создать архив", action = { ArchiveList.addArchive(scanner) }),
        MenuItem("Выход", action = {exit()})
    )

    override fun exit(): Boolean {
        println("Завершение работы приложения..")
        return false
    }
}