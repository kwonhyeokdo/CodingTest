import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main{
    public static void main(String[] args) throws Exception{
        
        int[] a = new int[]{1,2,3,4,5,2,4,6,8,10,3,6,9,12,15,4,8,12,16,20,5,10,15,20,25};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long N = Long.parseLong(br.readLine());
        final long k = Long.parseLong(br.readLine());
        long min = 1;
        long max = N * N + 1;

        while(min + 1 < max){
            final long mid = (min * max) / 2;

            long cnt = 0;
            for(long i = 1; i < mid; i++){
                cnt += mid / i;
            }

            System.out.println("min: " + min + ", max: " + max + ", mid: " + mid + ", cnt: " + cnt);

            if(cnt > k){
                min = mid;
            }else{
                max = mid;
            }
        }

        bw.write(String.valueOf(min));
        
        bw.flush();
        bw.close();
        br.close();
    }
}