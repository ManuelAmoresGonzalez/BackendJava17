package lambda;

@FunctionalInterface
public interface Operation {

    int operate(int x, int y);

    default void test(){
        System.out.println("test");
    }

    static void testStatic(){
        System.out.println("Test static");
    }
}
