package quiz.util;

import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static String readLine(String placeHolder) {
        Writer.blue(placeHolder);
        return Reader.readLine();
    }

    public static String option() {
        Writer.green("  => ");
        return Reader.readLine();
    }
}