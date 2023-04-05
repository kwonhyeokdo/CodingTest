public class ProblemProcessor {
    private SettingProperties settingProperties = null;

    public ProblemProcessor(final SettingProperties settingProperties){
        this.settingProperties = settingProperties;
    }

    public final void importProblem() throws IllegalAccessException{
        final ImportBaseEnum importBase = settingProperties.getImportBase();
        if(settingProperties == null){
            throw new IllegalAccessException("settingProperties(field) is null");
        }else if(settingProperties.getImportBase() == null){
            throw new IllegalAccessException("importBase(field) of settingProperties is null");
        }

        if(importBase == ImportBaseEnum.DIRECTORY){
            final String[] importDirectory = settingProperties.getImportContents();
            for(String rootDirectory : importDirectory){
                
            }
        }else{

        }
    }
}
