package athome.MazeWalker2;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Util {
    
    private static HashMap<Character, Character> tileMap = new HashMap<>() {{
        put('0', '⏹');
        put('_', ' ');
        put('@', '✧');
    }};

    private Util() {}

    public static String[] readLevel(String filename) {
        try (Scanner sc = new Scanner(new File(filename)); Scanner counter = new Scanner(new File(filename))){

            int lines = 0;
            while (counter.hasNextLine()) {
                counter.nextLine();
                lines++;
            }

            counter.close();

            String[] send = new String[lines];
            

            int i = 0;
            while (sc.hasNextLine()) {
                send[i] = sc.nextLine();
                i++;
            }
            sc.close();

            return send;

        } catch (Exception e) {
            System.out.println("An error occured.");
            return new String[0];
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

    public static void printMaze(String[] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.println(maze[i]);
        }
    }

    public static char getTile(char ch) {
        return tileMap.get(ch);
    }
}
