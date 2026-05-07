import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Buku yang Dipinjam");
            System.out.println("6. Lihat Deskripsi Item");
            System.out.println("7. Lihat Status Perpustakaan");
            System.out.println("8. Lihat Log Aktivitas");
            System.out.println("9. Keluar");
            System.out.print("Pilih: ");
            int choice = sc.nextInt(); sc.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Tipe (1. Buku / 2. DVD): ");
                    int tipe = sc.nextInt(); sc.nextLine();

                    System.out.print("Judul: ");
                    String judul = sc.nextLine();

                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    if (tipe == 1) {
                        System.out.print("Penulis: ");
                        String pen = sc.nextLine();
                        System.out.println(lib.addItem(new Book(judul, id, pen)));
                    } else {
                        System.out.print("Durasi (menit): ");
                        int dur = sc.nextInt();
                        System.out.println(lib.addItem(new DVD(judul, id, dur)));
                    }
                    
                } else if (choice == 2){
                    System.out.print("Nama Member: ");
                    String nm = sc.nextLine();
                    System.out.print("ID Member: ");
                    String mid = sc.nextLine();
        
                    Member memberBaru = new Member(nm, mid);
                    lib.addMember(memberBaru);
                    System.out.println("Member " + nm + " berhasil ditambahkan.");

                } else if (choice == 3) {
                    System.out.print("ID Member: ");
                    String mid = sc.nextLine();

                    System.out.print("ID Item: ");
                    int iid = sc.nextInt();

                    System.out.print("Hari: ");
                    int h = sc.nextInt();

                    Member m = lib.findMemberById(mid);
                    LibraryItem item = lib.findItemById(iid);
                    System.out.println(m.borrow(item, h));
                    lib.getLogger().logActivity(item.title + " dipinjam oleh " + m.getName());

                } else if (choice == 4) {
                    try {
                        System.out.print("ID Member: ");
                        String rMid = sc.nextLine();
                        System.out.print("ID Item: ");
                        int rId = sc.nextInt();
                        System.out.print("Keterlambatan (Hari): ");
                        int late = sc.nextInt();
            
                        Member rm = lib.findMemberById(rMid);
                        LibraryItem ri = lib.findItemById(rId);
            
                        String pesanKembali = rm.returnItem(ri, late);
                        System.out.println(pesanKembali);
            
                        lib.getLogger().logActivity(ri.title + " dikembalikan oleh " + rm.getName());
                    } finally {
                        sc.nextLine(); 
                        System.out.println("Status: Operasi pengembalian selesai.");
                    }

                } else if (choice == 5) {
                    System.out.print("ID Member: ");
                    String mid = sc.nextLine();
                    Member m = lib.findMemberById(mid);
                    m.getBorrowedItems();

                } else if (choice == 6){
                    System.out.print("ID Item: ");
                    int rId = sc.nextInt();
                    LibraryItem ri = lib.findItemById(rId);
                    if (ri != null){
                        System.out.println(ri.getDescription());
                    }else{
                        System.out.println("Item dengan ID " + rId + " tidak");
                    }

                } else if (choice == 7) {
                    lib.getLibraryStatus();

                } else if (choice == 8) {
                    System.out.println(lib.getLogger().getLogs());
                    
                } else if (choice == 9) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Kesalahan: " + e.getMessage());
            }
        }
        sc.close();
    }
}