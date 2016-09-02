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
public interface Movable {
    
    abstract void create();
    
    abstract char move(int x1, int y1, int x2, int y2, char s);
    
    abstract char getSymbol();
    
}

