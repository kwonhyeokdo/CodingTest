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

        final Deque<Integer> deque = new ArrayDeque<>();
        final int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            final String[] commands = br.readLine().split(" ");
            switch(commands[0]){
                case "push":
                    deque.add(Integer.parseInt(commands[1]));
                    break;
                case "front":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(deque.peek() + "\n");
                    }
                    break;
                case "pop":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(deque.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                default:
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}