/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knighttour;

public class Main {
   

	public static void main(String[] args) {
		Size boardSize = new Size();
                boardSize.setSize(8);
		KnightTour knightTour = new KnightTour();
		knightTour.solveKnightTour();
		
	}
}

