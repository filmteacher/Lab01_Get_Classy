import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        ArrayList<Person> folks = new ArrayList<>();
        boolean done = false;

String FirstName = "";
        String LastName = "";
        String Title = "";
        int YOB = 0;

        // Create an instance of SafeInputObject
        SafeInputObj SI = new SafeInputObj();

        do {
            //ID = SI.getNonZeroLenString("Enter the 6-digit ID");
            FirstName = SI.getNonZeroLenString("Enter the first name");
            LastName = SI.getNonZeroLenString("Enter the last name");
            Title = SI.getNonZeroLenString("Enter the title");
            YOB =  SI.getRangedInt("Enter the 4-digit year of birth", 1940, 2010);

            Person personRec = new Person(FirstName, LastName, Title, YOB);
            folks.add(personRec);

            done = SI.getYNConfirm("Are you done?");

        } while(!done);

        for (Person p : folks) {
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

            for(Person rec : folks)
            {
                writer.write(rec.toCSV());  // writer won't write the Person object unless we convert it to a string
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
