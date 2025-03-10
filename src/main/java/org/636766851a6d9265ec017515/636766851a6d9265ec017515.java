import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;
import org.atmosphere.cpr.Action;

public class AtmosphereResourceInspector {

    /**
     * Sospende automaticamente il {@link AtmosphereResource} in base al valore di {@link AtmosphereResource.TRANSPORT}.
     * @param r un {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        if (r.transport() == TRANSPORT.WEBSOCKET) {
            r.suspend();
        } else if (r.transport() == TRANSPORT.LONG_POLLING) {
            r.suspend(-1); // Sospende indefinitamente per LONG_POLLING
        } else {
            // Altri trasporti non gestiti
            r.resume();
        }
        return Action.CONTINUE;
    }
}