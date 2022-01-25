package World
import WorldObject.WorldObject
import scala.collection.mutable.Map
object World {
  val underlying = Map.empty[(Int, Int), WorldObject];
  private def deafult(pos:(Int, Int) = (0,0)) = WorldObject.creatEmpty(pos);
  
  def get(pos:(Int, Int)):WorldObject = underlying.getOrElse(pos, deafult(pos));

  def remove(pos:(Int, Int)) = underlying.remove(pos);

  def update(pos:(Int,Int), value:WorldObject) = underlying.update(pos, deafult(pos));

  def set(pos:(Int,Int), value:WorldObject) = underlying.put(pos, value);

  def apply(pos:(Int, Int)) = get(pos);

  /**Alwas moves the object on the old pos to the new pos*/
  def move(oldPos:(Int, Int), newPos:(Int,Int)):Unit = {
    val value = get(oldPos)
    remove(oldPos);
    set(newPos, value)
    value.pos = newPos
  }

  /**Moves to the pos if and only if the newPos is empty
   * 
   * Retruns true if move was made otherwise false
   * Empty is defind as containing the deafult tile
  */
  def moveIfAble(oldPos:(Int, Int), newPos:(Int,Int)):Boolean = {
    val canMove:Boolean = get(newPos).getClass() == deafult().getClass()
    if canMove then move(oldPos,newPos)
    canMove;

  }
}
