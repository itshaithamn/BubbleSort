import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Welcome to the BubbleSort sorter!\nPlease tpye a number if you would like to excute the bubble sort fucntion to:\n\t1. Write random integers to a file and sort\n\t2. Read inegers from a file and sort\nEnter here: ");
        int userIn = input.nextInt();
        switch(userIn){
            case 1:
                System.out.print("Enter the amount of numbers you would like to generate: ");
                int size = input.nextInt();
                int[] array = createRandomArray(size);
                bubbleSort(array);
                String sysfile = "file.txt";
                writeFileToArray(sysfile, array);
                break;
            case 2:
                System.out.println("The sorted integers of file.txt are: ");
                int[] array2 = readFileToArray("file.txt");
                for(int i = 0; i < array2.length; i++){
                    System.out.print(array2[i] + " ");
                }
                break;
        }
        input.close();
    }

    public static void writeFileToArray(String filename, int[] array) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for(int i = 0; i < array.length; i++){
            writer.write(array[i] + " ");
        }
    
        writer.close();
    }
    
    public static int[] readFileToArray(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        String[] strs = line.trim().split("\\s+");
        int n = strs.length;
        int[] array = new int[n];
 
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(strs[i]);
        }

        bubbleSort(array);

        reader.close();
        return array;
    }

    public static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] createRandomArray(int arrayLength){
        int[] array = new int[arrayLength];
        Random random = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(0, 100);
        }

        return array;
    }
}