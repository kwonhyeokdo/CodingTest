import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ProblemNameList {
    private SettingProperties settingProperties = null;
    private List<String> problemNameList = new ArrayList<>();

    public ProblemNameList(SettingProperties settingProperties) throws IllegalAccessException{
        if(settingProperties == null){
            throw new IllegalAccessException("SettingProperties param is null");
        }

        loadProblemNameList();
    }

    private final void loadProblemNameList() throws IllegalAccessException{
        ImportBaseEnum importBase = settingProperties.getImportBase();
        if(importBase == null){
            throw new IllegalAccessException("IMPORT_BASE is invaild");
        }

        
        switch(importBase){
            case DIRECTORY:
                //readDirectoryName(settingProperties.getImportContents());
                break;
            case FILE:
                break;
        }
    }

    public List<String> getShuffleList(){
        List<String> shuffleList = new ArrayList<>(problemNameList);
        Collections.shuffle(shuffleList);
        return shuffleList;
    }
}