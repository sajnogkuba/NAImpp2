import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;

    public File chooseTrainSet() {
        System.out.println("Input path to file with Train Set:");
        return chooseFile();
    }

    public int chooseMode() {
        System.out.println("""
                Choose option:\s
                \t1. Choose file with test set.\s
                \t2. Input vectors with data in interface.""");
        return selectOption(2);
    }

    public File chooseTestSet() {
        System.out.println("Input path to file with Test Set:");
        return chooseFile();
    }

    private int selectOption(int max) {
        scanner = new Scanner(System.in);
        try{
            int input = scanner.nextInt();
            if(input < 1 | input > max){
                System.out.println("You can choose options from 1 to " + max + " try again.");
                return selectOption(max);
            }
            return input;
        } catch (InputMismatchException e){
            System.out.println("You should type in an integer, try again.");
            return selectOption(max);
        }
    }


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

    public double chooseAlpha() {
        System.out.println("Choose alpha:");
        scanner = new Scanner(System.in);
        try{
            return scanner.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("You should type in a double, try again.");
            return chooseAlpha();
        }
    }

    public List<String> getUserVector(int numberOfValuesInVector) {
        System.out.println("Type in vector, separate values by comma. Like this: w,x,y,z");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split(",");
        if(arr.length != numberOfValuesInVector){
            System.out.println("You should type in " + numberOfValuesInVector + " values, try again.");
            return getUserVector(numberOfValuesInVector);
        }
        try{
            for (String value : arr) {
                Double.parseDouble(value);
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid values, try again.");
            return getUserVector(numberOfValuesInVector);
        }
        return Arrays.stream(arr).toList();
    }
}
