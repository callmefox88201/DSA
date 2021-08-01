package FinalExam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Q2_2020 {
    public static long size(File file) {
        if (!file.isDirectory())
            return file.length();
        File[] fs = file.listFiles();
        long size = 0;
        for (File f : fs)
            if (f.isDirectory())
                size += size(f);
            else
                size += f.length();
        return size;
    }

    public static List<String> ls(File file) {
        File[] fs = file.listFiles();
        List<File> list = new ArrayList<>();
        for (File f : fs)
            if (!f.isDirectory())
                list.add(f);
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).length() < list.get(j).length()) {
                    File f = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, f);
                }
        List<String> name = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            name.add(list.get(i).getName());
        return name;
    }

    public static void main(String[] args) {
        System.out.println(size(new File("src/FinalExam")));
        List<String> list = ls(new File("src/FinalExam"));
        for (String name : list)
            System.out.print(name + " ");
    }
}
