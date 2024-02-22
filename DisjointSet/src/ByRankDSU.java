class DisjointSetByRank {

    int parent[];
    int rank[];
    int n;

    public void init(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];

        // each node is parent itself
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // each node having rank 0
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
        }
    }

    public void unionByRank(int a, int b) {
        int parA = findParent(a); // find ultimate parent of a
        int parB = findParent(b); // find ultimate parent of b

        // if both having same parent
        if (parA == parB)
            return;

        int rankA = rank[parA];
        int rankB = rank[parB];

        // smaller rank parent elem attach to larger rank parent
        if (rankA < rankB) {
            parent[parA] = parB;
        }

        // smaller rank parent elem attach to larger rank parent
        else if (rankA > rankB){
            parent[parB] = parA;
        }

        // both rank equals => attach anyone and increase rank by 1
        else{
            parent[parB] = parA;
            rank[parA]++;
        }
    }

    public int findParent(int node) {
        // base case
        if (parent[node] == node) {
            return node;
        }

        // path compression step => store the ans if someone ask same question in the future, i'll tell this is the ans without again traversing
        // it reduce time complexity from longN to constant
        return parent[node] = findParent(parent[node]);
    }

    public boolean areFriend(int a, int b) {
        int parA = findParent(a);
        int parB = findParent(b);

        // means belonging to same group
        if (parA == parB)
            return true;

        return false;
    }
}

public class ByRankDSU {

    public static void main(String args[]) {

        DisjointSetByRank ds = new DisjointSetByRank();
        ds.init(8);
        ds.unionByRank(0, 1);
        ds.unionByRank(2, 7);
        System.out.println(ds.areFriend(0, 2));
        ds.unionByRank(3, 6);
        ds.unionByRank(0, 7);
        System.out.println(ds.areFriend(0, 2));
    }

}