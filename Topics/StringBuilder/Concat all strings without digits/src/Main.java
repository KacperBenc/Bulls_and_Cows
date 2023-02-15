import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder output = new StringBuilder();
        for(String str:strings){
            output.append(str);
        }
        for(int i = 0; i<output.length();i++){
            if(Character.isDigit(output.charAt(i)) || Character.isWhitespace(output.charAt(i))){
                output.deleteCharAt(i);
                i--;
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}