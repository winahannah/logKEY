# logKEY

Enhancements Keylogger Software for Parental Control.

Features:- 
- Notify user on Telegram when email received.
- Logging only an inapprpriate words typed in a text file. (e.g., drug, games, vape)
- Screenshot picture in .jpg
- Webcam capture in .png
- Persistence function for track children's daily activities on the Internet.

# Need to have a Kali Linux to install this software.

# Step for Kali Linux before install the software (The user computer aka parent's computer)

1. Clone the repository
- $ git clone https://github.com/winahannah/logKEY.git

2. Go into the file, open terminal and write command below to generate the software
- $ chmod +x run.sh
- $ ./run.sh

3. Enter required information (e.g., email, password)

4. Transfer the .EXE file from the target/folder to the targeted machine.

# Step for Windows (The target computer aka children's computer)

- Install the latest Java JRE 8 from Oracle, https://www.java.com/en/download/

- Double click the .EXE file that has been put in the target computer.

- Email and Notification will be sent to the user's email when an inappropriate word has been detected by the keylogger.

# To stop or uninstall the software in the target computer

- Go to task manager

- Search for Java(TM) Platform SE binary

- Right click & select "End Task"
