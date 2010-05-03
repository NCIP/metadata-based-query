
package edu.wustl.common.querysuite.queryobject;

import java.util.List;

import edu.wustl.common.querysuite.querableobjectinterface.QueryableAttributeInterface;


/**
 * @author prafull_kadam
 */
public interface IOutputEntity extends IQueryEntity
{

	//	public List<String> getUrls();
	//
	//	/**
	//	 * @param urls
	//	 * 
	//	 */
	//	public void setUrls(List<String> urls);

	/**
	 * all the Attributes in this list belong to the entity obtained from
	 * getDynamicExtensionsEntity()
	 * @return the list of Dynamic Extentsion attributes.
	 */
	List<QueryableAttributeInterface> getSelectedAttributes();

	/**
	 * @param selectedAttributesIndices The selectedAttributesIndices to set
	 * 
	 */
	void setSelectedAttributes(List<QueryableAttributeInterface> selectedAttributesIndices);

}
