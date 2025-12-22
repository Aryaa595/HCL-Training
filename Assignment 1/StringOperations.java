public class StringOperations {

    public static void main(String[] args) {

        String s1 = "  Java Programming  ";
        String s2 = "Java";
        String s3 = "Programming";

        // length()
        System.out.println("Length: " + s1.length());

        // isEmpty()
        System.out.println("Is Empty: " + s1.isEmpty());

        // charAt()
        System.out.println("Character at index 2: " + s1.charAt(2));

        // toString()
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("toString(): " + sb.toString());

        // equals()
        System.out.println("Equals: " + s2.equals("Java"));

        // compareTo()
        System.out.println("CompareTo: " + s2.compareTo(s3));

        // contains()
        System.out.println("Contains 'Java': " + s1.contains("Java"));

        // indexOf()
        System.out.println("IndexOf 'a': " + s1.indexOf('a'));

        // lastIndexOf()
        System.out.println("LastIndexOf 'a': " + s1.lastIndexOf('a'));

        // startsWith()
        System.out.println("StartsWith '  Ja': " + s1.startsWith("  Ja"));

        // endsWith()
        System.out.println("EndsWith '  ': " + s1.endsWith("  "));

        // matches()
        System.out.println("Matches letters only: " + s2.matches("[A-Za-z]+"));

        // substring()
        System.out.println("Substring: " + s1.substring(2, 6));

        // toLowerCase()
        System.out.println("Lowercase: " + s1.toLowerCase());

        // trim()
        System.out.println("Trimmed: '" + s1.trim() + "'");

        // replace()
        System.out.println("Replace: " + s1.replace("Java", "Core Java"));

        // split()
        String[] words = s1.trim().split(" ");
        System.out.println("Split words:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", words);
        System.out.println("Joined: " + joined);

        // valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf: " + numStr);
    }
}
