package fi.roikonen.forestry

trait Node[T <: Node[T]] {
  def children: Seq[T]
}
