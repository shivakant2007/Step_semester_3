// Pruner.java
public class Pruner extends CuttingTool {
    @Override
    public String specificUse() { return "then trimming branches precisely"; }
    @Override
    public String use() { return super.use() + ", " + specificUse(); }
}
