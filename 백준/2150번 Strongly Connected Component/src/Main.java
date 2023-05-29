import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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
        final ReverseGraph rGraph = new ReverseGraph(V);
        for(int i = 0; i < E; i++){
            final String[] inputUV = br.readLine().split(" ");
            final int u = Integer.parseInt(inputUV[0]);
            final int v = Integer.parseInt(inputUV[1]);
            graph.add(u, v);
            rGraph.add(v, u);
        }

        final List<Queue<Integer>> resultList =  rGraph.dfsStart(graph.dfsStart());
        final Queue<Queue<Integer>> answerPq = new PriorityQueue<>((o1, o2)->{
            return o1.peek() - o2.peek();
        });
        for(final Queue<Integer> pq : resultList){
            answerPq.add(pq);
        }

        bw.write(answerPq.size() + "\n");
        while(!answerPq.isEmpty()){
            final Queue<Integer> pq = answerPq.poll();
            while(!pq.isEmpty()){
                bw.write(pq.poll() + " ");
            }
            bw.write("-1\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private List<List<Integer>> adj = null;
        private boolean[] isVisited = null;
        private Stack<Integer> stack = null;

        protected Graph(final int n){
            final int size = n + 1;
            adj = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                adj.add(new ArrayList<>());
            }
            isVisited = new boolean[size];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final Stack<Integer> dfsStart(){
            stack = new Stack<>();

            for(int i = 1; i < adj.size(); i++){
                if(!isVisited[i]){
                    dfs(i);
                }
            }

            return stack;
        }

        private final void dfs(final int current){
            isVisited[current] = true;

            for(final int next : adj.get(current)){
                if(!isVisited[next]){
                    dfs(next);
                }
            }
            
            stack.push(current);
        }
    }

    private final class ReverseGraph{
        private List<List<Integer>> adj = null;
        private List<Queue<Integer>> resultList = new ArrayList<>();
        private boolean[] isVisited = null;

        protected ReverseGraph(final int n){
            final int size = n + 1;
            adj = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                adj.add(new ArrayList<>());
            }
            isVisited = new boolean[size];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final List<Queue<Integer>> dfsStart(final Stack<Integer> stack){
            int groupSeq = 0;

            while(!stack.isEmpty()){
                final int start = stack.pop();

                if(!isVisited[start]){
                    resultList.add(new PriorityQueue<>());
                    dfs(start, groupSeq);
                    groupSeq++;
                }
            }

            return resultList;
        }

        private final void dfs(final int current, final int groupSeq){
            isVisited[current] = true;
            resultList.get(groupSeq).add(current);

            for(final int next : adj.get(current)){
                if(!isVisited[next]){
                    dfs(next, groupSeq);
                }
            }
        }
    }
}