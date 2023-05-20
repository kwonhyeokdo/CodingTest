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

        final String[] input_N_K_D = br.readLine().split(" ");
        final long N = Long.parseLong(input_N_K_D[0]);
        final int K = Integer.parseInt(input_N_K_D[1]);
        final long D = Long.parseLong(input_N_K_D[2]);
        final long[][] rule = new long[K][3];
        long min = Long.MAX_VALUE;
        long max = 0;
        for(int i = 0; i < K; i++){
            final String[] input_A_B_C = br.readLine().split(" ");
            rule[i][0] = Long.parseLong(input_A_B_C[0]);
            rule[i][1] = Long.parseLong(input_A_B_C[1]);
            rule[i][2] = Long.parseLong(input_A_B_C[2]);
            min = Math.min(min, rule[i][0]);
            max = Math.max(max, rule[i][1]);
        }
        if(max > N){
            max = N;
        }

        while(min + 1 < max){
            final long mid = (min + max) / 2;

            int cnt = 0;
            for(int i = 0; i < K; i++){
                if(rule[i][0] <= mid){
                    final long[] range = {rule[i][0], Math.min(rule[i][1], mid)};
                    cnt += (range[1] - range[0]) / rule[i][2] + 1;
                }
                if(cnt > D){
                    break;
                }
            }

            if(cnt >= D){
                max = mid;
            }else{
                min = mid;
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
}