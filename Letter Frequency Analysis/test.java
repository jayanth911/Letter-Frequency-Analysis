import java.util.ArrayList;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i=97;i<133;i++){
            char c = (char)i;
            String s = Character.toString(c);
        ArrayList<String> temp = new ArrayList<>();
        temp.add(s);
        s=""+i;
        temp.add(s);
        list.add(temp);
    }
    System.out.println(list);
}
}