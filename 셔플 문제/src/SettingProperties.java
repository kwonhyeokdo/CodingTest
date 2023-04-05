

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

    public ImportBaseEnum getImportBase() {
        return importBase;
    }

    public void setImportBase(ImportBaseEnum importBase) {
        this.importBase = importBase;
    }

    public String[] getImportContents() {
        return importContents;
    }

    public void setImportContents(String[] importContents) {
        this.importContents = importContents;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String[] getOutputFileNames() {
        return outputFileNames;
    }

    public void setOutputFileNames(String[] outputFileNames) {
        this.outputFileNames = outputFileNames;
    }
}
