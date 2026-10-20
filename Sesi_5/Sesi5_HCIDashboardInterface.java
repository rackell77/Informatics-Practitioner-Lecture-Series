public class Sesi5_HCIDashboardInterface {

    public static void printBarChart(String label, int value, int threshold) {
        System.out.printf("%-12s | ", label);
        int bars = value / 10;
        for (int i = 0; i < bars; i++) {
            System.out.print("█");
        }
        System.out.print(" (" + value + " kWh)");
        
        if (value > threshold) {
            System.out.println(" [ALERT: TINGGI]");
        } else {
            System.out.println(" [NORMAL]");
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== DASHBOARD MONITORING ENERGI GEDUNG (HCI) ===");
        System.out.println("=================================================");

        int threshold = 500;
        printBarChart("Gedung A", 450, threshold);
        printBarChart("Gedung B", 820, threshold);
        printBarChart("Gedung C", 310, threshold);
        printBarChart("Gedung D", 690, threshold);

        System.out.println("=================================================");
    }
}
