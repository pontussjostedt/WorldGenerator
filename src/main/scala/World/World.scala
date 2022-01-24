package World
import WorldObject.WorldObject
import scala.collection.mutable.Map
object World {
  val underlying = Map.empty[(Int, Int), WorldObject];
  

  def get(pos:(Int, Int)) = underlying.getOrElse(pos, WorldObject.creatEmpty(pos));

  def remove(pos:(Int, Int)) = underlying.remove(pos);

  def uppdate(pos:(Int,Int), value:WorldObject) = underlying.update(pos, WorldObject);

  def set(pos:(Int,Int), value:WorldObject) = underlying.put(pos, value);
}
