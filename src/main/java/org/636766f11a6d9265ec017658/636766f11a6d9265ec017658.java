public class FilenameUtils {
    
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /**
     * 返回最后一个目录分隔符字符的索引。<p> 
     * 此方法将处理Unix或Windows格式的文件。返回最后一个正斜杠或反斜杠的位置。<p>
     * 无论代码运行在哪台机器上，输出都是相同的。
     * @param filename 要查找最后一个路径分隔符的文件名，如果为null则返回-1
     * @return 最后一个分隔符字符的索引，如果没有这样的字符则返回-1
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}