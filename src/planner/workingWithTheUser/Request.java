package planner.workingWithTheUser;

import java.util.Scanner;

public interface Request {
    static String request() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
