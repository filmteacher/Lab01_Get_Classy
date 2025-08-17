import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        String personRec = "";
        String ID = "";
        String FirstName = "";
        String LastName = "";
        String Title = "";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the 6-digit ID");
            FirstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            LastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            Title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter the 4-digit year of birth", 1000, 9999);

            personRec = ID + ", " + FirstName + ", " + LastName + ", " + Title + ", " + YOB;
            folks.add(personRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        } while(!done);

        for (String p : folks) {
            System.out.println(p);
        }

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        //getOutPutPath doesn't work on my Mac
        Path fileLocation = target.resolve("PersonTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            // BufferedOutputStream doesn't work on my Mac
           BufferedWriter writer =
                    Files.newBufferedWriter(fileLocation, Charset.forName("UTF-8"));

            // Finally can write the file LOL!

            for(String rec : folks)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
