import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    private static final int MAX_COST = 100000 * 10000;

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final int[] cost = new int[N];
        int min = MAX_COST + 1;
        int max = MAX_COST;
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, cost[i]);
        }

        while(min + 1 < max){
            final int mid = (min + max) / 2;

            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(sum < cost[i]){
                    cnt++;
                    sum = mid;
                }else{
                    sum -= cost[i];
                }
            }

            System.out.println("min: " + min + ", max: " + max + ", mid: " + mid + ", cnt: " + cnt);

            if(cnt > M){
                min = min + 1;
            }else{
                max = mid;
            }
        }

        bw.write(String.valueOf(max));
        
        bw.flush();
        bw.close();
        br.close();
    }
}