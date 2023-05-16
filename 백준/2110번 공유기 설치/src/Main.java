import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNC = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNC[0]);
        final int C = Integer.parseInt(inputNC[1]);
        final long[] x = new long[N];
        for(int i = 0; i < N; i++){
            x[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(x);

        long min = 0;
        long max = x[N - 1] + 1;

        while(min + 1 < max){
            final long mid = (min + max) / 2;

            int cnt = 0;
            long range = 0;
            for(int i = 0; i < N; i++){
                if(x[i] > range){
                    range = x[i] + mid;
                    cnt++;
                }else if(x[i] == range){
                    range = x[i] + mid;
                    cnt++;
                }
                if(cnt > C){
                    break;
                }
            }

            if(cnt >= C){
                min = mid;
            }else{
                max = mid;
            }
        }

        bw.write(String.valueOf(min));
        
        bw.flush();
        bw.close();
        br.close();
    }
}