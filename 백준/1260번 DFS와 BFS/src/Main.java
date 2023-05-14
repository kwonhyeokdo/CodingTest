import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class Main{
    final List<Integer> dfsAnswer = new ArrayList<>();
    final List<Integer> bfsAnswer = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNMV = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNMV[0]);
        final int M = Integer.parseInt(inputNMV[1]);
        final int V = Integer.parseInt(inputNMV[2]) - 1;
        final Graph graph = new Graph(N);
        for(int i = 0; i < M; i++){
            final String[] inputUV = br.readLine().split(" ");
            final int u = Integer.parseInt(inputUV[0]) - 1;
            final int v = Integer.parseInt(inputUV[1]) - 1;
            graph.add(u, v);
        }

        graph.solution(V);
        for(int i = 0; i < dfsAnswer.size(); i++){
            if(i != dfsAnswer.size() - 1){
                bw.write((dfsAnswer.get(i) + 1) + " ");
            }else{
                bw.write(String.valueOf(dfsAnswer.get(i) + 1));
            }
        }
        bw.newLine();
        for(int i = 0; i < bfsAnswer.size(); i++){
            if(i != bfsAnswer.size() - 1){
                bw.write((bfsAnswer.get(i) + 1) + " ");
            }else{
                bw.write(String.valueOf(bfsAnswer.get(i) + 1));
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private final List<List<Integer>> adjList = new ArrayList<>();
        private boolean[] isVistied = null;

        private Graph(final int N){
            for(int i = 0; i < N; i++){
                adjList.add(new ArrayList<>());
            }
        }

        private final void add(final int u, final int v){
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        private final void solution(final int V){
            for(int i = 0; i < adjList.size(); i++){
                adjList.get(i).sort(Comparator.naturalOrder());
            }
            isVistied = new boolean[adjList.size()];
            dfs(V);
            isVistied = new boolean[adjList.size()];
            bfs(V);
        }

        private final void dfs(final int current){
            isVistied[current] = true;
            dfsAnswer.add(current);
            for(Integer next : adjList.get(current)){
                if(!isVistied[next]){
                    dfs(next);
                }
            }
        }

        private final void bfs(final int n){
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            isVistied[n] = true;

            while(!q.isEmpty()){
                final int qSize = q.size();
                for(int i = 0; i < qSize; i++){
                    final int current = q.poll();
                    bfsAnswer.add(current);
                    for(Integer next : adjList.get(current)){
                        if(!isVistied[next]){
                            isVistied[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }
    }
}