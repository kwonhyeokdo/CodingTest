import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            final int n = Integer.parseInt(br.readLine());
            final int[][] stickerArray = new int[2][n];
            for(int j = 0; j < 2; j++){
                final String[] inputLine = br.readLine().split(" ");
                for(int k = 0; k < n; k++){
                    stickerArray[j][k] = Integer.parseInt(inputLine[k]);
                }
            }
            final int dp[][] = new int[n + 1][3];
            for(int y = 0; y < n + 1; y++){
                for(int x = 0; x < 3; x++){
                    dp[y][x] = -1;
                }
            }
            final int answer = getMaxScore(dp, 0, 0, stickerArray, n);
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private final int getMaxScore(final int[][] dp, final int col, final int status, final int[][] stickerArray, final int n){
        if(col == n){
            return 0;
        }
        if(dp[col][status] != -1){
            return dp[col][status];
        }

        int answer = getMaxScore(dp, col + 1, 0, stickerArray, n);
        if(status != 1){
            answer = Math.max(getMaxScore(dp, col + 1, 1, stickerArray, n) + stickerArray[0][col], answer);
        }
        if(status != 2){
            answer = Math.max(getMaxScore(dp, col + 1, 2, stickerArray, n) + stickerArray[1][col], answer);
        }
        dp[col][status] = answer;

        return answer;
    }
}
