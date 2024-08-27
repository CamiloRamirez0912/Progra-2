public class App {
    public static void main(String[] args) {
        long starTime = System.nanoTime();
        int count = 1;
        String result = "";
        while (count <= 100_000_000) {
            result += count + " ";
            count++;
            if (count%1000==0) {
                System.out.println(result);
                result = "";
            }
            
        }
        long finishTime = System.nanoTime();
        double totalTime = (finishTime - starTime)/1000000000.0;
        System.out.println("Tiempo de ejecución: " + totalTime + " segundos.");
    }
}