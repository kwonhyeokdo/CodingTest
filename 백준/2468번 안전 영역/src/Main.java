import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    private static final int DIRECT[][] = {
        {-1, 1, 0, 0},
        {0, 0, -1, 1}
    };

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int[][] board = new int[N][N];
        int max = 0;
        for(int y = 0; y < N; y++){
            final String[] inputSplit = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                final int height = Integer.parseInt(inputSplit[x]);
                board[y][x] = height;
                max = Math.max(max, height);
            }
        }

        int answer = 0;
        for(int i = 0; i < max; i++){
            answer = Math.max(answer, dfsAll(i, board));
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final int dfsAll(final int height, final int[][] board){
        int component = 0;
        final int n = board.length;
        final boolean[][] isVisited = new boolean[n][n];

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if(!isVisited[y][x] && board[y][x] > height){
                    component++;
                    dfs(y, x, isVisited, height, board);
                }
            }
        }

        return component;
    }

    private final void dfs(final int y, final int x, final boolean[][] isVisited, final int height, final int[][] board){
        final int n = board.length;
        isVisited[y][x] = true;
        for(int i = 0; i < 4; i++){
            final int nextY = y + DIRECT[0][i];
            final int nextX = x + DIRECT[1][i];
            if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= n){
                continue;
            }
            if(isVisited[nextY][nextX]){
                continue;
            }
            if(board[nextY][nextX] <= height){
                continue;
            }
            dfs(nextY, nextX, isVisited, height, board);
        }       
    }
}