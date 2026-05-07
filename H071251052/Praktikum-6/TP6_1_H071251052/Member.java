import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed){
            throw new IllegalStateException("Item tidak tersedia.");
        }
        String message = item.borrowItem(days);
        borrowedItems.add(item);
        return message;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        double fine = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+------+---------------+");
        System.out.println("|  ID  |     Judul     |");
        System.out.println("+------+---------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-13s |%n", item.itemId, item.title);
        }
        System.out.println("+------+---------------+");
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
}