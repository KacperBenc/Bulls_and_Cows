import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Map<Integer,Integer> seedMaximum = new HashMap<>();
        for(int i = 0; i<B-A+1;i++){
            int max = 0;
            Random random = new Random(A+i);
            for(int j = 0; j<N; j++){
                int temp = random.nextInt(K);
                if(temp>max){
                    max = temp;
                }
            }
            seedMaximum.put(A+i , max);
        }
        int minMax = seedMaximum.get(A);
        int seedMinMax = A;
        for(int i = 0; i < seedMaximum.size(); i++){
            if(seedMaximum.get(A+i)<minMax){
                minMax=seedMaximum.get(A+i);
                seedMinMax = A+i;
            }
        }
        System.out.println(seedMinMax);
        System.out.println(minMax);
    }
}