import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemNameList {
    private List<String> problemNameList = new ArrayList<>();

    public ProblemNameList(){
        
    }

    public List<String> getShuffleList(){
        List<String> shuffleList = new ArrayList<>(problemNameList);
        Collections.shuffle(shuffleList);
        return shuffleList;
    }
}
