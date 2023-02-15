
package bullscows;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        int secretNumbers = setCodeLength();
        int possibleSymbols = setPossibleSymbols(secretNumbers);
        gamePlay(generateSecretCode(secretNumbers, possibleSymbols),possibleSymbols);
        System.out.println("Congratulations! You guessed the secret code.");
    }
    public static char[] generateSecretCode(int codeLength, int possibleSymbols){
        boolean isUnique = false;
        char[] secretCode = new char[codeLength];
        while (!isUnique) {
            Random random = new Random();
            if(possibleSymbols<=10) {
                for (int i = 0; i < codeLength; i++) {
                    char randomNumber = (char) (random.nextInt(possibleSymbols) + 48);
                    secretCode[i] = randomNumber;
                }
            }
            else {
                for (int i = 0; i < codeLength; i++) {
                    int numberOrLetter = random.nextInt();
                    if(numberOrLetter%2==0) {
                        char randomNumber = (char) (random.nextInt(10) + 48);
                        secretCode[i] = randomNumber;
                    }
                    else{
                        char randomNumber = (char) (random.nextInt(possibleSymbols-10) + 97);
                        secretCode[i] = randomNumber;
                    }
                }
                }

       /*     long pseudoRandomNumber = System.nanoTime();
            pseudoRandomNumber = Long.reverse(pseudoRandomNumber);
            for (int i = 0; i < codeLength; i++) {
                long temporary = pseudoRandomNumber / 10;
                temporary = temporary * 10;
                secretCode[i] = (pseudoRandomNumber % temporary);
                pseudoRandomNumber /= 10;
                temporary /= 10;

            }*/
            // making only Unique digits valid
            isUnique = true;
            for (int i = 0; i < codeLength; i++) {
                for (int j = 0; j < codeLength; j++) {
                    if (secretCode[i] == secretCode[j] && i != j) {
                        isUnique = false;
                        break;
                    }
                }
            }
            if (secretCode[0] == 0) {
                isUnique = false;
            }
        }
        return secretCode;
    }
    public static void gamePlay(char[] secretCode , int possibleSymbols){
        if(possibleSymbols<=10){
            System.out.print ("The secret is prepared: ");
            for (int i = 0; i < secretCode.length ; i++) {
                System.out.print("*");
            }
            System.out.printf(" (0-%d).\n",possibleSymbols-1);
        }
        else if(possibleSymbols==11){
            System.out.print ("The secret is prepared: ");
            for (int i = 0; i < secretCode.length ; i++) {
                System.out.print("*");
            }
            System.out.print(" (0-9, a).\n");
        }
        else{
            System.out.print ("The secret is prepared: ");
            for (int i = 0; i < secretCode.length ; i++) {
                System.out.print("*");
            }
            System.out.printf(" (0-9, a-%c).\n",97-11+possibleSymbols);
        }
        System.out.println("Okay, let's start a game!");
        Scanner scanner = new Scanner(System.in);
        int bulls = 0;
        int cows = 0;
        String answer = "";
        char[] answerCode = new char[secretCode.length];
        int turn = 1;

        while (bulls!= secretCode.length){
            bulls = 0;
            cows = 0;
            System.out.printf("Turn %d. Answer:\n",turn);
            answer = scanner.nextLine();
            String[] stringCode = answer.split("");
            for(int i = 0; i<answerCode.length; i++){
                answerCode[i]=stringCode[i].charAt(0);
            }
            for(int i = 0; i<answerCode.length; i++){
                for (int j = 0; j<answerCode.length;j++){
                    if(answerCode[i]==secretCode[i]){
                        bulls++;
                        break;
                    }
                    else if(answerCode[i]==secretCode[j]){
                        cows++;
                        break;
                    }
                }
            }

            if(cows>1&&bulls>1){
                System.out.printf("%d cows and %d bulls.\n",cows,bulls);
            }
            else if (cows>1&&bulls==1){
                System.out.printf("%d cows and %d bull.\n",cows,bulls);
            } else if (cows==1&&bulls>1) {
                System.out.printf("%d cow and %d bulls.\n",cows,bulls);
            }
            else if(cows==1&&bulls==1) {
                System.out.printf("%d cow and %d bull.\n",cows,bulls);
            }
            else if(cows>1&&bulls==0) {
                System.out.printf("%d cows.\n",cows);
            }
            else if(cows==0&&bulls>1) {
                System.out.printf("%d bulls.\n",bulls);
            } else if (cows==1&&bulls==0) {
                System.out.printf("%d cow.\n",cows);
            }
            else if (cows==0&&bulls==1) {
                System.out.printf("%d bull.\n",bulls);
            }
            else System.out.print("None.");
            turn++;
        }
    }
    public static int setCodeLength(){

        Scanner scanner = new Scanner(System.in);
        String strSecretNumbers = "";
        int secretNumbers = 0;
        boolean isValid = false;
        while (!isValid){
            System.out.println("Please, enter the secret code's length:");
            try{
                strSecretNumbers = scanner.nextLine();
                secretNumbers = Integer.parseInt(strSecretNumbers);
            }
            catch (Exception e){
                System.out.printf("Error: %s isn't a valid number.\n", strSecretNumbers);
                continue;
            }
            if(secretNumbers>10||secretNumbers<1){
                System.out.println("Error: can't generate a secret number with this length.");
                continue;
            }
            isValid = true;
        }
        return secretNumbers;
    }
    public static int setPossibleSymbols(int codeLength){
        Scanner scanner = new Scanner(System.in);
        String strPossibleSymbols = "";
        int possibleSymbols = 0;
        boolean isValid = false;
        while (!isValid){
            System.out.println("Input the number of possible symbols in the code:");
            try{
                strPossibleSymbols = scanner.nextLine();
                possibleSymbols = Integer.parseInt(strPossibleSymbols);
            }
            catch (Exception e){
                System.out.printf("Error: %s isn't a valid number.\n", strPossibleSymbols);
                continue;
            }
            if(possibleSymbols>36||possibleSymbols<1){
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                continue;

            }
            if(possibleSymbols<codeLength){
                System.out.printf("it's not possible to generate a code with a length of %d with %d unique symbols.\n",codeLength,possibleSymbols );
                continue;
            }
            isValid=true;
        }
        return possibleSymbols;
    }
}


