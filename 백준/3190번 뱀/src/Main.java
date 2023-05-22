import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 2][N + 2];
        for(int i = 0; i < K; i++){
            final String[] inputApplePos = br.readLine().split(" ");
            final int y = Integer.parseInt(inputApplePos[0]);
            final int x = Integer.parseInt(inputApplePos[1]);
            board[y][x] = 2;
        }
        final int L = Integer.parseInt(br.readLine());
        final Map<Integer, String> direct = new HashMap<>();
        for(int i = 0; i < L; i++){
            final String[] inputTimeDir = br.readLine().split(" ");
            direct.put(Integer.parseInt(inputTimeDir[0]), inputTimeDir[1]);
        }

        int answer = 0;
        final LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1, 3});
        board[1][1] = 1;
        while(true){
            answer++;

            int[] head = snake.getFirst();
            int x = head[0];
            int y = head[1];
            int dir = head[2];
            if(dir == 0){
                y--;
            }else if(dir == 1){
                y++;
            }else if(dir == 2){
                x--;
            }else{
                x++;
            }

            // 맵 밖에 나가면 죽음
            if(x < 1 || x > N || y < 1 || y > N){
                break;
            }

            // 머리가 몸통에 닿음
            if(board[y][x] == 1){
                break;
            }

            final int[] newHead = {x, y, dir};
            snake.addFirst(newHead);
            head = newHead;
            if(board[y][x] != 2){
                final int[] tail = snake.removeLast();
                board[tail[1]][tail[0]] = 0;
            }
            
            board[y][x] = 1;

            if(direct.containsKey(answer)){
                final String C = direct.get(answer);
                if("L".equals(C)){
                    if(dir == 0){
                        head[2] = 2;
                    }else if(dir == 1){
                        head[2] = 3;
                    }else if(dir == 2){
                        head[2] = 1;
                    }else{
                        head[2] = 0;
                    }
                }else{
                    if(dir == 0){
                        head[2] = 3;
                    }else if(dir == 1){
                        head[2] = 2;
                    }else if(dir == 2){
                        head[2] = 0;
                    }else{
                        head[2] = 1;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}