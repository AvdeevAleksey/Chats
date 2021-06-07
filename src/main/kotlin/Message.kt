import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import java.util.*

data class Message(
    val messageId: Int = 0,
    val chatId: Int,
    val authorId: Int,
    val messageRecipientId: Int,
    val text: String,
    val dateTime: String = date(),
    val wasRead: Boolean = false
) {
}