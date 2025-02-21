package org.class636767031a6d9265ec0178dd;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    private HttpServletRequest request;

    public RequestUtils(HttpServletRequest request) {
        this.request = request;
    }

    /** 
     * Recupera la lunghezza del contenuto della richiesta.
     * @return La lunghezza del contenuto della richiesta.
     * @since 1.3
     */
    public long contentLength() {
        return request.getContentLengthLong();
    }
}