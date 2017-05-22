
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
public class Day6part1 {

    private boolean christmasLights[][] = new boolean[1000][1000];
    private int christmasLightsIntensity[][] = new int [1000][1000];
    private int numberOfLightsOn = 0;
    private int totalBrightness = 0;
    private String line = new String();

    private void clearLights() {
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                christmasLights[x][y] = false;
            }
        }
    }

    private void toggle(String from, String to) {
        String[] fromSplit = from.split(",");
        String[] toSplit = to.split(",");
        for (int x = Integer.valueOf(fromSplit[0]); x <= Integer.valueOf(toSplit[0]); x++) {
            for (int y = Integer.valueOf(fromSplit[1]); y <= Integer.valueOf(toSplit[1]); y++) {
                christmasLights[x][y] = !christmasLights[x][y];
                christmasLightsIntensity[x][y] += 2;
                totalBrightness += 2;
            }
        }
    }

    private void turnOn(String from, String to) {
        String[] fromSplit = from.split(",");
        String[] toSplit = to.split(",");
        for (int x = Integer.valueOf(fromSplit[0]); x <= Integer.valueOf(toSplit[0]); x++) {
            for (int y = Integer.valueOf(fromSplit[1]); y <= Integer.valueOf(toSplit[1]); y++) {
                christmasLights[x][y] = true;
                christmasLightsIntensity[x][y]++ ;
                totalBrightness++;
            }
        }
    }

    private void turnOff(String from, String to) {
        String[] fromSplit = from.split(",");
        String[] toSplit = to.split(",");
        for (int x = Integer.valueOf(fromSplit[0]); x <= Integer.valueOf(toSplit[0]); x++) {
            for (int y = Integer.valueOf(fromSplit[1]); y <= Integer.valueOf(toSplit[1]); y++) {
                christmasLights[x][y] = false;
                christmasLightsIntensity[x][y]-- ;
                if(christmasLightsIntensity[x][y] < 0)
                    christmasLightsIntensity[x][y] = 0;
                totalBrightness--;
            }
        }
        if (totalBrightness <0)
            totalBrightness = 0;
    }

    private int countLightsOn() {
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (christmasLights[x][y] == true) {
                    numberOfLightsOn++;
                }
            }
        }
        return numberOfLightsOn;
    }

    
    private int countLightsIintensity() {
        int intensity = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
             intensity += christmasLightsIntensity[x][y];
            }
        }
        return intensity;
    }
    
    private Day6part1(String fileName) {
        clearLights();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();
            while (!(line == null)) {
                String[] inputLine = line.split(" ");
                if (inputLine[1].equals("on")) {
                    turnOn(inputLine[2], inputLine[4]);
                }
                if (inputLine[1].equals("off")) {
                    turnOff(inputLine[2], inputLine[4]);
                }
                if (inputLine[0].equals("toggle")) {
                    toggle(inputLine[1], inputLine[3]);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }
        System.out.println("Number of lights on: " + countLightsOn());
        System.out.println("Total brightness: " + totalBrightness);
        System.out.println("or... "+countLightsIintensity());
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            Day6part1 day6part1 = new Day6part1(args[0]);
        }
    }
}
