//@author Knobs
package model;

public class CloudLicense extends Asset implements java.io.Serializable{

    // Private fields
    private int licenseCount;
    private double monthlyCost;

    // Default Constructor
    public CloudLicense(){
    }//end constructor

    // Parameterized Constructor
    public CloudLicense(String assetId, String assetName, int licenseCount, double monthlyCost){
        super(assetId, assetName);
        this.licenseCount = licenseCount;
        this.monthlyCost = monthlyCost;
    }//end constructor

    // Getters and Setters
    public int getLicenseCount(){
        return licenseCount;
    }//end getLicenseCount method

    public void setLicenseCount(int licenseCount){
        this.licenseCount = licenseCount;
    }//end setLicenseCount method

    public double getMonthlyCost(){
        return monthlyCost;
    }//end getMonthlyCost method

    public void setMonthlyCost(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }//end setMonthlyCost method

    // Polymorphism
    @Override
    public double calculateMonthlyCost(){
        return monthlyCost * licenseCount;
    }//end calcMonthlyCost method

    @Override
    public String toString(){
        return getAssetId() + " - " + getAssetName() + " (" + licenseCount + 
                " licenses)";
    }//end toString
}//end class
