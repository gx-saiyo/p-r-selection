package if_statement;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by n1631107 on 2017/01/08.
 */
public abstract class NestedStatement extends Statement {
    private List<Statement> statementList = new ArrayList<Statement>();

    public NestedStatement append(Statement statement) {
        statementList.add(statement);
        return this;
    }

    protected boolean any(int number) {
        for (Statement statement : statementList) {
            if (statement.condition(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void select(int number) {
        for (Statement statement : statementList) {
            if (statement.condition(number)) {
                statement.select(number);
                return;
            }
        }
    }
}
