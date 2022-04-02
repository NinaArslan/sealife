package south.islands.nc.sealife.Controller;

public class IlotNotFoundException extends RuntimeException{
    public IlotNotFoundException(String islandId) {
        super("Ilot non trouvé " + islandId);
    }
}
