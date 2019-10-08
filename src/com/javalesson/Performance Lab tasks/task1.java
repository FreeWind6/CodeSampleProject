import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//java -jar task1.jar text1.txt

public class task1 {
    public static void main(String[] args) throws IOException {

        ArrayList<Double> arrayList = new ArrayList();

        String fileNameIn = args[0];

        File file = new File(fileNameIn);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            arrayList.add(Double.valueOf(line));
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
//90 перцентиль
        System.out.println("What is percentile?");
//медиана
        if (arrayList.get(arrayList.size() / 2) % 2 != 0) {
            System.out.printf("%.2f", arrayList.get(arrayList.size() / 2));
        } else {
            System.out.printf("%.2f", (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2);
        }

        Collections.sort(arrayList);
//максимальное значение
        System.out.println();
        System.out.printf("%.2f", arrayList.get(arrayList.size() - 1));
//минимальное значение
        System.out.println();
        System.out.printf("%.2f", arrayList.get(0));
//среднее значение
        System.out.println();
        double average = 0;
        if (arrayList.size() > 0) {
            double sum = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                sum += arrayList.get(j);
            }
            average = sum / arrayList.size();
            System.out.printf("%.2f", average);
        }
    }
}