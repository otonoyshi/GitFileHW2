import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        String adress = "T:/Кодинг/Gamesfile/Games/savegames/";
        GameProgress gameProgressOne = new GameProgress(100, 2, 12, 1);
        GameProgress gameProgressTwo = new GameProgress(50, 3, 13, 2);
        GameProgress gameProgressThree = new GameProgress(25, 2, 14, 3);

        saveGame(adress, gameProgressOne, "1");
        saveGame(adress, gameProgressTwo, "2");
        saveGame(adress, gameProgressThree, "3");

//        File dir = new File(adress);
//        String nameFile = "";
//        List<String> files = new ArrayList<>();
//        if (dir.isDirectory()) {
//            for (File item : dir.listFiles()){
//                if (item.isDirectory()){
//                    System.out.println(item.getName() + " - директория");
//                } else if (!item.equals("T:/Кодинг/Gamesfile/Games/savegames/zip.zip")){
//                    nameFile = String.valueOf(item);
//                    files.add(nameFile);
//                }
//            }
//        }
//        System.out.println(files);

        zipFiles("T:/Кодинг/Gamesfile/Games/savegames/zip.zip", Arrays.asList("T:/Кодинг/Gamesfile/Games/savegames/save1.dat", "T:/Кодинг/Gamesfile/Games/savegames/save2.dat", "T:/Кодинг/Gamesfile/Games/savegames/save3.dat"));

    }

    public static void saveGame(String adress, GameProgress gameProgress, String number) {
        File file = new File(adress, "save" + number + ".dat");
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void zipFiles(String adress, List<String> files){
        int i = 0;
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(adress))){
            for (String s:files) {
                try (FileInputStream fis = new FileInputStream(s)){
                    i++;
                    ZipEntry entry = new ZipEntry(i + "test.txt");
                    zout.putNextEntry(entry);
                    byte[]bytes = new byte[fis.available()]; fis.read(bytes);
                    zout.write(bytes);
                    zout.closeEntry();
                }
                File file = new File(s);
                file.delete();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

//            try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(adress));
//                 FileInputStream fis = new FileInputStream(string)) {
//                for (String s : files) {
//                    string = s;
//                }
//
//                    i++;
//                    ZipEntry entry = new ZipEntry(i +"test.txt");
//                    zout.putNextEntry(entry);
//                    byte[] bytes = new byte[fis.available()]; fis.read(bytes);
//                    zout.write(bytes);
//                    zout.closeEntry();
//            }catch (Exception ex) {
//               ex.printStackTrace();
//            }


    }
}
