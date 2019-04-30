package tmall.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

	//Date covert to SQL Time stamp.
	public static Timestamp d2t(Date d) {
		
        if (null == d)
            return null;
        
        return new java.sql.Timestamp(d.getTime());
    }
 
	//SQL Time stamp covert to Date.
    public static Date t2d(Timestamp t) {
    	
        if (null == t)
            return null;
        
        return new Date(t.getTime());
    }
}
