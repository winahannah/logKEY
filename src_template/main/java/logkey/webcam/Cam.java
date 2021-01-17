package logkey.webcam;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cam {

    public static void Capture(String filePath, String fileName, int widthx, int heighty) throws IOException {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            webcam.setViewSize(new Dimension(widthx, heighty));
            webcam.open();
            ImageIO.write(webcam.getImage(), "PNG", new File(filePath + fileName + ".png"));
            webcam.close();
        }
    }
}

