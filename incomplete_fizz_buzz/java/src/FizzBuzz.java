public class FizzBuzz {
  public static void fizzBuzz(int number, Printable printer) {
    printer.execute(fizzBuzz(number));
  }

  public static String fizzBuzz(int number) {
    if(number == 0) {
      return String.valueOf(number);
    } else if(number % 15 == 0) {
      return "FizzBuzz";
    } else if(number % 3 == 0) {
      return "Fizz";
    } else if(number % 5 == 0) {
      return "Buzz";
    } else {
      return String.valueOf(number);
    }
  }
}
