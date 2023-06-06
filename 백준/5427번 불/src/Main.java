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

        final int T = Integer.parseInt(br.readLine());
        final int[][] direct = {
            {-1, 1, 0, 0},
            {0, 0, -1, 1}
        };
        for(int t = 0; t < T; t++){
            final String[] inputWidthLength = br.readLine().split(" ");
            final int width = Integer.parseInt(inputWidthLength[0]);
            final int length = Integer.parseInt(inputWidthLength[1]);
            final char[][] board = new char[length][width];
            final Queue<int[]> sangQue = new LinkedList<>();
            final Queue<int[]> fireQue = new LinkedList<>();
            for(int y = 0; y < length; y++){
                board[y] = br.readLine().toCharArray();
                for(int x = 0; x < width; x++){
                    if(board[y][x] == '*'){
                        fireQue.add(new int[]{y, x});
                    }else if(board[y][x] == '@'){
                        sangQue.add(new int[]{y, x});
                    }
                }
            }

            int time = 0;
            boolean isAnswer = false;
            while(!isAnswer && !sangQue.isEmpty()){
                time++;

                final int fireQueSize = fireQue.size();
                for(int i = 0; i < fireQueSize; i++){
                    final int[] poll = fireQue.poll();
                    for(int j = 0; j < 4; j++){
                        final int y = poll[0] + direct[0][j];
                        final int x = poll[1] + direct[1][j];

                        if(y < 0 || y >= length || x < 0 || x >= width || board[y][x] == '#' || board[y][x] == '*'){
                            continue;
                        }
                        board[y][x] = '*';
                        fireQue.add(new int[]{y, x});
                    }
                }

                final int sangQueSize = sangQue.size();
                for(int i = 0; i < sangQueSize && !isAnswer; i++){
                    final int[] poll = sangQue.poll();
                    for(int j = 0; j < 4; j++){
                        final int y = poll[0] + direct[0][j];
                        final int x = poll[1] + direct[1][j];

                        if(y < 0 || y >= length || x < 0 || x >= width){
                            isAnswer = true;
                            break;
                        }
                        if(board[y][x] == '#' || board[y][x] == '*' || board[y][x] == '@'){
                            continue;
                        }
                        board[y][x] = '@';
                        sangQue.add(new int[]{y, x});
                    }
                }
            }

            if(isAnswer){
                bw.write(time + "\n");
            }else{
                bw.write("IMPOSSIBLE\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}