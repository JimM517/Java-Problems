package CodingBat;

import java.util.Map;

public class CodingBat {


    // mapBully
    public Map<String, String> mapBully(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));

            map.put("a", "");
        }

        return map;

    }



    // mapShare
    public Map<String, String> mapShare(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
        }

        map.remove("c");

        return map;

    }


    // mapAb
    public Map<String, String> mapAB(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {

            String abValue = map.get("a") + map.get("b");

            map.put("ab", abValue);
        }
        return map;
    }


    // topping1
    public Map<String, String> topping1(Map<String, String> map) {

        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }
        map.put("bread", "butter");

        return map;



    }



    // topping2
    public Map<String, String> topping2(Map<String, String> map) {
        if (map.get("ice cream") != null) {
            map.put("yogurt", map.get("ice cream"));
        }
        if (map.get("spinach") != null) {
            map.put("spinach", "nuts");
        }


        return map;

    }


    // topping3
    public Map<String, String> topping3(Map<String, String> map) {

        if (map.get("potato") != null) {
            map.put("fries", map.get("potato"));
        }
        if (map.get("salad") != null) {
            map.put("spinach", map.get("salad"));
        }
        return map;

    }


    // mapAB2
    public Map<String, String> mapAB2(Map<String, String> map) {

        if ((map.containsKey("a") && map.containsKey("b")) && (map.get("a").equals(map.get("b")))) {
            map.remove("a");
            map.remove("b");
        }
        return map;

    }


    // mapAB3
    public Map<String, String> mapAB3(Map<String, String> map) {

        if (map.containsKey("a") && !map.containsKey("b")) {
            map.put("b", map.get("a"));
        }

        if (map.containsKey("b") && !map.containsKey("a")) {
            map.put("a", map.get("b"));
        }
        return map;


    }



    // mapAB4 -> NEED TO DOUBLE CHECK THIS
    public Map<String, String> mapAB4(Map<String, String> map) {

        String aVal = map.get("a");
        String bVal = map.get("b");

        if (aVal != null && bVal != null) {
            if (aVal.length() > bVal.length()) {
                map.put("c", aVal);
            } else if (bVal.length() > aVal.length()) {
                map.put("c", bVal);
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        } else if (aVal != null) {
            map.put("c", aVal);
        } else if (bVal != null) {
            map.put("c", bVal);
        }





        return map;
    }










}