import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final int[][] board = new int[N][M];
        for(int y = 0; y < N; y++){
            final char[] charLine = br.readLine().toCharArray();
            for(int x = 0; x < M; x++){
                board[y][x] = Character.getNumericValue(charLine[x]);
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}