package util;

public class Util { //the utilities

    /**
     * takes a string and returns it in title case
     *
     * @param str the given string that needs to be title cased
     * @return the initial string but in title case
     */
    public static String toTitleCase(String str) {
        //assuming all words in str have space, use str.split() so to cut at every space and take word
        if (str == null || str.isEmpty()) { //handle weird cases
            return str;
        }

        String[] words = str.split(" "); //to take the words separated by space and store them in array

        for (int i = 0; i < words.length; i++) { //title cases the words one by one
            if (words[i].length() == 1) { //if word is just a letter -> issue with substring(1) so to avoid that
                words[i] = words[i].toUpperCase();
            } else { //dealing with words that have at least two letters
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
        }

        return String.join(" ", words); //contrary of split() to put back the title cased words together with spaces
    }
}
