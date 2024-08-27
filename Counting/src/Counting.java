public class Counting {
    public static void main(String[] args) {
        long starTime = System.nanoTime();
        for (long i = 1; i <= 100000000; i++) {
            System.out.println(i);
        }
        long finishTime = System.nanoTime();
        double totalTime = (finishTime - starTime) / 1000000000.0;
        System.out.println("Tiempo de ejecución: " + totalTime + " segundos");
    }
}