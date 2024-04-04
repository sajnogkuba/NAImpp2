import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        File trainSet = userInterface.chooseTrainSet();
        double alpha = userInterface.chooseAlpha();
        int programMode = userInterface.chooseMode();

        switch (programMode){
            case 1 -> {
                File testSet = userInterface.chooseTestSet();
                Perceptron perceptron = new Perceptron(trainSet, alpha, testSet);
                for (int i = 0; i < 10000 && perceptron.checkAccuracy() < 100; i++){
                    System.out.println("Accuracy: " + perceptron.checkAccuracy() + " %");
                    perceptron.checkAccuracyPerType();
                    System.out.println();
                    perceptron.teach();
                }
                System.out.println("Accuracy: " + perceptron.checkAccuracy() + " %");
                perceptron.checkAccuracyPerType();
            }
            case 2 -> {
                Perceptron perceptron = new Perceptron(trainSet, alpha);
                for(int i = 0; i < 100; i++){
                    perceptron.teach();
                }
                Scanner scanner = new Scanner(System.in);
                String input = "";
                while (!input.equals("stop")) {
                    List<String> vector = userInterface.getUserVector(perceptron.getNumberOfValuesInVector());
                    System.out.println();
                    System.out.println("I think it is: " + perceptron.classify(vector));
                    System.out.println("Type in 'stop' to close program");
                    input = scanner.nextLine();
                }
            }
        }

    }
}
