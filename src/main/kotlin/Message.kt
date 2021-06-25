import java.time.Instant.now
import java.util.*

data class Message(
    val messageId: Int = 0,
    val chatId: Int,
    val authorId: Int,
    val messageRecipientId: Int,
    val text: String,
    val dateTime: String = now().toString(),
    val wasRead: Boolean = false
) {
}