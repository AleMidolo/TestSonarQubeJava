package org;

import java.util.Optional;

public class HttpHeaderBuilder {

    private long start;
    private long end;
    private long total;

    public HttpHeaderBuilder(long start, long end, long total) {
        this.start = start;
        this.end = end;
        this.total = total;
    }

    /** 
     * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
     * @return valore 'Content-Range'
     */
    private String buildContentRange() {
        return String.format("bytes %d-%d/%d", start, end, total);
    }

    public static void main(String[] args) {
        HttpHeaderBuilder builder = new HttpHeaderBuilder(0, 499, 1234);
        System.out.println(builder.buildContentRange()); // Output: bytes 0-499/1234
    }
}