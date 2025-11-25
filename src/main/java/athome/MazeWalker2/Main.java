package athome.MazeWalker2;

public class Main {

    public static void main(String[] args) {

        while (true) {
            String input = ""; boolean select = true;
            System.out.println("Maze Walker 2");
            System.out.println("[1] Level Select");
            System.out.print(": ");
            input = System.console().readLine();

            if (input.equals("quit")) break;
            if (input.equals("1")) while(select) {
                Util.clearConsole();
                System.out.println("Level Select:\n");
                if (input.equals("quit")) select = false;
            }
        }
        
        Level level1 = new Level("src/main/java/athome/MazeWalker2/Maps/level1.txt");
        Util.printMaze(level1);
    }
}
