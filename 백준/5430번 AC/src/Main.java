import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            final char[] p = br.readLine().toCharArray();
            final int n = Integer.parseInt(br.readLine());
            final String inputLine = br.readLine();
            final String[] inputStr = inputLine.substring(1, inputLine.length() - 1).split(",");
            final Deque<Integer> deque = new ArrayDeque<>();
            boolean goLeft = true;
            for(int j = 0; j < n; j++){
                deque.add(Integer.parseInt(inputStr[j].trim()));
            }
            StringBuffer sb = new StringBuffer();
            for(final char c : p){
                if(c == 'R'){
                    goLeft = !goLeft;
                }else{
                    if(deque.isEmpty()){
                        sb = new StringBuffer("error\n");
                        break;
                    }else if(goLeft){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }
            }

            if(!"error\n".equals(sb.toString())){
                    sb.append('[');
                    while(!deque.isEmpty()){
                        if(goLeft){
                            sb.append(deque.pollFirst());
                        }else{
                            sb.append(deque.pollLast());
                        }
                        if(deque.size() != 0){
                            sb.append(',');
                        }
                    }
                    sb.append("]\n");
            }
            bw.write(sb.toString());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}