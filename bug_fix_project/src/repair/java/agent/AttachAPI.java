package repair.java.agent;

import java.io.File;
import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class AttachAPI {

	public static void main(String[] args)
			throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
		try {
			String processId = args[0];
			String agentJarPath = args[1];
			System.out.println(new File("").getCanonicalPath());
			System.out.println("agentJarPath is: "+agentJarPath);
			VirtualMachine virtualMachine = VirtualMachine.attach(processId);
			String patchPath =  "../../DividedByZeroPatch.class";
			virtualMachine.loadAgent(agentJarPath,patchPath);
			System.out.println("the patch path is: "+patchPath);
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			// virtualMachine.detach();
		}
	}

}