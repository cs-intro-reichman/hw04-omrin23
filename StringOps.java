public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // System.out.println(capVowelsLowRest("vowels are fun"));
        // System.out.println(camelCase(word));
        String word = "MMMM";
        char chr = 'M';
        int[] indexes = allIndexOf(word, chr);
        for (int i = 0; i < indexes.length; i++) {
            System.out.println(indexes[i]);
        }
    }

    //returns the index of c in the given array
    //if c is not in array, returns -1
    public static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    //returns if a char is lower case
    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    //returns if a char is upper case
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    //returns the lower case of a char
    public static char lowerCase(char c) {
        return (char) ( c + 32) ;
    }

    //returns the upper case of a char
    public static char upperCase(char c) {
        return (char) ( c - 32) ;
    }

    //if a char is one of (a,e,i,o,u) than it's uppercased
    //any other char is lowercased
    public static String capVowelsLowRest (String string) {

        char[] vowels = new char[] {'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'};
        String newStr = "";

        for (int i = 0; i < string.length(); i++) {
            if (indexOf(vowels, string.charAt(i)) != -1) {
                if (isLowerCase(string.charAt(i))) {
                    newStr += upperCase(string.charAt(i));
                }
                else {
                    newStr += string.charAt(i);
                }
            }
            else if (string.charAt(i) == ' ') {
                newStr += string.charAt(i);
            }
            else {
                if (isUpperCase(string.charAt(i))) {
                    newStr += lowerCase(string.charAt(i));
                }
                else {
                    newStr += string.charAt(i);
                }
            }
        }
        
        return newStr;
    }

    //returns the first index after a space in
    //the given string
    public static int indexAfterSpace(String string) {

        int firstIndex = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) != ' ') {
                firstIndex = i;
                break;
            }
        }

        return firstIndex;
    }

    //returns the first index of a space in
    //the given string
    public static int indexTillSpace(String string) {

        int firstIndex = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == ' ') {
                firstIndex = i;
                break;
            }
        }

        return firstIndex;
    }

    //returns lower case string
    public static String lowerCaseWord(String string) {
        String lowerCaseStr = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return lowerCaseStr;
            }
            
            if (isUpperCase(string.charAt(i))) {
                lowerCaseStr += lowerCase(string.charAt(i));
            }
            else {
                lowerCaseStr += string.charAt(i);
            }
        }

        return lowerCaseStr;
    }

    //returns first letter upper case than lower case string
    public static String firstUpperThanlowerWord(String string) {
        
        String lowerCaseStr = "";
        if (string.length() > 0) {

            if (isLowerCase(string.charAt(0))) {
                lowerCaseStr += upperCase(string.charAt(0));
            }
            else {
                lowerCaseStr += string.charAt(0);
            }

            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == ' ') {
                    return lowerCaseStr;
                }

                if (isUpperCase(string.charAt(i))) {
                    lowerCaseStr += lowerCase(string.charAt(i));
                }
                else {
                    lowerCaseStr += string.charAt(i);
                }
            }

            return lowerCaseStr;
        }

        return lowerCaseStr;
    }

    //returns the number of words in a string
    public static int numOfWordsInString(String string) {

        int count = 1;
        boolean isWord = true;

        string = string.substring(indexAfterSpace(string), string.length());

        for (int i = 0; i < string.length(); i++) {
            if (isWord) { 
                if (string.charAt(i) == ' ') {
                    count++;
                    isWord = false;
                }
            }
            if (!isWord) {
                if (string.charAt(i) != ' ') {
                    isWord = true;
                }
            }
        }
        
        return count;
    }

    public static String[] wordsInString(String string) {

        String[] words = new String[numOfWordsInString(string)];

        for (int i = 0; i < words.length; i++) { 
            words[i] = "";
        }

        int wordsIndex = 0;
        boolean isWord = true;

        string = string.substring(indexAfterSpace(string), string.length());

        for (int i = 0; i < string.length(); i++) {
            if (isWord) { 
                if (string.charAt(i) == ' ') {
                    isWord = false;
                    wordsIndex++;
                }
                else {
                    words[wordsIndex] += string.charAt(i);
                }
            }
            if (!isWord) {
                if (string.charAt(i) != ' ') {
                    isWord = true;
                    words[wordsIndex] += string.charAt(i);
                }
            }
        }
        
        return words;
    }

    //returns the camel case of a string
    public static String camelCase (String string) {
        
        String camelCaseStr = "";
        String[] words = wordsInString(string);

        camelCaseStr += lowerCaseWord(words[0]);

        for  (int i = 1; i < words.length; i++) {
            camelCaseStr += firstUpperThanlowerWord(words[i]);
        }
        
        return camelCaseStr;
    }

    //calculates how many times chr appears in string
    public static int countChrInString (String string, char chr) {
        
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    //returns the indexes of chr appears in string
    public static int[] allIndexOf (String string, char chr) {
        
        int[] indexes = new int[countChrInString(string, chr)];
        int currentIndex = 0;

        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                indexes[currentIndex] = i;
                currentIndex++;
            }
        }

        return indexes;
    }
}
