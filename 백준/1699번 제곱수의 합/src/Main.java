import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class Main {
    private int[][] memo;
    private final List<Integer> sqrtList = new ArrayList<>();

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i++){
            final int pow = i * i;
            if(pow > N){
                break;
            }
            sqrtList.add(pow);
        }

        memo = new int[sqrtList.size() + 1][N + 1];
        for(int i = 0; i < sqrtList.size() + 1; i++){
            for(int j = 0; j < N + 1; j++){
                memo[i][j] = -1;
            }
        }

        final int answer = dp(0, N);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int dp(final int index, final int number) {
        if(index == sqrtList.size()){
            if(number == 0){
                return 0;
            }else{
                return Integer.MAX_VALUE - 1;
            }
        }

        if(memo[index][number] != -1){
            return memo[index][number];
        }

        int result = dp(index + 1, number);
        if(number >= sqrtList.get(index)){
            result = Math.min(result, dp(index, number - sqrtList.get(index)) + 1);
        }

        memo[index][number] = result;
        return result;
    }
}