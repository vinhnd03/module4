package com.vinhnd.ung_dung_muon_sach.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileUtil {
    private final static String PATH = "D:/CodeGym_DN/module4/ss9_aop_exception_handler/logger.txt";

    // phương thức ghi
    public static void writeFile(String string) {
        File file = new File(PATH);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


//    public List<Product> readFile(String path) {
//        List<Product> products = new ArrayList();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//                    int id = Integer.parseInt(parts[0].trim());
//                    String name = parts[1].trim();
//                    long price = Long.parseLong(parts[2].trim());
//                    products.add(new Product(id, name, price));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//
//    public void writeFile(String path, Product product) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
//            writer.newLine();
//            writer.write(product.getId() + "," + product.getName() + "," + product.getPrice());
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void writeFile(String path, List<Product> products) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
//            for (Product product : products) {
//                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice());
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

