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
        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final char[][] board = new char[N][M];
        final int[][] direct = {
            {-1, 1, 0, 0},
            {0, 0, -1, 1}
        };
        for(int y = 0; y < N; y++){
            board[y] = br.readLine().toCharArray();
        }

        final Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        int level = 1;
        boolean findAnswer = false;
        while(!queue.isEmpty() && !findAnswer){
            final int queSize = queue.size();
            for(int i = 0; i < queSize && !findAnswer; i++){
                final Point pop = queue.poll();
                for(int j = 0; j < 4 && !findAnswer; j++){
                    final int y = pop.y + direct[0][j];
                    final int x = pop.x + direct[1][j];
                    if(y < 0 || x < 0 || y >= N || x >= M || board[y][x] != '1'){
                        continue;
                    }
                    if(y == N - 1 && x == M - 1){
                        findAnswer = true;
                        break;
                    }
                    board[y][x] = 'x';
                    queue.add(new Point(y, x));
                }
            }
            level++;
        }

        bw.write(String.valueOf(level));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Point{
        final int y;
        final int x;

        protected Point(final int y, final int x){
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point [y=" + y + ", x=" + x + "]";
        }
    }
}