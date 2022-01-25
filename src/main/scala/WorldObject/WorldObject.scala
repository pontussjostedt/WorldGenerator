package WorldObject

trait WorldObject(var pos:(Int, Int)) {
  
}

class Empty (pos:(Int, Int) = (0,0)) extends WorldObject(pos)

object WorldObject {
    def creatEmpty(pos:(Int, Int) = (0,0)):Empty = Empty(pos)
}


