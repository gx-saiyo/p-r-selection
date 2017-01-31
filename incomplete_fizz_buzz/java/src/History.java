import java.io.BufferedWriter;
import java.util.List;
import java.util.ArrayList;

public class History {
  private List<Integer> histories = new ArrayList<Integer>();

  public void add(int number) {
    histories.add(number);
  }

  public void print(Printable printer) {
    for(int i=0; i < histories.size(); i++) {
      int number = histories.get(i);
      printer.execute(String.valueOf(number) + ", " + FizzBuzz.fizzBuzz(number));
    }
  }

  public void write(BufferedWriter bufferedWriter) throws Exception {
    for (int i=0; i < histories.size(); i++) {
      int history = histories.get(i);
      bufferedWriter.write(String.valueOf(history) + ", " + FizzBuzz.fizzBuzz(history));
      bufferedWriter.newLine();
    }
  }
}
