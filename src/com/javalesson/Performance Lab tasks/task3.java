import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//java -jar task3.jar cash

public class task3 {
    public static void main(String[] args) throws IOException {

        ArrayList<Double> arrayList0 = new ArrayList();
        ArrayList<Double> arrayList1 = new ArrayList();
        ArrayList<Double> arrayList2 = new ArrayList();
        ArrayList<Double> arrayList3 = new ArrayList();
        ArrayList<Double> arrayList4 = new ArrayList();

        // 0 файл
        String scr0 = args[0];
        File file0 = new File(scr0 + "\\Cash1.txt");
        //создаем объект FileReader для объекта File
        FileReader fr0 = new FileReader(file0);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader0 = new BufferedReader(fr0);
        // считаем сначала первую строку
        String line0 = reader0.readLine();
        while (line0 != null) {
            arrayList0.add(Double.valueOf(line0));
            // считываем остальные строки в цикле
            line0 = reader0.readLine();
        }

        //1 файл
        File file1 = new File(scr0 + "\\Cash2.txt");
        FileReader fr1 = new FileReader(file1);
        BufferedReader reader1 = new BufferedReader(fr1);
        String line1 = reader1.readLine();
        while (line1 != null) {
            arrayList1.add(Double.valueOf(line1));
            line1 = reader1.readLine();
        }

        //2 файл
        File file2 = new File(scr0 + "\\Cash3.txt");
        FileReader fr2 = new FileReader(file2);
        BufferedReader reader2 = new BufferedReader(fr2);
        String line2 = reader2.readLine();
        while (line2 != null) {
            arrayList2.add(Double.valueOf(line2));
            line2 = reader2.readLine();
        }

        //3 файл
        File file3 = new File(scr0 + "\\Cash4.txt");
        FileReader fr3 = new FileReader(file3);
        BufferedReader reader3 = new BufferedReader(fr3);
        String line3 = reader3.readLine();
        while (line3 != null) {
            arrayList3.add(Double.valueOf(line3));
            line3 = reader3.readLine();
        }

        //4 файл
        File file4 = new File(scr0 + "\\Cash5.txt");
        FileReader fr4 = new FileReader(file4);
        BufferedReader reader4 = new BufferedReader(fr4);
        String line4 = reader4.readLine();
        while (line4 != null) {
            arrayList4.add(Double.valueOf(line4));
            line4 = reader4.readLine();
        }

        //среднее арифметическое
        ArrayList<Double> arrayListAverage = new ArrayList();
        for (int i = 0; i < arrayList0.size(); i++) {
            arrayListAverage.add((arrayList0.get(i) + arrayList1.get(i) + arrayList2.get(i) + arrayList3.get(i) + arrayList4.get(i)) / 5);
        }

        TreeMap<Integer, Double> treeMapAverage = new TreeMap();
        for (int i = 0; i < arrayListAverage.size(); i++) {
            treeMapAverage.put(i, arrayListAverage.get(i));
        }

        treeMapAverage.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .forEach(System.out::println); // или любой другой конечный метод

        final TreeMap<Integer, Double> treeSortedByValues = new TreeMap<Integer, Double>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return treeMapAverage.get(o1).compareTo(treeMapAverage.get(o2));
            }
        });
        treeSortedByValues.putAll(treeMapAverage);

        System.out.println(treeSortedByValues.lastKey());
    }
}
