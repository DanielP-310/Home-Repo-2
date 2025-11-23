package athome.MazeWalker2;

import java.util.Scanner;
import java.io.File;

public class Util {
    
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

    public static void makeDisplayMaze(String[] maze) {
        for (int i = 0; i < maze.length; i++) {
            
        }
    }

    public static void printMaze(String[] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.println(maze[i]);
        }
    }
}
