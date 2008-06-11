package edu.wustl.common.querysuite.utils;

import static edu.wustl.common.querysuite.queryobject.RelationalOperator.getSQL;

import java.util.List;

import edu.wustl.common.querysuite.queryobject.ICustomFormula;
import edu.wustl.common.querysuite.queryobject.ITerm;
import edu.wustl.common.querysuite.queryobject.RelationalOperator;
import edu.wustl.common.querysuite.utils.TermProcessor.IAttributeAliasProvider;

/**
 * Provides the string representation of a custom formula. It uses
 * {@link TermProcessor} to obtain string representations of the LHS and RHS
 * terms and connects them based on the relational operator.
 * 
 * @author srinath_k
 * @see TermProcessor
 */
public class CustomFormulaProcessor {
    private TermProcessor termProcessor;

    private static final String SPACE = " ";

    /**
     * Uses the default {@link TermProcessor} to obtain string representation of
     * the terms.
     * 
     * @see TermProcessor#TermProcessor()
     */
    public CustomFormulaProcessor() {
        this.termProcessor = new TermProcessor();
    }

    /**
     * Uses a {@link TermProcessor} initialized with specified parameters to
     * obtain string representation of the terms.
     * 
     * @see TermProcessor#TermProcessor(IAttributeAliasProvider,
     *      DatabaseSQLSettings)
     */
    public CustomFormulaProcessor(IAttributeAliasProvider aliasProvider, DatabaseSQLSettings databaseSQLSettings) {
        this.termProcessor = new TermProcessor(aliasProvider, databaseSQLSettings);
    }

    /**
     * @return the string representation of the specified formula.
     */
    public String asString(ICustomFormula formula) {
        String lhs = getString(formula.getLhs());
        RelationalOperator relationalOperator = formula.getOperator();
        if (relationalOperator.numberOfValuesRequired() == 0) {
            // is (not) null
            return lhs + SPACE + getSQL(relationalOperator);
        }
        List<ITerm> rhses = formula.getAllRhs();
        if (rhses.isEmpty()) {
            throw new IllegalArgumentException("No value for operator " + getSQL(relationalOperator));
        }
        ITerm rhsTerm = rhses.get(0);
        String rhs = getString(rhsTerm);
        if (relationalOperator.numberOfValuesRequired() == 1) {
            // unary operators
            return lhs + SPACE + getSQL(relationalOperator) + SPACE + rhs;
        }
        if (relationalOperator == RelationalOperator.Between) {
            if (rhses.size() != 2) {
                throw new IllegalArgumentException("Between doesn't have 2 values.");
            }
            String rhs2 = getString(rhses.get(1));
            // (lhs >= rhs1 and lhs <= rhs2) or (lhs <= rhs1 and lhs >= rhs2)
            String res = "(" + lhs + " >= " + rhs + " and " + lhs + " <= " + rhs2 + ")";
            res += " or (" + lhs + " <= " + rhs + " and " + lhs + " >= " + rhs2 + ")";
            return res;
        }
        // In : lhs = rhs1 or lhs = rhs2 or lhs = rhs3...
        // NotIn : lhs != rhs1 and lhs != rhs2 and lhs != rhs3...
        String sqlOper = relationalOperator == RelationalOperator.In
                ? getSQL(RelationalOperator.Equals)
                : getSQL(RelationalOperator.NotEquals);
        String logicOper = relationalOperator == RelationalOperator.In ? "or" : "and";
        sqlOper = SPACE + sqlOper + SPACE;
        logicOper = SPACE + logicOper + SPACE;
        String res = lhs + sqlOper + rhs;

        for (int i = 1, n = rhses.size(); i < n; i++) {
            rhs = getString(rhses.get(i));
            String next = logicOper + lhs + sqlOper + rhs;
            res += next;
        }
        return res;
    }

    private String getString(ITerm term) {
        return termProcessor.convertTerm(term).getString();
    }
}
