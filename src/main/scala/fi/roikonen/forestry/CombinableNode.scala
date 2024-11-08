package fi.roikonen.forestry

import fi.roikonen.forestry.Node

trait CombinableNode[T <: CombinableNode[T]] extends Node[T] {
  def id: String
  def children: Seq[T]
}
