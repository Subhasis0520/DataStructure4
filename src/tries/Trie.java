package tries;


class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}


public class Trie {

    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }


    private void addHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        addHelper(child, word.substring(1));

    }

    public void add(String word) {
        addHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word) {
        //first check the base case if the word exists last character will have isTerminatinf true else false
        //lets check for the last character first
        if (word.length() == 0) {
            return root.isTerminating; //here root is the last character since it changes on every call
        }
        int childIndex = word.charAt(0) - 'a'; //we assume all words to be small
        TrieNode child = root.children[childIndex];
        //if child is not present it will give null, means the word does not exist
        if (child == null) {
            return false;
        }
        return searchHelper(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    public void remove(String word) {
        removeHelper(root, word);
    }

    private void removeHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return;
        }
        removeHelper(child, word.substring(1));

        if (!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            child.childCount--;

        }
    }
}



