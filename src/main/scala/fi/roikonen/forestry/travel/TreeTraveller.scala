package fi.roikonen.forestry.travel

/** Enables depth-first tree traversal.
  *
  * @tparam NodeType the type of the input tee node.
  * @tparam OutputType the type of the output objects.
  */
trait TreeTraveller[NodeType, OutputType] {

  /** Depth-first tree traversal in pre-order way.
    *
    * @param rootNode The root node of the tree.
    * @param conversion function for converting [[NodeType]] to [[OutputType]]
    * @return the sequence of [[OutputType]] values created by travelling through the tree depth-first in pre-order way.
    */
  def travelPreOrder(rootNode: NodeType, conversion: NodeType => OutputType): Seq[OutputType]

  /** Count how many items gets filtered.
    *
    * @param rootNode The root node of the tree.
    * @param filter Filter applied in counting.
    * @return Number of filter matches.
    */
  def count(rootNode: NodeType, filter: NodeType => Boolean): Int

}
