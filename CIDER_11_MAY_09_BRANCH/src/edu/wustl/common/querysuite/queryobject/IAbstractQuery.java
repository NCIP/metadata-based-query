package edu.wustl.common.querysuite.queryobject;

import java.util.Date;

/**
 * @author vijay_pande
 *
 */
public interface IAbstractQuery extends IBaseQueryObject, INameable, IDescribable {
    /**
     * This method returns the type of the query object
     * @return
     */
    String getType();

    /**
     * This method sets the type of the query object
     * @param type
     */
    void setType(String type);

    /**
     * This method returns the date of creation
     * @return
     */
    Date getCreatedDate();

    /**
     * This method sets the date of creation
     * @param createdDate
     */
    void setCreatedDate(Date createdDate);

    /**
     * This method returns the date of updation
     * @return
     */
    public Date getUpdationDate();


    /**
     * This method sets the date of updateion
     * @param updationDate
     */
	public void setUpdationDate(Date updationDate);

    /**
     * This method returns the identifier of the creator/user/owner
     * @return
     */
    Long getCreatedBy();

    /**
     * This method sets the identifier of the creator/user/owner
     * @param createdBy
     */
    void setCreatedBy(Long createdBy);
    
    /**
     * This method sets the identifier of the creator/user/owner
     * @param createdBy
     */
    public Long getUpdatedBy() ;
    /**
     * @param updatedBy the updatedBy to set
     */
	public void setUpdatedBy(Long updatedBy) ;
}
