fun main() {

    val chatService: ChatService = ChatService()
//    println(message = chatService.add(Chat(0,1,2)))
//    println(message = chatService.add(Chat(0,2,3)))
//    println(message = chatService.add(Chat(0,3,1)))
//    println()
//    println(message = chatService.get())
//    chatService.edit(Chat(1,1,1))
//    println()
//    println(message = chatService.get())
//    chatService.delete(1)
//    println()
    val messageService: MessageService = MessageService()
    println(message = messageService.add(Message(0,0,1,2,"text")))
    println(message = chatService.get())
    println(message = messageService.get())

}