package CodeUp.Base100;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();

        while(true) {
            if (a.equals("q")) {
                System.out.println(a);
                break;
            } else {
                System.out.println(a);
                a = scanner.next();
            }
        }
            scanner.close();
    }
}
