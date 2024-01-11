package dal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    public <T> boolean loadDataFromFile(List<T> list, String fileName) {
        list.clear();
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try {
            InputStream is = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(is);
            
            while(true){
                try {
                    T c = (T) ois.readObject();
                    list.add(c);
                } catch (Exception e) {
                    break;
                }
            }
            ois.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public <T> boolean saveDataToFile(List<T> list, List<T> list2, String fileName, String msg) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("File not exist!");
            return false;
        }
        
        try {
            OutputStream os = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (T item : list) {
                oos.writeObject(item);
            }
            for (T item : list2) {
                oos.writeObject(item);
            }
            oos.flush();
            oos.close();
            os.close();
            System.out.println(msg);
            return true; 
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public <T> boolean saveDataToFile(List<T> list, String fileName, String msg) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("Empty list");
            return false;
        }
        try {
            OutputStream os = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (T item : list) {
                oos.writeObject(item);
            }
            oos.flush();
            oos.close();
            os.close();
            System.out.println(msg);
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

}
