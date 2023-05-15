import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputKN = br.readLine().split(" ");
        final int K = Integer.parseInt(inputKN[0]);
        final int N = Integer.parseInt(inputKN[1]);
        final long len[] = new long[K];
        long min = 1;
        long max = 0;
        for(int i = 0; i < K; i++){
            len[i] = Long.parseLong(br.readLine());
            max = Math.max(max, len[i]);
        }
        max += 1;

        while(min + 1 < max){
            final long mid = (min + max) / 2;

            int cnt = 0;
            for(int i = 0; i < K; i++){
                cnt += (len[i] / mid);
            }

            if(cnt < N){
                max = mid;
            }else{
                min = mid;
            }
        }

        bw.write(String.valueOf(min));
        
        bw.flush();
        bw.close();
        br.close();
    }
}