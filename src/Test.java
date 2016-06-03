import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ankur on 6/2/2015.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner infile = new Scanner(new File("highscore.txt"));
        int i = 0;
        while (infile.hasNext() && i < 5) {
            String value = infile.next();
            System.out.println(value);
            i++;
        }

    }
}
