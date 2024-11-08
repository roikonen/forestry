package fi.roikonen.forestry

trait Transformer[InputNode, OutputNode] {

  private type Parents = Seq[InputNode]
  private type Children = Seq[OutputNode]
  
  /** Transforms the given tree identified by root node to output tree consisting of output nodes
   *
   * @param treeRoot input tree's root node
   * @param transformer transforms the nodes
   * @return output tree's root node with children beneath it
   */
  def transform(
                 treeRoot: InputNode, 
                 transformer: (InputNode, Parents, Children) => OutputNode
               ): OutputNode
    
}
