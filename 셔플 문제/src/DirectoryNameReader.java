import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryNameReader implements ProblemNameReader{
    @Override
    public List<String> read(String[] contents) throws IllegalAccessException{
        List<String> problemNameList = new ArrayList<>();
        for(String directoryPath : contents){
            File directory = new File(directoryPath);
            List<String> a = Arrays.stream(directory.listFiles((file)->file.isDirectory())).map(f->f.getName()).collect(Collectors.toList());

        }

        return problemNameList;
    }
}
