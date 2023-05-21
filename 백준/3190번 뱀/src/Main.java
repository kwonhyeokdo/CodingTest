import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
        final Set<int[]> apples = new HashSet<>();
        for(int i = 0; i < K; i++){
            final String[] inputApplePos = br.readLine().split(" ");
            final int x = Integer.parseInt(inputApplePos[0]);
            final int y = Integer.parseInt(inputApplePos[1]);
            apples.add(new int[]{x, y});
        }
        final int L = Integer.parseInt(br.readLine());
        final String[][] direct = new String[L][2];
        for(int i = 0; i < L; i++){
            direct[i] = br.readLine().split(" ");
        }

        int answer = 0;
        boolean isDie = true;
        final LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1, 3});
        boolean[][] board = new boolean[N + 1][N + 1];
        board[1][1] = true;
        while(!isDie){
            answer++;

            final int[] head = snake.getFirst();
            switch(head[2]){
                case 0:
                    head[1]--;
                    break;
                case 1:
                    head[1]++;
                    break;
                case 2:
                    head[0]--;
                    break;
                default:
                    head[0]++;
                    break;
            }
            if(head[0] < 1 || head[0] > N || head[1] < 1 || head[1] > N){
                break;
            }
            if(board[head[1]][head[0]]){
                break;
            }

            final int[] moveHead = {head[0], head[1]};
            if(apples.contains(moveHead)){
                apples.remove(moveHead);
            }else{
                
            }
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}