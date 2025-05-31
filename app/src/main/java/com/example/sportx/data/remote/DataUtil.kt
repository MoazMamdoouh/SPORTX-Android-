import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateUtil {

    companion object {

        private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        fun getDate7DaysAgo(): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -7)
            return dateFormat.format(calendar.time)
        }

        fun getDateIn7Days(): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, 7)
            return dateFormat.format(calendar.time)
        }
    }
}
