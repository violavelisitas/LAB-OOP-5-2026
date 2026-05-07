import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam).");
        }
        String message = item.borrowItem(days); 
        item.setBorrowed(true);
        borrowedItems.add(item);
        return message;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Member ini tidak meminjam item tersebut.";
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %.0f", item.getTitle(), fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }
        System.out.println("+--------+--------------------------------+");
        System.out.printf("| %-6s | %-30s |\n", "ID", "Judul");
        System.out.println("+--------+--------------------------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-6d | %-30s |\n", item.getItemId(), item.getTitle());
        }
        System.out.println("+--------+--------------------------------+");
    }
}