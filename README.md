# Mahout_Demo

## Install Mahout  (Do it one time only)
#Let us consider java is already installed. (If not, install it)  

###Install maven  
sudo apt-get install maven    
#check the version using 'mvn -v'  

###Install svn  
sudo apt-get install subversion  
#check the version using 'svn --version'  

###Install mahout   
#open a terminal   
mkdir mahout   
cd mahout/   
svn co http://svn.apache.org/repos/asf/mahout/trunk   
cd trunk/   
mvn compile  
mvn -DskipTests   

### Before running mahout on terminal do EVERYTIME (because we are not setting in .bashrc or profile.d:  
export MAHOUT_LOCAL=TRUE   
export MAHOUT_HEAPSIZE=1000    
export MAHOUT_HOME=/home/akkcm/mahout/trunk  
export PATH=$PATH:$MAHOUT_HOME/bin    


