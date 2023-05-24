import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            final String[] inputNM = br.readLine().split(" ");
            final int N = Integer.parseInt(inputNM[0]);
            final int M = Integer.parseInt(inputNM[1]);
            final String[] inputJobs = br.readLine().split(" ");
            final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            final Queue<Job> que = new LinkedList<>();
            for(int j = 0; j < N; j++){
                final int num = Integer.parseInt(inputJobs[j]);
                pq.add(num);
                que.add(new Job(j, num));
            }

            for(int j = 1; j <= N; j++){
                final int num = pq.poll();
                while(que.peek().value != num){
                    que.add(que.poll());
                }
                if(que.poll().seq == M){
                    bw.write(j + "\n");
                    break;
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private final class Job{
        private int seq;
        private int value;

        protected Job(final int seq, final int value){
            this.seq = seq;
            this.value = value;
        }
    }
}