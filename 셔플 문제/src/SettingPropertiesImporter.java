import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


// IMPORT_BASE = directory
// # 문제 이름이 적힌 파일 OR 문제 이름이 있는 디렉토리 경로
// # - 여러개일 경우 쉼표(,)로 구분한다.
// IMPORT_CONTENTS = C:\Users\knge2\Desktop\개발\CodingTest\백준,C:\Users\knge2\Desktop\개발\CodingTest\프로그래머스
// # 출력 파일 경로
// OUPUT_DIRECTORY = C:\Users\knge2\Desktop\개발\CodingTest
// # 출력 파일 이름
// # - 출력 파일의 내용은 무작위 순서로 지정된 문제 이름이 한 줄씩 기입되어 있다.
// # - 출력 파일의 확장자는 .txt이다.
// # - 새로 만들어질 출력 파일의 이름이 이미 디렉토리에 존재할 경우 이름 뒤에 (1)과 같이 순번이 붙게된다.
// # - {Date}를 붙이면 생성된 날짜가 지정된다.
// # - {DateTime}를 붙이면 생성된 날짜 및 시간이 지정된다.
// # - 여래개일 경우 쉼표(,)로 구분한다.
// OUPUT_FILE_NAME = ShuffleProblem{Date}
public final class SettingPropertiesImporter {
    private static final String ENCODING = "UTF-8"; 
    static final SettingProperties of(final String filePath) throws IOException, IllegalAccessException{
        final FileReader fileReader = new FileReader(filePath, Charset.forName(ENCODING));

        final Properties properties = new Properties();
        properties.load(fileReader);

        final String paramImportBase = properties.getProperty("IMPORT_BASE");
        final String paramImportContents = properties.getProperty("IMPORT_CONTENTS");
        final String paramOutputDirectory = properties.getProperty("OUPUT_DIRECTORY");
        final String paramOutputFileName = properties.getProperty("OUPUT_FILE_NAME");

        final List<String> nullList = new ArrayList<>();
        if(paramImportBase == null){
            nullList.add("IMPORT_BASE");
        }
        if(paramImportContents == null){
            nullList.add("IMPORT_CONTENTS");
        }
        if(paramOutputDirectory == null){
            nullList.add("OUPUT_DIRECTORY");
        }
        if(paramOutputFileName == null){
            nullList.add("OUPUT_FILE_NAME");
        }
        if(!nullList.isEmpty()){
            throw new IllegalAccessException(nullList + "is null");
        }

        final ImportBaseEnum importBase = (paramImportBase.toLowerCase().equals(ImportBaseEnum.DIRECTORY.toString().toLowerCase())) ? ImportBaseEnum.DIRECTORY : ImportBaseEnum.FILE;
        final String[] importContents = Arrays.stream(paramImportContents.split(",")).map(String::trim).toArray(String[]::new);
        final String outputDirectory = paramOutputDirectory;
        final String[] outputFileName = Arrays.stream(paramOutputFileName.split(",")).map(String::trim).toArray(String[]::new);

        final SettingProperties settingProperties = new SettingProperties(importBase, importContents, outputDirectory, outputFileName);
        return settingProperties; 
    }
}
