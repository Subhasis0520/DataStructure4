package tries;

public class UseTrie {
    public static void main(String[] args) {

        Trie t = new Trie();

        t.add("love");
        t.add("friendship");
        t.add("care");
        t.add("attitude");
        t.add("not");
        t.add("now");

        System.out.println(t.search("care"));
        t.remove("love");
        System.out.println(t.search("love"));
        t.remove("noe");
        System.out.println(t.search("not"));
        System.out.println(t.search("noe"));
    }
}
