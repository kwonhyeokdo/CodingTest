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

        final int N = Integer.parseInt(br.readLine());
        final int[][] board = new int[N][N];
        int n = 0;
        for(int i = 0; i < N; i++){
            final char[] inputLine = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(inputLine[j] == '1'){
                    board[i][j] = ++n;
                }
            }
        }
        final Graph graph = new Graph(n);

        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(board[y][x] == 0){
                    continue;
                }

                final int u = board[y][x] - 1;
                if(y - 1 >= 0 && board[y - 1][x] > 0){
                    final int v = board[y - 1][x] -1;
                    graph.add(u, v);
                }
                if(y + 1 < N && board[y + 1][x] > 0){
                    final int v = board[y + 1][x] -1;
                    graph.add(u, v);
                }
                if(x - 1 >= 0 && board[y][x - 1] > 0){
                    final int v = board[y][x - 1] -1;
                    graph.add(u, v);
                }
                if(x + 1 < N && board[y][x + 1] > 0){
                    final int v = board[y][x + 1] -1;
                    graph.add(u, v);
                }
            }
        }

        final int[] answer = graph.dfsAll();
        for(final int i : answer){
            bw.write(i + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private List<List<Integer>> adj = new ArrayList<>();
        private boolean[] isVistied = null;
        private int component = 0;
        private List<Integer> nodeCnt = new ArrayList<>();

        protected Graph(final int n){
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            isVistied = new boolean[n];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final int[] dfsAll(){
            for(int i = 0; i < adj.size(); i++){
                if(!isVistied[i]){
                    component++;
                    nodeCnt.add(dfs(i));
                }
            }

            nodeCnt.sort(Comparator.naturalOrder());
            int[] result = new int[1 + nodeCnt.size()];
            result[0] = component;
            for(int i = 0; i < nodeCnt.size(); i++){
                result[i + 1] = nodeCnt.get(i);
            }

            return result;
        }

        private final int dfs(final int n){
            isVistied[n] = true;
            int nodeCnt = 1;
            for(int next : adj.get(n)){
                if(!isVistied[next]){
                    nodeCnt += dfs(next);
                }
            }

            return nodeCnt;
        }
    }
}