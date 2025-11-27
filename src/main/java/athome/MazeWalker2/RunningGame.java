package athome.MazeWalker2;

public class RunningGame {
    
    public static void startGame(Level map) {
        String input = "";
        while (true) {
            Util.printMaze(map);
            System.out.print(": ");
            input = System.console().readLine();
            map.makeMove(input);
            if (map.hasWon()) { winSequence(map); break; }
            if (map.getTime() == 0) { looseSequence(map); break; }
            Util.clearConsole();
        }
    }

    public static void looseSequence(Level map) {
        Util.clearConsole();
        System.out.println(String.format("Level Failed: %s", map.getName()));
        System.out.println("Press enter to continue!");
        System.console().readLine();
    }

    public static void winSequence(Level map) {
        Util.clearConsole();
        System.out.println(String.format("Level Cleared: %s", map.getName()));
        if (map.getTime() != -1) System.out.println(String.format("Moves Remaining: %d", map.getTime()));
        System.out.println("Press enter to continue!");
        System.console().readLine();
    }
}
