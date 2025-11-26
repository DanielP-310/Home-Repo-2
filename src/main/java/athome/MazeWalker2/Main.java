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
                System.out.println("Level Select:");
                System.out.println("Enter NAME of level to play.");
                System.out.println("Type 'quit' to return to the main menu.\n");

                // printing list from all campaigns
                for (int camp = 0; camp < selectConnect.length; camp++) {
                    for (int i = 0; i < selectConnect[camp].length; i++) {
                        if (selectConnect[camp][i][1].equals("CONFIG")) System.out.println(String.format("> %s", selectConnect[camp][i][0]));
                    }

                    int dispInd = 1;
                    for (int i = 0; i < selectConnect[camp].length; i++) {
                        if (selectConnect[camp][i][1].equals("CONFIG")) continue;
                        System.out.println(String.format("  [%d] %s", dispInd, selectConnect[camp][i][0]));
                        dispInd++;
                    }
                }
                

                System.out.print(": ");
                input = System.console().readLine();



                if (input.equals("quit")) select = false;
                Util.clearConsole();
            }

            if (input.equals("3")) break;
        }
    }
}
