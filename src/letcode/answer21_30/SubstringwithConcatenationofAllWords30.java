package letcode.answer21_30;

import java.util.*;

//给一个String s,给一个包含相同长度的char[] chars,
public class SubstringwithConcatenationofAllWords30 {

    //words中不含重复的字符串，，，❎
    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) return list;
        int lll = words[0].length();
        for (String str : words) {
            map.put(str, 0);
        }
        for (int i = 0; i < s.length() - lll * words.length; i++) {
            int j = 0;
            String tem = s.substring(lll * j + i, lll * j + lll + i);
            while (map.containsKey(tem)) {
                if (map.get(tem) != 0) {
                    map.put(tem, -1);
                } else {
                    map.put(tem, 1);
                }
                j++;
                tem = s.substring(lll * j + i, lll * j + lll + i);
                if (j == map.size() && !map.containsValue(-1)) {
                    list.add(i);
                    break;
                } else if (j == map.size() && map.containsValue(-1)) {
                    break;
                }
            }
            if (j != 0) {
                for (String str : words) {
                    map.put(str, 0);
                }
            }
        }
        return list;
    }

    //words中含重复，用数组
    public List<Integer> findSubstring3(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        if (words.length == 0) return list;
        int length = words[0].length();
        int[] ints = new int[words.length];

        for (int i = 0; i <= s.length() - words.length * length; i++) {
            int j = 0;
            String tem = s.substring(j * length + i, (j + 1) * length + i);
            while (j < words.length) {
                if (fuzhu(ints, tem, words)) {
                    if (j == words.length - 1 && fuzhu1(ints)) {
                        list.add(i);
                        fuzhu2(ints);
                        break;
                    }
                    j++;
                    tem = s.substring(j * length + i, (j + 1) * length + i);
                }else {
                    if(j!=0){
                        fuzhu2(ints);
                    }
                    break;
                }
            }
        }
        return list;
    }

    private boolean fuzhu(int[] ints, String tem, String[] words) {
        for (int m = 0; m < words.length; m++) {
            if (ints[m] == 1) {
                continue;
            }
            if (tem.equals(words[m])) {
                ints[m] = 1;
                return true;
            }
        }
        return false;
    }

    private boolean fuzhu1(int[] ints) {
        for (int i : ints) {
            if (i != 1) return false;
        }
        return true;
    }

    private void fuzhu2(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 0;
        }
    }


    public List<Integer> findSubstring2(String s, String[] words) {
        if (s == null || s.length() == 0 || words.length == 0) return new ArrayList<>();

        int start = 0, runIdx = start;
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length(), totalWordChars = wordLen * words.length;
        Map<String, Integer> map = getWordsMap(words);

        while (runIdx + wordLen <= s.length()) {
            // find the matching word from the words list
            String wordToMatch = s.substring(runIdx, runIdx + wordLen);
            if (map.get(wordToMatch) != null && map.get(wordToMatch) > 0) {
                map.put(wordToMatch, map.get(wordToMatch) - 1);
                runIdx += wordLen;
            } else {
                // word not found or the same word is found but more than once
                // Only reset/unmatch the words occured before the word not found (exclucive)
                for (int j = start; j + wordLen <= runIdx; j = j + wordLen) {
                    int count = map.get(s.substring(j, j + wordLen));
                    map.put(s.substring(j, j + wordLen), count + 1);
                }
                start += 1; //we increment by once char, in case the char after that matches
                runIdx = start;
                continue;
            }

            // checks if current chars have hit the chars to be matched
            if (runIdx - start == totalWordChars) {
                for (String key : map.keySet()) {
                    if (map.get(key) != 0) continue;
                }

                // everything is visited
                result.add(start);
                start += 1;
                runIdx = start;
                // Reset the map
                map = getWordsMap(words);
            }
        }
        return result;
    }

    // Returns the map of the words, with counts as the num of occurence in the words array
    // counts later serve the purpose of the word being visited
    // count 0 all occurences have been visited, >1 means atleast 1 is yet to visit
    public Map<String, Integer> getWordsMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String[] ss = new String[]{"aa", "aa"};

        List<Integer> list = new SubstringwithConcatenationofAllWords30().findSubstring3(s, ss);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
