import org.junit.Test;

public class SolutionTestsV1 {

    @Test
    public void test1() {
        "acdb".equals(SolutionV1.removeDuplicateLetters("cbacdcbc"));
    }

    @Test
    public void test2() {
        "adbc".equals(SolutionV1.removeDuplicateLetters("cdadabcc"));
    }

    @Test
    public void test3() {
        "eacb".equals(SolutionV1.removeDuplicateLetters("ecbacba"));
    }

    @Test
    public void test4() {
        "bac".equals("bbcaac");
    }
}
