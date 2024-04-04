public enum IrisType {
    Iris_setosa,
    Iris_versicolor,
    Iris_virginica;

    public static IrisType getType(String type) {
        switch (type){
            case "Iris-setosa" -> {
                return IrisType.Iris_setosa;
            }
            case "Iris-versicolor" -> {
                return IrisType.Iris_versicolor;
            }
            case "Iris-virginica" -> {
                return IrisType.Iris_virginica;
            }
            default -> {
                return null;
            }
        }
    }
}
