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

        final String[] inputNK = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNK[0]);
        final int K = Integer.parseInt(inputNK[1]);
        long answer = 0;
        final List<Queue<Integer>> queList = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            queList.add(new LinkedList<>());
        }
        for(int i = 0; i < N; i++){
            final int len = br.readLine().length();
            final Queue<Integer> que = queList.get(len);
            while(!que.isEmpty() && que.peek() + K < i){
                que.poll();
            }
            answer += que.size();
            que.add(i);
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}