package TP5_1_H071251043;

abstract class Karyawan {
  private String nama;
  private String idKaryawan;
  private int jumlahKehadiran;
  
  public Karyawan(String nama, String idKaryawan) {
    this.nama = nama;
    this.idKaryawan = idKaryawan;
    this.jumlahKehadiran = 0;
  }

  int getJumlahKehadiran(){
    return jumlahKehadiran;
  }

  void absen() {
    jumlahKehadiran += 1;
  }

  abstract double hitungGaji();
  
} 
  
