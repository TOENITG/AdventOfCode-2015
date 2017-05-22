
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2 {

    public static void main(String[] args) throws IOException {

        int paperSize = 0;
        int ribbonLength = 0;
        int[] paperSides = new int[3];

        try (BufferedReader reader = new BufferedReader(new FileReader("./day-2.txt"))) {

            String line = reader.readLine();
            while (!(line == null)) {
                int i=0;
                for (String retval : line.split("x")) {
                    paperSides[i++] = Integer.valueOf(retval);
                }
                
                // Calculate paper size.
                
                paperSize += 2* ((paperSides[0]* paperSides[1])+
                        paperSides[1]* paperSides[2] +
                        paperSides[2]* paperSides[0]);
                
                // Add slack area
                Arrays.sort(paperSides);
                
                paperSize += paperSides[0] * paperSides[1];
                
                // Calculate ribbon length
                
                ribbonLength += 2*(paperSides[0]+ paperSides[1])+
                        paperSides[0] * paperSides[1] * paperSides[2];
                
                line = reader.readLine();
            }
            System.out.println("Square feet needed: " + paperSize);
            System.out.println("Ribbon needed: "+ ribbonLength);
            reader.close();
        } catch (IOException e) {
            System.err.println("File not found!");
            System.exit(0);
        }
    }
}