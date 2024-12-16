import javax.media.opengl.*;
import java.io.*;
// import javax.swing.*;
// import com.sun.opengl.util.*;
// import java.awt.*;
// import java.awt.event.*;

public class HowtoPlay2 {
  int index;
  int textures[];
  GL gl;

  public HowtoPlay2(int[] textures, int index, GL gl) throws FileNotFoundException {
    this.textures = textures;
    this.index = index;
    this.gl=gl;
  }

  public void drawH() {
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    String heading = "how to play";
    for (int i = 0, y = 280, x = -200; i < heading.length(); i++) {
      char ch = heading.charAt(i);
      if (ch != ' ') {
        draw(ch - 'a' + 10, x, y);
      }

      x += 40;
    }

    draw(36, 0, -50, 1100, 520);
    //back button
    draw(37, -575, 325,50 , 50);
  }

  private void draw(int index, double x, double y) {
    draw(index, x, y, 40, 40);
  }

  private void draw(int index, double x, double y, double width, double height) {
    // draw the character
    gl.glColor3f(1,1,1);
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