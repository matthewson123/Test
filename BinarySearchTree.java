public class BinarySearchTree{
    private BinaryNode root;
    public BinarySearchTree(){
        root = null;
    }

    class BinaryNode{
        int data;
        BinaryNode left;
        BinaryNode right;
        public BinaryNode(int d){
            data = d;
            left = right = null;
        }
        public int getData(){
            return data;
        }
    }

    public void insert(int d){
        root = insertSubtree(root,d);
    }
    
    public void delete(int x){
        root = deleteSubtree(root,x);
    }

    private BinaryNode insertSubtree (BinaryNode t, int d){
     if(t == null){
         t = new BinaryNode(d);
     }else if (d < t.data){
         t.left = insertSubtree(t.left, d);
     }else if (d > t.data){
         t.right = insertSubtree(t.right, d);
     }
     return t;
    }
    
    private BinaryNode findMin(BinaryNode t){
        if (t == null){
            return null;
        }else if (t.left == null){
            return t;
        }else{
            return findMin(t.left);
        }
    }
    
    private BinaryNode deleteSubtree(BinaryNode t, int x){
        BinaryNode temp, child;
        if (t == null){
           return null; 
        } 
        if (x < t.data){
            t.left = deleteSubtree(t.left, x);
        }else if (x > t.data){
            t.right = deleteSubtree(t.right, x);
        }else if (t.left != null && t.right != null){
            t.data = findMin(t.right).data;
            t.right = deleteSubtree(t.right, t.data);
        }
        else
            t = (t.left != null) ? t.left : t.right;
            return t;
    }
    
    void inorder()  { 
       inorderSubtree(root); 
    } 
  
    void inorderSubtree(BinaryNode t) { 
        if (t != null) { 
            inorderSubtree(t.left); 
            System.out.println(t.data); 
            inorderSubtree(t.right); 
        } 
    } 


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(2);
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(0);
        tree.insert(8);
        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
        
        System.out.println("\nDelete 3"); 
        tree.delete(3); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 7"); 
        tree.delete(7); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
        
    }
}