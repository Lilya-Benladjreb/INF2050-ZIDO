//Serves as a data class

public class Call {
    public static final int NATIONAL = 0;
    public static final int INTERNATIONAL = 1;
    public static final int LOCAL = 2;

    private String callID;
    private int priceCode;

    public Call(String callID, int priceCode){
        this.callID = callID;
        this.priceCode = priceCode;
    }

    public java.lang.String getCallID() {return callID;}

    public int getPriceCode() {return priceCode;}

    public void setPriceCode(int newCode) {priceCode = newCode;}
}
