import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class File {
  public static void write(History history) {
    try {
      FileWriter fileWrite = new FileWriter("data.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
      history.write(bufferedWriter);
      bufferedWriter.close();
      fileWrite.close();
    } catch(Exception e) {}
  }

  public static void read(Printable printer) {
    try {
      FileReader fileReader = new FileReader("data.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      print(bufferedReader, printer);
      fileReader.close();
      bufferedReader.close();
    } catch(Exception e) {}
  }

  public static void print(BufferedReader bufferedReader, Printable printer) throws Exception {
    while(true) {
      String line = bufferedReader.readLine();
      if(line == null) {
        break;
      }
      printer.execute(line);
    }
  }
}
