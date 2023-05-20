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

        final String[] input_N_K = br.readLine().split(" ");
        final Integer N = Integer.parseInt(input_N_K[0]);
        final Integer K = Integer.parseInt(input_N_K[1]);

        final Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            que.add(i);
        }

        bw.write('<');
        int cnt = 1;
        while(!que.isEmpty()){
            if(cnt < K){
                cnt++;
                que.add(que.poll());
            }else{
                cnt = 1;
                final int num = que.poll();
                if(!que.isEmpty()){
                    bw.write(num + ", ");
                }else{
                    bw.write(String.valueOf(num));
                }
            }
        }
        bw.write('>');
        
        bw.flush();
        bw.close();
        br.close();
    }
}