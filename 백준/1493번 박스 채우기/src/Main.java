import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class Main {
    private long answer = 0;
    private long volume = 0;
    private final Map<Integer, Long> powMap = new HashMap<>();
    private final TreeMap<Integer, Integer> cubeMap = new TreeMap<>(Comparator.reverseOrder());
    {
        powMap.put(0, 1L);
        long powNumber = 1L;
        for(int i = 1; i < 20; i++){
            powNumber *= 2L;
            powMap.put(i, powNumber);
        }
    }

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] input = br.readLine().split(" ");
        final long length = Long.parseLong(input[0]);
        final long weight = Long.parseLong(input[1]);
        final long height = Long.parseLong(input[2]);
        volume = length * weight * height;

        final int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            final String[] inputLine = br.readLine().split(" ");
            final int A = Integer.parseInt(inputLine[0]);
            final int B = cubeMap.getOrDefault(A, 0) + Integer.parseInt(inputLine[1]);
            if(B != 0){
                cubeMap.put(A, B);   
            }
        }

        fillBox(length, weight, height);

        if(volume != 0L){
            answer = -1L;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private final void fillBox(final long length, final long weight, final long height) {
        if(length <= 0L || weight <= 0L || height <= 0L || volume <= 0L || cubeMap.isEmpty()){
            return;
        }

        int pow = -1;
        for(Integer powKey : cubeMap.keySet()){
            final long powNumber = powMap.get(powKey);
            if(powNumber <= length && powNumber <= weight && powNumber <= height){
                pow = powKey;
                break;
            }
        }

        if(pow != -1){
            final long powNumber = powMap.get(pow);
            int cnt = cubeMap.get(pow) - 1;
            if(cnt == 0){
                cubeMap.remove(pow);
            }else{
                cubeMap.put(pow, cnt);
            }

            answer++;
            
            volume -= (powNumber * powNumber * powNumber);

            if(cubeMap.size() == 1 && cubeMap.containsKey(0)){
                final int v = cubeMap.get(0);
                if(volume - v <= 0L){
                    answer += volume;
                    volume = 0L;
                    return;
                }
            }

            fillBox(length - powNumber, powNumber, powNumber);
            fillBox(length, weight - powNumber, powNumber);
            fillBox(length, weight, height - powNumber);
        }
    }
}