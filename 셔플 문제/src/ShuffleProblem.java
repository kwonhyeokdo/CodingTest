import java.util.Properties;

public final class ShuffleProblem {
    public static void main(String[] args) throws Exception {
        String settingPropertiesPath = "";
        if(args == null || args.length == 0){
            settingPropertiesPath = "./Setting.properties";
        }else{
            settingPropertiesPath = args[0];
        }
        
        SettingProperties settingProperties = SettingPropertiesImporter.of(settingPropertiesPath);
        System.out.println(settingProperties.toString());
        //ProblemProcessor problemProcessor = new ProblemProcessor(settingProperties);
        ProblemNameList problemNameList = new ProblemNameList(settingProperties);
    }
}