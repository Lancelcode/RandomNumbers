

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtils {public void saveFile(String filename, int[] array) //method for saving file
{
    try
    {
        File newFile = new File(filename);
        FileWriter fw = new FileWriter(newFile);
        if(newFile.canWrite())
        {
            System.out.println("File: "+ newFile.getAbsolutePath() + " created");
            fw.write(Arrays.toString(array));
            fw.close();
        }
        else
        {
            System.out.println("File already exists");
        }
    }
    catch (IOException e)
    {
        System.out.println("error occured" + e.getLocalizedMessage());
    }

}
}

