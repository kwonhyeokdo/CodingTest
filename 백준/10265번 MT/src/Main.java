import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNK = br.readLine().split(" ");
        final int n = Integer.parseInt(inputNK[0]);
        final int k = Integer.parseInt(inputNK[1]);
        final String[] inputX = br.readLine().split(" ");
        final Graph graph = new Graph(n);
        for(int u = 0; u < n; u++){
            final int v = Integer.parseInt(inputX[u]) - 1;
            graph.add(u, v);
        }
        
        List<Integer> cycleNodeCntList = graph.dfsStart();
        System.out.println(graph.dfsStart());
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private int[] adj = null;
        private boolean[] isVisited = null;
        private boolean[] isFinished = null;

        protected Graph(final int n){
            adj = new int[n];
        }

        private final void add(final int u, final int v){
            adj[u] = v;
        }

        private final List<Integer> dfsStart(){
            List<Integer> result = new ArrayList<>();
            isVisited = new boolean[adj.length];
            isFinished = new boolean[adj.length];  
            for(int i = 0; i < adj.length; i++){
                if(!isVisited[i]){
                    final int cycleNodeCnt = dfs(i);
                    if(cycleNodeCnt != 0){
                        result.add(cycleNodeCnt);
                    }
                }
            }

            return result;
        }

        private final int dfs(final int current){
            isVisited[current] = true;
            final int next = adj[current];
            int cycleNodeCnt = 0;
            if(!isVisited[next]){
                cycleNodeCnt = dfs(next);
            }else if(!isFinished[next]){
                int cnt = 1;
                for(int tmp = adj[current]; tmp != current; tmp = adj[tmp]){
                    cnt++;
                }
                cycleNodeCnt = Math.max(cycleNodeCnt, cnt);
            }

            isFinished[current] = true;
            return cycleNodeCnt;
        }
    }
}