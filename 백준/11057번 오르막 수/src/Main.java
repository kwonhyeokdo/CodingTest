import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int IMPOSSIBLE = -1;
    private static final int MOD = 10007;
    private int[][] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        memo = new int[10][N + 1];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < N + 1; j++){
                memo[i][j] = IMPOSSIBLE;
            }
        }

        int answer = 0;
        for(int i = 0; i < 10; i++){
            answer = (answer + dp(i, N)) % MOD;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp(final int number, final int position){
        if(position == 1){
            return 1;
        }
        if(memo[number][position] != IMPOSSIBLE){
            return memo[number][position];
        }

        int result = 0;
        for(int i = 0; i <= number; i++){
            result += dp(i, position - 1) % MOD;
        }
        result %= MOD;

        memo[number][position] = result;

        return result;
    }
}