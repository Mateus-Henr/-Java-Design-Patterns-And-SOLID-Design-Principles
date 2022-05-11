import java.util.List;

// This class represents subscribers that are using the service of a phone company.
public class PhoneSubscriber extends Subscriber
{
    // This method is now "Open for Modification", or "Open for Extension".
    @Override
    public double calculateBill()
    {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();

        return totalDuration * baseRate / 100;
    }
}