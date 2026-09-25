// CuttingTool.java
public class CuttingTool extends GardenTool {
    @Override
    public String specificUse() { return "blade sharpened first"; }
    @Override
    public String use() { return super.use() + ", " + specificUse(); }
}
