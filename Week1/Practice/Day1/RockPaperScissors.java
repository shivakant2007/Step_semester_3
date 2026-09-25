import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        String p = playerMove.toLowerCase();
        String c = computerMove.toLowerCase();
        if (p.equals(c)) {
            return "Draw";
        }
        if ((p.equals("rock") && c.equals("scissors")) ||
            (p.equals("paper") && c.equals("rock")) ||
            (p.equals("scissors") && c.equals("paper"))) {
            return "Win";
        }
        return "Loss";
    }

    public static void main(String[] args) {
        String[] moves = {"rock", "paper", "scissors"};
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        String[] demoMoves = {"rock", "paper", "scissors", "rock", "paper"};

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            playerMoves[i] = demoMoves[i];
            computerMoves[i] = moves[rand.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            switch (results[i]) {
                case "Win": wins++; break;
                case "Loss": losses++; break;
                case "Draw": draws++; break;
            }
        }

        System.out.println("-------------------------------------------");
        System.out.printf("%-10s | %-15s | %-15s | %-10s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d | %-15s | %-15s | %-10s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------");

        System.out.println("Total Wins:   " + wins);
        System.out.println("Total Losses: " + losses);
        System.out.println("Total Draws:  " + draws);

        double winPercentage = (wins * 100.0) / 5;
        System.out.printf("Win Percentage: %.2f%%%n", winPercentage);
    }
}
