
package piglatin;

import java.util.ArrayList;

public class PigLatin {

    public static void main(String[] args) {
        System.out.println(toPig("Apple"));
        System.out.println(getLineWords("I like pie"));
        System.out.println(pigLatin("I like pie"));
    }
    public static String toPig(String word)
    {
        String ret;
        if(word.substring(0,1).equals("A") || word.substring(0,1).equals("E") || word.substring(0,1).equals("I") || 
           word.substring(0,1).equals("O") || word.substring(0,1).equals("U") || word.substring(0,1).equals("a") || 
           word.substring(0,1).equals("e") || word.substring(0,1).equals("i") || word.substring(0,1).equals("o") || 
           word.substring(0,1).equals("u"))
              ret = word + "yay";
        else
            ret = word.substring(1) + word.substring(0,1) + "ay";
        return ret;
    }
    private static ArrayList<String> getLineWords(String line)
    {
        int placehold = 0;
        ArrayList<String> ret = new ArrayList<>();
        for(int i=0;i<line.length();i++)
        {
            if(line.substring(i,i+1).equals(" "))
            {
                ret.add(line.substring(placehold,i));
                placehold = i+1;
            }
            else if(i == line.length()-1)
                ret.add(line.substring(placehold,i+1));
        }
        return ret;
    }
    public static String pigLatin(String line)
    {
        int placehold = 0;
        String ret = "";
        for(int i=0;i<line.length();i++)
        {
            if(line.substring(i,i+1).equals(" "))
            {
                ret+=(toPig(line.substring(placehold,i))+" ");
                placehold = i+1;
            }
            else if(i == line.length()-1)
                ret+=(toPig(line.substring(placehold,i+1))+ " ");
        }
        return ret;
    }
}
