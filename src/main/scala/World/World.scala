package World
import WorldObject.WorldObject
import scala.collection.mutable.Map
object World {
  val underlying = Map.empty[(Int, Int), WorldObject];
}
