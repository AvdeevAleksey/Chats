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

    fun getUnreadChatsCount(userId: Int): Int {
        return chats.count { it.ownerId == userId && it.messages.any { it -> !it.wasRead } }
    }

    fun getChats(userId: Int) = chats.filter {
        it.ownerId == userId
    }.map { chat ->
        chat.messages.replaceAll { message ->
            message.copy(wasRead = true)
        }
    }
}