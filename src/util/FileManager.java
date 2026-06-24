package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles saving and loading objects using
 * Java Serialization.
 */
public final class FileManager {

    private FileManager() {
    }

    /**
     * Saves a list of objects to a file.
     *
     * @param fileName file path
     * @param data data to save
     * @param <T> object type
     */
    public static <T> void saveData(String fileName, List<T> data) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {

            outputStream.writeObject(data);

        } catch (IOException e) {

            System.out.println(Messages.FILE_ERROR);
            e.printStackTrace();

        }
    }

    /**
     * Loads a list of objects from a file.
     *
     * @param fileName file path
     * @param <T> object type
     * @return loaded list
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            return (List<T>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(Messages.FILE_ERROR);
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
