import org.junit.Test
internal class MessageServiceTest {

    @Test
    fun add_test_empty() {
        val messageService:MessageService = MessageService()
        val expected: Int = 1
        messageService.add(Message(0,0,1,2,""))
        val result: Int = messageService.messages.last().messageId
        assert(expected == result)
    }

    @Test
    fun add_test_notEmpty() {
        val messageService:MessageService = MessageService()
        val expected: Int = 2
        messageService.add(Message(0,0,1,2,""))
        messageService.add(Message(0,0,1,2,""))
        val result: Int = messageService.messages.last().messageId
        assert(expected == result)
    }

    @Test
    fun delete_test_notEmpty() {
        val messageService:MessageService = MessageService()
        messageService.add(Message(0,0,1,2,""))
        messageService.add(Message(0,0,1,2,""))
        val searchMessageId: Message = messageService.messages.last()
        messageService.delete(messageService.get().last().chatId)
        assert(!messageService.messages.contains(searchMessageId))
    }

    @Test
    fun delete_test_empty() {
        val messageService:MessageService = MessageService()
        messageService.add(Message(0,0,1,2,""))
        val chatCount: Int = messageService.chatService.get().size
        messageService.delete(1)
        assert(chatCount != messageService.chatService.get().size)
    }

    @Test
    fun edit_test() {
        val messageService:MessageService = MessageService()
        val message: Message = Message(1,1,1,2,"text")
        messageService.add(message.copy(text = ""))
        messageService.edit(message)
        assert(messageService.messages.contains(message))
    }

    @Test
    fun get_test() {
        val messageService:MessageService = MessageService()
        messageService.add(Message(0,0,1,2,""))
        messageService.add(Message(0,0,1,2,""))
        val expected: Int = 2
        assert(messageService.get().size == expected)
    }
}