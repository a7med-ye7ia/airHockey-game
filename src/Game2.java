import java.awt.event.*;
import javax.media.opengl.*;
import GameObjects.Ball;
import GameObjects.Hand;
import java.util.BitSet;

public class Game2 {
  GL gl;
  int[] textures;
  BitSet keyBits;

  Hand handRight, handLeft;
  Ball ball;
  Timer2 timer;

  public Game2(GL gl, int[] textures, BitSet keyBits) {
    this.gl = gl;
    this.textures = textures;
    this.keyBits = keyBits;
    handRight = new Hand(textures[39], 440, 0, true, textures, gl);
    handLeft = new Hand(textures[39], -440, 0, false, textures, gl);
    ball = new Ball(textures, 0, 0, handRight, handLeft, gl);
    timer = new Timer2(60, textures, gl);
  }

  public void draw() {
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    timer.add();
    drawBackground();
    handleKeyPress();
    handRight.draw();
    handLeft.draw();
    ball.draw();
    timer.draw();
  }

  public void drawBackground() {
    draw(37, 0, 0, 1200, 700);
  }

  public void draw(int index, double x, double y, double width, double height) {
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

  public boolean isKeyPressed(final int keyCode) {
    return keyBits.get(keyCode);
  }

  public void handleKeyPress() {

    if (isKeyPressed(KeyEvent.VK_LEFT)) {
      handRight.move(-10, 0);
    }
    if (isKeyPressed(KeyEvent.VK_RIGHT)) {
      handRight.move(10, 0);
    }
    if (isKeyPressed(KeyEvent.VK_UP)) {
      handRight.move(0, 10);
    }
    if (isKeyPressed(KeyEvent.VK_DOWN)) {
      handRight.move(0, -10);
    }

    if (isKeyPressed(KeyEvent.VK_A)) {
      handLeft.move(-10, 0);
    }
    if (isKeyPressed(KeyEvent.VK_D)) {
      handLeft.move(10, 0);
    }
    if (isKeyPressed(KeyEvent.VK_W)) {
      handLeft.move(0, 10);
    }
    if (isKeyPressed(KeyEvent.VK_S)) {
      handLeft.move(0, -10);
    }
  }
}