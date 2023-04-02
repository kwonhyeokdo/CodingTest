import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final long MOD = 1000000000L;
    private long[][] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        memo = new long[10][N + 1];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < N + 1; j++){
                memo[i][j] = -1L;
            }
        }

        long answer = 0;
        for(int i = 0; i < 10; i++){
            answer = (answer + dp(i, N)) % MOD;
        }
        
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final long dp(final int number, final int position){
        if(position == 1){
            if(number == 0){
                return 0L;
            }else{
                return 1L;
            }
        }
        
        if(memo[number][position] != -1){
            return memo[number][position];
        }

        long result = 0;
        if(number == 0){
            result = dp(1, position - 1) % MOD;
        }else if(number == 9){
            result = dp(8, position - 1) % MOD;
        }else{
            result = (dp(number - 1, position - 1) + dp(number + 1, position - 1)) % MOD;
        }

        memo[number][position] = result;

        return result;
    }
}