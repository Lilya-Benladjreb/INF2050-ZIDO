//Call represents a client of the service provider

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Communication> communications =
                                    new ArrayList<>(0);

    public Customer(String name){
        this.name = name;
    }

    public void addCommunications(Communication communication){
        communications.add(communication);
    }

    public java.lang.String getName(){
        return name;
    }

    public String statement(){
        double totalAmount = 0;
        int rewardCallerPoints = 0;
        String result = "Details of " + getName() + "'s account \n";

        for (Communication each : communications){
            double thisAmount = 0;

            //Calculate amount of each communication
            switch (each.getCall().getPriceCode()){
                case Call.NATIONAL:
                    thisAmount += 2;
                    if (each.getMinutesCommunicated() > 2){
                        thisAmount += (each.getMinutesCommunicated() - 2) * 1.5;
                    }
                    break;
                case Call.INTERNATIONAL:
                    thisAmount += each.getMinutesCommunicated() * 3;
                    break;
                case Call.LOCAL:
                    thisAmount += 1.5;
                    if (each.getMinutesCommunicated() > 3) {
                        thisAmount += (each.getMinutesCommunicated() - 3 * 1.5);
                    }
                    break;
            }

            //add fidelity points
            rewardCallerPoints ++;

            //add bonus for international call
            if(each.getCall().getPriceCode() == Call.INTERNATIONAL){
                rewardCallerPoints ++;
            }

            //show data of this communication
            result += "\t" + each.getCall().getCallID()
                    + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add lines to foot of the page
        result += "Amount Due"
                + String.valueOf(totalAmount)
                + "\n";
        result += "You earned"
                + String.valueOf(rewardCallerPoints)
                + "fidelity points";
        return result;
    }
}
