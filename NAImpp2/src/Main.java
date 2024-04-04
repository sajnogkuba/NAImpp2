import java.io.File;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        File trainSet = userInterface.chooseTrainSet();

    }
}
