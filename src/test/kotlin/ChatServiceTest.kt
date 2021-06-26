import org.junit.Test

internal class ChatServiceTest {

    @Test
    fun add_test_empty() {
        val chatService: ChatService = ChatService()
        val expected: Int = 1
        chatService.add(Chat(0,1,2))
        val result: Int = chatService.chats.last().chatId
        assert(expected == result)
    }

    @Test
    fun add_test_notEmpty() {
        val chatService: ChatService = ChatService()
        val expected: Int = 2
        chatService.add(Chat(0,1,2))
        chatService.add(Chat(1,2,3))
        val result: Int = chatService.chats.last().chatId
        assert(expected == result)
    }

    @Test
    fun delete_test() {
        val chatService: ChatService = ChatService()
        chatService.add(Chat(0,1,2))
        val searchChatId: Chat = chatService.chats.last()
        chatService.delete(chatService.get().last().chatId)
        assert(!chatService.chats.contains(searchChatId))
    }

    @Test
    fun edit_test() {
        val chatService: ChatService = ChatService()
        val chat:Chat = Chat(1,1,3)
        chatService.add(chat.copy(userId = 2))
        chatService.edit(chat)
        assert(chatService.chats.contains(chat))
    }

    @Test
    fun get_test() {
        val chatService: ChatService = ChatService()
        val expected: Int = 2
        chatService.add(Chat(0,1,2))
        chatService.add(Chat(1,2,3))
        assert(chatService.get().size == expected)
    }

    @Test
    fun getUnreadChatsCount_test() {
        val messageService: MessageService = MessageService()
        val expected: Int = 2
        messageService.add(Message(0,1,1,2,""))
        messageService.add(Message(0,2,1,4,"",wasRead = true))
        messageService.add(Message(0,3,1,3,""))
        val result: Int = messageService.chatService.getUnreadChatsCount(1)
        assert(result == expected)
    }

    @Test
    fun getChats_test() {
        val messageService: MessageService = MessageService()
        val expected: Int = 2
        messageService.add(Message(0,1,1,2,""))
        messageService.add(Message(0,2,1,4,"",wasRead = true))
        messageService.add(Message(0,3,1,3,""))
        val result: Int = messageService.chatService.getChats(1).size
        assert(result == expected)
    }

}