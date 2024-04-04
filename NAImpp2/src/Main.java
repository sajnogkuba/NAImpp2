import java.io.File;
import java.util.Map;

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
            }
            case 2 -> {
                Perceptron perceptron = new Perceptron(trainSet, alpha);
            }
        }

    }
}
