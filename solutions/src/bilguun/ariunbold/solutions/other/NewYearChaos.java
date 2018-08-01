package bilguun.ariunbold.solutions.other;

import java.util.Scanner;

public class NewYearChaos {
	
	// Complete the minimumBribes function below.
	/**
	 * 
	 * Test Case:
	 * 
	 * 2
		8
		5 1 2 3 7 8 6 4
		8
		1 2 5 3 7 8 6 4
	 * 
	 * @param q
	 */
    static void minimumBribes(int[] q) {
        for(int i = 0; i < q.length; i ++) {
            if(q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
        }
        
        int numOfBribes = 0;
        boolean isDone = false;
        
        while(!isDone) {
            numOfBribes = numOfBribes + scanAndBribe(q);
            
            isDone = true;
            for(int i = 0; i < q.length - 1; i ++) {
                if(q[i] > q[i + 1]) {
                    isDone = false;
                    break;
                }
            }
            
            
        }
        
        System.out.println(numOfBribes);

    }
    
    static int scanAndBribe(int[] q) {
        int numOfBribes = 0; 
        for(int i =0; i < q.length - 1; i ++) {
            if(q[i] > q[i + 1]) {
                int tmp = q[i + 1];
                q[i + 1] = q[i];
                q[i] = tmp;
                numOfBribes++;
            }
        }
        
        return numOfBribes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}
