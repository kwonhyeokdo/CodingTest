import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public final class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String S = br.readLine();
        final int N = Integer.parseInt(br.readLine());
        final boolean memo[] = new boolean[S.length()];
        boolean isAnswer = false;
        Set<String> wordSet = new HashSet<>();
        for(int i = 0 ; i < N; i++){
            wordSet.add(br.readLine());
        }

        for(int i = 0; i < S.length() && !isAnswer; i++){
            if(memo[i] || i == 0){
                StringBuffer sb = new StringBuffer();
                for(int j = i; j < S.length() ; j++){
                    sb.append(S.charAt(j));
                    if(wordSet.contains(sb.toString())){
                        if(j + 1 == S.length()){
                            isAnswer = true;
                            break;
                        }
                        memo[j + 1] = true;
                    }
                }
            }
        }

        if(isAnswer){
            bw.write("1");
        }else{
            bw.write("0");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}