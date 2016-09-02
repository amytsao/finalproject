/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this collate file, choose Tools | Templates
 * and open the collate in the editor.
 */
package amytsao;

/**
 *
 * @author amytsao
 */
public abstract class Entity implements Movable {

    char symbol;
    int col;
    int row;
    
    // swap piece with desired position
    public char move(int col1, int row1, int col2, int row2, char s)
    {
        /*for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 50; j++) {
                System.out.print(Maze.maze[i][j]);
            }
            System.out.println();
        } */
        char t = Maze.maze[col2][row2];
        if (Maze.maze[col1][row1] == s) {
            if (Maze.maze[col2][row2] != '*') {
                 row = row2;
                 col = col2;
                 Maze.maze[col1][row1] = ' ';
                 Maze.maze[col2][row2] = s;
            }
        }
        return t;
    }
        
    abstract public char getSymbol();
    abstract public void create();
            
}
