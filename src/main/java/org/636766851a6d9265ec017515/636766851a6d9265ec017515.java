import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceImpl;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereInterceptor;

public class AutoSuspendInterceptor implements AtmosphereInterceptor {

  @Override 
  public Action inspect(AtmosphereResource r) {
  if (r != null && r.transport() != null) {
  switch (r.transport()) {
  case WEBSOCKET:
  case STREAMING:
  case SSE:
  case LONG_POLLING:
  r.suspend();
  break;
  default:
  break;
  }
  }
  return Action.CONTINUE;
  }

  @Override
  public void postInspect(AtmosphereResource r) {
  // No implementation needed
  }

  @Override
  public void destroy() {
  // No implementation needed
  }

  @Override
  public void configure(AtmosphereConfig config) {
  // No implementation needed
  }
}