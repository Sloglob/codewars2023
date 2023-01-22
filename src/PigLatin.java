import static java.lang.Character.isLetter;

class PigLatin {
    public static String pigIt(String str) {
        String[] splitOriginalString = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : splitOriginalString) {
            if (word.length() == 1 && !isLetter(word.charAt(0))) {
                result.append(word);
                continue;}
            String sb = word.substring(1) +
                    word.charAt(0) + "ay ";
            result.append(sb);
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(PigLatin.pigIt("Pig latin is cool"));
        System.out.println(PigLatin.pigIt("This is my string"));
        System.out.println(PigLatin.pigIt("Hello world !"));

        }
    }