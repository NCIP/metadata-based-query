/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.queryobject;

/**
 * Represents an operand in an {@link ITerm}. Each operand has a
 * {@link TermType}.
 * 
 * @author srinath_k
 * @see TermType
 * @see ITerm
 */
public interface IArithmeticOperand extends IOperand {
    TermType getTermType();
}
