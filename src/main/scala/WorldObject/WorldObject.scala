package WorldObject

abstract class WorldObject(var pos:(Int, Int)) {
  
}

class Empty(pos:(Int, Int) = (0,0))

object WorldObject {
    def creatEmpty(pos:(Int, Int) = (0,0)) = Empty(pos)
}


