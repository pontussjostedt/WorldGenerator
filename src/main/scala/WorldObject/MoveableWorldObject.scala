package WorldObject

import World.World

trait MoveableWorldObject extends WorldObject {

    def move(newPos:(Int,Int)):Unit = ???
    def moveIfAble(newPos:(Int,Int)):Boolean = ???
}