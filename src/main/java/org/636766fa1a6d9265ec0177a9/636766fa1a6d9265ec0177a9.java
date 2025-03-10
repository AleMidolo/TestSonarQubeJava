import java.util.ArrayList;
import java.util.List;

public class BasicBlock {
    private List<Integer> initializedTypes;

    public BasicBlock() {
        this.initializedTypes = new ArrayList<>();
    }

    /**
     * Agrega un tipo abstracto a la lista de tipos sobre los cuales se invoca un constructor en el bloque básico.
     * @param abstractType un tipo abstracto sobre el cual se invoca un constructor.
     */
    private void addInitializedType(final int abstractType) {
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }

    // Other methods and fields can be added here
}