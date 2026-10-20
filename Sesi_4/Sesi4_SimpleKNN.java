import java.util.Arrays;

public class Sesi4_SimpleKNN {

    public static double euclideanDistance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    public static void main(String[] args) {
        double[][] trainData = {
            {1.0, 2.0},
            {2.0, 1.0},
            {6.0, 7.0},
            {7.0, 8.0}
        };
        int[] trainLabels = {0, 0, 1, 1};

        double[] newSample = {1.5, 1.8};

        double minDistance = Double.MAX_VALUE;
        int predictedClass = -1;

        for (int i = 0; i < trainData.length; i++) {
            double dist = euclideanDistance(newSample, trainData[i]);
            if (dist < minDistance) {
                minDistance = dist;
                predictedClass = trainLabels[i];
            }
        }

        System.out.println("=== Sesi 4: Implementasi Algoritma KNN (Machine Learning) ===");
        System.out.println("Data Sampel Baru : " + Arrays.toString(newSample));
        System.out.println("Jarak Terdekat   : " + String.format("%.4f", minDistance));
        System.out.println("Hasil Prediksi Kategori : " + (predictedClass == 0 ? "Bunga Tipe A" : "Bunga Tipe B"));
    }
}
