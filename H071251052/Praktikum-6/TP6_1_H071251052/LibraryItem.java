//Abstract class LibraryItem
abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    //constructor
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    // Abstract methods
    public abstract String getDescription();//deskripsi item
    public abstract String borrowItem(int days);//deskripsi peminjaman
    public abstract double calculateFine(int daysLate);//jumlah dendanya

    // Method
    public String returnItem() {
        this.isBorrowed = false;
        return "[" + this.title + "] dikembalikan";
    }
}

// Class Book
class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14){
            throw new IllegalArgumentException("Maksimal peminjaman buku adalah 14 hari.");
        }
        if (isBorrowed){
            throw new IllegalArgumentException("Item telah dipinjam dan belum dikembalikan.");
        }
        isBorrowed = true;
        return "Item [" + title + "] berhasil dipinjam selama " + days + " hari";
    }
    

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000.0;
    }

    @Override
    public String getDescription() {
        return "Buku: [" + title + "] oleh " + author + ", ID: " + itemId;
    }
}

// Class DVD
class DVD extends LibraryItem {
    private int duration;//menit

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman DVD adalah 7 hari.");
        }
        isBorrowed = true;
        return "Item [" + title + "] berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000.0;
    }

    @Override
    public String getDescription() {
        return "DVD: [" + title + "], durasi " + duration + " menit, ID: " + itemId;
    }
}