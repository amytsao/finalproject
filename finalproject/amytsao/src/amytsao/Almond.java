/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amytsao;

import static amytsao.Nut.nutritionPoints;

/**
 *
 * @author amytsao
 */
public class Almond extends Nut {
    
    Almond() {
        nutritionPoints = 10;
        name = "Almond";
        create();
    }
    
    @Override
    public char getSymbol() {
        symbol = 'A';
        return symbol;
    }
}
