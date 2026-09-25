// ArtPiece.java
public abstract class ArtPiece {
    public final String pieceId;
    private static int counter = 0;

    public ArtPiece() {
        this.pieceId = "ART-" + (++counter);
    }

    public abstract String describe();
}
