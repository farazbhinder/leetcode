public class Main {

    // 316. Remove Duplicate Letters

    public static void main(String[] args) {
//        String result = SolutionV1.removeDuplicateLetters("cbacdcbc"); // answer should be acdb
//        String result = SolutionV1.removeDuplicateLetters("cdadabcc"); // answer should be adbc
//        String result = SolutionV1.removeDuplicateLetters("ecbacba"); // answer should be eacb
//        String result = SolutionV1.removeDuplicateLetters("bbcaac"); // answer should be bac
//        String result = SolutionV1.removeDuplicateLetters("bcabc"); // answer should be abc
//        String result = SolutionV1.removeDuplicateLetters("thesqtitxyetpxloeevdeqifkz"); // time limit exceeded -> hesitxyplovdqfkz
//        String result = SolutionV1.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"); // time limit exceeded

        String result = SolutionV2.removeDuplicateLetters("thesqtitxyetpxloeevdeqifkz");
//        String result = SolutionV2.removeDuplicateLetters("abacb"); // abc
//        String result = SolutionV2.removeDuplicateLetters("acbac"); // abc

        System.out.println(result);
    }
}
