/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amytsao;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author amytsao
 */
public class HungrySquirrelGame {
    public static void main (String[] args){
        // create maze and make squirrel 
        Maze maze = new Maze("Maze.txt");
        maze.display();
        
        Squirrel squirrel;
        
        while(true) {
            try {
                squirrel = new Squirrel();
                break;
            }
            catch(InputMismatchException m) {
                System.out.println("Invalid position. Please try again.");
            }
        }
        System.out.println();
        
        Nut[] squirrelFood = new Nut[5];
        
        // create five random nuts
        for(int i = 0; i < 5; i ++) {
            double n = Math.random();
            squirrelFood[i] = (n < 0.5) ? new Almond() : new Peanut();
        }
        
        // create 5 random poisonous cashews
        PoisonousCashew[] badFood = new PoisonousCashew[5];
        for (int i = 0; i < 5; i++)
        {
            badFood[i] = new PoisonousCashew();
        }
        
        // start game
        System.out.println("Enter commands u,d,l,r to move Up, Down, Left, and Right:\n");
        maze.display();
        Scanner gameControls = new Scanner(System.in);
        
        // while game is not over, wait for user input
        while(!gameControls.hasNext("done")) {
            if (gameControls.hasNext("u")) {
                squirrel.moveUp();
                maze.display();
                System.out.println("Enter command: ");
                gameControls.next();
            }
            else if (gameControls.hasNext("d")) {
                squirrel.moveDown();
                maze.display();
                System.out.println("Enter command: ");
                gameControls.next();
            }
            else if (gameControls.hasNext("l")) {
                squirrel.moveLeft();
                maze.display();
                System.out.println("Enter command: ");
                gameControls.next();
            }
            else if (gameControls.hasNext("r")) {
                squirrel.moveRight();
                maze.display();
                System.out.println("Enter command: ");
                gameControls.next();
            }
            else {
                System.out.println("Invalid command. Please try again:");
                gameControls.next();
            }
            // if dead, exit
            if (squirrel.points < 0) {
                System.exit(0);
            }
            // if all nuts are collected, exit
            if (squirrel.nutsCollected >= 5) {
                System.out.println("Squirrel successfully collected all the nuts. Total points " + squirrel.points);
                System.out.println("Thank you for playing this game");
                return;
            }
        }
    }
}
