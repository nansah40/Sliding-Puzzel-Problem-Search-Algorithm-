import java.util.*;
import java.util.Stack;

public class DFS
{ 
    public Scanner input = new Scanner(System.in);

    // goal state 
    public int[][] goal  = {
        {1,2,3},
        {8,0,4},
        {7,6,5}
    };

    // array to hold visited states 
    public ArrayList<Node> visited = new ArrayList<Node>();
    
    // method to check visted nodes
    public boolean checkVisited(Node curNode)
    {
        for (Node n : visited)
        {
            if (curNode.isEqual(n))
            {
                return true;
            }
        }
        return false;
    }

    // Main search method to search 
    public Node searchIterative(Node rootNode)
    {
        int moveCounter=0;
        Stack<Node> stack = new Stack<Node>();
        Node goalNode = new Node(this.goal);
        ArrayList<ArrayList<Integer>> options;
        stack.push(rootNode);

        while(stack.size() > 0)
        {
            Node curNode = stack.pop();
            Node child;
            options = curNode.getOptions();
            for(var opt : options)
            {    
                child = curNode.clone();
                child.swap(opt);
                
                if(checkVisited(child) == false)
                {
                    visited.add(child);
                    stack.push(child);
                    moveCounter++;
                    child.print();
                }
                if (child.isEqual(goalNode))
                {
                   
                    System.out.println("States visited:" + moveCounter);
                    System.out.println();
                    return child;
                }
            }
        }
        return null;
    }
}
