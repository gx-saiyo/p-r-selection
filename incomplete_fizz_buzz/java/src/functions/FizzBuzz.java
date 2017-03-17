package functions;

import output.Printable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class FizzBuzz {

  public static void fizzBuzz(int number, Printable printer) {
    if(number == 0) {
      printer.execute(String.valueOf(number));
    } else if(number % 15 == 0) {
      printer.execute("FizzBuzz");
    } else if(number % 3 == 0) {
      printer.execute("Fizz");
    } else if(number % 5 == 0) {
      printer.execute("Buzz");
    } else {
      printer.execute(String.valueOf(number));
    }
  }

  public static void fizzBuzzHistory(int number, Printable printer) {
    if(number == 0) {
      printer.execute(String.valueOf(number) + ", " + String.valueOf(number));
    } else if(number % 15 == 0) {
      printer.execute(String.valueOf(number) + ", FizzBuzz");
    } else if(number % 3 == 0) {
      printer.execute(String.valueOf(number) + ", Fizz");
    } else if(number % 5 == 0) {
      printer.execute(String.valueOf(number) + ", Buzz");
    } else {
      printer.execute(String.valueOf(number) + ", " + String.valueOf(number));
    }
  }

  public static void write(List<Integer> histories) {
    FileWriter fileWrite = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWrite = new FileWriter("data.txt");
      bufferedWriter = new BufferedWriter(fileWrite);
      for (int i=0; i < histories.size(); i++) {
        int history = histories.get(i);
        if(history == 0) {
          bufferedWriter.write(String.valueOf(history) + ", " + String.valueOf(history));
        } else if(history % 15 == 0) {
          bufferedWriter.write(String.valueOf(history) + ", FizzBuzz");
        } else if(history % 3 == 0) {
          bufferedWriter.write(String.valueOf(history) + ", Fizz");
        } else if(history % 5 == 0) {
          bufferedWriter.write(String.valueOf(history) + ", Buzz");
        } else {
          bufferedWriter.write(String.valueOf(history) + ", " + String.valueOf(history));
        }
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      fileWrite.close();
    } catch (Exception e) {}
  }
}
