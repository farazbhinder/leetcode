import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, Integer> months;

    public Solution() {
        months = new HashMap<>();
        months.put("Jan", 1);
        months.put("Feb", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("Jun", 6);
        months.put("Jul", 7);
        months.put("Aug", 8);
        months.put("Sep", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dec", 12);
    }

    public String reformatDate(String date) {
        String[] splitted = date.split(" ");
        return String.format("%s-%02d-%02d", splitted[2], months.get(splitted[1]), Integer.parseInt(splitted[0].substring(0, splitted[0].length() - 2)));
    }
}