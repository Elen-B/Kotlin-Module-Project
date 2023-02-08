import data.Archive
import data.MenuItem
import menu.MainMenu
import java.util.Scanner

object ArchiveList {
    private val archiveList: MutableList<Archive> = mutableListOf()
    private val mainMenu: MainMenu = MainMenu()

    fun getStart() {
        this.mainMenu.start()
    }

    fun addArchive(scanner: Scanner): Boolean {
        val archive = Archive.newArchive(scanner)
        archiveList.add(archive)
        mainMenu.itemList.add(mainMenu.itemList.lastIndex, MenuItem(archive.name, action = {archive.archiveMenu.start(); true}))
        return true
    }
}