package gfx

import java.awt.image.BufferedImage

object Assets {
    val townHall = loadImage("res/townhall.png")


    def loadImage(path: String): BufferedImage = {
        javax.imageio.ImageIO.read(new java.io.File(path))
    }
}
