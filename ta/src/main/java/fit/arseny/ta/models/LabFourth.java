package fit.arseny.ta.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class LabFourth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Integer totalCountOfWords;
    private Integer countUniqueWords;
    private String top8FrequentWordsByString;
    private Integer amountWordsWithCharX;
    private Integer amountWordsWith3differerentChars;
    private String three_3_letters_sequences;

    public LabFourth() {

    }

    public LabFourth(String input_text){
        this.text = input_text;
//        this.totalCountOfWords = countTotalAmountOfWords();
//        this.countUniqueWords = countAmountOfUniqueWords();
//        List<String> top8FrequentWords = countTop8FrequentWords();
//        this.top8FrequentWordsByString = String.join(",", top8FrequentWords);
//        this.amountWordsWithCharX = countAmountWordsWithoutCharX();
//        this.amountWordsWith3differerentChars = countAmountWordsWith3differerentChars();
//        List<String> tmp = countTop3ThreeLeterSequencesWords();
//        this.three_3_letters_sequences = String.join(",", tmp);
    }

    public Integer countTotalAmountOfWords(){
        String trim = this.text.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split("\\s+").length;
    }

    public Integer countAmountOfUniqueWords(){
        String[] words = this.text.split(" ");
        boolean[] array = new boolean[words.length];
        int j, i = 0;
        int count = 0;
        for (i = 0; i < words.length; i++) {
            if (!array[i]) {
                count++;
                for (j = i + 1; j < words.length; j++){
                    if (words[j].compareTo(words[i]) == 0){
                        array[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public List<String> countTop8FrequentWords() {
        String[] words = text.split(" ");
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, 8);
    }

    public Integer countAmountWordsWithoutCharX(){
        Integer count = 0;
        String[] words = text.split(" ");

        for (String word : words) {
            if(!word.contains("x")){
                count += 1;
            }
        }

        return count;
    }

    private int getUniqeCount(String word){
        ArrayList<Character> unique = new ArrayList<Character>();
        for( int i = 0; i < word.length(); i++)
            if( !unique.contains( word.charAt( i ) ) )
                unique.add( word.charAt( i ) );
        return unique.size();
    }

    public Integer countAmountWordsWith3differerentChars(){
        Integer count = 0;
        String[] words = text.split(" ");

        for (String word: words){
            if(getUniqeCount(word) == 3){
                count += 1;
            }
        }

        return count;
    }

    public List<String> countTop3ThreeLeterSequencesWords(){
        String[] words = text.split(" ");
        List<String> three_chars_arr = new ArrayList<>();

        for (String word: words){
            if(word.length() >= 3){
                three_chars_arr.add(word.substring(0,3));
            }
        }

        Map<String, Integer> count = new HashMap();
        for (String word : three_chars_arr) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, 3);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTotalCountOfWords() {
        return totalCountOfWords;
    }

    public Integer getCountUniqueWords() {
        return countUniqueWords;
    }

    public String getTop8FrequentWordsByString() {
        return top8FrequentWordsByString;
    }

    public Integer getAmountWordsWithCharX() {
        return amountWordsWithCharX;
    }

    public Integer getAmountWordsWith3differerentChars() {
        return amountWordsWith3differerentChars;
    }

    public String getThree_3_letters_sequences() {
        return three_3_letters_sequences;
    }


///////////////////////////

    public void setTotalCountOfWords() {
        this.totalCountOfWords = countTotalAmountOfWords();
    }

    public void setCountUniqueWords() {
        this.countUniqueWords = countAmountOfUniqueWords();
    }

    public void setTop8FrequentWordsByString() {
        List<String> top8FrequentWords = countTop8FrequentWords();
        this.top8FrequentWordsByString = String.join(",", top8FrequentWords);
    }

    public void setAmountWordsWithCharX() {
        this.amountWordsWithCharX = countAmountWordsWithoutCharX();
    }

    public void setAmountWordsWith3differerentChars() {
        this.amountWordsWith3differerentChars = countAmountWordsWith3differerentChars();
    }

    public void setThree_3_letters_sequences() {
        List<String> tmp = countTop3ThreeLeterSequencesWords();
        this.three_3_letters_sequences = String.join(",", tmp);
    }
}
