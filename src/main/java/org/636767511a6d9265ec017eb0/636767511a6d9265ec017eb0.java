public class NonZeroCounter {
    
    /**
     * एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या प्राप्त करें।
     * @param row पंक्ति
     * @return एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या
     */
    public int nonZeros(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonZeroCounter counter = new NonZeroCounter();
        int[] row = {1, 0, 2, 3, 0, 4};
        System.out.println("गैर-शून्य प्रविष्टियों की संख्या: " + counter.nonZeros(row));
    }
}