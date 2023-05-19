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
        
        final String[] input_N_K = br.readLine().split(" ");
        final int N = Integer.parseInt(input_N_K[0]);
        final int K = Integer.parseInt(input_N_K[1]);
        final String[][] paper = new String[K][2];
        int[] duplicate = new int[26];
        boolean isAnswer = true;
        for(int i = 0; i < K; i++){
            String[] input_Num_S = br.readLine().split(" ");
            paper[i][0] = input_Num_S[0];
            paper[i][1] = input_Num_S[1];
        }
        final Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            deque.add('?');
        }

        for(final String[] context : paper){
            final int move = Integer.parseInt(context[0]);
            final char c = context[1].charAt(0);

            for(int i = 0; i < move; i++){
                deque.add(deque.poll());
            }
            
            /*
            final char poll = deque.poll();
            if(poll == '?'){
                if(duplicate[c - 'A'] == 1){
                    isAnswer = false;
                    break;
                }
                deque.addFirst(c);;
                duplicate[c - 'A'] = 1;
            }else if(poll != c){
                isAnswer = false;
                break;
            }
            */
            
            final char peek = deque.peek();
            if(peek == '?'){
                if(duplicate[c - 'A'] == 1){
                    isAnswer = false;
                    break;
                }
                deque.poll();
                deque.addFirst(c);
                duplicate[c - 'A'] = 1;
            }else if(peek != c){
                isAnswer = false;
                break;
            }
        }

        if(!isAnswer){
            bw.write('!');
        }else{
            final StringBuffer sb = new StringBuffer();
            sb.append(deque.poll());
            while(!deque.isEmpty()){
                sb.append(deque.pollLast());
            }
    
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}