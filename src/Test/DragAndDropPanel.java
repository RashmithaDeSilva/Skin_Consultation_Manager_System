package Test;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import javax.swing.*;

public class DragAndDropPanel extends JPanel {
    private Image img = new Image();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag and Drop Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DragAndDropPanel panel = new DragAndDropPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public DragAndDropPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBorder(BorderFactory.createLineBorder(Color.black));

        // Enable drag and drop
        setTransferHandler(new TransferHandler() {
            public boolean canImport(TransferHandler.TransferSupport support) {
                // Only import files
                if (!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    return false;
                }

                return true;
            }

            public boolean importData(TransferHandler.TransferSupport support) {
                // Get the dropped file
                Transferable t = support.getTransferable();
                try {
                    @SuppressWarnings("unchecked")
                    java.util.List<File> files = (java.util.List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    File file = files.get(0);
                    //img = new ImageIcon(file.getAbsolutePath()).getImage();
                    repaint();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            //g.drawImage(img, 0, 0, null);
        }
    }
}