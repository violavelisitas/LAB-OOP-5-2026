public class Main {
  public static void main(String[] args) {
    SmartCCTV cctv = new SmartCCTV("dahua", 15);

    SmartLamp lampu = new SmartLamp("philips", 10);

    SmartSpeaker speaker = new SmartSpeaker("xiaomi", 12);

    cctv.cekFungsi();
    cctv.hubungkanWiFi();
    cctv.infoPower();

    lampu.cekFungsi();
    lampu.prosesPerintah("NYALA");
    lampu.infoPower();

    speaker.cekFungsi();
    speaker.hubungkanWiFi();
    speaker.prosesPerintah("NYALA");
    speaker.infoPower();

  }
}
