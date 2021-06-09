package common;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuntionReadWrite {
    private static final String PATH ="src/data/danhba.csv";
    private static final String COMA =",";
    private static final String HEADER= "numberPhone,group,name,gender,address,birthday,email";
    public static void writeToCsv(List<PhoneBook> list){
        try {
            FileWriter outputStream = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
            bufferedWriter.write(HEADER);
            bufferedWriter.newLine();

            for (PhoneBook phoneBook : list) {
                bufferedWriter.write(phoneBook.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PhoneBook> readFileCsv(){
        List<PhoneBook> list = new ArrayList<>();
        try {
            FileReader inputStream = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               if(line.equals(HEADER)){
                   continue;
               }
                String[] strings = line.split(COMA);
                PhoneBook phoneBook = new PhoneBook(strings[0], strings[1], strings[2], strings[3], strings[4],
                        strings[5], strings[6]);
                list.add(phoneBook);
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

