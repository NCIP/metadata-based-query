/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/metadata-based-query/LICENSE.txt for details.
 */

package edu.wustl.common.querysuite.utils;

import edu.wustl.common.querysuite.queryobject.ArithmeticOperator;
import edu.wustl.common.querysuite.queryobject.IDateLiteral;

class MySQLPrimitiveOperationProcessor extends SQLPrimitiveOperationProcessor {
    private static final String dateFormat="%Y-%m-%d";
    private static final String strToDateFunc="STR_TO_DATE";
    
    @Override
    String getDateDiffString(String leftStr, String rightStr) {
        return "timestampdiff(SECOND, " + rightStr + ", " + leftStr + ")";
    }

    @Override
    String dateToTimestamp(String s) {
        return "timestamp(" + s + ")";
    }

    @Override
    String getTimeOffsetOpString(String timeStr, String offsetStr, ArithmeticOperator operator) {
        if (operator == ArithmeticOperator.Minus) {
            offsetStr = "-" + offsetStr;
        }
        return "timestampadd(SECOND, " + offsetStr + ", " + timeStr + ")";
    }
    
    @Override
    String modifyDateLiteral(IDateLiteral s) {
        return strToDateFunc + "('" + standardDateFormat(s) + "', '" + dateFormat + "')";
    }
   
}
