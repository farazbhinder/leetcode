import org.junit.Test;

public class SolutionTestsV2 {

    @Test
    public void test1() {
        "acdb".equals(SolutionV2.removeDuplicateLetters("cbacdcbc"));
    }

    @Test
    public void test2() {
        "adbc".equals(SolutionV2.removeDuplicateLetters("cdadabcc"));
    }

    @Test
    public void test3() {
        "eacb".equals(SolutionV2.removeDuplicateLetters("ecbacba"));
    }

    @Test
    public void test4() {
        "abc".equals(SolutionV2.removeDuplicateLetters("acbac"));
    }


}