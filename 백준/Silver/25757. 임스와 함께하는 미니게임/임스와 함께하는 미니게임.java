import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> playerSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] commandList = command.split(" ");
        int n = Integer.parseInt(commandList[0]);
        String gameChar = commandList[1];

        for (int i = 0; i < n; i++) {
            String gamerId = sc.nextLine();
            playerSet.add(gamerId);
        }

        if (gameChar.equals("Y")) {
            System.out.println(playerSet.size());
        } else if (gameChar.equals("F")) {
            System.out.println(playerSet.size() / 2);
        } else {
            System.out.println(playerSet.size() / 3);
        }
    }
}
