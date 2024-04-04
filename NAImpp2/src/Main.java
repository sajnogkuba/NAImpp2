import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        File trainSet = userInterface.chooseTrainSet();
        Perceptron perceptron = new Perceptron(trainSet);
        int programMode = userInterface.chooseMode();

        switch (programMode){
            case 1 -> {
                File testSet = userInterface.chooseTestSet();
            }
            case 2 -> {}
        }

    }
}
