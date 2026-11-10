//@author Knobs
package model;

public abstract class Asset implements java.io.Serializable {

    private String assetId;
    private String assetName;

    public Asset(){
    }//end constructor

    public Asset(String assetId, String assetName){
        this.assetId = assetId;
        this.assetName = assetName;
    }//end constructor

    // Getters and Setters
    public String getAssetId(){
        return assetId;
    }//end getAssetId method

    public void setAssetId(String assetId){
        this.assetId = assetId;
    }//end setAssetId methos

    public String getAssetName(){
        return assetName;
    }//end getAssetName method

    public void setAssetName(String assetName){
        this.assetName = assetName;
    }//end setAssetName method

    // Polymorphism
    public abstract double calculateMonthlyCost();
}//end class