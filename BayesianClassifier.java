/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/12/2016.
 */

import java.util.List;
import java.util.ArrayList;

public class BayesianClassifier
{
    public static void main(String[] args)
    {
        // training tests /////////////////////////////////////
        NaiveBayes nb = new NaiveBayes(0.3, 0.9);
        nb.train("Roger","man");
        nb.train("Roger","code");
        nb.train("Roger","man");

        nb.train("cheese","food");

        List<String> test = new ArrayList<String>();
        test.add("Roger");

        List<String> test1 = new ArrayList<String>();
        test1.add("cheese");

        System.out.println("---- First Classifications ----");
        System.out.println("Roger = " + nb.classify(test));
        System.out.println("cheese = " + nb.classify(test1));


        List<String> train1 = new ArrayList<String>();
        train1.add("Roger");
        train1.add("Roger");
        train1.add("Roger");
        train1.add("Roger");
        train1.add("Roger");
        train1.add("Roger");
        nb.train(train1, "sailor");

        List<String> test3 = new ArrayList<String>();
        test3.add("Roger");

        System.out.println("\n---- Classification after further training ----");
        System.out.println("Roger 2 = " + nb.classify(test3));


        //////////////////////////////////////////////////////////////
        // serialisation tests
        System.out.println("\n---- Serialise, reload and classify test ----");

        // serialise the classifier
        SaveLoadClassifier.SaveClassifier(nb, "naiveBayes.ser" );

        // deserialise into a new classifier
        NaiveBayes nb1 = null;
        nb1 = SaveLoadClassifier.LoadClassifier(nb1, "naiveBayes.ser");

        nb1.setAssumedProb(0.9);
        nb1.setWeight(0.3);

        List<String> test4 = new ArrayList<String>();
        test4.add("Roger");

        System.out.println("Roger nb1 = " + nb1.classify(test4));
    }
}
