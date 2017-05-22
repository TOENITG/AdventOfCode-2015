
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
public class Day5 {

    private String line = new String();

// Part 1, support method
    private int getNumberOfWovels(char wovel, String row) {
        int existences = 0;

        for (int i = -1; (i = row.indexOf(wovel, i + 1)) != -1;) {
            existences++;
        }
        return existences;
    }

// Part 1
    private boolean atleastThreeWovels(String row) {
        String wovels = "aeiou";
        int numberOfWovels = 0;
        for (int i = 0; i < wovels.length(); i++) {
            numberOfWovels += getNumberOfWovels(wovels.charAt(i), row);
        }
        if (numberOfWovels >= 3) {
            return true;
        } else {
            return false;
        }
    }

// Part 1
    private boolean doubleLetters(String row) {
        for (int i = 0; i < row.length() - 1; i++) {
            if (row.charAt(i) == row.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

// Part 1
    private boolean notBadStrings(String row) {
        boolean badStringExists = false;
        String[] badStrings = {"ab", "cd", "pq", "xy"};
        for (int i = 0; i < 4; i++) {
            if (! !row.contains(badStrings[i])) {
                badStringExists = true;
            }
        }
        return !(badStringExists);
    }

// Part 2
    // Find at least 2 occurencies of a paired string within a string
    private boolean pairOfLetters(String row) {
        boolean pairOfLettersExists = false;
        String substring = new String();
        String compareWith = new String();
        for (int i = 0; i < row.length() - 3; i++) {
            substring = row.substring(i, i + 2);
            compareWith = row.substring(i + 2, row.length());
            if (compareWith.indexOf(substring) > 0) {
                pairOfLettersExists = true;
            }
        }
        return pairOfLettersExists;
    }

// Part 2
    // Find a repeating character with a character inbetween.
    private boolean repeatingLetters(String row) {
        boolean repeatingLettersExist = false;
        for (int i = 0; i < row.length() - 2; i++) {
            if (row.charAt(i) == row.charAt(i + 2)) {
                repeatingLettersExist = true;
            }
        }
        return repeatingLettersExist;
    }

    public Day5(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            line = reader.readLine();
            int allRows = 0;
            int goodRowsPart1 = 0;
            int goodRowsPart2 = 0;
            while (!(line == null)) {
                allRows++;
                if (atleastThreeWovels(line)
                        && doubleLetters(line)
                        && notBadStrings(line)) {
                    goodRowsPart1++;
                }

                if (pairOfLetters(line)
                        && repeatingLetters(line)) {
                    goodRowsPart2++;
                }

                line = reader.readLine();
            }
            System.out.println("All rows: " + allRows);
            System.out.println("Good rows part 1: " + goodRowsPart1);
            System.out.println("Good rows part 2: " + goodRowsPart2);
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            Day5 day5 = new Day5(args);
        }
    }
}
