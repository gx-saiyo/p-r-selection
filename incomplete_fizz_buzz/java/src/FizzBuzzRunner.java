import html.Director;
import html.HtmlBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizzBuzzRunner {

  private Inputable inputer;
  private Printable printer;
  private List<Integer> histories = new ArrayList<>();
  static final  String DISCRIPTION_TEXT =
      "起動すると入力待ち状態になります．各操作に関しては以下の通りです\n" +
          "1：fizzbuzz受付\n" +
          "2：入力と出力の履歴表示\n" +
          "3：履歴をファイルに保存\n" +
          "4：保存されたファイルを読み込み\n" +
          "html：履歴をhtmlファイルで保存\n" +
          "0：プログラム終了\n" +
          "となります．\n" +
          "数値または\"html\"と入力してください．";

  public FizzBuzzRunner(Inputable inputer, Printable printer) {
    this.inputer = inputer;
    this.printer = printer;
  }

  /**
   * 入力待ち状態で入力に対応した状態に移ります．
   * 元々の機能に加えて，全角で入力された場合，不正な値が入力された場合，
   * htmlでの出力が求められた場合を追加しました．
   *
   * @param selector {@link Inputer#gets()}より得られた文字列
   */
  public void run(String selector) {
    if(selector.equals("1")) {
      int number = Integer.parseInt(inputer.gets());
      histories.add(number);
      FizzBuzz.fizzBuzz(number, printer);
    } else if(selector.equals("2")) {
      for (Integer history : histories) {
        FizzBuzz.fizzBuzzHistory(history, printer);
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
      } catch(Exception e) {
      }
    } else if (selector.equals("html")) { // htmlで出力したい場合
      List<String> historiesStr = converter(histories);
      new Director(new HtmlBuilder(historiesStr),historiesStr).director();
    } else if (!findMatches(PatternEnum.ALNUM, selector)) { // 全角で入力された場合
      System.out.println("全角で入力していませんか？半角で入力をお願いします．\n");
    } else { // 何も入力されなかった場合
      System.out.println(DISCRIPTION_TEXT);
    }
  }

  /**
   * FizzBuzzRunnerクラスのhistoriesをFizzBuzzの判別式にかけ，結果をString型で返す．
   * @param historiesInt
   * @return 判別式適用後のリスト "historyInt, 変換後historyInt"(:String)のリスト
   */
  private List<String> converter(List<Integer> historiesInt){
    List<String> historiesString = new ArrayList<String>();
    for (int historyInt:historiesInt){
      historiesString.add(historiesInt+", "+FizzBuzz.fizzbuzzDiscriminant(historyInt));
    }
    return historiesString;
  }

  /**
   * 正規表現を用いるためのenumオブジェクトです．
   * ALNUMは半角英数字です．
   */
  private enum PatternEnum {
    ALNUM("^[a-zA-Z0-9]+$");
    private final String regex;

    PatternEnum(final String regex) {
      this.regex = regex;
    }

    public Pattern toPattern() {
      return Pattern.compile(regex);
    }
  }

  private static boolean findMatches(Pattern pattern, CharSequence input) {
    final Matcher m = pattern.matcher(input);
    return m.find();
  }

  /**
   * 正規表現のenumオブジェクトを用いて，特定の正規表現で表されているかを
   * 判別します．
   *
   * @param patternEnum
   * @param input
   * @return 特定の正規表現が入力されている場合はtrueをそうでない場合はfalseを返します．
   */
  private static boolean findMatches(PatternEnum patternEnum, CharSequence input) {
    return findMatches(patternEnum.toPattern(), input);
  }
}
