fun main() {

//    val chatService: ChatService = ChatService()
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
    println(message = messageService.add(Message(0,0,1,2,"text1")))
    println(message = messageService.add(Message(0,0,1,2,"text2")))
    println(message = messageService.add(Message(0,0,2,3,"text3")))
    println(message = messageService.add(Message(0,0,1,2,"text4")))
    println(message = messageService.get())
    println()
    println(message = messageService.chatService.get())



}