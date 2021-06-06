import java.util.*

data class Message(
    val messageId: Int = 0,
    val chatId: Int,
    val authorId: Int,
    val messageRecipientId: Int,
    val text: String,
    val dateTime: Date,
    val wasRead: Boolean = false
) {
}