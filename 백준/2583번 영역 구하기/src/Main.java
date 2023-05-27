import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputMNK = br.readLine().split(" ");
        final int M = Integer.parseInt(inputMNK[0]);
        final int N = Integer.parseInt(inputMNK[1]);
        final int K = Integer.parseInt(inputMNK[2]);
        final int[][] board = new int[M][N];

        for(int i = 0; i < K; i++){
            final String[] inputPos = br.readLine().split(" ");
            final int leftX = Integer.parseInt(inputPos[0]);
            final int leftY = Integer.parseInt(inputPos[1]);
            final int rightX = Integer.parseInt(inputPos[2]);
            final int rightY = Integer.parseInt(inputPos[3]);
            for(int y = leftY; y < rightY; y++){
                for(int x = leftX; x < rightX; x++){
                    board[y][x] = -1;
                }
            }
        }

        int n = 0;
        for(int y = 0; y < M; y++){
            for(int x = 0; x < N; x++){
                if(board[y][x] != -1){
                    board[y][x] = n++;
                }
            }
        }

        final Graph graph = new Graph(n);
        for(int y = 0; y < M; y++){
            for(int x = 0; x < N; x++){
                if(board[y][x] == -1){
                    continue;
                }
                final int u = board[y][x];
                if(y - 1 >= 0 && board[y - 1][x] > -1){
                    final int v = board[y - 1][x];
                    graph.add(u, v);
                }
                if(y + 1 < M && board[y + 1][x] > -1){
                    final int v = board[y + 1][x];
                    graph.add(u, v);
                }
                if(x - 1 >= 0 && board[y][x - 1] > -1){
                    final int v = board[y][x - 1];
                    graph.add(u, v);
                }
                if(x + 1 < N && board[y][x + 1] > -1){
                    final int v = board[y][x + 1];
                    graph.add(u, v);
                }
            }
        }

        final List<Integer> answer = graph.dfsAll();
        bw.write(answer.remove(answer.size() - 1) + "\n");
        answer.sort(Comparator.naturalOrder());
        for(final int i: answer){
            bw.write(i + " ");
        }
        
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

        private final List<Integer> dfsAll(){
            List<Integer> nodeCntList = new ArrayList<>();
            int component = 0;

            for(int i = 0; i < adj.size(); i++){
                if(!isVisited[i]){
                    nodeCntList.add(dfs(i));
                    component++;
                }
            }
            nodeCntList.add(component);
            return nodeCntList;
        }

        private final int dfs(int n){
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