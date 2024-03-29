package demo11;
import java.io.*;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/29  15:23
 */
import java.util.Arrays;

public class test02 {



        public static void main(String[] args) {
            String inputFilePath = "txt/开发00.txt";
            String outputFilePath = "txt/开发.txt";

            try {
                addLineNumbers(inputFilePath, outputFilePath);
                System.out.println("行号添加完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void addLineNumbers(String inputFilePath, String outputFilePath) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                String numberedLine = lineNumber + ". " + line;
                writer.write(numberedLine);
                writer.newLine();
                lineNumber++;
            }

            reader.close();
            writer.close();
        }
    }


