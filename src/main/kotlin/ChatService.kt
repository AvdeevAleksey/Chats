class ChatService: CrudService <Chat> {

    val chats = mutableListOf<Chat>()

    override fun add(entity: Chat): Int {
        val lastId = if (chats.isNotEmpty()) chats.last().chatId + 1 else 1
        chats.add(entity.copy(chatId = lastId))
        return chats.size
    }

    override fun delete(id: Int) {
        chats.removeIf { it ->
            it.chatId == id
        }
    }

    override fun edit(entity: Chat) {
        chats[chats.indexOfFirst { it -> it.chatId == entity.chatId }] = entity
    }

    override fun get(): List<Chat> {
        return chats?: emptyList()
    }

    fun getUnreadChatsCount() {
        //TODO
    }

    fun getChats(id: Int): List<Chat> {
        //TODO
    }
}