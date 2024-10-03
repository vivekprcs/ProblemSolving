package com.vivek.problemsolving;


public class RemoveSpecialCharacters {


    public static void main(String args[]) {
        String str="Pr!ogr#am%m*in&g1 Lan?#guag(e";
         removeCharacters(str);
//        removeCharacters1(str);
//        removeNonAlphanumeric(str);
//          removeUsingInbuilt(str);
    }

    public static void removeCharacters(String input_str) {
        String resultStr = "";
        for (int i=0;i<input_str.length();i++)
        {
            if (input_str.charAt(i)>64 && input_str.charAt(i)<=122)
                //returns true if both conditions returns true
            {
                resultStr=resultStr+input_str.charAt(i);
            }
        }
        System.out.println("output"+resultStr);
    }
    public static void removeCharactersUsingRegex(String input_str) {
        String resultStr = "";
        for (int i=0;i<input_str.length();i++)
        {
            if (input_str.charAt(i)>64 && input_str.charAt(i)<=122) //returns true if both conditions returns true
            {
                resultStr=resultStr+input_str.charAt(i);
            }
        }
        System.out.println("output"+resultStr);
    }

    public static void removeCharacters1(String str){
        char[] s = str.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length; i++) {

            // Store only valid characters
            if ((s[i] >= 'A' && s[i] <= 'Z')
                    || (s[i] >= 'a' && s[i] <= 'z')) {
                s[j] = s[i];
                j++;
            }
        }
        System.out.println(String.valueOf(s).substring(0, j));
    }
    public static void removeNonAlphanumeric(String str){
        // replace the given string with empty string
        // except the pattern "[^a-zA-Z0-9]"
        str = str.replaceAll(
                "[^a-zA-Z0-9]", "");
        System.out.println(str);
    }

    public static void removeUsingInbuilt(String str){
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            boolean b1 = Character.isDigit(str.charAt(i));
            boolean b2 = Character.isAlphabetic(str.charAt(i));
            if (b1 || b2) {
                newstr += str.substring(i, i + 1);
            }
        }
        System.out.println(newstr);
    }
}
