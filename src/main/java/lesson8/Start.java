package lesson8;

public class Start {
    public static void main(String[] args) {
        int [][]ar =    {{1,0},{2,0},{3,1},{4,3},{5,4},{8,4},{6,0},{9,6},{7,1}};
        TreeId treeId = new TreeId(ar);
        treeId.buildTree();
        //treeId.rec(1);
        treeId.printMass();
        //treeId.printListId();
    }
}
