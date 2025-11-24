package athome.MazeWalker2;

public class Main {

    public static void main(String[] args) {

        while (true) {
            String input = "";
            System.out.println("Maze Walker 2");
            input = System.console().readLine();

            if (input.equals("quit")) break;
        }
        
        Level level1 = new Level("src/main/java/athome/MazeWalker2/Maps/level1.txt");
        Util.printMaze(level1);
    }
}
