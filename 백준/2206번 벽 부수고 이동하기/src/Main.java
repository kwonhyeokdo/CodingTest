import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        final char[][][] board = new char[2][N][M];
        for(int i = 0; i < N; i++){
            final String inputLine = br.readLine();
            for(int j = 0; j < inputLine.length(); j++){
                board[0][i][j] = inputLine.charAt(j);
            }
        }

        int answer = bfs(board);

        if(answer == 0){
            bw.write("-1");
        }else{
            bw.write(String.valueOf(answer));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final int bfs(final char[][][] board){
        final int YY = board[0].length;
        final int XX = board[0][0].length;
        if(YY == 1 && XX == 1){
            return 1;
        }
        
        final int[][] direct = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        int cnt = 0;
        boolean isGoal = false;

        final Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        while(!isGoal && !que.isEmpty()){
            final int queSize = que.size();
            cnt++;
            for(int i = 0; !isGoal && i < queSize; i++){
                final int[] poll = que.poll();
                for(int j = 0; j < 4; j++){
                    final int y = poll[0] + direct[0][j];
                    final int x = poll[1] + direct[1][j];
                    if(y < 0 || x < 0 || y >= YY || x >= XX){
                        continue;
                    }

                    if(y == YY - 1 && x == XX - 1){
                        isGoal = true;
                        cnt++;
                        break;
                    }
                    que.add(new int[]{y, x});
                }
            }
        }

        return isGoal ? cnt : -1;
    }
}