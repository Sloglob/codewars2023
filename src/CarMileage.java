import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CarMileage {
    static int numberToOperate;
    static int[] awesomePhrasesToCheck;

    public static int isInteresting(int number, int[] awesomePhrases) {
        //Go to town
        if (number == 98) return 1;
        if (number < 98) return 0;
        numberToOperate = number;
        awesomePhrasesToCheck = awesomePhrases;
        ArrayList<Integer> checkList = new ArrayList<>();
        checkList.add(isZeroes());
        checkList.add(isPalindrome());
        checkList.add(isSequentialDecrementing());
        checkList.add(isSequentialIncrementing());
        checkList.add(isMatchForAwesomePhrases());
        return checkList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
    }

    public static int isPalindrome() {
        String checkForPalindrome = String.valueOf(numberToOperate);
        int counter = 0;
        for (int i = 0; i < checkForPalindrome.length()/2; i++) {
            if (checkForPalindrome.charAt(i) == checkForPalindrome.charAt(checkForPalindrome.length()-1-i)) counter++;
        }
        if (counter == checkForPalindrome.length()/2) return 2;
        String checkForPalindromePlusOne = String.valueOf(numberToOperate+1);
        int counterPlusOne = 0;
        for (int i = 0; i < checkForPalindromePlusOne.length()/2; i++) {
            if (checkForPalindromePlusOne.charAt(i) == checkForPalindromePlusOne.charAt(checkForPalindromePlusOne.length()-1-i)) counterPlusOne++;
        }
        if (counterPlusOne == checkForPalindromePlusOne.length()/2) return 1;
        String checkForPalindromePlusTwo = String.valueOf(numberToOperate+2);
        int counterPlusTwo = 0;
        for (int i = 0; i < checkForPalindromePlusTwo.length()/2; i++) {
            if (checkForPalindromePlusTwo.charAt(i) == checkForPalindromePlusTwo.charAt(checkForPalindromePlusTwo.length()-1-i)) counterPlusTwo++;
        }
        if (counterPlusTwo == checkForPalindrome.length()/2) return 1;
        return 0;}

    public static int isZeroes() {
        String checkForZeroes = String.valueOf(numberToOperate);
        if (checkForZeroes.substring(1).matches("0+")) return 2;
        String checkForZeroesPlusOne = String.valueOf(numberToOperate+1);
        String checkForZeroesPlusTwo = String.valueOf(numberToOperate+2);
        if (checkForZeroesPlusOne.substring(1).matches("0+") || checkForZeroesPlusTwo.substring(1).matches("0+")) return 1;
        return 0;
    }

    public static int isSequentialIncrementing() {
        char[] mileage = String.valueOf(numberToOperate).toCharArray();
        boolean isSequential = true;
        for (int i = 0; i < mileage.length-1; i++) {
            if (mileage[i] == 9 && mileage[i+1] != 0) {
                isSequential = false;
                break;
            }
            if (mileage[i] - mileage[i + 1] != -1 && mileage[i] - mileage[i + 1] != 9) {
                isSequential = false;
                break;
            }
        }
        if (isSequential) return 2;
        char[] mileagePlusOne = String.valueOf(numberToOperate+1).toCharArray();
        boolean isSequentialPlusOne = true;
        for (int i = 0; i < mileagePlusOne.length-1; i++) {
            if (mileagePlusOne[i] == 9 && mileagePlusOne[i+1] != 0) {
                isSequentialPlusOne = false;
                break;
            }
            if (mileagePlusOne[i] - mileagePlusOne[i + 1] != -1 && mileagePlusOne[i] - mileagePlusOne[i + 1] != 9) {
                isSequentialPlusOne = false;
                break;
            }
        }
        char[] mileagePlusTwo = String.valueOf(numberToOperate+2).toCharArray();
        boolean isSequentialPlusTwo = true;
        for (int i = 0; i < mileagePlusTwo.length-1; i++) {
            if (mileagePlusTwo[i] == 9 && mileagePlusTwo[i+1] != 0) {
                isSequentialPlusTwo = false;
                break;
            }
            if (mileagePlusTwo[i] - mileagePlusTwo[i + 1] != -1 && mileagePlusTwo[i] - mileagePlusTwo[i + 1] != 9) {
                isSequentialPlusTwo = false;
                break;
            }
        }
        if (isSequentialPlusOne || isSequentialPlusTwo) return 1;
        return 0;}

    public static int isSequentialDecrementing() {
        char[] mileage = String.valueOf(numberToOperate).toCharArray();
        boolean isSequential = true;
        for (int i = 0; i < mileage.length-1; i++) {
            if (mileage[i] - mileage[i + 1] != 1) {
                isSequential = false;
                break;
            }
        }
        if (isSequential) return 2;
        char[] mileagePlusOne = String.valueOf(numberToOperate+1).toCharArray();
        boolean isSequentialPlusOne = true;
        for (int i = 0; i < mileagePlusOne.length-1; i++) {
            if (mileagePlusOne[i] - mileagePlusOne[i + 1] != 1) {
                isSequentialPlusOne = false;
                break;
            }
        }
        char[] mileagePlusTwo = String.valueOf(numberToOperate+2).toCharArray();
        boolean isSequentialPlusTwo = true;
        for (int i = 0; i < mileagePlusTwo.length-1; i++) {
            if (mileagePlusTwo[i] - mileagePlusTwo[i + 1] != 1) {
                isSequentialPlusTwo = false;
                break;
            }
        }
        if (isSequentialPlusOne || isSequentialPlusTwo) return 1;
        return 0;
    }

    public static int isMatchForAwesomePhrases() {
        for (Integer awesome : awesomePhrasesToCheck) {
            if (numberToOperate == awesome) {
                return 2;
            }
        }
        for (Integer awesome : awesomePhrasesToCheck) {
            if (numberToOperate+1 == awesome || numberToOperate+2 == awesome) {
                return 1;
            }
        }
        return 0;}
}