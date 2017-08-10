package repair.java.agent;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

public class BugFixAgent {

    public static void agentmain(String arg, Instrumentation inst)
            throws Exception {

         System.out.println("Starting the agent main: " + arg);

        Class<?> targetClass = Class.forName("test.java.agent.DividedByZeroDemo");

        //Get current path
        System.out.println(ClassLoader.getSystemResource("") );

        File f = new File(arg);
        byte[] patchClass = new byte[(int) f.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.readFully(patchClass);
        in.close();

        // Apply the redefinition
        inst.redefineClasses(new ClassDefinition(targetClass, patchClass));

        System.out.println("Agent Main Done"); 
    }

}