package athome.MazeWalker2;

public class Main {

    public static void main(String[] args) {

        Level level1 = new Level(Util.readLevel("src/main/java/athome/MazeWalker2/Maps/level1.txt"), 1, 1, "Level 1", -1);
        System.out.println("Hi");
        Util.printMaze(level1.getDisp(true));
    }
}
