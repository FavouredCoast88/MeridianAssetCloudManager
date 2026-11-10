//@author Knobs
package util;

import javax.swing.SwingWorker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import model.Employee;
import model.Hardware;
import model.CloudLicense;

public class FileWorker extends SwingWorker<Boolean, Void> {

    private String operation;

    private ArrayList<Employee> employees;
    private LinkedList<Hardware> hardwareList;
    private ArrayList<CloudLicense> licenses;
    private Runnable onStart;
    private Runnable onFinish;

    public FileWorker(String operation, ArrayList<Employee> employees,
            LinkedList<Hardware> hardwareList, ArrayList<CloudLicense> licenses,
            Runnable onStart, Runnable onFinish){
        
        this.operation = operation;
        this.employees = employees;
        this.hardwareList = hardwareList;
        this.licenses = licenses;
        this.onStart = onStart;
        this.onFinish = onFinish;
    }//end constructor

    @Override
    protected Boolean doInBackground(){
        if(onStart != null){
            onStart.run();
        }//end if
        
        try{
            switch(operation){
                case "SAVE_EMPLOYEES":
                    FileManager.saveEmployees(employees);
                    break;

                case "SAVE_HARDWARE":
                    FileManager.saveHardware(hardwareList);
                    break;

                case "SAVE_LICENSES":
                    FileManager.saveLicenses(licenses);
                    break;
                default:
                    return false;
            }//end switch
            return true;

        }catch(IOException e){
            return false;
        }//end catch
    }//end doInBackground method

    @Override
    protected void done(){
        try{
            get();
        }catch(Exception e){
            e.printStackTrace();
        }//end catch

        if(onFinish != null){
            javax.swing.SwingUtilities.invokeLater(onFinish);
        }//end if

        System.out.println("Background file operation completed: " + operation);
    }//end done method
}//end class
