import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        for (String s : words) {
            charArrayWriter.append(s);
        }

        return charArrayWriter.toCharArray();
    }
}