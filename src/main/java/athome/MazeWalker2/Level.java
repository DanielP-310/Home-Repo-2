package athome.MazeWalker2;

public class Level {
    
    private String[] maze;
    private String[] runningMaze;
    // Pos in terms of Y, X
    private int[] startPos = new int[2];
    private int[] currentPos = new int[2];
    private String name;
    // -1 to disable timer
    private int time;

    public Level(String[] maze, int startPosY, int startPosX, String name, int time) {
        this.maze = maze;
        this.name = name;
        this.time = time;
        this.startPos[0] = startPosY;
        this.startPos[1] = startPosX;
        this.currentPos = startPos;
        this.runningMaze = Util.cloneMaze(maze);
    }

    public Level(String filePath) {
        this.maze = Util.readLevel(filePath);
        this.name = Util.getNameFromFile(filePath);
        this.time = Util.getDataFromFile(filePath, "time");
        this.startPos[0] = Util.getDataFromFile(filePath, "y");
        this.startPos[1] = Util.getDataFromFile(filePath, "x");
        this.currentPos = startPos;
        this.runningMaze = Util.cloneMaze(maze);
    }

    public String[] getMaze() {
        return maze;
    }

    public String[] getRunningMaze() {
        return runningMaze;
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

    public String[] getDisp(boolean hasPlayer) {
        String[] send = Util.cloneMaze(runningMaze);
        if (hasPlayer) send[currentPos[0]] = send[currentPos[0]].substring(0, currentPos[1]) + '@' + send[currentPos[0]].substring(currentPos[1]+1);
        return Util.makeDisplayMaze(send);
    }

    public void makeMove(String input) {

    }

    public void stepTime(int decrement) {
        time -= decrement;
    }

}
