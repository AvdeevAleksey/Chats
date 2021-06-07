class MessageService: CrudService<Message> {

    private val messages = mutableListOf<Message>()
    val chatService: ChatService = ChatService()

    override fun add(entity: Message): Int {
        val lastId = if (messages.isNotEmpty()) messages.last().messageId + 1 else 1
        messages.add(entity.copy(messageId = lastId))
        if (lastId == 1) {
            chatService.add(Chat(0, entity.authorId, entity.messageRecipientId, messages))
        } else {
            chatService.edit(Chat(entity.chatId, entity.authorId,entity.messageRecipientId, messages))
        }
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