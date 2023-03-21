import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int N;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp(final int beforeNumber, final int currentIndex){
        if(currentIndex == N){
            return 0;
        }
        if(currentIndex ==  0){
            
        }

        int result = 0;

        return result;
    }
}