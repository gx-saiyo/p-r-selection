import if_statement.Statement;
import if_statement.NestedStatement;
import if_statement.ChainedStatement;

/**
 * Created by n1631107 on 2017/01/08.
 */
public class Main {
    static public void main(String[] argv) {
        // ifとelse ifの連鎖を保持するオブジェクトを用意する
        ChainedStatement chain = new ChainedStatement();

        // 分岐Aを作成して、条件と処理を設定する
        Statement statementA = new Statement() {
            @Override
            protected boolean condition(int number) {
                return number == 0;
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理A (number=%d)%n", number);
            }
        };

        // 分岐Aをchainに追加する
        chain.append(statementA);

        // 分岐Bの条件と処理の設定をして、chainに追加する
        chain.append(new Statement() {
            @Override
            protected boolean condition(int number) {
                return number == 1;
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理B (number=%d)%n", number);
            }
        });

        /*
        ネストされた分岐を表すnestedStatementを作る
        nestedStatementは次のようなif文を表すように初期化される:
            if ((number >= 2) && (number <= 4)) {
                if (number == 2) {
                    System.out.printf("処理C (number=%d)%n", number);
                } else {
                    System.out.printf("処理D (number=%d)%n", number);
                }
            }
        */
        NestedStatement nestedStatement = new NestedStatement(){
            @Override
            protected boolean condition(int number) {
                return (number >= 2) && (number <= 4);
            }
        }.append(new Statement() {
            @Override
            protected boolean condition(int number) {
                return number == 2;
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理C (number=%d)%n", number);
            }
        }).append(new Statement() {
            @Override
            protected void select(int number) {
                System.out.printf("処理D (number=%d)%n", number);
            }
        });

        // ネストされた分岐をchainに追加する
        chain.append(nestedStatement);

        /*
        if、else ifの連鎖を表すchainedStatementを作る
        chainedStatementは次のif、else ifの連鎖を表すように初期化される:
            if ((number >= 4) && (number <= 5)) {
                System.out.printf("処理E (number=%d)%n", number);
            } else if (number == 6) {
                System.out.printf("処理F (number=%d)%n", number);
            }
         */
        ChainedStatement chainedStatement = new ChainedStatement().append(new Statement() {
            @Override
            protected boolean condition(int number) {
                return (number >= 4) && (number <= 5);
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理E (number=%d)%n", number);
            }
        }).append(new Statement() {
            @Override
            protected boolean condition(int number) {
                return number == 6;
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理F (number=%d)%n", number);
            }
        });

        // 分岐の連鎖をchainに追加する
        chain.append(chainedStatement);

        // 分岐Gの条件と処理を設定して、chainに追加する
        chain.append(new Statement() {
            @Override
            protected boolean condition(int number) {
                return number == 7;
            }

            @Override
            protected void select(int number) {
                System.out.printf("処理G (number=%d)%n", number);
            }
        });

        /*
        ここまでの処理でchainは次のようなifとelse ifの連鎖を表すようになる:
            if (number == 0) {
                System.out.printf("処理A (number=%d)%n", number);
            } else if (number == 1) {
                System.out.printf("処理B (number=%d)%n", number);
            } else if ((number >= 2) && (number <= 4)) {
                if (number == 2) {
                    System.out.printf("処理C (number=%d)%n", number);
                } else {
                    System.out.printf("処理D (number=%d)%n", number);
                }
            } else if ((number >= 4) && (number <= 5)) {
                System.out.printf("処理E (number=%d)%n", number);
            } else if (number == 6) {
                System.out.printf("処理F (number=%d)%n", number);
            } else if (number == 7) {
                System.out.printf("処理G (number=%d)%n", number);
            }
         */

        // Aを実行する
        chain.select(0);

        // Bを実行する
        chain.select(1);

        // Cを実行する
        chain.select(2);

        // Dを実行する
        chain.select(3);

        // Dを実行する
        chain.select(4);

        // Eを実行する
        chain.select(5);

        // Fを実行する
        chain.select(6);

        // Gを実行する
        chain.select(7);

        // どの処理も実行しない
        chain.select(8);
    }
}
