import java.util.ArrayList;
import java.util.List;

class Channels {
    private List<IConsumer> consumers;

    public Channels() {
        this.consumers = new ArrayList<>();
    }

    public void addConsumer(IConsumer consumer) {
        consumers.add(consumer);
    }

    public List<IConsumer> getConsumers() {
        return consumers;
    }
}

interface IConsumer {
    void consume(String message);
}

public class TargetChannelManager {
    /** 
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        channels.addConsumer(consumer);
    }

    public static void main(String[] args) {
        Channels channels = new Channels();
        TargetChannelManager manager = new TargetChannelManager();

        IConsumer consumer = new IConsumer() {
            @Override
            public void consume(String message) {
                System.out.println("Consumed message: " + message);
            }
        };

        manager.addNewTarget(channels, consumer);
        System.out.println("New consumer added. Total consumers: " + channels.getConsumers().size());
    }
}