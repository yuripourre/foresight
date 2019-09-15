package examples;

import com.harium.keel.core.source.ImageSource;
import com.harium.keel.core.source.MatrixSource;
import com.harium.keel.effect.noise.PerlinNoise;
import foresight.procedural.MapConverter;
import foresight.procedural.NoiseMap;
import foresight.swing.util.SwingUtils;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PerlinExample {

  public static void main(String[] args) {

    int seed = 123;
    int width = 800;
    int height = 800;
    double persistance = 80;

    PerlinNoise noiseEffect = new PerlinNoise()
        .persistance(persistance)
        .lacunarity(1)
        .seed(seed);

    ImageSource noise = noiseEffect.apply(new MatrixSource(width, height));

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = image.createGraphics();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int gray = noise.getRGB(x, y);

        graphics2D.setColor(new Color(gray));
        graphics2D.fillRect(x, y, 1, 1);
      }
    }

    SwingUtils.openDialog(image);
  }

}
