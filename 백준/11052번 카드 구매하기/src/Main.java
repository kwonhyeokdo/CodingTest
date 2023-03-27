import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        final String[] inputLine = br.readLine().split(" ");
        final double[] cardPackRank = new double[N];
        for(int i = 0; i < inputLine.length; i++){
            cardPackRank[i] = (i + 1) / Double.parseDouble(inputLine[i]);
        }
        


        br.close();
        bw.flush();
        bw.close();
    }
}