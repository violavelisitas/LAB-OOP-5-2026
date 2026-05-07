import java.util.ArrayList;
import java.util.List;

class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int id) {
        for (LibraryItem item : items) {
            if (item.itemId == id) return item;
        }
        throw new IllegalArgumentException("Item tidak ditemukan.");
    }

    public Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equals(id)) return m;
        }
        throw new IllegalArgumentException("Member tidak ditemukan.");
    }

    public void getLibraryStatus() {
        System.out.println("+------+---------------+----------+");
        System.out.println("|  ID  |     Judul     |  Status  |");
        System.out.println("+------+---------------+----------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-4d | %-13s | %-8s |\n", item.itemId, item.title, status);
        }
        System.out.println("+------+---------------+----------+");
    }

    public LibraryLogger getLogger() { return logger; }
}