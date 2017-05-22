
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
public class Day3part1 {

    public Day3part1(String[] args) {
        String line = new String();

        int[][] houses = new int[200][200];

        int posX = 100;
        int posY = 100;
        int luckyHouses = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            line = reader.readLine();
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }

        houses[posX][posY] = 1;
        luckyHouses++;
        for (int i = 0; i < line.length(); i++) {

            char direction = line.charAt(i);

            switch (direction) {
                case '<':
                    posX -= 1;

                    break;
                case '>':
                    posX += 1;
                    break;

                case '^':
                    posY += 1;
                    break;

                case 'v':
                    posY -= 1;
                    break;
            }
            houses[posX][posY] += 1;
            if (houses[posX][posY] == 1) {
                luckyHouses++;
            }
        }
        System.out.println("Lucky houses: " + luckyHouses);
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            Day3part1 day3 = new Day3part1(args);
        }
    }
}
