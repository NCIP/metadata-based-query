package edu.wustl.common.querysuite.queryobject.impl;

import java.util.Date;

import edu.wustl.common.querysuite.queryobject.IAbstractQuery;

/**
 * @author vijay_pande
 * @author chetan_patil
 * Class created for the model changes for Composite Query.
 */
public class AbstractQuery extends BaseQueryObject implements IAbstractQuery
{
	 /**
     * Default Constructor
     */
    public AbstractQuery()
    {

    }

	  /**
     * AbstractQuery Constructor.
     * This constructor will be used by Hibernate internally.
     *
     * @param id
     * @param name
     * @param description
     * @param type
     */
    public AbstractQuery(Long id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }
    /** Default serial version id */
    private static final long serialVersionUID = 1L;

    /** Name of the query */
    protected String name;

    /** Type of the query */
    protected String type;

	/** Description of the query */
    protected String description;

    /** Date of creation */
    protected Date createdDate;

    /** Date of updation */
    protected Date updationDate;

    /** The identifier of the creator/user */
    protected Long createdBy;

    /** The identifier of the updator/user */
    protected Long updatedBy;

	/**
     * @see edu.wustl.common.querysuite.queryobject.IDescribable#getName()
     *
     * @hibernate.property name="name" column="QUERY_NAME" type="string"
     *                     length="255" unique="true"
     */
    public String getName() {
        return name;
    }

    /**
     * @see edu.wustl.common.querysuite.queryobject.IDescribable#setName(java.lang.String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @see edu.wustl.common.querysuite.queryobject.IDescribable#getDescription()
     *
     * @hibernate.property name="description" column="DESCRIPTION" type="string" not-null="true"
     */
    public String getDescription() {
        return description;
    }

    /**
     * @see edu.wustl.common.querysuite.queryobject.IDescribable#setDescription()
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the type
     *
     * @hibernate.property name="type" column="QUERY_TYPE" type="string" length="30"
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the createdDate
     *
     * @hibernate.property name="createdDate" column="CREATED_DATE" type="timestamp" not-null="true"
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updationDate
     *
     * @hibernate.property name="updationDate" column="UPDATION_DATE" type="timestamp" not-null="true"
     */
    public Date getUpdationDate() {
		return updationDate;
	}


    /**
     * @param updationDate the updationDate to set
     */
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

    /**
     * @return the createdBy
     *
     * @hibernate.property name="createdBy" column="CREATED_BY" type="long" not-null="true"
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     *
     * @hibernate.property name="updatedBy" column="UPDATED_BY" type="long" not-null="true"
     */
    public Long getUpdatedBy() {
		return updatedBy;
	}
    /**
     * @param updatedBy the updatedBy to set
     */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
