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
public class Peanut extends Nut {
    
    Peanut() {
        nutritionPoints = 10;
        name = "Peanut";
        create();
    }
    
    @Override
    public char getSymbol() {
        symbol = 'P';
        return symbol;
    }
}

