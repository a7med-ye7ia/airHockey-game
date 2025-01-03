package Pages;

import javax.media.opengl.*;
import java.io.*;

public class HowToPlay {
  int index;
  int textures[];
  GL gl;

  public HowToPlay(int[] textures, int index, GL gl) throws FileNotFoundException {
    this.textures = textures;
    this.index = index;
    this.gl = gl;
  }

  public void draw() {
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    draw(40, 0, 0, 1200, 700);

    gl.glColor3f(1, 1, 1);
    gl.glBegin(GL.GL_QUADS);
    gl.glVertex2d(-230, 310);
    gl.glVertex2d(230, 310);
    gl.glVertex2d(230, 250);
    gl.glVertex2d(-230, 250);
    gl.glEnd();

    String heading = "how to play";
    for (int i = 0, y = 280, x = -200; i < heading.length(); i++) {
      char ch = heading.charAt(i);
      if (ch != ' ') {
        draw(ch - 'a' + 10, x, y);
      }

      x += 40;
    }

    draw(36, 0, -50, 1100, 520);
    // back button
    draw(57, -575, 325, 50, 50);
  }

  private void draw(int index, double x, double y) {
    int width = 40;
    if (index == 1) width = 10;
    else if (index == 2) width = 20;
    draw(index, x, y, width, 40);
  }

  private void draw(int index, double x, double y, double width, double height) {
    // draw the character
    gl.glColor3f(1, 1, 1);
    gl.glEnable(GL.GL_BLEND);
    gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]); // Turn Blending On

    gl.glBegin(GL.GL_QUADS);
    gl.glTexCoord2f(0.0f, 0.0f); // bottom left point
    gl.glVertex3f((float) (x - 0.5 * width), (float) (y - 0.5 * height), -1.0f);
    gl.glTexCoord2f(1.0f, 0.0f); // top left point
    gl.glVertex3f((float) (x + 0.5 * width), (float) (y - 0.5 * height), -1.0f);
    gl.glTexCoord2f(1.0f, 1.0f); // top right point
    gl.glVertex3f((float) (x + 0.5 * width), (float) (y + 0.5 * height), -1.0f);
    gl.glTexCoord2f(0.0f, 1.0f); // bottom right point
    gl.glVertex3f((float) (x - 0.5 * width), (float) (y + 0.5 * height), -1.0f);
    gl.glEnd();

    gl.glDisable(GL.GL_BLEND);
  }
}