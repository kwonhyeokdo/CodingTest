import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final List<List<Integer>> lhLists = new ArrayList<>();
        int answer = 0;
        int maxH = -1;
        for(int i = 0; i < N; i++){
            final String[] inputLH = br.readLine().split(" ");
            final List<Integer> lhList = new ArrayList<>();
            final int L = Integer.parseInt(inputLH[0]);
            final int H = Integer.parseInt(inputLH[1]);
            lhList.add(L);
            lhList.add(H);
            lhLists.add(lhList);
            if(maxH < H){
                maxH = H;
            }
        }
        lhLists.sort((o1, o2)->{
            return o1.get(0) - o2.get(0);
        });

        int left = 0;
        int leftBeforeL = lhLists.get(left).get(0);
        int leftMaxH = lhLists.get(left).get(1);
        for(left = 1; left < lhLists.size(); left++){
            final int L = lhLists.get(left).get(0);
            final int H = lhLists.get(left).get(1);
            if(leftMaxH < H){
                answer += (L - leftBeforeL) * leftMaxH;
                leftMaxH = H;
                leftBeforeL = L;
                if(leftMaxH == maxH){
                    break;
                }
            }
        }
        
        int right = lhLists.size() - 1;
        int rightBeforeL = lhLists.get(right).get(0);
        int rightMaxH = lhLists.get(right).get(1);
        for(right = lhLists.size() - 2; right >= 0; right--){
            final int L = lhLists.get(right).get(0);
            final int H = lhLists.get(right).get(1);
            if(rightMaxH < H){
                answer += (rightBeforeL - L) * rightMaxH;
                rightMaxH = H;
                rightBeforeL = L;
                if(rightMaxH == maxH){
                    break;
                }
            }
        }

        answer += (rightBeforeL - leftBeforeL + 1) * maxH;

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}