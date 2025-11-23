package athome.MazeWalker2;

public class Level {
    
    private String[] maze;
    private String[] disp;
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
        this.disp = Util.makeDisplayMaze(maze);
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

    public String[] getDisp(boolean hasPlayer) {
        StringBuilder sb = new StringBuilder();
        String[] send = new String[disp.length];

        for (int i = 0; i < disp.length; i++) {
            for (int j = 0; j <disp[i].length(); j++) {
                sb.append(disp[i].charAt(j));
            }

            send[i] = sb.toString();
            sb.setLength(0);
        }

        if (hasPlayer) send[currentPos[0]] = send[currentPos[0]].substring(0, currentPos[1]) + Util.getTile('@') + send[currentPos[0]].substring(currentPos[1]+1);
        return send;
    }

    public void stepTime(int decrement) {
        time -= decrement;
    }
}
