import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FizzBuzzRunner {

  private Inputable inputer;
  private Printable printer;
  private List<Integer> histories = new ArrayList<Integer>();

  public FizzBuzzRunner(Inputable inputer, Printable printer) {
    this.inputer = inputer;
    this.printer = printer;
  }

  public void run(String selector) {
    if(selector.equals("1")) {
      int number = Integer.parseInt(inputer.gets());
      histories.add(number);
      FizzBuzz.fizzBuzz(number, printer);
    } else if(selector.equals("2")) {
      for(int i=0; i < histories.size(); i++) {
        FizzBuzz.fizzBuzzHistory(histories.get(i), printer);
      }
    } else if(selector.equals("3")) {
      FizzBuzz.write(histories);
    } else if(selector.equals("4")) {
      FileReader fileReader = null;
      BufferedReader bufferedReader = null;
      try {
        fileReader = new FileReader("data.txt");
        bufferedReader = new BufferedReader(fileReader);
        while(true) {
          String line = bufferedReader.readLine();
          if(line == null) {
            break;
          }
          printer.execute(line);
        }
        fileReader.close();
        bufferedReader.close();
      } catch(Exception e) {}
    }
  }
}
