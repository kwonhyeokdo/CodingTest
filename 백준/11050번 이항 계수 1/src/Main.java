import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int memo[] = null;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        memo = new int[N + 1];

        int answer = (factorial(N)) / ((factorial(K)) * (factorial(N - K)));
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final int factorial(final int n){
        if(n == 0){
            return 1;
        }

        if(memo[n] != 0){
            return memo[n];
        }

        return n * factorial(n - 1);
    }
}