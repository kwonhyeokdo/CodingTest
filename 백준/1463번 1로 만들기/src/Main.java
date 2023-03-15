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

        for(int i = 2; i < N + 1; i++){
            memo[i] = memo[i - 1] + 1;
            if(i % 2 == 0){
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }
            if(i % 3 == 0){
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }
        }

        bw.write(String.valueOf(memo[N]));

        bw.flush();
        bw.close();
        br.close();
    }
}