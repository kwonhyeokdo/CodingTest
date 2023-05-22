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
        
        final String prefix = br.readLine();
        final Stack<Character> stack = new Stack<>();
        final StringBuffer sb = new StringBuffer();
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if('A' <= c && c <= 'Z'){
                sb.append(c);
            }else if('*' == c || '/' == c){
                if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }else if('+' == c || '-' == c){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }else if(c == '('){
                stack.push(c);
            }else{
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}