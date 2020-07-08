import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DiaryEntry {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private final LocalDateTime createdAt;

    DiaryEntry(/* Add necessary parameters */) {
        this.createdAt = LocalDateTime.now();
    }

    private static LocalDateTime parseDateTimeString(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString);
    }

    private String getDateTimeString() {
        return createdAt.format(formatter);
    }
}
