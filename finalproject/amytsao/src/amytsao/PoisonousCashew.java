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
public class PoisonousCashew extends Nut {
    
    PoisonousCashew()
    {
       nutritionPoints = -15;
       name = "Cashew";
       create();
    }

    @Override
    public char getSymbol()
    {
        symbol = 'C';
        return symbol;
    }
    
}

