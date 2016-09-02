/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amytsao;

/**
 *
 * @author amytsao
 */
public abstract class Wall extends Entity {
    
    Wall() {
        create();
    }

    @Override
    public char getSymbol() {
        symbol = '*';
        return symbol;
    }
    @Override
    public void create()
    {
        int rowN = (int)(Math.random() * 50);
        int colN = (int)(Math.random() * 20);
        
        // while is not an empty space
        while (Maze.maze[colN][rowN] != ' ') {
             rowN = (int)(Math.random() * 50);
             colN = (int)(Math.random() * 20);
        }
        row = rowN;
        col = colN;
        Maze.maze[col][row] = getSymbol();
    }
}
