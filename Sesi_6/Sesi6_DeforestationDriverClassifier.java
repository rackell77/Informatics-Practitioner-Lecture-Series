class SatellitePixel {
    double ndvi;
    double ndbi;

    public SatellitePixel(double ndvi, double ndbi) {
        this.ndvi = ndvi;
        this.ndbi = ndbi;
    }

    public String classifyDriver() {
        if (ndvi < 0.20 && ndbi > 0.40) {
            return "Pertambangan / Infrastruktur";
        } else if (ndvi >= 0.20 && ndvi <= 0.45) {
            return "Pertanian / Perkebunan Sawit";
        } else {
            return "Perambahan / Lainnya";
        }
    }
}

public class Sesi6_DeforestationDriverClassifier {
    public static void main(String[] args) {
        SatellitePixel alert1 = new SatellitePixel(0.12, 0.48);
        SatellitePixel alert2 = new SatellitePixel(0.35, 0.15);

        System.out.println("=== Sesi 6: Atribusi Penyebab Deforestasi (Satellite + AI) ===");
        System.out.println("Sinyal Satelit #1 [NDVI: " + alert1.ndvi + ", NDBI: " + alert1.ndbi + "] -> Pemicu Utama: " + alert1.classifyDriver());
        System.out.println("Sinyal Satelit #2 [NDVI: " + alert2.ndvi + ", NDBI: " + alert2.ndbi + "] -> Pemicu Utama: " + alert2.classifyDriver());
    }
}
