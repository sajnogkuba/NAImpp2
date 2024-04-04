import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Perceptron {

    private final List<List<String>> trainSet;
    private List<List<String>> testSet;
    private List<Double> weights;
    private final double alpha;
    public Perceptron(File trainSet, double alpha) {
        this.alpha = alpha;
        this.trainSet = generateVectorsFromFile(trainSet);
        this.weights = generateWeightsVector();
    }

    public Perceptron(File trainSet, double alpha, File testSet) {
        this(trainSet, alpha);
        this.testSet = generateVectorsFromFile(testSet);
    }

    public double checkAccuracy() {
        double correctAnswers = 0;
        for (List<String> vector : testSet) {
            if (classify(vector) == IrisType.getType(vector.getLast())){
                correctAnswers++;
            }
        }
        return correctAnswers / testSet.size() * 100;
    }

    public void checkAccuracyPerType() {
        Map<IrisType, Double> count = new HashMap<>();
        Map<IrisType, Double> correctAnswers = new HashMap<>();
        for (List<String> vector : testSet) {
            correctAnswers.put(IrisType.getType(vector.getLast()), 0.0);
            if(count.containsKey(IrisType.getType(vector.getLast()))){
                count.put(IrisType.getType(vector.getLast()), count.get(IrisType.getType(vector.getLast())) + 1);
            } else {
                count.put(IrisType.getType(vector.getLast()), 1.0);
            }
        }
        for (List<String> vector : testSet) {
            if(classify(vector).equals(IrisType.getType(vector.getLast()))){
                correctAnswers.put(IrisType.getType(vector.getLast()), correctAnswers.get(IrisType.getType(vector.getLast())) + 1);
            }
        }
        correctAnswers.forEach((k, v) -> System.out.println(k + ": " + v / count.get(k) * 100 + "%"));
    }

    private IrisType classify(List<String> vector) {
        double sum = 0;
        for(int i = 0; i < vector.size() - 1; i++){
            sum += Double.parseDouble(vector.get(i)) * weights.get(i);
        }
        if (sum > weights.getLast()){
            return IrisType.Iris_setosa;
        } else {
            return IrisType.Iris_versicolor;
        }
    }


    private List<Double> generateWeightsVector() {
        Random random = new Random();
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < trainSet.size(); i++) {
            result.add(random.nextDouble());
        }
        return result;
    }

    private List<List<String>> generateVectorsFromFile(File trainSet){
        List<List<String>> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(trainSet)){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                result.add(Arrays.stream(line.split(",")).toList());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void teach() {
        for (List<String> vector : trainSet) {
            List<Double> weights = new ArrayList<>();
            int d = Objects.requireNonNull(IrisType.getType(vector.getLast())).toInt();
            int y = classify(vector).toInt();
            for (int i = 0; i < vector.size() - 1; i++) {
                weights.add(this.weights.get(i) + (d - y) * alpha * Double.parseDouble(vector.get(i)));
            }
            weights.add(weights.getLast()+ (d - y) * alpha * -1);
            this.weights = weights;
        }


    }
}
