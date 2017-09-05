/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/12/2016.
 */

import java.io.*;

public class SaveLoadClassifier
{
    public static void SaveClassifier(NaiveBayes nb, String outputFilename)
    {
        // serialise the classifier
        try
        {
            FileOutputStream fos =
                    new FileOutputStream(outputFilename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nb);
            oos.close();
            fos.close();
            System.out.println("Classifier saved to " + outputFilename);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(0);
        }
    }


    public static NaiveBayes LoadClassifier(NaiveBayes nb, String inputFilename)
    {
        try
        {
            FileInputStream fis = new FileInputStream(inputFilename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            nb = (NaiveBayes) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(0);
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            System.exit(0);
        }

        return nb;
    }
}
