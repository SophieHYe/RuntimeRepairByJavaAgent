# Runtime-repaire-by-Java-Agent
This is a toy exercise of using Java agent to apply the patch to the target buggy project. 
The exercise is consist of three projects: buggy project, java agent project and bug fix project.


# Target running buggy project
 The project contains an ArithmeticException : / by zero
 
 # Java agent project
 Sepcifys the target buggy class and provides an agentmain method to redefine buggy classes. 
 
 # Bug fix project
 The bug fix project loads java agent jar to fix the bugs in buggy project. 
