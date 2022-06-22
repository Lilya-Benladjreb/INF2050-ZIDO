//Class represents a client that receives or makes a call

public class Communication {
    private int minutesCommunicated;
    private Call call;

    public Communication(Call call, int minutesCommunicated){
        this.call = call;
        this.minutesCommunicated = minutesCommunicated;
    }

    public int getMinutesCommunicated() { return minutesCommunicated;}

    public Call getCall() {
        return call;
    }
}
