import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public final class Main{
    private int answer = 0;
    private int[] numbers = null;
    private int S = 0;

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputSN = br.readLine().split(" ");
        final int N = Integer.parseInt(inputSN[0]);
        S = Integer.parseInt(inputSN[1]);
        final String[] inputNumbers = br.readLine().split(" ");
        numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        for(int r = 1; r <= N; r++){
            combination(0, new boolean[N], 0, r, 0);
        }
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final void combination(final int cnt, final boolean[] isVisited, final int start, final int r, final int sum){
        if(cnt == r){
            if(sum == S){
                System.out.println("cnt: " + cnt + ", r: " + r + ", sum: " + sum + ", S: " + S);
                answer++;
            }
            return;
        }

        for(int i = start; i < numbers.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                combination(cnt + 1, isVisited, start + 1, r, sum + numbers[i]);
                isVisited[i] = false;
            }
        }
    }
}