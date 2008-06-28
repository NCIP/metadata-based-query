package edu.wustl.common.querysuite.queryobject.impl;

import edu.wustl.common.querysuite.queryobject.IArithmeticOperand;
import edu.wustl.common.querysuite.queryobject.TermType;

abstract class ArithmeticOperand extends BaseQueryObject implements IArithmeticOperand {
    private TermType termType;

    public ArithmeticOperand(TermType termType) {
        if (termType == TermType.Invalid) {
            throw new IllegalArgumentException("the term type 'Invalid' not permissible for an operand.");
        }
        this.termType = termType;
    }

    public ArithmeticOperand() {

    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

}