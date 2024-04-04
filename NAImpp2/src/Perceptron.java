import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Perceptron {
    private int numberOfValuesInVector;
    public Perceptron(File trainSet) {
        try (Scanner scanner = new Scanner(trainSet);){
            numberOfValuesInVector = (int)Arrays.stream(scanner.nextLine().split(",")).count() - 1;
            System.out.println(numberOfValuesInVector);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
