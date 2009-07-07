package edu.wustl.common.querysuite.utils;

import edu.wustl.common.querysuite.queryobject.ArithmeticOperator;
import edu.wustl.common.querysuite.queryobject.IDateLiteral;
import edu.wustl.common.querysuite.queryobject.TimeInterval;


public class DB2XQueryPrimitiveOperationProcessor extends SQLPrimitiveOperationProcessor {

    public DB2XQueryPrimitiveOperationProcessor() 
    {
        super("YYYY-MM-DD" , "xs:dateTime");
    }

    @Override
    String getDateDiffString(String leftStr, String rightStr) {
        return numSecs(leftStr + " - " + rightStr);
    }

    private String numSecs(String s) {
    	return s;
    }

    @Override
    String dateToTimestamp(String s) 
    {
// If it is an attribute 
    	
    	if(!s.contains("_"))
    	{
    		s = "timestamp('" + s + "-00.00.00')";
    	}
        return s;
    }

    @Override
    String getTimeOffsetOpString(String timeStr, String offsetStr, ArithmeticOperator operator) {
        return super.getResultString(timeStr, operator, offsetStr);
    }
    
    protected String modifyDateLiteral(IDateLiteral s) {
        return standardDateFormat(s);
    }
    
    protected String getIntervalString(String s, TimeInterval<?> timeInterval) {
    	return getTimeIntervalFormula(s, timeInterval);
    }
    
    private String getTimeIntervalFormula(String s, TimeInterval<?> timeInterval)
    {
    	String intervalDuration = "";

    	if(timeInterval.name().equals("Year"))
    	{
    		intervalDuration = s + " YEARS ";
    	}
    	if(timeInterval.name().equals("Month"))
    	{
    		intervalDuration = s + " MONTHS ";
    	}
    	if(timeInterval.name().equals("Day"))
    	{
    		intervalDuration = s + " DAYS ";
    	}
    	if(timeInterval.name().equals("Hour"))
    	{
    		intervalDuration = s + " HOURS ";
    	}
    	if(timeInterval.name().equals("Minute"))
    	{
    		intervalDuration = s + " MINUTES ";
    	}
    	if(timeInterval.name().equals("Second"))
    	{
    		intervalDuration = s + " SECONDS ";
    	}
    	if(timeInterval.name().equals("Week"))
    	{
    		int k = Integer.valueOf(s) * 7;
    		intervalDuration = k + " DAYS ";
    	}
    	if(timeInterval.name().equals("Quarter"))
    	{
    		int k = Integer.valueOf(s) * 91;
    		intervalDuration = k + " DAYS ";
    	}
    	return intervalDuration;
    }

}
