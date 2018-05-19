package euler;

public class Test {

    public static void main(String[] args) {
        double startTime = System.nanoTime();

        System.out.println(Problem_206.concealedSquare());
        double endTime = System.nanoTime();
        System.out.println("It took " + convertTime(endTime - startTime));
    }
    
    private static String convertTime(double time) {
        long exp = (long) Math.log10(time);
        if (exp > 8)
            return time/1000000000l + " s.";
        if (exp > 5)
            return time/1000000 + " ms.";
        return time + " ns.";
    }

}
