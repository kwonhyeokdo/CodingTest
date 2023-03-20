import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int n = 0;
    private int k = 0;
    private int[][] memo;
    private int[] coinArray;
    private static final int MAX_VALUE = Integer.MAX_VALUE - 1; 

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputLine = br.readLine().split(" ");
        n = Integer.parseInt(inputLine[0]);
        k = Integer.parseInt(inputLine[1]);
        coinArray = new int[n];
        for(int i = 0; i < n; i++){
            coinArray[i] = Integer.parseInt(br.readLine());
        }
        memo = new int[n + 1][k + 1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < k + 1; j++){
                memo[i][j] = -1;
            }
        }
        
        int answer = dp(0, k);
        if(answer == MAX_VALUE){
            answer = -1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final int dp(final int n, final int k){
        if(n == this.n){
            return (k == 0 ? 0 : MAX_VALUE);
        }
        if(memo[n][k] != -1){
            return memo[n][k];
        }

        int result = dp(n + 1, k);
        if(coinArray[n] <= k){
            result = Math.min(result, dp(n, k - coinArray[n]) + 1);
        }
        memo[n][k] = result;
        return result;
    }
}
