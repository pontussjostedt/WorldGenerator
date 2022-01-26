import scala.compiletime.ops.boolean
import World.World
import java.awt.Graphics2D
class Simulation {
  val window = new gfx.Window("Sim", 1330, 770)
  val camera: gfx.Camera = new gfx.Camera
  val running: Boolean = true;


  World.init()

  while(running) {
      tick()
      window.render(draw(_))
  }

  def tick(): Unit = {
    World.tick()
  }

  def draw(g2d: Graphics2D): Unit = {
    World.draw(g2d, camera)
  }
}
