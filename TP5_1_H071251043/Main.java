package TP5_1_H071251043;

public class Main {
  public static void main(String[] args) {

    KaryawanTetap Vivien = new KaryawanTetap("Vivien", "001", 300, 50);

    Vivien.absen();
    Vivien.absen();

    System.out.println("Gaji Vivien: " + Vivien.hitungGaji(100));

    KaryawanKontrak Mufii = new KaryawanKontrak("Mufii", "002", 100);

    for (int i = 0; i < 21; i++) {
      Mufii.absen();
    }

    System.out.println("Gaji Mufii: " + Mufii.hitungGaji());
  }
}