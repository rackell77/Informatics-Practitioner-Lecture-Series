import java.util.ArrayList;
import java.util.List;

class Invoice {
    double amount;
    int daysOverdueHistory;
    int creditScore;

    public Invoice(double amount, int daysOverdueHistory, int creditScore) {
        this.amount = amount;
        this.daysOverdueHistory = daysOverdueHistory;
        this.creditScore = creditScore;
    }

    public String predictRisk() {
        if (daysOverdueHistory > 14 || creditScore < 600) {
            return "BERISIKO TINGGI (Late Payment)";
        } else {
            return "AMAN (On Time)";
        }
    }
}

public class Sesi1_LatePaymentRisk {
    public static void main(String[] args) {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1500000, 0, 750));
        invoices.add(new Invoice(5000000, 20, 580));
        invoices.add(new Invoice(12000000, 5, 800));

        System.out.println("=== Sesi 1: Analisis Risiko Keterlambatan Pembayaran ===");
        for (int i = 0; i < invoices.size(); i++) {
            Invoice inv = invoices.get(i);
            System.out.println("Invoice #" + (i + 1) + " [Nominal: Rp" + inv.amount + 
                               ", Overdue History: " + inv.daysOverdueHistory + " hari] -> Status: " + inv.predictRisk());
        }
    }
}
