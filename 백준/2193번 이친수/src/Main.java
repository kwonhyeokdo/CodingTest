import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int N;
    private long[] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new long[N + 1];
        for(int i = 0; i < N + 1; i++){
            memo[i] = -1;
        }

        final long answer = dp(N);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final long dp(final int digit) {
        if(digit == 1){
            return 1;
        }
        if(digit == 2){
            return 1;
        }

        if(memo[digit] != -1){
            return memo[digit];
        }

        memo[digit] = dp(digit - 2) + dp(digit - 1);

        return memo[digit];
    }
}