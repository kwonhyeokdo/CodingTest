import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            que.add(i);
        }

        boolean isPoll = true;
        while(que.size() > 1){
            if(isPoll){
                que.poll();
            }else{
                que.add(que.poll());
            }
            isPoll = !isPoll;
        }

        bw.write(String.valueOf(que.poll()));
        
        bw.flush();
        bw.close();
        br.close();
    }
}