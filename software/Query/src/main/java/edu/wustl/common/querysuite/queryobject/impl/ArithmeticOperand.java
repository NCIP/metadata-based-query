/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.queryobject.impl;

import edu.wustl.common.querysuite.queryobject.IArithmeticOperand;
import edu.wustl.common.querysuite.queryobject.TermType;

abstract class ArithmeticOperand extends BaseQueryObject implements IArithmeticOperand {
    private TermType termType;

    ArithmeticOperand() {
    // for hibernate
    }

    public ArithmeticOperand(TermType termType) {
        setTermType(termType);
    }

    public TermType getTermType() {
        return termType;
    }

    protected void setTermType(TermType termType) {
        if (termType == null) {
            throw new NullPointerException("term type is null.");
        }
        if (termType == TermType.Invalid) {
            throw new IllegalArgumentException("the term type 'Invalid' not permissible for an operand.");
        }
        this.termType = termType;
    }
}
