package fi.roikonen.forestry

trait Combiner[
  InputNode1 <: CombinableNode[InputNode1],
  InputNode2 <: CombinableNode[InputNode2],
  OutputNode <: CombinableNode[OutputNode]
] {

  private type Parents1 = Seq[InputNode1]
  private type Parents2 = Seq[InputNode2]
  private type Children = Seq[OutputNode]

  /**
   * @param treeRoot1 First tree to combine.
   * @param treeRoot2 Second tree to combine.
   * @param combiner Combine nodes into output node type.
   * @param transformer1 If node of type1 did not have counterpart in another tree, convert type1 into output node type.
   * @param transformer2 If node of type2 did not have counterpart in another tree, convert type2 into output node type.
   * @return Combined tree.
   */
  def combine(treeRoot1: InputNode1,
              treeRoot2: InputNode2,
              combiner: (InputNode1, Parents1, InputNode2, Parents2, Children) => OutputNode,
              transformer1: (InputNode1, Parents1, Children) => OutputNode,
              transformer2: (InputNode2, Parents2, Children) => OutputNode
             ): OutputNode
  
}
