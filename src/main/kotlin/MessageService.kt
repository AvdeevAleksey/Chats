class MessageService: CrudService<Message> {

    private val messages = mutableListOf<Message>()
    val chatService: ChatService = ChatService()
    val userService: UserService = UserService()

    override fun add(entity: Message): Int {
        if (chatService.chats.isNotEmpty()) {
            val chat = chatService.chats.find { it ->
                it.ownerId == entity.authorId &&
                it.userId == entity.messageRecipientId ||
                it.ownerId == entity.messageRecipientId &&
                it.userId == entity.authorId
            }
            if (chat != null) {
                messages.add(messages.size, entity.copy(messageId = messages.last().messageId+1, chatId = chat.chatId))
                chatService.edit(chat.copy(messages = messages.filter { it.chatId == chat.chatId } as MutableList<Message>))
            } else {
                messages.add(messages.size, entity.copy(messageId = messages.size+1, chatId = chatService.chats.size+1))
                chatService.add(Chat(chatService.chats.size+1, entity.authorId, entity.messageRecipientId, messages.filter { it.chatId == chatService.chats.size+1} as MutableList<Message>))
            }
        } else {
            messages.add(messages.size, entity.copy(messageId = messages.size+1, chatId = chatService.chats.size+1))
            chatService.add(Chat(0, entity.authorId, entity.messageRecipientId, messages))
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