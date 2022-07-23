package quiz.util;

public class Writer {

    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    public static void black(String str) {
        System.out.print(BLACK + str + WHITE);
    }

    public static void red(String str) {
        System.out.print(RED + str + WHITE);
    }

    public static void green(String str) {
        System.out.print(GREEN + str + WHITE);
    }

    public static void yellow(String str) {
        System.out.print(YELLOW + str + WHITE);
    }

    public static void blue(String str) {
        System.out.print(BLUE + str + WHITE);
    }

    public static void purple(String str) {
        System.out.print(PURPLE + str + WHITE);
    }

    public static void cyan(String str) {
        System.out.print(CYAN + str + WHITE);
    }

    public static void white(String str) {
        System.out.print(WHITE + str + WHITE);
    }

    public static void blackLine(String str) {
        System.out.println(BLACK + str + WHITE);
    }

    public static void redLine(String str) {
        System.out.println(RED + str + WHITE);
    }

    public static void greenLine(String str) {
        System.out.println(GREEN + str + WHITE);
    }

    public static void yellowLine(String str) {
        System.out.println(YELLOW + str + WHITE);
    }

    public static void blueLine(String str) {
        System.out.println(BLUE + str + WHITE);
    }

    public static void purpleLine(String str) {
        System.out.println(PURPLE + str + WHITE);
    }

    public static void cyanLine(String str) {
        System.out.println(CYAN + str + WHITE);
    }

    public static void whiteLine(String str) {
        System.out.println(WHITE + str + WHITE);
    }

}
