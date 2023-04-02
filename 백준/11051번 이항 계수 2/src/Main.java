import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int[][] memo = null;
    private static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        memo = new int[N + 1][K + 1];

        final int answer = pascal(N, K);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int pascal(final int n, final int k){
        if(n == k || k == 0){
            return 1;
        }
        
        if(memo[n][k] != 0){
            return memo[n][k];
        }

        memo[n][k] = (pascal(n - 1, k - 1) % MOD + pascal(n - 1, k) % MOD) % MOD;

        return memo[n][k];
    }
}