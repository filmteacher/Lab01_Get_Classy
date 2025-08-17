import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args)
    {
        ArrayList<String> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        String productRec = "";
        String ID = "";
        String Name = "";
        String Desc = "";
        double Cost = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the 6-digit ID");
            Name = SafeInput.getNonZeroLenString(in, "Enter the product name");
            Desc = SafeInput.getNonZeroLenString(in, "Enter the product description");
            Cost = SafeInput.getDouble(in, "Enter the product cost");
            productRec = ID + ", " + Name + ", " + Desc + ", " + Cost;
            products.add(productRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        } while(!done);

        for (String p : products) {
            System.out.println(p);
        }

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        //getOutPutPath doesn't work on my Mac
        Path fileLocation = target.resolve("ProductTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            // BufferedOutputStream doesn't work on my Mac
            BufferedWriter writer =
                    Files.newBufferedWriter(fileLocation, Charset.forName("UTF-8"));

            // Finally can write the file LOL!

            for(String rec : products)
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
