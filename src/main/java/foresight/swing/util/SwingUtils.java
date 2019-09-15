package foresight.swing.util;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingUtils {

  public static void openDialog(BufferedImage image) {
    ImageIcon wrapper = new ImageIcon(image);

    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(new JLabel(wrapper));
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
