package wordCount;

import java.nio.file.*;

public class Passage
{
    public static String passage(String passage) throws Exception
    {
    String words = "";
    words = new String(Files.readAllBytes(Paths.get(passage)));
    return words;
    }

    public String getThePassage() throws Exception
    {
        String words = passage("..\\src\\wordCount\\passage.txt");
        return words;
    }
}