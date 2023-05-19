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
        final Deque<Balloon> deque = new ArrayDeque<>();
        final String[] inputNumbers = br.readLine().split(" ");
        for(int i = 1; i <= N; i++){
            final int num = Integer.parseInt(inputNumbers[i - 1]);
            deque.add(new Balloon(i, num));
        }

        while(!deque.isEmpty()){
            Balloon ballon = deque.poll();
            if(deque.isEmpty()){
                bw.write(String.valueOf(ballon.getSeq()));
                break;
            }else{
                bw.write(ballon.getSeq() + " ");
            }

            if(ballon.getNum() > 0){
                for(int i = 0; i < ballon.getNum() - 1; i++){
                    deque.add(deque.poll());
                }
            }else{
                for(int i = 0; i < Math.abs(ballon.getNum()); i++){
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Balloon{
        private int seq;
        private int num;

        protected Balloon(final int seq, final int num){
            this.seq = seq;
            this.num = num;
        }

        private final int getSeq(){
            return seq;
        }

        private final int getNum(){
            return num;
        }
    }
}