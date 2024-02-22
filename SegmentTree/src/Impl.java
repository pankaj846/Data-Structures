public class Impl {

    static int arr[];
    static int segTree[];

    public static void build(int nodeIdx, int low, int high){

        // leaf node => contains array elements
        if(low==high){
            segTree[nodeIdx] = arr[low];
            return;
        }

        int mid = (low+high) >> 1;
        build(2*nodeIdx + 1, low, mid); // left
        build(2*nodeIdx+2, mid+1, high); // right

        // Post call => after returning left and right
        // current node have sum of both its children
        segTree[nodeIdx] = segTree[2*nodeIdx+1] + segTree[2*nodeIdx+2];
    }

//     three conditions:
//    1. completely overlap
//    2. partially overlap
//    3. No overlap

    public static int query(int nodeIdx, int low, int high, int l, int r){

        // completely overlap
        if(low>=l && high<=r){
            return segTree[nodeIdx];
        }

        // no overlap
        if(low>r || high<l){
            return 0;
        }

        // partially overlap

        int mid = (low+high) >> 1;
        int left = query(2*nodeIdx+1, low, mid, l, r);
        int right = query(2*nodeIdx+2, mid+1, high, l, r);

        return left+right;

    }

    public static void update(int nodeIdx, int low, int high, int idx, int val){

        // left node, automatically hit to the target node
        if(low==high){
            segTree[nodeIdx] += val;
            arr[low] += val;
            return;
        }

        int mid = (low+high) >> 1;

        // idx is on left child
        if(idx <= mid){
            update(2*nodeIdx+1, low, mid, idx, val);
        }

        // idx on right child
        else{
            update(2*nodeIdx+2, mid+1, high, idx, val);
        }

        // post call => current node have sum of both its children
        segTree[nodeIdx] = segTree[2*nodeIdx+1] + segTree[2*nodeIdx+2];
    }

    public static void main(String[] args) {

        arr = new int[] {2, 4, 7, 2, 3, 8, 5, 1};
        int n = arr.length;

        segTree = new int[4*n+1];

        build(0, 0, n-1);
        int ans = query(0, 0, n-1, 2, 5);
        System.out.println(ans);

        update(0, 0, n-1, 3, 8);

        int ans2 = query(0, 0, n-1, 2, 5);
        System.out.println(ans2);

    }
}

