import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int[] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        final int answer = dp(n);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp(final int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = ((dp(n - 2) % 10007) + (dp(n - 1)) % 10007) % 10007;

        return memo[n];
    }
}