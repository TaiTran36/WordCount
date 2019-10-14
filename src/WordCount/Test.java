package WordCount;
import java.util.LinkedList;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Scanner;
public class Test {
    static String regex_start = "^[[a-zA-Z]|(á|ạ|à|ả|ã|Á|Ạ|À|Ả|Ã|ă|ắ|ằ|ẳ|ặ|ẵ|Ă|Ắ|Ằ|Ẳ|Ặ|Ẵ|â|ấ|ầ|ẩ|ẫ|ậ|Â|Ấ|Ầ|Ẩ|Ẫ|Ậ|é|ẹ|è|ẻ|ẽ|É|Ẹ|È|Ẻ|Ẽ|ê|ề|ế|ể|ệ|ễ|Ê|Ế|Ề|Ể|Ệ|Ễ|í|ì|ỉ|ị|ĩ|Í|Ĩ|Í|Ị|Ỉ|ó|ò|ỏ|ọ|õ|Ó|Ò|Ỏ|Õ|Ọ|ô|ố|ồ|ổ|ộ|Ô|Ố|Ồ|Ổ|Ộ|Ỗ|ơ|ớ|ờ|ợ|ỡ|ở|Ơ|Ớ|Ờ|Ở|Ợ|Ỡ)]+.*";
    static String regex = "[?|!|:|}|{|\\]|\\[|\\+|=|@|#|$|%|^|&|*|\\(|\\)|.|,|;|'|\"|~|`|€|£|¥|€|©|®|™|±|≠|∞|µ|α|β|π|Ω|∑|≤|≥|÷|×]*";
    static ArrayList<String> words = new ArrayList<>();
    static LinkedList<WordCount> wl = new LinkedList<WordCount>();
    public static void readFile(String fileName){
        try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){
            stream.forEach(line ->{
                line = line.trim();
                String [] w = line.split(" ");
                for (String s: w) {
                    if(!s.isEmpty()){
                        s = s.replaceAll(regex,"");
                        words.add(s);
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void wordCount(ArrayList<String> words){


        for (int i = 0; i < words.size(); i++) {
//            WordCount w = new WordCount(words.get(i));
//            int id = wl.indexOf(w);
//            if (id == -1) {
//                wl.add(w);
//            } else {
//                wl.get(id).upCount();
//            }
            if(words.get(i).matches(regex_start)) {

                WordCount w = new WordCount(words.get(i));
                int id = wl.indexOf(w);
                if (id == -1) {
                    wl.add(w);
                } else {
                    wl.get(id).upCount();
                }
            }
        }

        for (int i = 0; i < wl.size() - 1; i++)
            for (int j = i + 1; j < wl.size(); j++) {
                if (wl.get(i).getCount() < wl.get(j).getCount()) {
                    WordCount wi = wl.get(i).clone();
                    WordCount wj = wl.get(j).clone();
                    wl.set(i, wj);
                    wl.set(j, wi);
                }
            }

//        for (WordCount w : wl) {
//            System.out.println(w);
//        }
    }
    public static void checkKeyWord(){
        String result = "";
        int count =0;
        System.out.println("Nhập từ khoá cần tìm: ");
        Scanner sc = new Scanner(System.in);
        String keyWord = sc.nextLine();
        for (int i=0;i<wl.size();i++){

        }
        for (WordCount w : wl) {
            if(w.getWord().equals(keyWord)){
                result = "Từ "+keyWord+" được tìm thấy trong file. ";
                count = w.getCount();
            }
        }
        if(result != ""){
            System.out.println(result);
            System.out.println("Số lần xuất hiện: "+count);
        }
        else{
            System.out.println("Không tìm thấy từ trong file");
        }
    }
    public static void main(String[] args) {
        readFile("C:\\Users\\trant\\OneDrive\\Máy tính\\test.txt");
        wordCount(words);
        checkKeyWord();
//        String w = "123;'";
//        System.out.println(w.replaceAll(regex,""));
    }

}
