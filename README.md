# Setup envirement 
*  Install Java SDK   [( download )](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
    
    ![download](doc/022017_1205_Guidetoinst2.png?raw=true "Title")
* Install Eclipe IDE [( download )](https://www.eclipse.org/downloads/)

    ![download](doc/022017_1205_Guidetoinst3.png?raw=true "Title")
     ![install](doc/022017_1205_Guidetoinst5.png?raw=true "Title")
* Install chrome [( download )](https://www.google.com/chrome/)
* Install firefox [( download )](https://www.mozilla.org/en-US/firefox/new/)

# Setup project
* clone the repo or download it as zip and extract it
* launch Eclipse IDE > File > Open Projects from File System...

    ![install](doc/project0.png?raw=true "Title")

* on the `" Import source " ` > Directory and select the folder where did you clone or extract the zip file of this repo > Finish

    ![install](doc/project1.png?raw=true "Title")
    ![install](doc/project2.png?raw=true "Title")

* Download an extract needed jars folder [( link )](https://drive.google.com/file/d/1k45YKNLULTU9E_8_VdbMm6Z374uzsEQq/view?usp=sharing)
    
    ![install](doc/project1-2.png?raw=true "Title")

* right click on the project name > properties then select `Java Build Path` on the left menu

    ![install](doc/project3.png?raw=true "Title")

* add selenium  jars by clicking > Add External Jars

    ![install](doc/project4.png?raw=true "Title")

* add extent-reports  jars by clicking > Add External JARs

    ![install](doc/project5.png?raw=true "Title")

* add testNG lib by clicking > Add Library

    ![install](doc/project6.png?raw=true "Title")

    note if you can not find TestNG on the libraries list please follow this tutorial [how to install TestNG with eclipse](https://www.guru99.com/install-testng-in-eclipse.html)

# Run project

* right click on the project name > Run As > TestNG test

# Output

after a successful run a folder reports and test-output are generated on the projrct dir ( maybe you have to do right click > refresh on the Projrct Explorer menu to see them)

    
![output](doc/output0.png?raw=true "Title")
![output](doc/output1.png?raw=true "Title")
![output](doc/output3.png?raw=true "Title")
