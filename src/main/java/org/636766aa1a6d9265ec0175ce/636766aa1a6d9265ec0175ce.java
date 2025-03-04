import java.util.ArrayList;
import java.util.List;

public class StackMapFrameVisitor {
    private Frame currentFrame;
    private List<Frame> frames;
    
    public StackMapFrameVisitor() {
        frames = new ArrayList<>();
    }
    
    private static class Frame {
        int offset;
        int numLocal;
        int numStack;
        int nextIndex;
        
        Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextIndex = 0;
        }
    }
    
    int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        return currentFrame.nextIndex;
    }
}