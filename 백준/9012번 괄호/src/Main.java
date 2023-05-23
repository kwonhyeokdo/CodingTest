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
        for(int i = 0; i < N; i++){
            final char[] parentheses = br.readLine().toCharArray();
            final Stack<Character> stack = new Stack<>();
            boolean isAnswer = true;
            for(char parenthesis : parentheses){
                if(parenthesis == '('){
                    stack.push(parenthesis);
                }else{
                    if(stack.isEmpty()){
                        isAnswer = false;
                        break;
                    }else{
                        if(stack.pop() != '('){
                            isAnswer = false;
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()){
                isAnswer = false;
            }

            if(isAnswer){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}