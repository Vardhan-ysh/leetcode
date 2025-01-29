class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        ArrayList<String> currWords = new ArrayList<>();
        int currUsed = 0;

        for (String word : words) {
            int len = word.length();

            if (currUsed + currWords.size() + len <= maxWidth) {
                currWords.add(word);
                currUsed += len;
            } else {
                ans.add(buildWords(currWords, maxWidth - currUsed));
                currWords.clear();
                currWords.add(word);
                currUsed = len;
            }
        }

        if (!currWords.isEmpty()) {
            ans.add(String.join(" ", currWords) + " ".repeat(maxWidth - currUsed - (currWords.size() - 1)));
        }

        return ans;
    }

    static String buildWords(ArrayList<String> currWords, int spaces) {
    if (currWords.size() == 1) {
        return currWords.get(0) + " ".repeat(spaces);
    }

    int gaps = currWords.size() - 1;
    int spaceBetween = spaces / gaps;
    int extraSpaces = spaces % gaps;
    
    StringBuilder justifiedLine = new StringBuilder();
    
    for (int i = 0; i < currWords.size(); i++) {
        justifiedLine.append(currWords.get(i));
        
        if (i < gaps) {
            int spacesToAdd = spaceBetween + (extraSpaces > 0 ? 1 : 0);
            justifiedLine.append(" ".repeat(spacesToAdd));
            extraSpaces--;
        }
    }
    
    return justifiedLine.toString();
}
}
