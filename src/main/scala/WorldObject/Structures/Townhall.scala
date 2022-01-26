package WorldObject.Structures
import WorldObject.WorldObject
import java.awt.Graphics2D
import gfx.Assets
class Townhall(position: (Int, Int)) extends WorldObject(position) {

    def tick(): Unit = {

    }

    def draw(g2d: Graphics2D, camera: gfx.Camera): Unit = {
        val x = pos(0); val y = pos(1)
        g2d.drawImage(Assets.townHall, x * camera.tileSize + camera.xOffset, y * camera.tileSize + camera.yOffset, camera.tileSize, camera.tileSize, null)
    }
  
}
