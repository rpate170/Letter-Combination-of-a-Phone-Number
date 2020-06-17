class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Integer, String> combination = new HashMap<>();
        combination.put(2, "abc");
        combination.put(3, "def");
        combination.put(4, "ghi");
        combination.put(5, "jkl");
        combination.put(6, "mno");
        combination.put(7, "pqrs");
        combination.put(8, "tuv");
        combination.put(9, "wxyz");
        
        List<String> list = new ArrayList<>();
	    char[] letters = new char[digits.length()];
	    recrsv(digits, 0, combination, list, letters);
	    return list;
        
    }
    
    public void recrsv (String digits, int index, Map<Integer, String> combination, List<String> list, char[] letters) {
        if (index == digits.length()) {
            list.add(String.valueOf(letters));
            return;
        }
        
        int digit = Character.getNumericValue(digits.charAt(index));
        String s = combination.get(digit);
        
        for (int i = 0; i < s.length(); i++) {
            letters[index] = s.charAt(i);
            recrsv(digits, index+1, combination, list, letters);
        }
    }
}