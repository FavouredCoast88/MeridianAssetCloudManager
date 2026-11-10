//@author Knobs
package model;

public class Hardware extends Asset implements java.io.Serializable{

    // Private fields
    private String hardwareType;
    private String status;
    private double monthlyCost;

    // Default Constructor
    public Hardware(){
    }//end constructor

    // Parameterized Constructor
    public Hardware(String assetId, String assetName, String hardwareType, String status, double monthlyCost){
        super(assetId, assetName);
        this.hardwareType = hardwareType;
        this.status = status;
        this.monthlyCost = monthlyCost;
    }//end constructor

    // Getters and Setters
    public String getHardwareType(){
        return hardwareType;
    }//end getHardwareType method

    public void setHardwareType(String hardwareType){
        this.hardwareType = hardwareType;
    }//end setHardwareType method

    public String getStatus(){
        return status;
    }//end getStatus method

    public void setStatus(String status){
        this.status = status;
    }//end setStatus method

    public double getMonthlyCost(){
        return monthlyCost;
    }//end getMonthlyCost method

    public void setMonthlyCost(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }//end setMonthlyCost method

    // Polymorphism
    @Override
    public double calculateMonthlyCost(){
        return monthlyCost;
    }//end calcMonthlyCost method

    @Override
    public String toString(){
        return getAssetId() + " - " + getAssetName() + " (" + hardwareType + ")";
    }//end toString method
}//end class
