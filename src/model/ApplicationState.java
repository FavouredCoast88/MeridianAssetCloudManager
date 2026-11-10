//@author Knobs
package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ApplicationState implements Serializable {

    private static final long serialVersionUID = 1L;

    private Stack<Hardware> deletedHardware;
    private Queue<String> deploymentQueue;

    public ApplicationState() {

        deletedHardware = new Stack<>();
        deploymentQueue = new LinkedList<>();
    }//end constructor

    public Stack<Hardware> getDeletedHardware() {
        return deletedHardware;
    }//end getDeletedHardware method

    public void setDeletedHardware(Stack<Hardware> deletedHardware){
        this.deletedHardware = deletedHardware;
    }//end setDeletedHardware method

    public Queue<String> getDeploymentQueue(){
        return deploymentQueue;
    }//end getDeploymentQueue method

    public void setDeploymentQueue(Queue<String> deploymentQueue){
        this.deploymentQueue = deploymentQueue;
    }//end set DeploymentQueue method
    
    public void addDeploymentRequest(String request){
        deploymentQueue.offer(request); //offer() adds to the back of queue
    }//end addDeploymentRequest method

    public String processNextDeployment(){
        return deploymentQueue.poll(); //poll() removes the item at the front
    }//end processNextDeployment method
}//end class