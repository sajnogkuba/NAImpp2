import java.io.File;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;


    private File chooseFile() {
        scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File result = new File(path);
        if(result.isFile()){
            if(path.substring(path.lastIndexOf('.') + 1).equals("csv")){
                return result;
            } else {
                System.out.println("You should choose .csv file, try again.");
                return chooseFile();
            }

        } else {
            System.out.println("No such file, try again.");
            return chooseFile();
        }
    }

    public File chooseTrainSet() {
        System.out.println("Input path to file with Train Set:");
        return chooseFile();
    }
}
