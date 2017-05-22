
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tobias
 */
public class Day3part2 {

    public Day3part2(String[] args) {
        String line = new String();

        int[][] houses = new int[200][200];

        boolean santasTurn = true;

        int posX = 100;
        int posY = 100;
        int robotX = 100;
        int robotY = 100;
        int luckyHouses = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            line = reader.readLine();
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }

        houses[posX][posY] = 2;
        luckyHouses += 1;
        for (int i = 0; i < line.length(); i++) {

            char direction = line.charAt(i);

            switch (direction) {
                case '<':
                    if (santasTurn) {
                        posX -= 1;
                    } else {
                        robotX -= 1;
                    }
                    break;
                case '>':
                    if (santasTurn) {
                        posX += 1;
                    } else {
                        robotX += 1;
                    }
                    break;

                case '^':
                    if (santasTurn) {
                        posY += 1;
                    } else {
                        robotY += 1;
                    }
                    break;

                case 'v':
                    if (santasTurn) {
                        posY -= 1;
                    } else {
                        robotY -= 1;
                    }
                    break;

            }
            if (santasTurn) {
                houses[posX][posY] += 1;
                if (houses[posX][posY] == 1) {
                    luckyHouses++;
                }
            } else {
                houses[robotX][robotY] += 1;
                if (houses[robotX][robotY] == 1) {
                    luckyHouses++;
                }
            }
            santasTurn = !(santasTurn);
        }
        System.out.println("Lucky houses: " + luckyHouses);
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            Day3part2 day3 = new Day3part2(args);
        }
    }
}
