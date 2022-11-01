import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class wordFrequency {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jayan\\Desktop\\keyBoard\\one-hand-key-board\\rawData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        File file2 = new File("C:\\Users\\jayan\\Desktop\\keyBoard\\one-hand-key-board\\rawDataAllEnglishWords.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String st[] = br.readLine().split(" ");
        String st2[] = br2.readLine().split(" ");
        Scanner s = new Scanner(file);  
        Scanner s2 = new Scanner(file2);

        int n = st.length; 
        int n2 = st2.length; 
        int arr[][] = new int[28][28];
        
        // 

        for(int i=0;i<n;i++)
        {
            String str=" ";
            str += st[i];
            str+=" ";
            str.toLowerCase();
            int prevIdx = 26;
            for(int j=1;j<str.length();j++)
            {
                int idx;
                if(str.charAt(j)==' ') idx=26;
                else if(str.charAt(j)<97||str.charAt(j)>122) idx = 27;
                else idx = str.charAt(j)-'a';
                arr[idx][prevIdx]++;
                prevIdx = idx;
            }
        }
        
        for(int i=0;i<n2;i++)
        {
            String str=" ";
            str += st2[i];
            str+=" ";
            str.toLowerCase();
            int prevIdx = 26;
            for(int j=1;j<str.length();j++)
            {
                int idx;
                if(str.charAt(j)==' ') idx=26;
                else if(str.charAt(j)<97||str.charAt(j)>122) idx = 27;
                else idx = str.charAt(j)-'a';
                arr[idx][prevIdx]++;
                prevIdx = idx;
            }
        }
        ArrayList<ArrayList<Integer>> mostFreq = new ArrayList<>();
        for(int j=0;j<28;j++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(j);
            int count=0;
            for(int k=0;k<28;k++)
            {
                count+=arr[j][k];
            }
            temp.add(count);
            mostFreq.add(temp);
        }
        Collections.sort(mostFreq,(p,q)->p.get(1)-q.get(1));
        ArrayList<ArrayList<String>> list1 = new ArrayList<>();
            for(ArrayList<Integer> k : mostFreq)
            {
                ArrayList<String> temp = new ArrayList<>();
                int o =96+k.get(0);
                char cl = (char)o;
                String sk = Character.toString(cl);
                if(sk.equals("{")) temp.add("space");
                else if(sk.equals("|")) temp.add("misc");
                else temp.add(sk);
                sk=""+k.get(1);
                temp.add(sk);
                list1.add(temp);

            }
            //System.out.println(count);
            System.out.println(list1);
        //System.out.println(mostFreq);
        
        String matrix[][] = new String[28][56];
        int c = 0;
        Path fileName = Path.of( "outputData.txt");
        for(int i=0;i<28;i++)
        {
            ArrayList<ArrayList<Integer>> count = new ArrayList<>();
            for(int j=0;j<28;j++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1+j);
                temp.add(arr[j][i]);
                count.add(temp);
            }
            char convertedChar = (char)(i+97);
            if(convertedChar=='{')
            System.out.println("space : ");
            else if(convertedChar=='|')
            System.out.println("misc : ");
            else  System.out.println(convertedChar +"   : ");
            Collections.sort(count,(q,p)->p.get(1)-q.get(1));
            
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            for(ArrayList<Integer> k : count)
            {
                ArrayList<String> temp = new ArrayList<>();
                int o =96+ k.get(0);
                char cl = (char)o;
                String sk = Character.toString(cl);
                if(sk.equals("{")) temp.add("space");
                else if(sk.equals("|")) temp.add("misc");
                else temp.add(sk);
                sk=""+k.get(1);
                temp.add(sk);
                list.add(temp);

            }
            //System.out.println(count);
           // System.out.println(list);
            System.out.println();
           
        }
        
        
        
        
      
}
}
