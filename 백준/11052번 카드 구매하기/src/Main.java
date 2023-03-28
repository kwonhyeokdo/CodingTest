import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private int[] cardPack;
    private int[] memo;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        final String[] inputLine = br.readLine().split(" ");
        cardPack = new int[N + 1];
        for(int i = 0; i < N; i++){
            cardPack[i + 1] = Integer.parseInt(inputLine[i]);
        }

        final int answer = dp(N);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final int dp(final int n){
        int result = 0;

        if(memo[n] != 0){
            return memo[n];
        }

        result = cardPack[n];
        for(int i = 1; i < n; i++){
            result = Math.max(result, dp(i) + dp(n - i));
        }

        memo[n] = result;

        return result;
    }
}