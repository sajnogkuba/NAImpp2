import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Perceptron {
    private int numberOfValuesInVector;
    private List<List<String>> trainSet;
    private List<Double> weights;
    private double alpha;
    public Perceptron(File trainSet, double alpha) {
        this.alpha = alpha;
        try (Scanner scanner = new Scanner(trainSet);){
            numberOfValuesInVector = (int)Arrays.stream(scanner.nextLine().split(",")).count();
            this.trainSet = generateTrainSetAsList(trainSet);
            this.weights = generateWeightsVector();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.weights);
    }

    private List<Double> generateWeightsVector() {
        Random random = new Random();
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < numberOfValuesInVector; i++) {
            result.add(random.nextDouble());
        }
        return result;
    }

    private List<List<String>> generateTrainSetAsList(File trainSet){
        List<List<String>> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(trainSet);){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                result.add(Arrays.stream(line.split(",")).toList());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
