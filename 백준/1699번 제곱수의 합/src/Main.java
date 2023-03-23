import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int[] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        //final int answer = dp(N);

        memo[1] = 1;
        for(int i = 1; i <= N; i++){
            final int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i){
                memo[i] = 1;
            }else{
                memo[i] = memo[i - 1] + 1;
            }
        }

        bw.write(String.valueOf(memo[N]));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp(final int n) {
        if(memo[n] != 0){
            return memo[n];
        }

        final int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n){
            memo[n] = 1;
        }else{
            memo[n] = dp(n - 1) + 1;
        }

        return memo[n];
    }
}
