import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputLine = br.readLine().split(" ");
        final int N = Integer.parseInt(inputLine[0]);
        final int M = Integer.parseInt(inputLine[1]);
        final int[] trees = new int[N];
        long sum = 0;
        inputLine = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(inputLine[i]);
            sum += trees[i];
        }

        int max = sum > 1000000000L ? 1000000000 : (int)sum;
        int min = 0;
        while(min + 1 < max){
            int mid = (max + min) / 2;
            long cutSum = 0;

            for(int i = 0; i < N; i++){
                if(trees[i] > mid){
                    cutSum += (trees[i] - mid);
                }
            }

            if(cutSum >= M){
                min = mid;
            }else{
                max = mid;
            }
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }
}