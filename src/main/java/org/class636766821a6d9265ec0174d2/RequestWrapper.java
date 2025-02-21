package org.class636766821a6d9265ec0174d2;

import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereRequest;

public class RequestWrapper {

    /** 
     * Fornisce un {@link HttpServletRequest}.
     * @param request {@link HttpServletRequest}
     * @return un {@link AtmosphereRequest}
     */
    public static AtmosphereRequest wrap(HttpServletRequest request) {
        // Create a new AtmosphereRequest using the provided HttpServletRequest
        AtmosphereRequest atmosphereRequest = new AtmosphereRequest.Builder()
                .request(request)
                .build();
        return atmosphereRequest;
    }
}