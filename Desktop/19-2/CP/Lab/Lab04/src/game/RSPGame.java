package game;

import java.util.Scanner;
import java.time.*;

public class RSPGame {
    private int round = 0;
    private static String[] rsp = {"rock", "scissors", "paper"};
    private static String[] resultCases = {"Draw", "user win", "user lose"};
    private History history;
    private boolean drawValid;
    private Scanner scanner;

    RSPGame(boolean drawValid){
        this.drawValid = drawValid;
        this.scanner = new Scanner(System.in);
    }

    History playGame() {
        this.round++;
//        history = new History();
        System.out.println("Round " + round);
        String input;
        int userPick;
        int systemPick;

        do {
            systemPick = generateSystemPick();
            System.out.println("Please enter one of 'scissors', 'rock', 'paper'");
            input = scanner.next();
            userPick = checkUserInput(input);
        } while (userPick < 0);
        recordHistory(userPick, systemPick);

    }

    private int checkUserInput(String userInput){
            for (int i = 0; i < rsp.length; i++) {
                if (rsp[i].equals(userInput))
                    return i;
            }

            System.out.println("Not valid Input");
            return -1;
    }

    private int generateSystemPick(){
        return (int)(3 * Math.random());

    }

    private void recordHistory(int userPick, int systemPick){
        int result = (userPick - systemPick +3) % 3;
    }

    class History {
        private int round;
        private String userPick;
        private String systemPick;
        private String result;
        private LocalDate date;
        private LocalTime time;
        private boolean update = false;

        public History(int round) {
            this.round = round;
        }

        public boolean printHistory(){
            if(!update) {
                System.out.println("history is not valid");
                return false;
            }
            System.out.println("\n< Result of Round " + round +" >");
            System.out.println("Date : " + date);
            System.out.println("Time : " + time);
            System.out.println("User Pick : " + userPick);
            System.out.println("System Pick : " + systemPick);
            System.out.println("Game result : " + result);
            return true;
        }

        private void setPresentDT(){
            date = LocalDate.now();
            time = LocalTime.now();

        }

        public int getResult(){
            for (int i = 0; i < resultCases.length; i++) {
                if (resultCases[i].equals(result)) {
                    return i;
                }
            }
            return -1;
        }

    }

}
