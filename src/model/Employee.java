//@author Knobs
package model;

public class Employee implements java.io.Serializable{

    // Private fields (Encapsulation)
    private String employeeId;
    private String name;
    private String department;

    // Default Constructor
    public Employee(){
    }//end constructor

    // Parameterized Constructor
    public Employee(String employeeId, String name, String department){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }//end constructor

    // Getters and Setters
    public String getEmployeeId(){
        return employeeId;
    }//end getEmployeeId method

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }//end setEmployeeId method

    public String getName(){
        return name;
    }//end getName method

    public void setName(String name){
        this.name = name;
    }//end setName method

    public String getDepartment(){
        return department;
    }//end getDepartment method

    public void setDepartment(String department){
        this.department = department;
    }//end setDepartment method

    // Used when displaying Employees in lists or debugging
    @Override
    public String toString(){
        return employeeId + " - " + name + " (" + department + ")";
    }//end toString method
}//end class
