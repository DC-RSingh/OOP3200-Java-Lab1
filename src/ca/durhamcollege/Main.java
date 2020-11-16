/** OOP3200. F2020. Main.java
 *	@author		Raje Singh, Angus Wai
 *	@studentIDs	100776793 & 100719558
 *	@version	2020.10
 *	@date		October 8, 2020
 */
package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Number of games played
        int gamesPlayed = 2;

        // Number of players per game
        int teamSize = 3;

        // String holding the names of the players
        String[] players = {"Raje", "Angus", "Tom"};

        // Two-Dimensional Array
        int [][] scoreboard = new int[teamSize][gamesPlayed];

        // Scanner
        Scanner keyboardInput = new Scanner(System.in);

        // Populate Array with valid data
        for (int y= 0; y < gamesPlayed; y++)
        {
            for (int x = 0; x < teamSize; x++)
            {
                boolean isValidInput = false;

                do
                {
                    System.out.print("Please enter " + players[x] + "'s score for game #" + (y + 1) + ": ");
                    try
                    {
                        scoreboard[x][y] = keyboardInput.nextInt();
                        isValidInput = true;

                        if ((scoreboard[x][y] <= 0) || (scoreboard[x][y] > 300))
                        {
                            System.out.println("Invalid input. Value between 0 and 300 needed. Please try again.");
                            keyboardInput.nextLine();
                            isValidInput = false;
                        }
                    }
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.println("Invalid input. Numeric value needed. Please try again.");
                        keyboardInput.nextLine();
                        isValidInput = false;
                    }
                }
                while(!isValidInput);

                System.out.println();
            }
        }

    }
}
