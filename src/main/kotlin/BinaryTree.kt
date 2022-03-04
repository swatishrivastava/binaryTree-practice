import java.lang.Float.POSITIVE_INFINITY
import java.util.*

class BinaryTree {


    var a = Node("a")
    var b = Node("b")
    var c = Node("c")
    var d = Node("d")
    var e = Node("e")
    var f = Node("f")


    fun createBinaryTree() {
        a.left = b
        a.right = c
        b.left = d
        b.right = e
        c.left = f
    }


    fun createTreeWithIntValue(): Node<Int> {
        var a = Node(1)
        var b = Node(2)
        var c = Node(3)
        var d = Node(6)
        var e = Node(8)
        var f = Node(1)
        a.left = null
        a.right = b
        b.left = c
        b.right = null


        return a
    }

    fun bfs(root: Node<String>) {
        var queue = LinkedList<Node<String>>() as Queue<Node<String>>
        queue.offer(root)
        while (queue.isNotEmpty()) {
            var curr = queue.poll()
            println("print node: $curr")

            if (curr.left != null) {
                queue.offer(curr.left)
            }
            if (curr.right != null) {
                queue.offer(curr.right)
            }
        }
    }


    fun bfsGivenNUm(root: Node<String>, target: String): Boolean {
        var queue = LinkedList<Node<String>>() as Queue<Node<String>>
        queue.offer(root)
        while (queue.isNotEmpty()) {
            var curr = queue.poll()
            if (curr.value == target) {
                return true
            }
            println("print node: $curr")

            if (curr.left != null) {
                queue.offer(curr.left)
            }
            if (curr.right != null) {
                queue.offer(curr.right)
            }
        }

        return false

    }


    fun depthFirstSearch(root: Node<String>) {
        var stack = Stack<Node<String>>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            var curr = stack.pop()
            println("DPS Print node: $curr")
            if (curr.right != null) {
                stack.push(curr.right)
            }
            if (curr.left != null) {
                stack.push(curr.left)
            }
        }
    }


    fun depthFirstSearchRecursion(root: Node<String>) {
        if (root == null) return
        println("Recursion DFS: $root")
        root.left?.let { depthFirstSearchRecursion(it) }
        root.right?.let { depthFirstSearchRecursion(it) }
    }

    fun inorderTraversal(root: Node<Int>?): List<Any> {
        var result = mutableListOf<Int>()
        var stack = Stack<Node<Int>>()
        if (root == null) {
            return result
        }

        var curr = root
        while (curr != null || stack.isNotEmpty()) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            result.add(curr.value)
            curr = curr.right
        }

        return result
    }

    fun findMinInTree(root: Node<Int>): Int {
        var smallest = POSITIVE_INFINITY.toInt()

        var stack = Stack<Node<Int>>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            var curr = stack.pop()
            if (smallest > curr.value) {
                smallest = curr.value
            }
            if (curr.left != null) {
                stack.push(curr.left)
            }
            if (curr.right != null) {
                stack.push(curr.right)
            }

        }
        return smallest
    }

//pre order: self left right
// post order: left right self
//  in order: left self right


    fun checkGivenTwoTreesAreEqual(p: Node<Int>?, q: Node<Int>?): Boolean {
        var firstTree = p
        var secTree = q

        if (firstTree == null && secTree == null) {
            return true
        }
        if (firstTree != null || secTree != null) {
            if (firstTree?.value != secTree?.value) {
                return false
            }
        }
        var isSameLeft =checkGivenTwoTreesAreEqual(firstTree?.left, secTree?.left)
        var isSameRight =checkGivenTwoTreesAreEqual(firstTree?.right, secTree?.right)
        return (isSameLeft && isSameRight)
    }

}


