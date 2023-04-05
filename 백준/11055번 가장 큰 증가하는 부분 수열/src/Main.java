import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        final int[] inputArray = new int[N];
        final int[] memo = new int[N];
        final String[] inputLine = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            memo[i] = inputArray[i] = Integer.parseInt(inputLine[i]);
        }
        int answer = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(inputArray[i] > inputArray[j]){
                    memo[i] = Math.max(memo[j] + inputArray[i], memo[i]);
                }
            }
            answer = Math.max(answer, memo[i]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}