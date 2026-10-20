import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sesi2_HPCParallelProcessing {
    
    // Perhitungan komputasi matematis
    public static double heavyTask(long iterations) {
        double sum = 0;
        for (long i = 0; i < iterations; i++) {
            sum += Math.sqrt(i);
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int tasks = 8;
        long iterations = 20000000L;

        // 1. Eksekusi Sekuensial
        long startSeq = System.currentTimeMillis();
        for (int i = 0; i < tasks; i++) {
            heavyTask(iterations);
        }
        long timeSeq = System.currentTimeMillis() - startSeq;

        // 2. Eksekusi Paralel (Multithreading / Simulasi Node HPC)
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        
        long startPar = System.currentTimeMillis();
        for (int i = 0; i < tasks; i++) {
            executor.submit(() -> heavyTask(iterations));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        long timePar = System.currentTimeMillis() - startPar;

        System.out.println("=== Sesi 2: Benchmark Paralel HPC (Multithreading) ===");
        System.out.println("Jumlah Core CPU Digunakan : " + cores);
        System.out.println("Waktu Sekuensial          : " + timeSeq + " ms");
        System.out.println("Waktu Paralel             : " + timePar + " ms");
        System.out.printf("Speedup Factor            : %.2fx\n", (double) timeSeq / timePar);
    }
}
