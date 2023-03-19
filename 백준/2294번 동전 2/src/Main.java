import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputLine = br.readLine().split(" ");
        final int n = Integer.parseInt(inputLine[0]);
        final int k = Integer.parseInt(inputLine[1]);
        final int[] coinArray = new int[n];
        for(int i = 0; i < n; i++){
            coinArray[i] = Integer.parseInt(br.readLine());
        }

        

        br.close();
        bw.flush();
        bw.close();
    }
}
