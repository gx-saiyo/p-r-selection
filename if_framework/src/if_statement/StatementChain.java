package if_statement;

/**
 * Created by n1631107 on 2017/01/08.
 */
public class StatementChain extends NestedStatement {
    @Override
    final protected boolean condition(int number) {
        return true;
    }

    @Override
    final public void select(int number) {
        super.select(number);
    }
}
