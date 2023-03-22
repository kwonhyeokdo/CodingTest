import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private long[] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        memo = new long[N + 1];
        for(int i = 0; i < N + 1; i++){
            memo[i] = -1;
        }

        final long answer = dp(N);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final long dp(final int n) {
        if(n == 1){
            return 1L;
        }else if(n == 2){
            return 2L;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        memo[n] = ((dp(n - 2) % 15746) + (dp(n - 1) % 15746)) % 15746;

        return memo[n];
    }
}