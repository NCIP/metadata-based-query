/**
 * 
 */

package edu.wustl.common.querysuite.queryobject.impl;

import org.apache.commons.lang.builder.HashCodeBuilder;

import edu.wustl.common.querysuite.querableobjectinterface.QueryableAttributeInterface;
import edu.wustl.common.querysuite.queryobject.IExpression;
import edu.wustl.common.querysuite.queryobject.IOutputAttribute;

/**
 * @author chetan_patil
 * @created Sep 27, 2007, 3:44:18 PM
 * 
 * @hibernate.class table="QUERY_OUTPUT_ATTRIBUTE"
 * @hibernate.cache usage="read-write"
 */
public class OutputAttribute extends BaseQueryObject implements IOutputAttribute
{

	private static final long serialVersionUID = 1L;

	private IExpression expression;

	private QueryableAttributeInterface attribute;

	private String name;

	/** Default Constructor */
	public OutputAttribute()
	{

	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param expression
	 * @param attribute
	 */
	public OutputAttribute(IExpression expression, QueryableAttributeInterface attribute)
	{
		this.expression = expression;
		this.attribute = attribute;
		name = attribute.getDisplayName();
	}

	/**
	 * Parameterized Constructor
	 * @param name display name of attribute
	 * @param expression
	 * @param attribute
	 */
	public OutputAttribute(String name, IExpression expression,
			QueryableAttributeInterface attribute)
	{
		this(expression, attribute);
		this.name = name;
	}

	/**
	 * Name: Abhishek Mehta Reviewer Name : Deepti Bug ID: 5661 Patch ID: 5661_3
	 * See also: 1-7 Description : Making cascade none from cascade all
	 */

	/**
	 * @return the expression
	 * 
	 * @hibernate.many-to-one column="EXPRESSIONID_ID"
	 *                        class="edu.wustl.common.querysuite.queryobject.impl.Expression"
	 *                        cascade="none" lazy="false"
	 */
	public IExpression getExpression()
	{
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(IExpression expression)
	{
		this.expression = expression;
	}

	/**
	 * @return the attribute
	 */
	public QueryableAttributeInterface getAttribute()
	{
		return attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(QueryableAttributeInterface attribute)
	{
		this.attribute = attribute;
	}

	/**
	 * Returns the identifier assigned to BaseQueryObject.
	 * 
	 * @return a unique id assigned to the Condition.
	 * 
	 * @hibernate.id name="id" column="IDENTIFIER" type="long" length="30"
	 *               unsaved-value="null" generator-class="native"
	 * @hibernate.generator-param name="sequence" value="OUTPUT_ATTRIBUTE_SEQ"
	 */
	@Override
	public Long getId()
	{
		return id;
	}

	/**
	 * To check equality of the two object.
	 * 
	 * @param obj to be check for equality.
	 * @return true if objects are equals.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object)
	{
		boolean isEqual = false;

		if (this == object)
		{
			isEqual = true;
		}
		else if (object != null && this.getClass() == object.getClass())
		{
			OutputAttribute outputAtrribute = (OutputAttribute) object;
			IExpression expression = outputAtrribute.getExpression();

			if (getExpression().equals(expression)
					&& getAttribute().equals(outputAtrribute.getAttribute()))
			{
				isEqual = true;
			}
		}

		return isEqual;
	}

	/**
	 * To get the HashCode for the object.
	 * 
	 * @return The hash code value for the object.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(expression).append(attribute).toHashCode();
	}

	/** (non-Javadoc)
	 * @see edu.wustl.common.querysuite.queryobject.INameable#getName()
	 * @return name Display Name of output attribute
	 * @hibernate.property name="name" column="NAME" type="string"
	 *                     length="255"
	 */
	public String getName()
	{
		//Following change is the temporary one since Onsite database is old one and currently
		// we are not providing DML script to load default values for the name of outputAttribute
		// which are already created
		if (name == null || "".equals(name))
		{
			name = getAttribute().getName();
		}
		return name;
	}

	/** (non-Javadoc)
	 * @see edu.wustl.common.querysuite.queryobject.INameable#setName(java.lang.String)
	 * @param name Display Name of output attribute
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
