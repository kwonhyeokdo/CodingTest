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
        
        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final Graph graph = new Graph(N);
        for(int i = 0; i < M; i++){
            final String[] inputUV = br.readLine().split(" ");
            final int u = Integer.parseInt(inputUV[0]) - 1;
            final int v = Integer.parseInt(inputUV[1]) - 1;
            graph.add(u, v);
        }

        final int answer = graph.dfsAll();

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    final private class Graph{
        private List<List<Integer>> adjList = new ArrayList<>();
        private boolean[] isVisited = null;

        Graph(final int n){
            for(int i = 0; i < n; i++){
                adjList.add(new ArrayList<>());
            }
            isVisited = new boolean[n];
        }

        final void add(final int u, final int v){
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        final void dfs(final int current){
            isVisited[current] = true;
            for(Integer next : adjList.get(current)){
                if(!isVisited[next]){
                    dfs(next);
                }
            }
        }

        final int dfsAll(){
            int component = 0;

            for(int i = 0; i < adjList.size(); i++){
                if(!isVisited[i]){
                    dfs(i);
                    component++;
                }
            }

            return component;
        }
    }
}