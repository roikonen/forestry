package fi.roikonen.forestry.travel

import fi.roikonen.forestry.BaseSpec
import fi.roikonen.forestry.Node
import fi.roikonen.forestry.travel.impl.TreeTravellerImpl

class TreeTravellerSpec extends BaseSpec {

  case class InputNodeClass(id: String, children: Seq[InputNodeClass] = Seq.empty)
      extends Node[InputNodeClass]

  type InputNodeType = InputNodeClass
  type OutputType    = String

  val treeTraveller: TreeTraveller[InputNodeType, OutputType] =
    new TreeTravellerImpl[InputNodeType, OutputType]()

  def inputNodes(ids: String*): Seq[InputNodeType] =
    ids.map(id => InputNodeClass(id)).toList

  val input: InputNodeClass = InputNodeClass(
    id = "1",
    children = Seq(
      InputNodeClass(
        id = "2",
        children = inputNodes("3", "4", "5")
      ),
      InputNodeClass(
        id = "6",
        children = inputNodes("7", "8") :+ InputNodeClass(
          id = "9",
          children = inputNodes("10", "11", "12")
        )
      ),
      InputNodeClass(
        id = "13",
        children = inputNodes("14", "15", "16")
      )
    )
  )

  "TreeTraveller" should {

    "create sequence of converted objects from tree structure depth-first in pre-order way" in {

      def conversion(rootNode: InputNodeType): OutputType = rootNode.id
      treeTraveller.travelPreOrder(input, conversion) shouldEqual (1 to 16).map(_.toString)

    }

    "count even node id numbers from a tree" in {

      def hasEvenIdNumber(node: InputNodeType): Boolean = node.id.toInt % 2 == 0
      treeTraveller.count(input, hasEvenIdNumber) shouldEqual 8

    }

  }

}
