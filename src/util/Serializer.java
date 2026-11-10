//@author Knobs
package util;

import java.io.*;
import model.ApplicationState;

public class Serializer {
    private static final String STATE_FILE = "state.ser";
    
    public static void saveState(ApplicationState state) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream
        (STATE_FILE))){
            output.writeObject(state);
        }//end try
    }//end saveState method

    public static ApplicationState loadState() throws IOException, ClassNotFoundException{
        File file = new File(STATE_FILE);

        if(!file.exists()){
            return new ApplicationState();
        }//end if

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream
        (STATE_FILE))){
            return (ApplicationState) input.readObject();
        }//end try
    }//end loadState method
}//end class
