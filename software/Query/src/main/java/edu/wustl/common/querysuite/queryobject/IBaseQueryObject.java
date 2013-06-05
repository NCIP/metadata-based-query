/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.queryobject;

import java.io.Serializable;

/**
 * This interface must be implemented by each Query interface Objects.
 * 
 * @author prafull_kadam
 * @version 1.0
 */
public interface IBaseQueryObject extends Serializable {

    Long getId();

    void setId(Long id);

}
