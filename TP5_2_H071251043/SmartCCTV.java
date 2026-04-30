class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
  public SmartCCTV(String merk, int dayaListrik) {
    super(merk, dayaListrik);
  }

  void cekFungsi() {
    System.out.println("CCTV aktif");
  }
  
  public void hubungkanWiFi() {
    System.out.println("Mengirim data ke server...");
  }
}
