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

        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final int[] cost = new int[N];
        int min = 0;
        int max = 1;
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, cost[i]);
            max += cost[i];
        }

        while(min + 1 < max){
            final int mid = (min + max) / 2;

            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(mid < cost[i]){
                    cnt = 0;
                    break;
                }else if(sum > cost[i]){
                    sum -= cost[i];
                }else{
                    cnt++;
                    sum = mid - cost[i];
                }
            }

            if(cnt > M){
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