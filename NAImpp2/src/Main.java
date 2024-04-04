import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        File trainSet = userInterface.chooseTrainSet();
        int programMode = userInterface.chooseMode();

    }
}
