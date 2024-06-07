import java.util.ArrayList;
import java.util.Scanner;

class GelirGider {
    private String aciklama;
    private double miktar;

    public GelirGider(String aciklama, double miktar) {
        this.aciklama = aciklama;
        this.miktar = miktar;
    }

    public String getAciklama() {
        return aciklama;
    }

    public double getMiktar() {
        return miktar;
    }
}

public class HesapTakipUygulamasi {
    private static ArrayList<GelirGider> hesapHareketleri = new ArrayList<>();
    private static double toplamBakiye = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Gelir Ekle");
            System.out.println("2. Gider Ekle");
            System.out.println("3. Hesap Hareketlerini Görüntüle");
            System.out.println("4. Toplam Bakiye");
            System.out.println("5. Çıkış");

            System.out.print("Yapmak istediğiniz işlemi seçin: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    gelirEkle(scanner);
                    break;
                case 2:
                    giderEkle(scanner);
                    break;
                case 3:
                    hesapHareketleriniGoruntule();
                    break;
                case 4:
                    toplamBakiyeyiGoruntule();
                    break;
                case 5:
                    System.out.println("Programdan çıkılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz işlem!");
            }
        }
    }

    private static void gelirEkle(Scanner scanner) {
        System.out.print("Gelir açıklamasını girin: ");
        String aciklama = scanner.next();
        System.out.print("Gelir miktarını girin: ");
        double miktar = scanner.nextDouble();

        hesapHareketleri.add(new GelirGider(aciklama, miktar));
        toplamBakiye += miktar;
        System.out.println("Gelir başarıyla eklendi.");
    }

    private static void giderEkle(Scanner scanner) {
        System.out.print("Gider açıklamasını girin: ");
        String aciklama = scanner.next();
        System.out.print("Gider miktarını girin: ");
        double miktar = scanner.nextDouble();

        hesapHareketleri.add(new GelirGider(aciklama, -miktar));
        toplamBakiye -= miktar;
        System.out.println("Gider başarıyla eklendi.");
    }

    private static void hesapHareketleriniGoruntule() {
        if (hesapHareketleri.isEmpty()) {
            System.out.println("Henüz hesap hareketi bulunmamaktadır.");
            return;
        }

        System.out.println("Hesap Hareketleri:");
        for (GelirGider hareket : hesapHareketleri) {
            System.out.println(hareket.getAciklama() + ": " + hareket.getMiktar());
        }
    }

    private static void toplamBakiyeyiGoruntule() {
        System.out.println("Toplam Bakiye: " + toplamBakiye);
    }
}
