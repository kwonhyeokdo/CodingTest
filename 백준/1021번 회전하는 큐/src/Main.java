import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        final String[] inputNM = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final List<Integer> pickList = new ArrayList<>();
        final LinkedList<Integer> linkedList = new LinkedList<>();
        final String[] inputPick = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            pickList.add(Integer.parseInt(inputPick[i]));
        }
        for(int i = 1; i <= N; i++){
            linkedList.add(i);
        }

        for(final int pick : pickList){
            int startLeft = 0;
            int startRight = 0;
            for(Integer i : linkedList){
                if(i == pick){
                    break;
                }
                startLeft++;
            }
            for(int i = linkedList.size() - 1; i >= 0; i--){
                startRight++;
                if(linkedList.get(i) == pick){
                    break;
                }
            }

            if(startLeft < startRight){
                for(int i = 0; i < startLeft; i++){
                    linkedList.addLast(linkedList.removeFirst());
                }
                answer += startLeft;
            }else{
                for(int i = 0; i < startRight; i++){
                    linkedList.addFirst(linkedList.removeLast());
                }
                answer += startRight;
            }
            linkedList.removeFirst();
        }
        
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}