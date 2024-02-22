class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];

        for(int i=0; i<26; i++)
            children[i] = null;

        isEnd = false;
    }
}

public class Impl {

   static void insert(TrieNode root, String val){
        TrieNode curr = root;
        for(int i=0; i<val.length(); i++){
            int idx = val.charAt(i) - 'a';

            if(curr.children[idx]==null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }

       curr.isEnd = true;
    }


    static boolean search(TrieNode root, String val){
        TrieNode curr = root;
        for(int i=0; i<val.length(); i++){
            int idx = val.charAt(i) - 'a';

            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.isEnd;
    }


    static boolean searchPrefix(TrieNode root, String val){
        TrieNode curr = root;
        for(int i=0; i<val.length(); i++){
            int idx = val.charAt(i) - 'a';

            if(curr.children[idx]==null){
                return false;
            }



            curr = curr.children[idx];
        }

        return true;
    }


    public static void main(String[] args) {
        String keys[] = {"hello", "took", "and", "random"};

        TrieNode root = new TrieNode();

        for(String key: keys)
            insert(root, key);

        System.out.println(search(root, "hello"));
        System.out.println(search(root, "to"));
        System.out.println(search(root, "dom"));

        System.out.println(searchPrefix(root, "too"));
        System.out.println(searchPrefix(root, "llo"));
    }
}
