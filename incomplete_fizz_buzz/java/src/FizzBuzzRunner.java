import functions.FizzBuzz;
import input.Inputable;
import items.MenuType;
import output.Printable;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FizzBuzzRunner {

  private Inputable inputer;
  private Printable printer;
  private List<Integer> histories = new ArrayList<>();

  public FizzBuzzRunner(Inputable inputer, Printable printer) {
    this.inputer = inputer;
    this.printer = printer;
  }

  public void run(int selector) {
    switch (MenuType.getType(selector)) {
      case FIZZBUZZ:
        System.out.println("数字を入力してください");
        try {
          int number = Integer.parseInt(inputer.gets());
          histories.add(number);
          FizzBuzz.fizzBuzz(number, printer);
        }catch (NumberFormatException e) {
          System.out.println("数字以外が入力されました、もう一度やり直してください");
        }
        break;
      case HISTORY:
        for(Integer i : histories) {
          FizzBuzz.fizzBuzzHistory(i, printer);
        }
        break;
      case SAVE:
        FizzBuzz.write(histories);
        break;
      case LOAD:
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
          fileReader = new FileReader("data.txt");
          bufferedReader = new BufferedReader(fileReader);
          while (true) {
            String line = bufferedReader.readLine();
            if (line == null) break;
            printer.execute(line);
          }
          fileReader.close();
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
    }
  }
}
