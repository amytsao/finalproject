/*
 * To change this rowlate, choose Tools | Templates
 * and open the rowlate in the editor.
 */
package amytsao;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author amytsao
 */
public class Squirrel extends Entity {
    
    int points;
    int nutsCollected;
    int sRow;
    int sCol;
    
    Squirrel() {
        points = 0;
        nutsCollected = 0;
        getSymbol();
        create();
        sRow = col;
        sCol = row;
    }
    
    @Override
    public void create()
    {
        try {
            System.out.println("Enter the Squirrel position (column , row):");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().replaceAll("\\s+","");
            String[] tokens = input.split(",");
            // parse input
            col = Integer.parseInt(tokens[0]);
            row = Integer.parseInt(tokens[1]);
            while ((col < 0) || (col > Maze.Max_Maze_Row-1) || (row < 0) || (row > Maze.Max_Maze_Column-1)) {
                System.out.println("Out of bounds. For column, please enter an integer from 0 to 49. For row, please enter an integer from 0 to 19.");
                input = scan.nextLine().replaceAll("\\s+","");
                tokens = input.split(",");
                // parse input
                col = Integer.parseInt(tokens[0]);
                row = Integer.parseInt(tokens[1]);
            }
            while (!Maze.available(col, row)) {
                System.out.println("That position is already filled. Please pick a new position.");
                input = scan.nextLine().replaceAll("\\s+","");
                tokens = input.split(",");
                // parse input
                col = Integer.parseInt(tokens[0]);
                row = Integer.parseInt(tokens[1]);
                while ((col < 0) || (col > Maze.Max_Maze_Row-1) || (row < 0) || (row > Maze.Max_Maze_Column-1)) {
                    System.out.println("Out of bounds. For column, please enter an integer from 0 to 49. For row, please enter an integer from 0 to 19.");
                    input = scan.nextLine().replaceAll("\\s+","");
                    tokens = input.split(",");
                    // parse input
                    col = Integer.parseInt(tokens[0]);
                    row = Integer.parseInt(tokens[1]);
                }
            }
        }
        catch (InputMismatchException m) {
            throw m;
        }
        System.out.println("The squirrel is at (" + row + ", " + col + ")");
        Maze.maze[col][row] = '@';
        Maze.display();
    }
    
    @Override
    public char getSymbol()
    {
        symbol = '@';
        return symbol;
    }
    
    void moveUp()
    {
        switch (Maze.maze[col-1][row]) {
            case 'A':
                almond();
                break;
            case 'P':
                peanut();
                break;
            case 'C':
                cashew();
                break;
            case ' ':
                break;
            default:
                System.out.println("Position not available. Try again!");
                return;
        }
        if (points < 0) {
            dead();
            move(col, row, col-1, row, 'X');
        }
        move(col, row, col-1, row, getSymbol());
    }
    
    void moveDown()
    {
        switch (Maze.maze[col+1][row]) {
            case 'A':
                almond();
                break;
            case 'P':
                peanut();
                break;
            case 'C':
                cashew();
                break;
            case ' ':
                break;
            default:
                System.out.println("Position not available. Try again!");
                return;
        }
        if (points < 0) {
            dead();
            move(col, row, col + 1, row, 'X');
        }         
        move(col, row, col + 1, row, getSymbol());
    }
    
    void moveLeft()
    {
        switch (Maze.maze[col][row-1]) {
            case 'A':
                almond();
                break;
            case 'P':
                peanut();
                break;
            case 'C':
                cashew();
                break;
            case ' ':
                break;
            default:
                System.out.println("Position not available. Try again!");
                return;
        }
        if (points < 0) {
            dead();
            move(col, row, col, row-1, 'X');
        }
        move(col, row, col, row-1, getSymbol());
    }
    
    void moveRight()
    {
        switch (Maze.maze[col][row+1]) {
            case 'A':
                almond();
                break;
            case 'P':
                peanut();
                break;
            case 'C':
                cashew();
                break;
            case ' ':
                break;
            default:
                System.out.println("Position not available. Try again!");
                return;
        }
        if (points < 0) {
            dead();
            move(col, row, col, row + 1, 'X');
        }
        move(col, row, col, row + 1, getSymbol());
    }
    
    public String getPoints() {
        return "(Total " + points + " Points)";
    }

    public void almond() {
        points += 5;
        nutsCollected++;
        sRow = row;
        sCol = col;
        System.out.println("!!! Squirrel ate an Almond and gained 5 points " + getPoints() + " !!!");
    }
    
    public void peanut() {
        points += 10;
        nutsCollected++;
        sRow = row;
        sCol = col;
        System.out.println("!!! Squirrel ate a Peanut and gained 10 points " + getPoints() + " !!!");
    }
    
    public void cashew() {
        points -= 15;
        sRow = row;
        sCol = col;
        System.out.println("!!! Squirrel ate a Poisonous Cashew and lost 15 points " + getPoints() + " !!!");
    }
    
    public void dead() {
        points = -1;
        System.out.println("Oh no! Squirrel is dead. Game over. :((");
        Maze.maze[col][row] = 'X';
    }
}