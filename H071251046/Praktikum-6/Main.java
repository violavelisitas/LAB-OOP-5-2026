import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Jenis (1 untuk Buku, 2 untuk DVD): ");
                        String type = scanner.nextLine();
                        System.out.print("ID Item: ");
                        int itemId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Judul: ");
                        String title = scanner.nextLine();
                        
                        if (type.equals("1")) {
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            System.out.println(library.addItem(new Book(title, itemId, author)));
                        } else if (type.equals("2")) {
                            System.out.print("Durasi (menit): ");
                            int duration = Integer.parseInt(scanner.nextLine());
                            System.out.println(library.addItem(new DVD(title, itemId, duration)));
                        } else {
                            System.out.println("Jenis tidak valid.");
                        }
                        break;
                    case "2":
                        System.out.print("ID Anggota: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Nama Anggota: ");
                        String name = scanner.nextLine();
                        library.addMember(new Member(name, memberId));
                        break;
                    case "3":
                        System.out.print("ID Anggota: ");
                        String bMemberId = scanner.nextLine();
                        System.out.print("ID Item: ");
                        int bItemId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Lama pinjam (hari): ");
                        int bDays = Integer.parseInt(scanner.nextLine());
                        library.borrowProcess(bMemberId, bItemId, bDays);
                        break;
                    case "4":
                        System.out.print("ID Anggota: ");
                        String rMemberId = scanner.nextLine();
                        System.out.print("ID Item: ");
                        int rItemId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Keterlambatan (hari): ");
                        int rDaysLate = Integer.parseInt(scanner.nextLine());
                        library.returnProcess(rMemberId, rItemId, rDaysLate);
                        break;
                    case "5":
                        library.getLibraryStatus();
                        break;
                    case "6":
                        library.getAllLogs();
                        break;
                    case "7":
                        System.out.print("ID Anggota: ");
                        String sMemberId = scanner.nextLine();
                        library.printMemberBorrowedItems(sMemberId);
                        break;
                    case "8":
                        System.out.println("Keluar dari sistem. Terima kasih!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input data. Pastikan ID dan angka diisi dengan benar.");
            }
        }
    }
}