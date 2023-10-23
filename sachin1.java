import java.io.*;
import java.util.ArrayList;

class sachin1{
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> wordslist = null;
        int count=2;
        try {
            FileReader ff = new FileReader("D:\\input\\text.txt");
            BufferedReader br = new BufferedReader(ff);
            wordslist = new ArrayList<>();
            String word = br.readLine();
            while (word != null) {
                wordslist.add(word);
                word = br.readLine();
            }
            br.close();
        } catch (IOException e) {
        }
        wordslist.sort((a, b) -> Integer.compare(b.length(), a.length()));
        for (String word : wordslist){
            boolean check = checkcompound(word,wordslist);
            if(check&&count==2){
                --count;
                System.out.println("Longest Compound Word : "+word);

            }
            else if(check&&count==1){
                System.out.println("Second Longest Compound Word : "+word);
                break;
            }
        }
    }

    public static boolean checkcompound(String word,ArrayList <String> wordslist) {
        for (int i = 1; i < word.length(); i++) {
            String a = word.substring(0, i);
            String b = word.substring(i);
            if (wordslist.contains(a) && (wordslist.contains(b) || checkcompound(b, wordslist))) {
                return true;
            }
        }
        return false;
}
}