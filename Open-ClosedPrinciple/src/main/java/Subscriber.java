// This will be our base class that helps us avoid duplicate data. This has been marked as abstract since we
// are not going to have a subscriber object.

// Base class. This class is now "Closed for Modification".
public abstract class Subscriber
{
    protected Long subscriberId;

    private String address;

    private Long phoneNumber;

    protected int baseRate;

    public Long getSubscriberId()
    {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId)
    {
        this.subscriberId = subscriberId;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Long getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public int getBaseRate()
    {
        return baseRate;
    }

    public void setBaseRate(int baseRate)
    {
        this.baseRate = baseRate;
    }

    public abstract double calculateBill(); // It indicates the extension.

}
