import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNMP = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNMP[0]);
        final int M = Integer.parseInt(inputNMP[1]);
        final int P = Integer.parseInt(inputNMP[2]) - 1;
        final Graph graph = new Graph(M);
        for(int i = 0; i < N; i++){
            final String[] inputChannel = br.readLine().split(" ");
            final int u = Integer.parseInt(inputChannel[1]) - 1;
            final int v = Integer.parseInt(inputChannel[0]) - 1;
            graph.add(u, v);
        }
        
        final int answer = graph.dfs(P);
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private Map<Integer, Queue<Integer>> adj = null;
        private boolean[] isVisited = null;

        protected Graph(final int n){
            adj = new HashMap<>();
            isVisited = new boolean[n];
        }

        private final void add(final int u, final int v){
            if(adj.containsKey(u)){
                adj.get(u).add(v);   
            }else{
                Queue<Integer> pq = new LinkedList<>();
                pq.add(v);
                adj.put(u, pq);
            }
        }

        private final int dfs(final int current){
            isVisited[current] = true;
            if(!adj.containsKey(current)){
                return 0;
            }else{
                final int next = adj.get(current).peek();
                if(isVisited[next]){
                    return -1;
                }else{
                    int cnt = dfs(next);
                    return cnt == -1 ? cnt : ++cnt;
                }
            }
        }
    }
}