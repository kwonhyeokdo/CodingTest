import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final String postfix = br.readLine();
        final Map<Character, Double> map = new HashMap<>();
        char key = 'A';
        for(int i = 1; i <= N; i++){
            final double num = Double.parseDouble(br.readLine());
            map.put(key, num);
            key++;
        }
        final Stack<Double> stack = new Stack<>();
        for(int i = 0 ; i < postfix.length(); i++){
            final char c = postfix.charAt(i);
            if('A' <= c && c <= 'Z'){
                stack.push(map.get(c));
            }else{
                final double num2 = stack.pop();
                final double num1 = stack.pop();
                switch(c){
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    default:
                        stack.push(num1 / num2);
                        break;
                }
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        
        bw.flush();
        bw.close();
        br.close();
    }
}