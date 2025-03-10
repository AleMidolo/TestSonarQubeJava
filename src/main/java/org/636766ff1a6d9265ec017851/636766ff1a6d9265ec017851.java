/**
 * 从指定的 <code>position</code> 开始，搜索 <code>buffer</code> 中指定值的字节。
 * @param value 要查找的值。
 * @param pos   搜索的起始位置。
 * @return 找到的字节位置，从 <code>buffer</code> 开始计数，如果未找到则返回 <code>-1</code>。
 */
protected int findByte(byte value, int pos) {
    if (pos < 0 || pos >= buffer.length) {
        throw new IllegalArgumentException("Position is out of bounds");
    }
    
    for (int i = pos; i < buffer.length; i++) {
        if (buffer[i] == value) {
            return i;
        }
    }
    
    return -1;
}