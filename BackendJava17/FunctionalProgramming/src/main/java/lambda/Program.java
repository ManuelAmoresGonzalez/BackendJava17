package lambda;

public class Program {

    /**
     * Interfaces functionals
     * Consumer
     * Supplier
     * Function
     * @param args
     */

    public static void main(String[] args) {
        Operation sum = Integer::sum;
        Operation mult = (a,b) -> a*b;
        int result1 = sum.operate(10, 20);
        int result2 = mult.operate(10, 20);

        sum.test();
        Operation.testStatic();

        System.out.println(result1);
        System.out.println(result2);

    }
}
