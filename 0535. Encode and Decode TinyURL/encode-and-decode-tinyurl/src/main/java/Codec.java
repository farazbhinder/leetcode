public class Codec {
    private final Integer OFFSET = 4;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl.charAt(longUrl.length()-1) == '/') {
            return longUrl;
        }
        String[] splitted = longUrl.split("/");
        char[] arr = splitted[splitted.length-1].toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(((int) arr[i]) + OFFSET);
        }
        splitted[splitted.length-1] = new String(arr);
        return String.join("/", splitted);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl.charAt(shortUrl.length()-1) == '/') {
            return shortUrl;
        }
        String[] splitted = shortUrl.split("/");
        char[] arr = splitted[splitted.length-1].toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(((int) arr[i]) - OFFSET);
        }
        splitted[splitted.length-1] = new String(arr);
        return String.join("/", splitted);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));