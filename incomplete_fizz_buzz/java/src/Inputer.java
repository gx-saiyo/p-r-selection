import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputer implements Inputable {

  @Override
  public String gets() {
    try {
//        非推奨
//      DataInputStream stream = new DataInputStream(System.in);
//      return stream.readLine();

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
