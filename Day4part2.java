
import java.io.UnsupportedEncodingException;
import java.security.*;

public class Day4part2 {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        
        String hashStart = "yzbqklnj";
        int addToHash = 0;

        String calculate = new String();
        boolean found = false;

        while (!(found)) {
            calculate = hashStart.concat(Integer.toString(addToHash));
            byte[] bytesOfMessage = calculate.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theDigest = md.digest(bytesOfMessage);

            if (theDigest[0] == 0 && theDigest[1] == 0 && theDigest[2]== 0)  {
                found = true;
                System.out.println(theDigest[0]+":"+theDigest[1]+":"+theDigest[2]);
            } else {
                addToHash++;
            }
        }
        System.out.println(addToHash);

        
    }
}
