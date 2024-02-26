package Pegas.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        prepareFile();
        try {
            Map<String, Integer> map = loadFile();
            for (Map.Entry<String, Integer>i: map.entrySet()){
                System.out.println(i);
            }
        } catch (LoadFileProcessException e) {
            System.out.println(e.getMessage());
            System.out.println("In line "+e.getCounter());
            System.out.println("Expected int or \"?\", get "+e.getLine());
        }
    }
    static Map<String, Integer> loadFile() throws LoadFileProcessException {
        String line;
        int counter = 0;
        Map<String, Integer> map=new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("name.txt"))){
            while ((line=br.readLine())!= null){
                counter++;
                String[] lines = line.split("=");
                try{
                    map.put(lines[0], lines[1].length()==1&&lines[1].charAt(0)=='?'?lines[0].length(): Integer.parseInt(lines[1]));
                }catch (NumberFormatException e) {
                    throw new LoadFileProcessException("Exception of convert", counter, lines[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    static void prepareFile(){
        try(FileWriter fw = new FileWriter("name.txt", false)) {
            fw.write("Anna=4\n");
            fw.write("Elena=5\n");
            fw.write("Marina=6\n");
            fw.write("Bladimir=8\n");
            fw.write("Konstantnin=?\n");
            fw.write("Ivan=4\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
