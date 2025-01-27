package data

data class MenuItem(val name: String, val action: () -> Boolean) {
    override fun toString(): String {
        return name
    }
}
