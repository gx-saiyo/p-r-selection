import input.Inputable;
import items.MenuType;

public class Looper {

  private FizzBuzzRunner fizzBuzzRunner;
  private Inputable inputer;

  public Looper(FizzBuzzRunner fizzBuzzRunner, Inputable inputer) {
    this.fizzBuzzRunner = fizzBuzzRunner;
    this.inputer = inputer;
  }

  public void loop() {
    while(true) {
      System.out.println("以下のメニューから選択してください");
      System.out.println("1:FizzBuzz 2:履歴の表示 3:履歴の保存 4:保存した履歴を閲覧");
      try {
        int selector = Integer.parseInt(inputer.gets());
        if (selector == 0) return;
        if(selector < 0 || selector > MenuType.values().length) {
          System.out.println("メニューに無い数字が入力されました");
          continue;
        }
        fizzBuzzRunner.run(selector);
      } catch (NumberFormatException e) {
        System.out.println("メニューの数字を入力してください");
      }
    }
  }
}
