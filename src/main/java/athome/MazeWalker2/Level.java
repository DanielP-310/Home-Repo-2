package athome.MazeWalker2;

public class Level {
    
    private String[] maze;
    private String[] disp;
    private int[] startPos;
    private String name;
    // -1 to disable timer
    private int time;

    public Level(String[] maze, int[] startPos, String name, int time) {
        this.maze = maze;
        this.name = name;
        this.time = time;
        this.startPos = startPos;
        
    }

    public String[] getMaze() {
        return maze;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int[] getStartPos() {
        return startPos;
    }

    public void stepTime(int decrement) {
        time -= decrement;
    }
}
