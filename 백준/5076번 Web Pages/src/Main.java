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
            for(int i = 0; i < inputChars.length - 1; i++){
                char c1 = inputChars[i];
                char c2 = inputChars[i + 1];
                if(c1 == '<' && c2 != '/'){
                    StringBuffer sb = new StringBuffer();
                    boolean isKeyword = true;
                    for(int j = i + 1; j < inputChars.length; j++){
                        if(inputChars[j] == '/' && j < inputChars.length - 1){
                            if(inputChars[j + 1] == '>'){
                                i = j + 1;
                                break;
                            }
                        }
                        if(inputChars[j] == '>'){
                            stack.push(sb.toString());
                            i = j;
                            break;
                        }
                        if(isKeyword && inputChars[j] == ' '){
                            isKeyword = false;
                        }
                        if(isKeyword){
                            sb.append(inputChars[j]);
                        }
                    }
                }else if(c1 == '<' && c2 == '/'){
                    StringBuffer sb = new StringBuffer();
                    for(int j = i + 2; j < inputChars.length; j++){
                        if(inputChars[j] == '>'){
                            final String keyword = sb.toString();
                            if(!stack.isEmpty() && stack.peek().equals(keyword)){
                                stack.pop();
                                i = j;
                            }else{
                                isAnswer = false;
                            }
                            break;
                        }
                        sb.append(inputChars[j]);
                    }
                }
            }

            if(isAnswer && !stack.isEmpty()){
                isAnswer = false;
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