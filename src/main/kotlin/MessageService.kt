class MessageService: CrudService<Message> {

    private val messages = mutableListOf<Message>()

    override fun add(entity: Message): Int {
        val lastId = if (messages.isNotEmpty()) messages.last().messageId + 1 else 1
        messages.add(entity.copy(messageId = lastId))
        return messages.size
    }

    override fun delete(id: Int) {
        val chat: Int = messages[messages.lastIndex].chatId
        messages.removeIf { it ->
            it.messageId == id
        }
        if (messages.isEmpty()) {
            val chatService: ChatService = ChatService()
            chatService.delete(chat)
        }
    }

    override fun edit(entity: Message) {
        messages[messages.indexOfFirst { it -> it.messageId == entity.messageId }] = entity
    }

    override fun get(): List<Message> {
        return messages?: emptyList()
    }
}