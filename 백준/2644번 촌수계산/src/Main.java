import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int n = Integer.parseInt(br.readLine());
        final String[] targetSplit = br.readLine().split(" ");
        final int[] target = new int[]{Integer.parseInt(targetSplit[0]) - 1, Integer.parseInt(targetSplit[1]) - 1};
        final int m = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n);
        for(int i = 0; i < m; i++){
            final String[] inputSplit = br.readLine().split(" ");
            graph.add(Integer.parseInt(inputSplit[0]) - 1, Integer.parseInt(inputSplit[1]) - 1);
        }

        graph.bfs(target[0]);
        int answer = graph.levelList.get(target[1]);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        final List<List<Integer>> adjList = new ArrayList<>();
        final List<Integer> levelList = new ArrayList<>();
        boolean[] isVisited = null;

        Graph(int n){
            for(int i = 0; i < n; i++){
                adjList.add(new ArrayList<>());
                levelList.add(-1);
            }
            isVisited = new boolean[n];
        }

        final void add(final int u, final int v){
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        final void bfs(final int n){
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            isVisited[n] = true;

            int level = 0;
            while(!q.isEmpty()){
                int qSize = q.size();
                for(int i = 0; i < qSize; i++){
                    int current = q.poll();
                    levelList.set(current, level);
                    for(Integer next : adjList.get(current)){
                        if(!isVisited[next]){
                            isVisited[next] = true;
                            q.add(next);
                        }
                    }
                }
                level++;
            }
        }
    }
}