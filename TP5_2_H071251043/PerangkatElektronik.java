abstract class PerangkatElektronik {
  String merk;
  int dayaListrik;

  public PerangkatElektronik(String merk, int dayaListrik) {
    this.merk = merk;
    this.dayaListrik = dayaListrik;
  }

  abstract void cekFungsi();

  void infoPower() {
    System.out.println("Perangkat sedang menyedot daya sebesar" + dayaListrik + " Watt");
  }
}