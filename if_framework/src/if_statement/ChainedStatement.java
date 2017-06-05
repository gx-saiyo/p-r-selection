package if_statement;

/**
 * Created by n1631107 on 2017/01/08.
 */
public class ChainedStatement extends NestedStatement {
    public ChainedStatement append(Statement statement) {
        super.append(statement);
        return this;
    }

    @Override
    final protected boolean condition(int number) {
        return any(number);
    }

    @Override
    final public void select(int number) {
        super.select(number);
    }
}
