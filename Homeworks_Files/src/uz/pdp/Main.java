package uz.pdp;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException {
       File file=new File("./2022");
       file.mkdir();
       File file1;
        LocalDate date1=LocalDate.of(2022, 1, 1);
        LocalDate date2=LocalDate.of(2022, 1, 1);
        for (int i = 0; i < 12; i++) {
            file=new File("2022/"+date1.getMonth());
            file.mkdir();
            while (date2.isBefore(date1.plusMonths(1))){
                file1=new File("2022/"+date1.getMonth()+"/"+date2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+".txt");
                PrintWriter writer=new PrintWriter(file1);
                writer.println(date2);
                writer.flush();
                writer.close();
                date2=date2.plusDays(1);
            }
            date1=date1.plusMonths(1);
        }
    }








//    private static void writeInThirdFile(File file1, File file2, File file3){
//        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
//        BufferedReader reader2=new BufferedReader(new FileReader(file2));
//        PrintWriter writer=new PrintWriter(file3);
//        ) {
//            String s1="";
//            String s2="";
//            while (true){
//
//                s1= reader1.readLine();
//                s2= reader2.readLine();
//                if (s1==null&&s2==null){break;}
//                if (s1==null){s1="";}
//                if (s2==null){s2="";}
//
//                writer.println(s1+" = "+s2);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    private static String findLongestWord(File file){
//        String longetsWord="";
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String s;
//            while ((s= reader.readLine())!=null){
//                if (s.length()>longetsWord.length()){
//                    longetsWord=s;
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return longetsWord;
//    }


//    private static int findNumberOfLines(File file){
//        int sum=0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String s;
//            while ((s= reader.readLine())!=null){
//                sum++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return sum;
//    }

//    private static void hasThisText(File file, String text){
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (File file1 : files) {
//                if (file1.isFile()) {
//                    if (file1.getName().contains(text)){
//                        System.out.println(file1.getName());
//                    }
//                }else {
//                    if (file1.getName().contains(text)){
//                        System.out.println(file1.getName());
//                    }
//                    hasThisText(file1, text);
//                }
//            }
//        }else {
//            System.out.println("Berilgan file papka emas.");
//        }
//    }

//    private static void hasFileOrFolde(Path path){
//        int numberOfFiles=0;
//        int numberOfFolders=0;
//        File file=new File(String.valueOf(path));
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (File file1 : files) {
//                if (file1.isFile()) {
//                    numberOfFiles++;
//                }
//                if (file1.isDirectory()) {
//                    numberOfFolders++;
//                }
//            }
//            if (numberOfFiles == 0 && numberOfFolders == 0) {
//                System.out.println("Papka bo`sh");
//            }
//            if (numberOfFiles > 0 && numberOfFolders == 0) {
//                System.out.println("Filelar bor");
//            }
//            if (numberOfFiles == 0 && numberOfFolders > 0) {
//                System.out.println("Papkalar bor");
//            }
//        }
//        System.out.println("Berilgan pathda papka emas file mavjud");
//    }


//    private static void isFileOrFolder(Path path){
//        File file=new File(String.valueOf(path));
//        if (file.isFile()) {
//            System.out.println("This is a file");
//        }
//        if (file.isDirectory()) {
//            System.out.println("This is a folder");
//        }
//    }


}
