/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.queryobject;

public interface IParameter<T extends IParameterizable> extends INameable {
    T getParameterizedObject();
}
