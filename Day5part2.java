
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
public class Day5part2 {

    private String line = new String();

    private int getNumberOfWovels(char wovel, String row) {
        int existences = 0;

        for (int i = -1; (i = row.indexOf(wovel, i + 1)) != -1;) {
            existences++;
        }
        return existences;
    }

    private boolean atleastThreeWovels(String row) {

        String wovels = "aeiou";
        int numberOfWovels = 0;
        for (int i = 0; i < wovels.length(); i++) {
            numberOfWovels += getNumberOfWovels(wovels.charAt(i), row);
        }
        if (numberOfWovels >= 3)
        return true;
        else 
            return false;
    }

    private boolean doubleLetters(String row) {
        for (int i = 0; i < row.length() - 1; i++) {
            if (row.charAt(i) == row.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

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

    public Day5part2(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            line = reader.readLine();
            int allRows = 0;
            int goodRows = 0;
            while (!(line == null)) {
                allRows++;
                if (atleastThreeWovels(line)
                        && doubleLetters(line)
                        && notBadStrings(line)) {
                    goodRows++;
                }
                line = reader.readLine();
            }
            System.out.println("All rows: " + allRows);
            System.out.println("Good rows: " + goodRows);
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            Day5part2 day5part2 = new Day5part2(args);
        }
    }
}