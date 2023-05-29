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
        for(int i = 0; i < E; i++){
            final String[] inputUV = br.readLine().split(" ");
            final int u = Integer.parseInt(inputUV[0]);
            final int v = Integer.parseInt(inputUV[1]);
            graph.add(u, v);
        }

        final List<Queue<Integer>> resultList =  graph.dfsStart();
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
        private List<Queue<Integer>> scc = null;
        private boolean[] finished = null;
        private int[] sccGroup = null;
        private int sccSeq = 0;
        private Stack<Integer> stack = null;
        private int groupSeq = 0;

        protected Graph(final int n){
            final int size = n + 1;
            adj = new ArrayList<>();
            for(int i = 0; i < size; i++){
                adj.add(new ArrayList<>());
            }
            sccGroup = new int[size];
            finished = new boolean[size];
            stack = new Stack<>();
            scc = new ArrayList<>();
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final List<Queue<Integer>> dfsStart(){
            for(int i = 1; i < adj.size(); i++){
                if(sccGroup[i] == 0){
                    dfs(i);
                }
            }
            return scc;
        }

        private final int dfs(final int current){
            sccSeq++;
            sccGroup[current] = sccSeq;
            stack.push(current);

            int parent = sccSeq;
            for(final int next : adj.get(current)){
                if(sccGroup[next] == 0){
                    parent = Math.min(parent, dfs(next));
                }else if(!finished[next]){
                    parent = Math.min(parent, sccGroup[next]);
                }
            }

            if(parent == sccGroup[current]){
                int pop = 0;
                do{
                    pop = stack.pop();
                    finished[pop] = true;
                    if(scc.isEmpty() || scc.size() <= groupSeq){
                        scc.add(new PriorityQueue<>());
                    }
                    scc.get(groupSeq).add(pop);
                }while(pop != current);

                groupSeq++;
            }

            return parent;
        }
    }
}