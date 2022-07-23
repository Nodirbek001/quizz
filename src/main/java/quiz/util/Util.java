package quiz.util;

import java.util.List;

public class Util {
    public static String right(String str, int width) {
        StringBuilder strBuilder = new StringBuilder(str);
        for (int x = strBuilder.length(); x < width; ++x) {
            strBuilder.insert(0, ' ');
        }
        str = strBuilder.toString();
        return str;
    }

    public static void middle(String str) {
        Writer.yellowLine("   ***   " + str + "   ***   ");
    }

    public static void error(String str) {
        Writer.redLine("   ***   " + str + "   ***   ");
    }

    public static void success(String str) {
        Writer.greenLine("   ***   " + str + "   ***   ");
    }

    public static String left(String str, int width) {
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.append(" ".repeat(Math.max(0, width - strBuilder.length())));
        str = strBuilder.toString();
        return str;
    }

    public static void pause() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static String menu(List<String> list) {
        Writer.cyanLine("+------------------------------+");

        Writer.cyan("|");
        int a = (30 - list.get(0).length()) / 2;
        for (int i = 0; i < a; i++) {
            System.out.print(" ");
        }
        Writer.yellow(list.get(0));
        for (int i = 0; i < 30 - list.get(0).length() - a; i++) {
            System.out.print(" ");
        }
        Writer.cyanLine("|");

        Writer.cyanLine("+------------------------------+");

        for (int i = 1; i < list.size(); i++) {
            Writer.cyan("|");
            System.out.print(list.get(i));
            for (int j = 0; j < 30 - list.get(i).length(); j++) {
                System.out.print(" ");
            }
            Writer.cyanLine("|");
        }
        Writer.cyanLine("+------------------------------+");

        return Reader.option();
    }
}
