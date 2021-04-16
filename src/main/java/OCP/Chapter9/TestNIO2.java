package OCP.Chapter9;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

public class TestNIO2 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println(FileSystems.getDefault().getClass());

        System.out.println(Paths.get(".").toRealPath());

        Path path = Paths.get("src/main/java/OCP/Chapter9/TestFile");

        System.out.println(Files.exists(path));

        Path pathNewFile = Paths.get("src/main/java/OCP/Chapter9/NewFile");

//        Files.createDirectory(Path)
//        Files.copy(Path,Path)
        // Copy stream data to file
//        Files.copy(is, Paths.get("c:\\mammals\\wolf.txt"));
// Copy file data to stream
//        Files.copy(Paths.get("c:\\fish\\clown.xsl"), out);

        //bad if big file, since it loads all lines in memory
        List<String> fileRows = Files.readAllLines(path);
        fileRows.forEach(System.out::println);
        // better alternative that reads line by line but in a stream instead
        Files.lines(path).forEach(System.out::println);

        try (BufferedWriter writer = Files.newBufferedWriter(pathNewFile, StandardCharsets.UTF_16)) {
            for (String fileRow : fileRows) {
                writer.write(fileRow);
                writer.newLine();
            }
        }

        System.out.println(Files.size(path));
        System.out.println(Files.size(pathNewFile));

        System.out.println(LocalDateTime.ofInstant(
                        Files.getLastModifiedTime(pathNewFile).toInstant(),
                        TimeZone.getTimeZone("UTC").toZoneId()));

        //DFS directorie search
        Files.walk(Paths.get("."))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);

    }
}
