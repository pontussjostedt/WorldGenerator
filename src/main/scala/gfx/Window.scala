package gfx
import java.awt.event.KeyListener
import java.awt.event.KeyListener
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import java.awt.Graphics2D
class Window(val title: String, val width: Int, val height: Int) {
  var keyManager = new KeyManager()
  var mouseManager = new MouseManager()
  var display: Display = new Display(title, width, height)
  display.frame.addKeyListener(keyManager)
  display.frame.addMouseListener(mouseManager)
  display.frame.addMouseMotionListener(mouseManager)
  display.canvas.addMouseListener(mouseManager)
  display.canvas.addMouseMotionListener(mouseManager)

  def render(draw:(draw: Graphics2D) => Unit): Unit = {
    import java.awt.Color
    var bs = display.canvas.getBufferStrategy
    if (bs == null) {
      display.canvas.createBufferStrategy(3)
      bs = display.canvas.getBufferStrategy
    }
    val g2d = bs.getDrawGraphics().asInstanceOf[Graphics2D]
    g2d.clearRect(0, 0, width, height)
    draw(g2d) //RITAR ALLT
    bs.show()
    g2d.dispose()

  }
}

class KeyManager() extends KeyListener {
  var keys: Array[Boolean] = new Array(526)

  override def keyPressed(e: KeyEvent): Unit = {
    keys(e.getKeyCode) = true
    if(e.getKeyCode == 27)
      System.exit(0)
  }

  override def keyReleased(e: KeyEvent): Unit = {
    keys(e.getKeyCode) = false
  }

  override def keyTyped(e: KeyEvent): Unit = {

    //Ingen anledning att ha atm :)
  }

  def isKeyPressed(input: Int): Boolean = {
    keys(input)
  }

  def lookUpKey(table: Map[String, Int], input: String): Boolean = {
    isKeyPressed(table(input))
  }

}

class MouseManager() extends MouseListener, MouseMotionListener {
  var leftPressed: Boolean = false
  var rightPressed: Boolean = false
  var pos: (Int, Int) = (-1, -1)

  override def mouseClicked(e: MouseEvent): Unit = {}
  override def mouseEntered(e: MouseEvent): Unit = {}
  override def mouseExited(e: MouseEvent): Unit = {}

  override def mousePressed(e: MouseEvent): Unit =
    println("PRESSED")
    if (e.getButton() == MouseEvent.BUTTON1) then leftPressed = true
    if (e.getButton() == MouseEvent.BUTTON2) then rightPressed = true

  override def mouseReleased(e: MouseEvent): Unit =
    if (e.getButton() == MouseEvent.BUTTON1) then leftPressed = false
    if (e.getButton() == MouseEvent.BUTTON2) then rightPressed = false

  override def mouseDragged(e: MouseEvent): Unit =
    pos = (e.getX(), e.getY())
  override def mouseMoved(e: MouseEvent): Unit =
    pos = (e.getX(), e.getY())
}

class Display(title: String, var width: Int, var height: Int) {
  import java.awt.Canvas
  import java.awt.Dimension
  import javax.swing.JFrame
  var frame = new JFrame(title)
  frame.setSize(width, height)
  frame.setDefaultCloseOperation(3)
  frame.setResizable(false)
  frame.setLocationRelativeTo(null)
  frame.setVisible(true)

  var canvas = new Canvas()

  //canvas.setBackground(new java.awt.Color(255, 0, 0))
  canvas.setPreferredSize(new Dimension(width, height))
  canvas.setMaximumSize(new Dimension(width, height))
  canvas.setMinimumSize(new Dimension(width, height))
  canvas.setFocusable(false)
  frame.add(canvas)
  frame.pack()
}



//RÄTT =  vc=0 då t=0 och V0 då t>>RC
//RÄtt =  vL=V0 då t=0+ och vL=0 då t>>L/R
//RÄTT =  T mycket större än RC

// T=R/C
// T=RC
