import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private char[][] starArr = null;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        starArr = new char[N][N];


        br.close();
        bw.flush();
        bw.close();
    }

    private final void start(final int startIndex, final int endIndex, final boolean isDraw) throws Exception{
        final int divide = (endIndex - startIndex + 1) / 3;

        for(int y = startIndex; y < divide * 3; y += divide){
            
        }
    }
}
