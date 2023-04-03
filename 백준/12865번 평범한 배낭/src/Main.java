import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private Integer[][] memo = null;
    private int[] weight = null;
    private int[] value = null;
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputLine = br.readLine().split(" ");
        final int N = getInteger(inputLine[0]);
        final int K = getInteger(inputLine[1]);
        memo = new Integer[N + 1][K + 1];
        weight = new int[N + 1];
        value = new int[N + 1];

        for(int i = 1; i <= N; i++){
            inputLine = br.readLine().split(" ");
            weight[i] = getInteger(inputLine[0]);
            value[i] = getInteger(inputLine[1]);
        }

        int answer = dp(N, K);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final Integer dp(int n, int k){
        if(n == 0){
            return 0;
        }

        if(memo[n][k] != null){
            return memo[n][k];
        }

        if(weight[n] > k){
            memo[n][k] = dp(n - 1, k);
        }else{
            memo[n][k] = Math.max(dp(n - 1, k), dp(n - 1, k - weight[n]) + value[n]);
        }

        return memo[n][k];
    }

    private final int getInteger(String s){
        return Integer.parseInt(s);
    }
}