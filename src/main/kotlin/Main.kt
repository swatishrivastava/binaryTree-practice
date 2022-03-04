fun main(args: Array<String>) {
    var binaryTree = BinaryTree()
//   binaryTree.createBinaryTree()
//   binaryTree.bfs(binaryTree.a)
//   println(binaryTree.bfsGivenNUm(binaryTree.a, "a"))
//   binaryTree.depthFirstSearchRecursion(binaryTree.a)

    // create tree with Int value
    var root = binaryTree.createTreeWithIntValue()
    var root2 = binaryTree.createTreeWithIntValue()
    println("GIven trees are same: " + binaryTree.checkGivenTwoTreesAreEqual(root, root2))
    // println("Print min from the tree: ${binaryTree.inorderTraversal(root)}")


}