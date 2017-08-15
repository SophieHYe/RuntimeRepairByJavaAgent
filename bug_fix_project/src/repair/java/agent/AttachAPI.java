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
			String processId;
			String agentJarPath;
			if(args.length>0){
				processId = args[0];
				agentJarPath = args[1];
			} else{
				processId="20176";
				agentJarPath = "D:\\current_project\\JavaAgent\\RuntimeRepairByJavaAgent\\agent_project\\target\\AgentProject-0.1.jar";
			}
			
			
			System.out.println("agentJarPath is: "+agentJarPath);
			VirtualMachine virtualMachine = VirtualMachine.attach(processId);
			String patchPath =  "D:\\current_project\\JavaAgent\\RuntimeRepairByJavaAgent\\bug_fix_project\\target\\classes\\repair\\java\\agentDividedByZero.class";
			virtualMachine.loadAgent(agentJarPath,patchPath);
			System.out.println("the patch path is: "+patchPath);
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			// virtualMachine.detach();
		}
	}

}