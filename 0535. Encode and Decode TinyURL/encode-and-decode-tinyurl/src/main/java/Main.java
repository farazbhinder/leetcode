public class Main {
    public static void main(String[] args) {

        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
//        System.out.println(codec.encode(url));
//        System.out.println(codec.decode(codec.encode(url)));

        String url1 = "http://airport.example.com/";
        System.out.println(codec.encode(url1));
        System.out.println(codec.decode(codec.encode(url1)));
    }
}
