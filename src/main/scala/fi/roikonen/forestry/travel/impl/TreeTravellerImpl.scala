package fi.roikonen.forestry.travel.impl

import fi.roikonen.forestry.Node
import fi.roikonen.forestry.travel.TreeTraveller

import scala.annotation.tailrec

class TreeTravellerImpl[NodeType <: Node[NodeType], OutputType]
    extends TreeTraveller[NodeType, OutputType] {

  override def travelPreOrder(
      rootNode: NodeType,
      conversion: NodeType => OutputType
  ): Seq[OutputType] = {

    @tailrec
    def tailRecToConverted(
        unprocessed: Seq[NodeType],
        processed: Seq[OutputType] = Seq.empty
    ): Seq[OutputType] = {
      if (unprocessed.isEmpty) return processed
      val children = unprocessed.head.children
      tailRecToConverted(
        children ++ unprocessed.tail,
        processed :+ conversion(unprocessed.head)
      )
    }

    tailRecToConverted(unprocessed = Seq(rootNode))
  }

  /** Count how many items gets filtered.
    *
    * @param rootNode The root node of the tree.
    * @param filter   Filter applied in counting.
    * @return Number of filter matches.
    */
  override def count(rootNode: NodeType, filter: NodeType => Boolean): Int = {

    @tailrec
    def tailRecToCount(
        unprocessed: Seq[NodeType],
        count: Int = 0
    ): Int = {
      if (unprocessed.isEmpty) return count
      val children = unprocessed.head.children
      tailRecToCount(
        children ++ unprocessed.tail,
        if (filter(unprocessed.head)) count + 1
        else count
      )
    }

    tailRecToCount(unprocessed = Seq(rootNode))
  }
}
