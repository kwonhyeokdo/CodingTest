import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int memo[];

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        final int answer = dp(n);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final int dp(final int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 3;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = ((2 * dp(n - 2)) % 10007 + (dp(n - 1)) % 10007) % 10007;

        return memo[n];
    }
}