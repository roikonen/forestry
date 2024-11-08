package fi.roikonen.forestry

trait Filter[NodeType] {

  /** Filters the given tree and returns the result tree.
   *
   * @param treeRoot   root node of the target tree
   * @param nodeFilter filter applied to tree nodes
   * @return filtered tree or None if filter did not match any of the nodes in the tree
   */
  def filter(treeRoot: NodeType, nodeFilter: NodeType => Boolean): Option[NodeType]
  
}
