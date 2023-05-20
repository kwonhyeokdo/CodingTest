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

        final long N = Long.parseLong(br.readLine());
        final long k = Long.parseLong(br.readLine());
        long min = 1;
        long max = k;

        while(min < max){
            final long mid = (min + max) / 2;

            long cnt = 0;
            for(long i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N);
            }

            if(cnt < k){
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }

        bw.write(String.valueOf(min));
        
        bw.flush();
        bw.close();
        br.close();
    }
}