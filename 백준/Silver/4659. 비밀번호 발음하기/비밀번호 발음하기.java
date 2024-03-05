import java.util.Scanner;

public class Main {
    public static boolean checkVowel(String str) {
        if (str.contains("a")) {
            return true;
        }
        if (str.contains("e")) {
            return true;
        }
        if (str.contains("i")) {
            return true;
        }
        if (str.contains("o")) {
            return true;
        }
        if (str.contains("u")) {
            return true;
        }
        return false;
    }

    public static boolean checkTriple(String str) {
        String[] strArr = str.split("");
        int len = str.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (strArr[i].equals("a") || strArr[i].equals("i") || strArr[i].equals("u") || strArr[i].equals("e") || strArr[i].equals("o")) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == 3) {
                return true;
            }
        }

        cnt = 0;

        for (int i = 0; i < len; i++) {
            if (!strArr[i].equals("a") && !strArr[i].equals("i") && !strArr[i].equals("u") && !strArr[i].equals("e") && !strArr[i].equals("o")) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == 3) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkDouble(String str) {
        String[] strArr = str.split("");
        int len = str.length();

        for (int i = 0; i < len - 1; i++) {
            if (strArr[i].equals(strArr[i + 1])) {
                if (strArr[i].equals("e") && strArr[i + 1].equals("e")) {
                    continue;
                } else if(strArr[i].equals("o") && strArr[i + 1].equals("o")) {
                    continue;
                } else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();

            if (str.equals("end")) {
                break;
            }

            if (!checkVowel(str)) {
                System.out.println("<" + str + "> is not acceptable.");
                continue;
            }

            if (checkTriple(str)) {
                System.out.println("<" + str + "> is not acceptable.");
                continue;
            }

            if (checkDouble(str)) {
                System.out.println("<" + str + "> is not acceptable.");
                continue;
            }

            System.out.println("<" + str + "> is acceptable.");
        }
    }
}
