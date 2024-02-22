import java.util.List;

class DisjointSet{

    int p[];
    int n;
    public void init(int n){
        p = new int[n];
        this.n = n;
        // each node is parent itself
        for(int i=0; i<n; i++){
            p[i] = i;
        }
    }

    public void union(int a, int b){
        // find ultimate parent of node
        int parA = find(a);
        int parB = find(b);

        // both in same group
        if(parA==parB){
            return;
        }

        // different parent => make parent of a to b
        else{
            p[parA] = parB;
        }
    }

    // find ultimate parent
    public int find(int a){
        if(p[a]==a) return a;
        return find(p[a]);
    }

    public boolean areFriend(int a, int b){
        // if both having same parent
        if(find(a)==find(b)) return true;
        return false;
    }

}


public class BasicDSU {

    public static void main(String args[]){

        DisjointSet ds = new DisjointSet();
        ds.init(8);
        ds.union(0, 1);
        ds.union(2, 7);
        System.out.println(ds.areFriend(0, 2));
        ds.union(3, 6);
        ds.union(0, 7);
        System.out.println(ds.areFriend(0, 2));

    }
}