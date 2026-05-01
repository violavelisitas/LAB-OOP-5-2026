package TP5_1_H071251043;

class KaryawanKontrak extends Karyawan{
  double upahPerHari;

  public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
    super(nama, idKaryawan);
    this.upahPerHari = upahPerHari;
  }

  double hitungGaji(){
    double totalGaji = upahPerHari * getJumlahKehadiran();

    if (getJumlahKehadiran() > 20) {
      totalGaji += 500000;
    }
    return totalGaji;
  }
}
