import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final String[] inputNM = br.readLine().split(" ");
        final String[] inputLecture = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNM[0]);
        final int M = Integer.parseInt(inputNM[1]);
        final int[] lectureArray = new int[N];
        long min = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            lectureArray[i] = Integer.parseInt(inputLecture[i]);
            max += lectureArray[i];
        }

        while(min + 1 < max){
            final long mid = (min + max) / 2;
            int m = 1;
            long sum = 0;
            for(int i = 0; i < N; i++){
                if(sum + lectureArray[i] <= mid){
                    sum += lectureArray[i];
                }else{
                    if(lectureArray[i] > mid){
                        m = Integer.MAX_VALUE;
                        break;
                    }else{
                        sum = lectureArray[i];
                        m++;
                    }
                }
                if(m > M){
                    break;
                }
            }

            if(m < M){
                max = mid;
            }else if(m == M){
                max = mid;
            }else{
                min = mid;
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
}