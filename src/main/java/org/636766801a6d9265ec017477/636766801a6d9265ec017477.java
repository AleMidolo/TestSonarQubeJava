import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
 */
private void addReverse(final InputStream[] files) {
    try {
        // Create a ByteArrayOutputStream to hold the concatenated data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Iterate over the files in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            InputStream inputStream = files[i];
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from the current file and write to the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the current input stream
            inputStream.close();
        }

        // Convert the output stream to a byte array (if needed)
        byte[] result = outputStream.toByteArray();

        // Close the output stream
        outputStream.close();

        // Use the result as needed (e.g., write to another stream or process further)
    } catch (IOException e) {
        e.printStackTrace();
    }
}