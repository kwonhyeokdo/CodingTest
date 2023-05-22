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
        final Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            final String[] inputCommand = br.readLine().split(" ");
            switch(inputCommand[0]){
                case "push":
                    stack.push(Integer.parseInt(inputCommand[1]));
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                default:
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}