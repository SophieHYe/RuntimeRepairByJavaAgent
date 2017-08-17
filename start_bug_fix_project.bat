@echo off
echo "Running bug fix project,please input the process id of buggy project: "

set/p x=

java -jar ./bug_fix_project/target/BugFixProject-0.1-jar-with-all-dependencies.jar%x%


pause