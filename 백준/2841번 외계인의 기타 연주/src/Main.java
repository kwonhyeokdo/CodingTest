import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Main{
    private static final int LINES_CNT = 6;

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        final String[] inputNP = br.readLine().split(" ");
        final int N = Integer.parseInt(inputNP[0]);

        final List<Stack<Integer>> lines = new ArrayList<>();
        for(int i = 0; i < LINES_CNT + 1; i++){
            lines.add(new Stack<>());
        }

        for(int i = 0; i < N; i++){
            final String[] inputLineFret = br.readLine().split(" ");
            final int lineNumber = Integer.parseInt(inputLineFret[0]);
            final int fret = Integer.parseInt(inputLineFret[1]);
            final Stack<Integer> line = lines.get(lineNumber);
            if(line.isEmpty() || line.peek() < fret){
                answer++;
                line.push(fret);
            }else if(line.peek() > fret){
                while(!line.isEmpty() && line.peek() > fret){
                    answer++;
                    line.pop();
                }
                if(line.isEmpty() || line.peek() != fret){
                    answer++;
                    line.push(fret);
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}