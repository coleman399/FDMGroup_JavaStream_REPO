

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws Exception {
        ThreadManager threadManager = new ThreadManager();
        ThreadManagerChild threadManagerChild = new ThreadManagerChild();
        AverageCalculator averageCalculator = new AverageCalculator();
        String testFileLocation = "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\testFile.txt";
        MyRunnable runnable = new MyRunnable("testFile");
        FileReaderThread fileReaderThread = new FileReaderThread(averageCalculator, testFileLocation, runnable);
        Random rand = new Random();
        int upperLimit = 5;
        int randomNumber = rand.nextInt(upperLimit);

        threadManager.createThreads(randomNumber);
        threadManagerChild.createThreads(randomNumber);

        try {
            File file1 = new File(
                    "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\file1.txt");
            File file2 = new File(
                    "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\file2.txt");
            File file3 = new File(
                    "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\file3.txt");
            File file4 = new File(
                    "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\file4.txt");
            File testFile = new File(testFileLocation);
            FileWriter writeInFile1 = new FileWriter(file1);
            FileWriter writeInFile2 = new FileWriter(file2);
            FileWriter writeInFile3 = new FileWriter(file3);
            FileWriter writeInFile4 = new FileWriter(file4);
            FileWriter writeInTestFile = new FileWriter(testFile);
            writeInFile1.write("3,7");
            writeInFile2.write("5,1,6");
            writeInFile3.write("9,8");
            writeInFile4.write("2,4,10");
            writeInTestFile.write("3,7,5,1,6,9,8,2,4,10");
            writeInFile1.close();
            writeInFile2.close();
            writeInFile3.close();
            writeInFile4.close();
            writeInTestFile.close();
            System.out.println("files created");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        fileReaderThread.start();
        fileReaderThread.join();

        System.out.println("total: " + fileReaderThread.getTotal());
        System.out.println("count: " + fileReaderThread.getCount());
        System.out.println("average: " + fileReaderThread.calculateAverage());

    }
}
