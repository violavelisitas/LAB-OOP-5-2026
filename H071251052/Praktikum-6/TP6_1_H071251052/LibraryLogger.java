import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    public void logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(timestamp + " " + activity);
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Log kosong.";
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}