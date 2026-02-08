package athome.MazeWalker2;

public class Main {

    public static void main(String[] args) {

        String[][][] selectConnect = Util.fullReference();

        while (true) {
            String input = ""; boolean select = true;
            System.out.println("Maze Walker 2");
            System.out.println("[1] Level Select");
            System.out.println("[2] Stats");
            System.out.println("[3] quit");
            System.out.print(": ");
            input = System.console().readLine();
            Util.clearConsole();

            
            if (input.equals("1")) while(select) {
                Util.clearConsole();
                System.out.println("Campaign Select:");
                System.out.println("Type 'quit' to return to the main menu.\n");

                // printing list of all campaigns
                int tracker = 1;
                for (int camp = 0; camp < selectConnect.length; camp++) {
                    for (int i = 0; i < selectConnect[camp].length; i++) {
                        if (selectConnect[camp][i][1].equals("CONFIG")) {
                            System.out.println(String.format("> [%d] %s", tracker, selectConnect[camp][i][0]));
                            tracker++;
                        }
                    }

                    
                }
                

                System.out.print(": ");
                int intSelector = -1;
                try {
                    input = System.console().readLine();
                    intSelector = Integer.parseInt(input) - 1;
                    if (intSelector < 0) intSelector = -2;
                } catch (Exception e) {
                    intSelector = -2;
                }
                
                Util.clearConsole();

                if (input.equals("quit")) select = false;
                boolean found = false;

                for (int i = 0; i < selectConnect.length; i++) {
                    if (i == intSelector) {
                        int dispInd = 1; found = true;
                        for (int k = 0; k < selectConnect[i].length; k++) {
                            if (selectConnect[i][k][1].equals("CONFIG")) continue;
                            System.out.println(String.format("  [%d] %s", dispInd, selectConnect[i][k][0]));
                            dispInd++;
                        }
                    }
                }

                if (found) {

                    found = false;
                    System.out.print(": ");
                    int lvSelect;

                    try {
                    input = System.console().readLine();
                    lvSelect = Integer.parseInt(input);
                    if (lvSelect < 1) lvSelect = -2;
                    } catch (Exception e) {
                        lvSelect = -2;
                    }

                    for (int i = 0; i < selectConnect[intSelector].length; i++) {
                        if (i == lvSelect) {
                            Util.clearConsole();
                            RunningGame.startGame(new Level(selectConnect[intSelector][i][1]));
                        }
                    }
                }

                if (input.equals("quit")) { select = false; Util.clearConsole();}
            }

            if (input.equals("3")) break;
        }
    }
}
