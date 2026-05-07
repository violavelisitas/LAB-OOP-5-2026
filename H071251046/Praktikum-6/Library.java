import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member " + member.getName() + " berhasil ditambahkan.");
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }
    
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan.");
    }

    public void borrowProcess(String memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        
        String result = member.borrow(item, days);
        System.out.println(result);
        
        String type = item instanceof Book ? "Buku" : "DVD";
        logger.logActivity("[" + type + "] " + item.getTitle() + " dipinjam oleh " + member.getName() + " selama " + days + " hari");
    }

    public void returnProcess(String memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        
        String result = member.returnItem(item, daysLate);
        System.out.println(result);
        
        String type = item instanceof Book ? "Buku" : "DVD";
        logger.logActivity("[" + type + "] " + item.getTitle() + " dikembalikan oleh " + member.getName() + " (Terlambat: " + daysLate + " hari)");
    }

    public void getLibraryStatus() {
        System.out.println("+--------+--------------------------------+------------+");
        System.out.printf("| %-6s | %-30s | %-10s |\n", "ID", "Judul", "Status");
        System.out.println("+--------+--------------------------------+------------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-6d | %-30s | %-10s |\n", item.getItemId(), item.getTitle(), status);
        }
        System.out.println("+--------+--------------------------------+------------+");
    }

    public void getAllLogs() {
        logger.getLogs();
    }
    
    public void printMemberBorrowedItems(String memberId) {
        Member member = findMemberById(memberId);
        System.out.println("Daftar pinjaman member: " + member.getName());
        member.getBorrowedItems();
    }
}