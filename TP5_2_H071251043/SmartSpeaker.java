class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
  public SmartSpeaker(String merk, int dayaListrik) {
    super(merk, dayaListrik);
  }

  void cekFungsi() {
    System.out.println("\nSpeaker siap digunakan");
  }

  public void hubungkanWiFi() {
    System.out.println("Speaker terhubung ke WiFi");
  }

  public void prosesPerintah(String perintah) {
    System.out.println("Memproses perintah: " + perintah);
  }
}
