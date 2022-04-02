package south.islands.nc.sealife.Controller;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException(String animalName) {
        super("Animal non trouvé " + animalName);
    }
}
