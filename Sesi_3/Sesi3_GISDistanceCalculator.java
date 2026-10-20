public class Sesi3_GISDistanceCalculator {

    private static final double EARTH_RADIUS = 6371.0;

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    public static void main(String[] args) {
        double unibLat = -3.7578;
        double unibLon = 102.2741;
        double assetLat = -3.7900;
        double assetLon = 102.2600;

        double distance = calculateDistance(unibLat, unibLon, assetLat, assetLon);
        double bufferLimitKm = 5.0;

        System.out.println("=== Sesi 3: Analisis Spasial GIS (Haversine Distance) ===");
        System.out.printf("Jarak antara Koordinat UNIB dan Titik Aset : %.2f km\n", distance);
        
        if (distance <= bufferLimitKm) {
            System.out.println("Status: Titik Aset masuk dalam ZONA BUFFER " + bufferLimitKm + " KM.");
        } else {
            System.out.println("Status: Titik Aset di LUAR Jangkauan Zona.");
        }
    }
                                  }
