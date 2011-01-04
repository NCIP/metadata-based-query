package edu.wustl.common.querysuite.queryobject.impl;

import edu.wustl.common.querysuite.querableobjectinterface.QueryableAttributeInterface;
import edu.wustl.common.querysuite.queryobject.IExpression;
import edu.wustl.common.querysuite.queryobject.IExpressionAttribute;
import edu.wustl.common.querysuite.queryobject.TermType;

public class ExpressionAttribute extends ArithmeticOperand implements IExpressionAttribute {
    private static final long serialVersionUID = 2376055279144184693L;

    private IExpression expression;

    private QueryableAttributeInterface attribute;

    ExpressionAttribute() {
    // for hibernate
    }

    public ExpressionAttribute(IExpression expression, QueryableAttributeInterface attribute, TermType termType) {
        setExpression(expression);
        setAttribute(attribute);
        setTermType(termType);
    }

    @Override
    public void setTermType(TermType termType) {
        super.setTermType(termType);
    }

    public QueryableAttributeInterface getAttribute() {
        return attribute;
    }

    public void setAttribute(QueryableAttributeInterface attribute) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        this.attribute = attribute;
    }

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        if (expression == null) {
            throw new NullPointerException();
        }
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ExprId: " + expression.getExpressionId() + ", Attribute: " + attribute;
    }
}