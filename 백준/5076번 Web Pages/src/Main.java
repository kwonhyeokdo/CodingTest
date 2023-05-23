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
            final char[] inputChars = br.readLine().toCharArray();
            if(inputChars.length == 1 && inputChars[0] == '#'){
                break;
            }

            boolean isAnswer = true;

            final Stack<String> stack = new Stack<>();
            boolean isOpen = false;
            for(int i = 0; i < inputChars.length; i++){
                if(i < inputChars.length - 2){
                    
                } 
            }
            

            if(isAnswer){
                bw.write("legal\n");
            }else{
                bw.write("illegal\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}