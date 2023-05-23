import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int answer = 0;
        final int[] heightArray = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            final int inputHeight = Integer.parseInt(br.readLine());
            heightArray[i] = inputHeight;
            while(!stack.isEmpty() && heightArray[stack.peek()] >= inputHeight){
                final int pop = stack.pop();
                final int peek = stack.isEmpty() ? -1 : stack.peek();
                answer = Math.max(answer, heightArray[pop] * (i - peek - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            final int pop = stack.pop();
            final int peek = stack.isEmpty() ? -1 : stack.peek();
            answer = Math.max(answer, heightArray[pop] * (N - peek - 1));
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}