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
            final int n = Integer.parseInt(br.readLine());
            final String[] inputSplit = br.readLine().split(" ");
            final List<Integer> adj = new ArrayList<>();
            for(final String numStr : inputSplit){
                adj.add(Integer.parseInt(numStr) - 1);
            }

            int cycleCnt = n;
            final boolean[] isVisited = new boolean[n];
            final boolean[] isFinished = new boolean[n];
            for(int j = 0; j < n; j++){
                if(!isVisited[j]){
                    cycleCnt -= dfs(j, adj, isVisited, isFinished);
                }
            }

            bw.write(cycleCnt + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final int dfs(final int current, final List<Integer> adj, final boolean[] isVisited, final boolean[] isFinished){
        int cycleNodeCnt = 0;

        isVisited[current] = true;
        final int next = adj.get(current);
        if(!isVisited[next]){
            cycleNodeCnt += dfs(next, adj, isVisited, isFinished);
        }else{
            if(!isFinished[next]){
                for(int temp = next; temp != current; temp = adj.get(temp)){
                    cycleNodeCnt++;
                }
                cycleNodeCnt++;
            }
        }
        isFinished[current] = true;
        return cycleNodeCnt;
    }
}