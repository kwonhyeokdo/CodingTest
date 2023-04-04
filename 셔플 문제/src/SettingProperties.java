

public class SettingProperties {
    private ImportBaseEnum importBase = null;
    private String[] importContents = null;
    private String outputDirectory = null;
    private String[] outputFileNames = null;

    public SettingProperties(ImportBaseEnum importBase, String[] importContents, String outputDirectory, String[] outputFileNames){
        this.importBase = importBase;
        this.importContents = importContents;
        this.outputDirectory = outputDirectory;
        this.outputFileNames = outputFileNames;
    }
}
