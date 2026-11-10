//@author Knobs
package util;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import model.Employee;
import model.Hardware;
import model.CloudLicense;

public class FileManager {
    private static final String EMPLOYEE_FILE = "employees.txt";
    private static final String HARDWARE_FILE = "hardware.txt";
    private static final String LICENSE_FILE = "licenses.txt";
    
    //=======================
    //        Employees
    //=======================
    public static void saveEmployees(ArrayList<Employee> employees) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE));
        
        for(Employee employee : employees){
            writer.write(employee.getEmployeeId()+ "," + employee.getName()
                    + "," + employee.getDepartment());
            writer.newLine();
        }//end for
        writer.close();
    }//end saveEmployees method
    
    //Load employees from text file
    public static ArrayList<Employee> loadEmployees() throws IOException{
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(EMPLOYEE_FILE);
        
        if(!file.exists()){
            return employees;
        }//end if
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        
        while((line = reader.readLine())!= null){
            String[] data = line.split(",");
            if(data.length == 3){
                Employee employee = new Employee(data[0], data[1], data[2]);
                employees.add(employee);
            }//end if
        }//end while
        reader.close();
        return employees;
    }//end LoadEmployees from txt method
    
    //====================
    //      Hardware
    //====================
    public static void saveHardware(LinkedList<Hardware> hardwareList) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(HARDWARE_FILE))){       
            for(Hardware hardware: hardwareList){
                writer.write(hardware.getAssetId()+ "," + hardware.getAssetName()
                        + "," + hardware.getHardwareType()+ "," + hardware.getStatus()
                        + "," + hardware.getMonthlyCost());
                writer.newLine();
            }//end for
        }//end try
    }//end saveHardware method
    
    public static LinkedList<Hardware> loadHardware() throws IOException{
        LinkedList<Hardware> hardwareList = new LinkedList<>();
        File file = new File(HARDWARE_FILE);
        
        if(!file.exists()){
            return hardwareList;
        }//end if
        
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
        
            while((line = reader.readLine())!= null){
                String[] data = line.split(",");
                if(data.length == 5){
                    double monthlyCost = Double.parseDouble(data[4]);
                    hardwareList.add(new Hardware(data[0],data[1],data[2],
                            data[3],monthlyCost));
                }//end if
            }//end while
        }//end try
        return hardwareList;
    }//end loadHardware method
    
    //=========================
    //       Cloud Licenses
    //=========================
    
    public static void saveLicenses(ArrayList<CloudLicense> licenses) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LICENSE_FILE))){
            for(CloudLicense license: licenses){
                writer.write(license.getAssetId()+ "," + license.getAssetName()+ ","
                        + license.getLicenseCount()+ "," + license.getMonthlyCost());
                writer.newLine();
            }//end for
        }//end try
    }//end saveLicenses method
    
    public static ArrayList<CloudLicense> loadLicenses() throws IOException{
        ArrayList<CloudLicense> licenses = new ArrayList<>();
        File file = new File(LICENSE_FILE);
        
        if(!file.exists()){
            return licenses;
        }//end if
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
        
            while((line = reader.readLine())!= null){
                String[] data = line.split(",");
                if(data.length == 4){
                    int licenseCount = Integer.parseInt(data[2]);
                    double monthlyCost = Double.parseDouble(data[3]);
                
                    licenses.add(new CloudLicense(data[0],data[1],
                            licenseCount,monthlyCost));
                }//end if
            }//end while
        }//end try
        return licenses;
    }//end loadLicenses method
    
}//end class
