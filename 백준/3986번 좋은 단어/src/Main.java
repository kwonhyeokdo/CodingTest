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
        for(int i = 0; i < N; i++){
            final char[] inputChars = br.readLine().toCharArray();
            final Stack<Character> stack = new Stack<>();
            for(final char c : inputChars){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

            if(stack.size() % 2 == 0){
                while(!stack.isEmpty()){
                    final char c1 = stack.pop();
                    final char c2 = stack.pop();
                    if(c1 != c2){
                        stack.push(c1);
                        break;
                    }
                }
                if(stack.isEmpty()){
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}