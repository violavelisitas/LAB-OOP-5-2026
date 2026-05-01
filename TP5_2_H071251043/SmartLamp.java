class SmartLamp extends PerangkatElektronik implements KontrolSuara {
  public SmartLamp(String merk, int dayaListrik) {
    super(merk, dayaListrik);
  }

  void cekFungsi() {
    System.out.println("\nSmart Lamp siap digunakan");
  }

  public void prosesPerintah(String perintah) {
    if (perintah.equals("NYALA")) {
      System.out.println("Lampu berpijar");
    }
    else {
      System.out.println("Input tidak valid");
    }

  }
}
