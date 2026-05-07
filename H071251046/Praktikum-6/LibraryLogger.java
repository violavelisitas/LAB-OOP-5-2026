import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " | " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public void getLogs() {
        if (logs.isEmpty()) {
            System.out.println("Belum ada log aktivitas.");
            return;
        }
        System.out.println("=== Log Aktivitas ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void clearLogs() {
        logs.clear();
    }
}