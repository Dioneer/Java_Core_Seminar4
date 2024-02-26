package Pegas.task1;

public class Program {
    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n*****Iteration #%d ******\n", i+1);
            processArray(arrayUtils);
        }
    }
    static void processArray(ArrayUtils arrayUtils){
        try {
            System.out.printf("Summ of all elements: %d\n", arrayUtils.processArray(arrayUtils.generateArray()));
        } catch (MyArraySizeException e) {
            System.out.printf("%s the size we need 4x4, but get %dx%d\n", e.getMessage(), e.getX(), e.getY());
        } catch (MyArrayDataException e) {
            System.out.printf("%s bu index [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
