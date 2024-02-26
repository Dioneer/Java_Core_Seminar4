package Pegas.task1;

import java.util.Random;

public class ArrayUtils {
    private static Random random = new Random();

    public String[][] generateArray(){
        int add = random.nextInt(2);
        String[][] arr = new String[4+add][4+add];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.toString(random.nextInt(10,100));
            }
        }
        if(random.nextInt(3)==0){
            arr[random.nextInt(arr.length)][random.nextInt(arr.length)] = "abc";
        }
        printArray(arr);
        return arr;
    }
    public void printArray(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%s\t", arr[i][j]);
            }
            System.out.println();
        }
    }
    public int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length!=4 || arr[0].length!=4){
            throw new MyArraySizeException("Uncorrect array size", arr.length, arr[0].length);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum+=parseElement(arr[i][j], i,j);
            }}
        
        return sum ;
    }

    private int parseElement(String s, int i, int j) throws MyArrayDataException {
        try{
            return Integer.parseInt(s);
        }catch(NumberFormatException e){
            throw new MyArrayDataException("Uncorrect data format", i ,j);
        }
    }
}
