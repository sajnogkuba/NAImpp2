public enum IrisType {
    Iris_setosa,
    Iris_versicolor;

    public static IrisType getType(String type) {
        switch (type){
            case "Iris-setosa" -> {
                return IrisType.Iris_setosa;
            }
            case "Iris-versicolor" -> {
                return IrisType.Iris_versicolor;
            }
            default -> {
                return null;
            }
        }
    }
    public int toInt(){
        if (this.equals(Iris_setosa))
            return 1;
        else
            return 0;
    }
}
