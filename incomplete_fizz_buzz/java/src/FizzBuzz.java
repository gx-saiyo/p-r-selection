import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class FizzBuzz {
  private static final String FIZZ_TEXT = "Fizz";
  private static final String BUZZ_TEXT = "Buzz";
  private static final String PRIME_TEXT = "not Fizz and Buzz.But Prime!";

  static void fizzBuzz(int number, Printable printer) {
    printer.execute(fizzbuzzDiscriminant(number));
  }

  static void fizzBuzzHistory(int number, Printable printer) {
    printer.execute(String.valueOf(number)+", "+fizzbuzzDiscriminant(number));
  }

  static void write(List<Integer> histories) {
    FileWriter fileWrite = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWrite = new FileWriter("data.txt");
      bufferedWriter = new BufferedWriter(fileWrite);
      for (int history : histories) {
        bufferedWriter.write(String.valueOf(history)+", "+fizzbuzzDiscriminant(history));
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      fileWrite.close();
    } catch (Exception e) {}
  }

  /**
   * 入力された値を受け取り，FizzBuzz判定をする式
   * @param num
   * @return それぞれに適切な文字列
   */
  public static String fizzbuzzDiscriminant(int num){
    if (num == 0) {
      return String.valueOf(num);
    } else if (num % 15 == 0) {
      return FIZZ_TEXT+BUZZ_TEXT;
    } else if (num % 3 == 0) {
      return FIZZ_TEXT;
    } else if (num % 5 == 0) {
      return BUZZ_TEXT;
    } else if (isPrime(num)){
      return PRIME_TEXT;
    } else {
      return String.valueOf(num);
    }
  }

  /**
   * isPrimeメソッド
   * 入力された値が素数ならtrueを合成数ならfalseを返します
   * @param inputted
   * @return 値が素数ならtrue
   */
  static boolean isPrime(int inputted){
    if (inputted <=1){
      return false;
    }
    for (int div = 2;div<=Math.sqrt(inputted);div++){
      if ((inputted % div) == 0) {
        return false;
      }
    }
    return true;
  }
}
