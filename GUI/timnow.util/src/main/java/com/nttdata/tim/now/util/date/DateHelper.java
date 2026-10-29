package com.nttdata.tim.now.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateHelper {
    protected static Logger logger = LoggerFactory.getLogger(DateHelper.class);

    public static final String DATE_FORMAT_A = "dd-MM-yyyy";
    public static final String DATE_FE = "dd/MM/yyyy";
    public static final String DATE_BE = "yyyy-MM-dd"; // 2014-05-14T17:00:27.82+0200
    public static final String TIMESTAMP_BE = "yyyy-MM-dd'T'HH:mm:ss.SSSz"; // 2014-05-14T17:00:27.82+0200
    
    //RU_902
    public static final String TIMESTAMP_BE_TRACKING = "yyyy-MM-dd'T'HH:mm:ss.SSS"; //2019-10-21T12:29:30.400 
    

    public static final String DATE_FE_LONG = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_BE_LONG = "yyyy-MM-dd'T'HH:mm:ssX"; // 2014-05-14T17:00:27+0200

    public static final String DATE_BE_LONG2 = "yyyy-MM-dd'T'HH:mm:ssXXX"; // 2014-05-14T17:00:27-05:00

    public static final String TIMEZONE_IT = "Europe/Rome";

    private DateHelper() {
    }

    public static String getESBDate(Date date) {
        String dateString = null;
        try {
            if (date != null) {
                dateString = getFormatDateString(date, DateHelper.DATE_BE);
            }
        } catch (ParseException pe) {
            logger.error("ParseException : ",pe);
        }
        return dateString;
    }

    public static String getESBDateLong(Date date) {
        String dateString = null;
        try {
            if (date != null) {
                dateString = getFormatDateString(date, DateHelper.DATE_BE_LONG2);
            }
        } catch (ParseException pe) {
            logger.error("ParseException : ",pe);
        }
        return dateString;
    }

    public static String getFormatDateString(Date date, String format) throws ParseException {
        DateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    // Bean -> DTO
    public static String convertFromFE(String source) {
        String destination = null;
        if (StringUtils.isNotEmpty(source)) {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FE);
            Date dateSource;
            try {
                dateSource = formatter.parse(source);
                destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_BE);
            } catch (ParseException pe) {
                logger.error("ParseException : ",pe);
            }
        }
        return destination;
    }

    //Bean Long --> DTO Long
    public static String convertFromFELong(String source) {
    	String destination = null;
    	if (StringUtils.isNotEmpty(source)) {
    		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FE_LONG);
    		Date dateSource;
    		try {
    			dateSource = formatter.parse(source);
    			destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_BE_LONG);
    		} catch (ParseException pe) {
    			logger.error("ParseException long value from FELong to BELong: ",pe);
    		}
    	}
    	return destination;
    }

    // Bean -> DTO for IN date
    public static String convertFromFEMultiple(String source, String delimiter) {
        String destination = null;
        if (StringUtils.isNotEmpty(source)) {
            StringTokenizer st = new StringTokenizer(source, delimiter);
            if (st.countTokens()>1){
                StringBuffer destinationTmp = new StringBuffer(); 
                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FE);
                Date dateSourceFirst, dateSourceSecond;
                try {
                    dateSourceFirst = formatter.parse(st.nextToken());
                    dateSourceSecond = formatter.parse(st.nextToken());
                    if (dateSourceFirst.before(dateSourceSecond)){
                        destinationTmp.append(DateHelper.getFormatDateString(dateSourceFirst, DateHelper.DATE_BE));
                        destinationTmp.append(delimiter);
                        destinationTmp.append(DateHelper.getFormatDateString(dateSourceSecond, DateHelper.DATE_BE));
                    }else{
                        destinationTmp.append(DateHelper.getFormatDateString(dateSourceSecond, DateHelper.DATE_BE));
                        destinationTmp.append(delimiter);
                        destinationTmp.append(DateHelper.getFormatDateString(dateSourceFirst, DateHelper.DATE_BE));
                    }
                    destination = destinationTmp.toString();
                } catch (ParseException pe) {
                    logger.error("ParseException : ",pe);
                }
            }else{
                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FE);
                Date dateSource;
                try {
                    dateSource = formatter.parse(source);
                    destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_BE);
                } catch (ParseException pe) {
                    logger.error("ParseException : ",pe);
                }
            }
        }
        return destination;
    }

    
    // DTO -> Bean
    public static String convertFromBE(String source) {
        String destination = null;
        String tmp = source;
        if (StringUtils.isNotEmpty(source)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(DateHelper.DATE_BE);
                if (source.length() > 10) {
                    tmp = source.substring(0, 10);
                }
                Date dateSource = formatter.parse(tmp);
                destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_FE);
            } catch (ParseException pe) {
                logger.error("ParseException : ",pe);
            }
        }
        return destination;
    }

    // DTO Long -> Bean Long
    public static String convertFromBELong(String source) {
        String destination = null;
        if (StringUtils.isNotEmpty(source)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(DateHelper.DATE_BE_LONG);
                Date dateSource = formatter.parse(source);
                destination = DateHelper.getFormatDateString(dateSource, DateHelper.DATE_FE_LONG);
            } catch (ParseException pe) {
                logger.error("ParseException : ",pe);
            }
        }
        return destination;
    }

    //Bean -->DTO
    public static String convertFromFE(String source, String destformat) {
        String destination = null;
        String tmp = source;
        if (StringUtils.isNotEmpty(source)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(DateHelper.DATE_FE);
                if (source.length() > 10) {
                    tmp = source.substring(0, 10);
                }
                Date dateSource = formatter.parse(tmp);
                destination = DateHelper.getFormatDateString(dateSource, destformat);
            } catch (ParseException pe) {
                logger.error("ParseException : ",pe);
            }
        }
        return destination;
    }
   
    
    
    public static Date getNextSelectedDay(Date today, int selected){
        
        Calendar dataC = Calendar.getInstance();
        dataC.setTime(today);
        dataC.add(Calendar.DATE, selected);
        return dataC.getTime();
    }
}
