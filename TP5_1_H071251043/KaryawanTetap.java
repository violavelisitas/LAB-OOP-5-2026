package TP5_1_H071251043;

class KaryawanTetap extends Karyawan {
  double gajiPokok;
  double tunjanganMakan;

  public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
    super(nama, idKaryawan);
    this.gajiPokok = gajiPokok;
    this.tunjanganMakan = tunjanganMakan;

  }

  double hitungGaji(){
    return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
  }

  double hitungGaji(double bonusKinerja){
    return hitungGaji() + bonusKinerja;
  }




}