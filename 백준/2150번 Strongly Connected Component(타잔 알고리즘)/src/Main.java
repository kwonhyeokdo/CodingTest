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
        
        final String[] inputVE = br.readLine().split(" ");
        final int V = Integer.parseInt(inputVE[0]);
        final int E = Integer.parseInt(inputVE[1]);
        final Graph graph = new Graph(V);
        for(int i = 0; i < E; i++){
            final String[] inputUV = br.readLine().split(" ");
            final int u = Integer.parseInt(inputUV[0]);
            final int v = Integer.parseInt(inputUV[1]);
            graph.add(u, v);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private List<List<Integer>> adj = null;
        private List<List<Integer>> scc = null;
        private boolean[] visited = null;

        protected Graph(final int n){
            final int size = n + 1;
            adj = new ArrayList<>();
            for(int i = 0; i < size; i++){
                adj.add(new ArrayList<>());
            }
            visited = new boolean[size];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final void dfsStart(){

        }
    }
}