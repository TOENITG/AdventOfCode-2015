import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    
    public static void main(String[] args) throws IOException {


        int floor = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("day-1.txt"))) {
            
            Boolean basement = false;
            String line = reader.readLine();
            while (!(line == null)) {
                for (int i=0; i < line.length(); i++)
                {
                    if(line.charAt(i) == '(')
                        floor++;
                    if(line.charAt(i) == ')')
                        floor--;
                    if (floor == -1 && !(basement)){
                        System.out.println("Basement reached at position: "+(i+1));
                        basement = true;
                    }
                }
                System.out.println("Floor: "+floor);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e){
            System.err.println("File not found!");
            System.exit(0);
        }   
    }
}
