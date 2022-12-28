package Test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {
    private BufferedImage resizeImage(File imageFile, int width, int height) throws IOException {

        // Read the image file into a BufferedImage object
        BufferedImage originalImage = ImageIO.read(imageFile);

        // Create a new BufferedImage object with the desired size
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the graphics context for the resized image
        Graphics graphics = resizedImage.getGraphics();

        // Draw the original image on the resized image
        graphics.drawImage(originalImage, 0, 0, width, height, null);
        graphics.dispose();

        return resizedImage;
    }



}
