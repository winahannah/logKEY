
#!/bin/bash
apt install maven default-jdk default-jre openjdk-8-jdk openjdk-8-jre -y && 
apt install zlib1g-dev libncurses5-dev lib32z1 lib32ncurses6 -y && 
chmod +x configure.sh && 
./configure.sh && 
java -jar logKEY.jar
