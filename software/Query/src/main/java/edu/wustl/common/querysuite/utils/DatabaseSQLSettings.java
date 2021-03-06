/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.utils;

/**
 * Represents database specific settings that are used while building SQL.
 * 
 * @author srinath_k
 */
public class DatabaseSQLSettings {
    private DatabaseType databaseType;

    /**
     * @param databaseType the database type
     * @param dateFormat the format in which date literals are specified.
     */
    public DatabaseSQLSettings(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

}
