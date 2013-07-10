/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.queryobject;

import java.sql.Date;

public interface IDateLiteral extends ILiteral {
    void setDate(Date date);

    Date getDate();
}
