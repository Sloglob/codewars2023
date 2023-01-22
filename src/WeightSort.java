import java.util.ArrayList;
import java.util.Comparator;

public class WeightSort {

    public static class Weight{
        public int weight;
        public String originalWeight;

        public Weight(String string) {
            this.originalWeight = string;
            this.weight = sumOfDigits(string);
        }

        private int sumOfDigits(String string) {
            return String.valueOf(string)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        }

        @Override
        public String toString() {
            return originalWeight;
        }
    }

    public static String orderWeight(String string) {
        // your code
        if (string.isEmpty()) return "";
        ArrayList<Weight> weightsList = new ArrayList<>();
        String[] weights = string.split("\\s+");
        if (weights.length == 1) return string;
        for (String str : weights) {
            weightsList.add(new Weight(str));
        }
        Comparator<Weight> comparator = Comparator.comparing(w -> w.weight);
        comparator = comparator.thenComparing(w -> w.originalWeight);
        weightsList.sort(comparator);
        StringBuilder sb = new StringBuilder();
        for (Weight weight : weightsList) {
            sb.append(weight.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}