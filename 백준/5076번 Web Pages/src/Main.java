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

        while(true){
            final String[] inputSplit = br.readLine().split(" ");
            if("#".equals(inputSplit[0])){
                break;
            }
            final Stack<String> stack = new Stack<>();
            for(String split : inputSplit){
                if(split.startsWith("<")){
                    // '<'와 '>'개수 검사
                    
                    if(split.endsWith("/>")){

                    }
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}