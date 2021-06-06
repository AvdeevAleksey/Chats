class UserService: CrudService<User> {

    private val users = mutableListOf<User>()

    override fun add(entity: User): Int {
        val lastId = if (users.isNotEmpty()) users.last().userId + 1 else 1
        users.add(entity.copy(userId = lastId))
        return users.size
    }

    override fun delete(id: Int) {
        users.removeIf { it ->
            it.userId == id
        }
    }

    override fun edit(entity: User) {
        users[users.indexOfFirst { it -> it.userId == entity.userId }] = entity
    }

    override fun get(): List<User> {
        return users?: emptyList()
    }
}