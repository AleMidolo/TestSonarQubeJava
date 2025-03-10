import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class URIDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> pathSegments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return pathSegments;
        }

        // Remove leading '/' if the path is absolute
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] segments = path.split("/");
        for (String segment : segments) {
            if (segment.isEmpty()) {
                continue;
            }
            String decodedSegment = decode ? decodeSegment(segment) : segment;
            pathSegments.add(new PathSegmentImpl(decodedSegment));
        }

        return pathSegments;
    }

    private static String decodeSegment(String segment) {
        // Implement URI decoding logic here
        // For simplicity, this example uses URLDecoder, but you may need to handle specific URI decoding rules
        try {
            return java.net.URLDecoder.decode(segment, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to decode segment", e);
        }
    }

    public static class PathSegmentImpl {
        private final String path;

        public PathSegmentImpl(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        @Override
        public String toString() {
            return "PathSegmentImpl{" +
                    "path='" + path + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}