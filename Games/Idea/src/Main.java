import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();


        List<String> listDir = Arrays.asList("src", "res", "savegames", "temp");
        for (String d : listDir) {
            File newDir = new File(d);
            sb.append(newDir.getName() + ":" + newDir.mkdir() + " ");
        }

        List<String> listMain = Arrays.asList("main", "test");
        for (String fm : listMain){
            File newDirMain = new File("src" , fm);
            sb.append(newDirMain.getName() + ":" + newDirMain.mkdir() + " ");
        }

        List<String> listRes = Arrays.asList("drawables", "vectors", "icons");
        for (String fres : listRes){
            File newDirRes = new File("res" , fres);

            sb.append( " " + newDirRes.getName() + ":" + newDirRes.mkdir() + " ");
        }
        String log = sb.toString();
        File tempFile = new File("temp", "temp.txt");
        try (FileWriter writer = new FileWriter(tempFile)){
            writer.write(log);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}



