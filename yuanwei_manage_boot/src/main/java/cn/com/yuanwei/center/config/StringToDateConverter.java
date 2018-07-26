package cn.com.yuanwei.center.config;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;

/**
 * 字符串转日期的转换器
 * @author 
 * @version 
 */
public class StringToDateConverter implements Converter<String, Date> {
    private static final String dateFormat      = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String gmtDateFormat = "EEE MMM dd yyyy HH:mm:ss 'GMT' Z";
    private static final String utcDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";

    /** 
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Date convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        source = source.trim();
        try {
        	SimpleDateFormat formatter;
            if (source.contains("-")) {
                if(source.contains("T")){
                	source = source.replace("Z", " UTC");
                	formatter = new SimpleDateFormat(utcDateFormat);
                }else if (source.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                Date dtDate = formatter.parse(source);
                Calendar ca = Calendar.getInstance();
        		ca.setTime(dtDate);
//        		ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY)+8);
//        		System.out.println(ca.getTime());
                return ca.getTime();
//        		return dtDate;
            } else if (source.matches("^\\d+$")) {
                Long lDate = new Long(source);
                return new Date(lDate);
            } else{
            	DateFormatSymbols sym = new DateFormatSymbols(Locale.US);  
            	formatter = new SimpleDateFormat(gmtDateFormat,sym);
                return formatter.parse(source.replace("(中国标准时间)", "").replace("0800", "+0800"));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", source));
        }
    }
    
}
