import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int DIVIDE = 1000000000;
    private int[][] memo;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        memo = new int[11][N + 1];

        
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp() {
        int result = 0;

        return result;
    }
}