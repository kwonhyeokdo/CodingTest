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

        final int N = Integer.parseInt(br.readLine());
        final Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            final String[] commands = br.readLine().split(" ");

            switch(commands[0]){
                case "push_front":
                    dq.addFirst(Integer.parseInt(commands[1]));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(commands[1]));
                    break;
                case "pop_front":
                    if(dq.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(dq.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if(dq.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(dq.pollLast() + "\n");
                    }
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(dq.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(dq.peekFirst() + "\n");
                    }
                    break;
                default:
                    if(dq.isEmpty()){
                        bw.write("-1\n");
                    }else{
                        bw.write(dq.peekLast() + "\n");
                    }
                    break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}