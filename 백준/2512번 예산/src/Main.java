import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    private int[] budget = null;
    private int answer = 0;
    private int M = 0;

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final String[] inputSplit = br.readLine().split(" ");
        M = Integer.parseInt(br.readLine());
        budget = new int[N];
        int maxBudget = 0;
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(inputSplit[i]);
            maxBudget = Math.max(maxBudget, budget[i]);
        }
        
        int max = M;
        int min = 0;

        while(min + 1 < max){
            final int mid = (min + max) / 2;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(mid > budget[i]){
                    sum += budget[i];
                }else{
                    sum += mid;
                }
            }
            
            if(sum > M){
                max = mid;
            }else{
                min = mid;
            }
        }

        answer = (min > maxBudget) ? maxBudget : min;

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}