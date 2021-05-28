data class Chat(
    val chatId: Int =0,
    val ownerId: Int,
    val userId: Int,
    val messageViewedList: List<Message>,
    val messageUnvisitedList: List<Message>
) {
}