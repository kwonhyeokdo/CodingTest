import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputRC = br.readLine().split(" ");
        final int R = Integer.parseInt(inputRC[0]);
        final int C = Integer.parseInt(inputRC[1]);
        final char[][] board = new char[R][C];
        final Queue<int[]> waterQue = new LinkedList<>();
        final Queue<int[]> hedgehogQue = new LinkedList<>();
        final int[][] direct = {
            {-1, 1, 0, 0},
            {0, 0, -1, 1}
        };
        for(int y = 0; y < R; y++){
            board[y] = br.readLine().toCharArray();
            for(int x = 0; x < C; x++){
                if(board[y][x] == '*'){
                    waterQue.add(new int[]{y, x});
                }else if(board[y][x] == 'S'){
                    hedgehogQue.add(new int[]{y, x});
                }
            }
        }
        
        boolean isAnswer = false;
        int answer = 0;
        while(!isAnswer && !hedgehogQue.isEmpty()){
            answer++;

            final int waterQueSize = waterQue.size();
            for(int i = 0; i < waterQueSize; i++){
                final int[] waterPoll = waterQue.poll();
                for(int j = 0; j < 4; j++){
                    final int y = waterPoll[0] + direct[0][j];
                    final int x = waterPoll[1] + direct[1][j];

                    if(y < 0 || y >= R || x < 0 || x >= C || board[y][x] == '*' || board[y][x] == 'X' || board[y][x] == 'D'){
                        continue;
                    }

                    board[y][x] = '*';
                    waterQue.add(new int[]{y, x});
                }
            }

            final int hedgehogSize = hedgehogQue.size();
            for(int i = 0; i < hedgehogSize && !isAnswer; i++){
                final int[] hedgehogPoll = hedgehogQue.poll();
                for(int j = 0; j < 4; j++){
                    final int y = hedgehogPoll[0] + direct[0][j];
                    final int x = hedgehogPoll[1] + direct[1][j];

                    if(y < 0 || y >= R || x < 0 || x >= C || board[y][x] == '*' || board[y][x] == 'X' || board[y][x] == 'S'){
                        continue;
                    }

                    if(board[y][x] == 'D'){
                        isAnswer = true;
                        break;
                    }

                    board[y][x] = 'S';
                    hedgehogQue.add(new int[]{y, x});
                }
            }
        }

        if(isAnswer){
            bw.write(String.valueOf(answer));
        }else{
            bw.write("KAKTUS");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}