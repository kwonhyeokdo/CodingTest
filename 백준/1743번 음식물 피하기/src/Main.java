import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNMK = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNMK[0]);
        final int M = Integer.parseInt(inputNMK[1]);
        final int K = Integer.parseInt(inputNMK[2]);
        final int[][] board = new int[N][M];
        int k = 0;
        final Graph graph = new Graph(K);
        for(int i = 0; i < K; i++){
            final String[] inputYX = br.readLine().split(" ");
            final int y = Integer.parseInt(inputYX[0]) - 1;
            final int x = Integer.parseInt(inputYX[1]) - 1;
            board[y][x] = ++k;
        }
        
        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                if(board[y][x] == 0){
                    continue;
                }
                
                final int u = board[y][x] - 1;
                if(y - 1 >= 0 && board[y - 1][x] > 0){
                    final int v = board[y - 1][x] - 1;
                    graph.add(u, v);
                }
                if(y + 1 < N && board[y + 1][x] > 0){
                    final int v = board[y + 1][x] - 1;
                    graph.add(u, v);
                }
                if(x - 1 >= 0 && board[y][x - 1] > 0){
                    final int v = board[y][x - 1] - 1;
                    graph.add(u, v);
                }
                if(x + 1 < M && board[y][x + 1] > 0){
                    final int v = board[y][x + 1] - 1;
                    graph.add(u, v);
                }
            }
        }

        final int answer = graph.dfsAll();
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private final List<List<Integer>> adj = new ArrayList<>();
        private boolean[] isVisited = null;

        protected Graph(final int n){
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            isVisited = new boolean[n];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final int dfsAll(){
            int maxNode = 0;

            for(int i = 0; i < adj.size(); i++){
                if(!isVisited[i]){
                    maxNode = Math.max(maxNode, dfs(i));
                }
            }

            return maxNode;
        }

        private final int dfs(final int n){
            isVisited[n] = true;

            int nodeCnt = 1;
            for(final int next : adj.get(n)){
                if(!isVisited[next]){
                    nodeCnt += dfs(next);
                }
            }

            return nodeCnt;
        }
    }
}