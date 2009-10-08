
package edu.wustl.common.querysuite.queryobject;

import edu.wustl.common.querysuite.querableobjectInterface.QueryableObjectInterface;

/**
 * anything that implements/extends this interface will finally be
 * represented/stored as an Entity in DE
 * @author prafull_kadam
 */
public interface IQueryEntity extends IBaseQueryObject
{

    /**
	 * 
	 * @return The Dynamic Extension Entity reference corresponding to the QueryEntity.
	 */
	QueryableObjectInterface getDynamicExtensionsEntity();

}
