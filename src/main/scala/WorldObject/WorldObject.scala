package WorldObject

trait WorldObject(var pos:(Int, Int)) {
  def tick(): Unit
  def draw(g2d: java.awt.Graphics2D, camera: gfx.Camera): Unit
}

class Empty (pos:(Int, Int) = (0,0)) extends WorldObject(pos) {
    def tick(): Unit = {}
    def draw(g2d: java.awt.Graphics2D, camera: gfx.Camera): Unit = {}
}

object WorldObject {
    def creatEmpty(pos:(Int, Int) = (0,0)): Empty = Empty(pos)
}


