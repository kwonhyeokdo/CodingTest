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

        final int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            final String[] inputSplit = br.readLine().split(" ");
            final int M = Integer.parseInt(inputSplit[0]);
            final int N = Integer.parseInt(inputSplit[1]);
            final int K = Integer.parseInt(inputSplit[2]);
            final int[][] board = new int[N][M];
            int cnt = 0;
            for(int j = 0; j < K; j++){
                final String[] inputXY = br.readLine().split(" ");
                final int Y = Integer.parseInt(inputXY[1]);
                final int X = Integer.parseInt(inputXY[0]);
                board[Y][X] = ++cnt;
            }
            
            final Graph graph = new Graph(cnt);
            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){
                    if(board[y][x] != 0){
                        final int u = board[y][x] - 1;
                        if(y - 1 >= 0 && board[y - 1][x] != 0){
                            final int v = board[y - 1][x] -1;
                            graph.add(u, v);
                        }
                        if(y + 1 < N && board[y + 1][x] != 0){
                            final int v = board[y + 1][x] - 1;
                            graph.add(u, v);
                        }
                        if(x - 1 >= 0 && board[y][x - 1] != 0){
                            final int v = board[y][x - 1] - 1;
                            graph.add(u, v);
                        }
                        if(x + 1 < M && board[y][x + 1] != 0){
                            final int v = board[y][x + 1] - 1;
                            graph.add(u, v);
                        }
                    }
                }
            }
            final int answer = graph.dfsAll();
            bw.write(answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private List<List<Integer>> adjList = new ArrayList<>();
        private boolean[] visited = null;

        Graph(final int n){
            for(int i = 0; i < n; i++){
                adjList.add(new ArrayList<>());
            }
            visited = new boolean[n];
        }

        private final void add(final int u, final int v){
            adjList.get(u).add(v);
        }

        private final void dfs(final int n){
            visited[n] = true;
            for(Integer next : adjList.get(n)){
                if(!visited[next]){
                    dfs(next);
                }
            }
        }

        private final int dfsAll(){
            int component = 0;

            for(int i = 0; i < adjList.size(); i++){
                if(!visited[i]){
                    component++;
                    dfs(i);
                }
            }

            return component;
        }
    }
}