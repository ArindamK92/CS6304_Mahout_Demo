# Mahout_Demo

### Importing Project:
* Open “eclipse”, right click on “Package Explorer” window, click import.
* Select “Git”-> “Projects from Git” and click “next”.
* Select “clone url” and click “next”.
* Paste “https://github.com/shudipdatta/Mahout_Demo.git” in the “url” textbox, Change protocol to “git”, and click “next”. 
* Choose “Import existing project” and click “finish”.

### Referencing libraries:
* Right click on project and select “build path”-> “configure build path” ->”libraries”->”add external jars”.
* Go to "usr->lib->mahout and select all jars
* Go to "usr->lib->hadoop and select all jars
* Go to "usr->lib->hadoop->lib and select all jars and click "ok"

### General Information (Cloudera):

* Operating System:         Mac -> Microsoft Remote Desktop, Windows -> Default Remote Desktop, Ubuntu -> Remmina
* Machine:                  cqs-cs6304-xxx.ats.mst.edu
* User:                     cloudera
* Default Password:         stu-pass
* Change Password Command:  sudo passwd cloudera

* "Firefox already running" error solve by command:     killall -SIGTERM firefox

* "Eclipse resource is out of sync" error solve by:
* Windows -> Preferences -> General -> Workspace
* Check "Refresh using native tool or polling"

* "ConnectionRefused" error solve by following haddop commands:
* sudo /sbin/service hadoop-hdfs-namenode restart
* sudo /sbin/service hadoop-hdfs-datanode restart
