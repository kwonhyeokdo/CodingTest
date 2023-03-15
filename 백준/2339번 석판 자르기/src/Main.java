import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private int[][] slate = null;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        slate = new int[N][N];
        for(int y = 0; y < N; y++){
            final String[] inputLine = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                slate[y][x] = Integer.parseInt(inputLine[x]);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}