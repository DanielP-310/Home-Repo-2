package athome.MazeWalker2;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Util {
    
    private static HashMap<Character, Character> tileMap = new HashMap<>() {{
        put('0', '0');
        put('_', ' ');
        put('@', '@');
        put(' ', ' ');
        put('#', '#');
        put(']', ']');
        put('*', '*');
        put('-', ' ');
        put('%', '%');
        put('^', '^');
        put('[', '[');
    }};

    private Util() {}

    public static String[] readLevel(String filename) {
        try (Scanner sc = new Scanner(new File(filename)); Scanner counter = new Scanner(new File(filename))){

            int lines = 0; String current = "";
            while (counter.hasNextLine()) {
                current = counter.nextLine();
                if (current.contains("Name: ") || current.contains("x: ") ||
                    current.contains("y: ") || current.contains("Time: ")) continue;
                lines++;
            }

            counter.close();

            String[] send = new String[lines];
            

            int i = 0;
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                if (data.contains("Name: ") || data.contains("x: ") ||
                    data.contains("y: ") || data.contains("Time: ")) continue;
                send[i] = data;
                i++;
            }
            sc.close();

            return send;

        } catch (Exception e) {
            System.out.println("An error occured: 0");
            return new String[0];
        }
    }

    public static String getNameFromFile(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            String send = "";
            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                if (data.contains("Name: ")) send = data.substring(6);
            }
            sc.close();
            return send;
        } catch (Exception e) {
            System.out.println("An error occured: 1");
            return "";
        }
    }

    public static int getDataFromFile(String fileName, String element) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            String data = "";
            if (element.equals("x")) while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (data.contains("x: ")) return Integer.parseInt(data.substring(3));
            }
            if (element.equals("y")) while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (data.contains("y: ")) return Integer.parseInt(data.substring(3));
            }
            if (element.equals("time")) while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (data.contains("Time: ")) return Integer.parseInt(data.substring(6));
            }
            sc.close();
            return 0;
        } catch (Exception e) {
            System.out.println("An error occured: 2");
            return 0;
        }
    }

    public static String[] makeDisplayMaze(String[] maze) {
        StringBuilder sb = new StringBuilder();
        String[] send = new String[maze.length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                sb.append(getTile(maze[i].charAt(j)) + " ");
            }
            send[i] = sb.toString();
            sb.setLength(0);
        }
        return send;
    }

    public static String[] cloneMaze(String[] maze) {
        StringBuilder sb = new StringBuilder();
        String[] send = new String[maze.length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                sb.append(maze[i].charAt(j));
            }
            send[i] = sb.toString();
            sb.setLength(0);
        }
        return send;
    }

    public static void printMaze(Level level) {
        System.out.println(level.getName());
        if (level.getTime() != -1) System.out.println(String.format("Moves remaining: %d", level.getTime()));
        System.out.println("\n");
        String[] send = level.getDisp(true);
        for (int i = 0; i < level.getDisp(false).length; i++) {
            System.out.println(send[i]);
        }
    }

    public static char getTile(char ch) {
        return tileMap.get(ch);
    }

    public static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static File[] getGameFiles(String path) {
        File directory = new File(path);
        return directory.listFiles();
    }

    public static String[][] levelsWithPaths(String directory) {
        String[][] send = new String[getGameFiles(directory).length][2]; int i = 0;
        for (File level : getGameFiles(directory)) {
            if (fileContains(level.getPath(), "CONFIG")) {
                send[i][0] = getNameFromFile(level.getPath());
                send[i][1] = "CONFIG";
            } else {
                send[i][0] = getNameFromFile(level.getPath());
                send[i][1] = level.getPath();
            }
            i++;
        }
        return send;
    }

    // Modify to add more campaigns.
    public static String[][][] fullReference() {
        File maps = new File("src/main/java/athome/MazeWalker2/Maps");
        String[][][] send = new String[maps.listFiles().length][][];
        for (int i = 0; i < maps.listFiles().length; i++) {
            send[i] = levelsWithPaths(maps.listFiles()[i].getPath());
        }
        return send;
    }

    public static boolean fileContains(String fileName, String check) {
        try (Scanner sc = new Scanner (new File(fileName))) {
            while (sc.hasNextLine()) {
                if (sc.nextLine().contains(check)) return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(String.format("Error checking for %s", check));
            return true;
        }
    }

    public static void toggleSwitch(String[] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].charAt(j) == ']') {
                    maze[i] = maze[i].substring(0,j) + '-' + maze[i].substring(j+1);
                }
                else if (maze[i].charAt(j) == '-') {
                    maze[i] = maze[i].substring(0,j) + ']' + maze[i].substring(j+1);
                }
            }
        }
    }

    public static void collectKey(String[] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].charAt(j) == '%') {
                    maze[i] = maze[i].substring(0,j) + "_" + maze[i].substring(j+1);
                }
                else if (maze[i].charAt(j) == '^') {
                    maze[i] = maze[i].substring(0,j) + "#" + maze[i].substring(j+1);
                }
                else if (maze[i].charAt(j) == '[') {
                    maze[i] = maze[i].substring(0,j) + "_" + maze[i].substring(j+1);
                }
            }
        }
    }
}
