/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amytsao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author amytsao
 */

public class Maze 
{
    static int Max_Maze_Row = 20;
    static int Max_Maze_Column = 50;
    public static char[][] maze;
    BufferedReader mazeReader;
    
    Maze(String fileName) {
        create(fileName);
        this.maze = maze;
    }
    int create(String fileName)
    {
        File mazeTemplate = new File(fileName);
        maze = new char[Max_Maze_Row][Max_Maze_Column];
        try {
            FileReader read = new FileReader(mazeTemplate);
            mazeReader = new BufferedReader(read);
        }
        catch (FileNotFoundException noMaze) {
            System.out.println("No maze text :(");
            System.exit(0);
        }
        try {
            for (int i = 0; i < Max_Maze_Row; i++) {
                String row = mazeReader.readLine();
                for (int j = 0; j < Max_Maze_Column; j++) {
                    maze[i][j] = row.charAt(j);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        return 1;
    }
    
    public static Boolean available(int row, int column)
    {
        if ((row > Max_Maze_Row - 1) || (row < 0)) {
            System.out.println("Invalid row input. Row is " + row);
            System.exit(0);
        }
        if ((column > Max_Maze_Column -1) || (column < 0)) {
            System.out.println("Invalid column input. Column is " + column);
            System.exit(0);
        }
        char spot = maze[row][column];
        if (spot == ' ') {
            return true;
        }
        else {
            return false;
        }
    }
    
    static void display()
    {
        for(int i = 0; i < Max_Maze_Row; i++) {
            String line = "";
            for(int j = 0; j < Max_Maze_Column; j++) {
                line += maze[i][j];
            }
            System.out.println(line);
        }
       System.out.println();
    }
    
}
