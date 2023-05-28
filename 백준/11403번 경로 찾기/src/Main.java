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

        final int N = Integer.parseInt(br.readLine());
        final Graph graph = new Graph(N);
        for(int u = 0; u < N; u++){
            final String[] inputLine = br.readLine().split(" ");
            for(int v = 0; v < N; v++){
                final int n = Integer.parseInt(inputLine[v]);
                if(n == 1){
                    graph.add(u, v);
                }
            }
        }

        for(int i = 0; i < N; i++){
            final List<Integer> resultList = graph.dfsStart(i);
            final boolean[] line = new boolean[N];
            for(int j = 0; j < resultList.size(); j++){
                line[resultList.get(j)] = true;
            }
            for(int j = 0; j < N; j++){
                if(line[j]){
                    bw.write('1');
                }else{
                    bw.write('0');
                }
                if(j != N - 1){
                    bw.write(' ');
                }else{
                    bw.write('\n');
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private List<List<Integer>> adj = null;

        protected Graph(final int n){
            adj = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                final List<Integer> list = new ArrayList<>(n);
                adj.add(list);
            }
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final List<Integer> dfsStart(final int n){
            final boolean[] isVistied = new boolean[adj.size()];
            final List<Integer> resultList = new ArrayList<>(adj.size());

            dfs(n, isVistied, resultList);

            return resultList;
        }

        private final void dfs(final int current, final boolean[] isVistied, final List<Integer> resultList){
            for(final int next : adj.get(current)){
                if(!isVistied[next]){
                    isVistied[next] = true;
                    resultList.add(next);
                    dfs(next, isVistied, resultList);
                }
            }
        }
    }
}