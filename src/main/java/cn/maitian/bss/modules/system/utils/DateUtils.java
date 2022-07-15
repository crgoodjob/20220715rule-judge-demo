package cn.maitian.bss.modules.system.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    public static String YEAR = "year";
    public static String MONTH = "month";
    public static String DAY = "day";
    public static String HOUR = "hour";
    public static String MINUTE = "minute";
    public static String SECOND = "second";
    public static String MILL_SECOND = "mill-second";

    /**
     * 日期验证
     *
     * @param dateStr
     * @return
     */
    public static Date checkDate(String dateStr) {
        if (dateStr == null)
            return null;
        if ("".equals(dateStr))
            return null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天开始的时间
     *
     * @param dateString
     * @return
     */
    public static Date StrToDayStartDate(String dateString) {
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        try {
            String date = DateUtils.formatDate(DateUtils.parseDate(dateString), "yyyy-MM-dd");
            date = date + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天开始的时间
     *
     * @param date
     * @return
     */
    public static Date dateToDayStartDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            String dateString = DateUtils.formatDate(date, "yyyy-MM-dd");
            dateString = dateString + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天开始的时间
     *
     * @param date
     * @return
     */
    public static Date dateToStartDay(Date date) {
        if (date == null) {
            return null;
        }
        try {
            String startDate = DateUtils.formatDate(date, "yyyy-MM-dd");
            startDate = startDate + " 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.parse(startDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天开始的时间
     *
     * @param dateString
     * @return
     */
    public static String StrToDayStartStr(String dateString) {
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        try {
            String date = DateUtils.formatDate(DateUtils.parseDate(dateString), "yyyy-MM-dd");
            date = date + " 00:00:00";
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天结束的时间
     *
     * @param dateString
     * @return
     */
    public static Date StrToDayEndDate(String dateString) {
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        try {
            String date = DateUtils.formatDate(DateUtils.parseDate(dateString), "yyyy-MM-dd");
            date = date + " 23:59:59";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天结束的时间
     *
     * @param date
     * @return
     */
    public static Date dateToEndDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            String strDate = DateUtils.formatDate(date, "yyyy-MM-dd");
            strDate = strDate + " 23:59:59";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.parse(strDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把某一天时间，转换成一天结束的时间
     *
     * @param dateString
     * @return
     */
    public static String StrToDayEndStr(String dateString) {
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        try {
            String date = DateUtils.formatDate(DateUtils.parseDate(dateString), "yyyy-MM-dd");
            date = date + " 23:59:59";
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateToStr(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String getDateToStr(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String getStartAndEndStrByDate(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String startDateStr = "";
        String endDateStr = "";
        if (startDate != null) {
            startDateStr = dateFormat.format(startDate);
        }
        if (endDate != null) {
            endDateStr = dateFormat.format(endDate);
        }
        if (StringUtils.isBlank(startDateStr) && StringUtils.isBlank(endDateStr)) {
            return "";
        }
        return startDateStr + "#" + endDateStr;
    }

    public static String timeToStr(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String dateToTimeStr(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String customDateToStr(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static Date getStandardDate(String source, String pattern) {
        if (source == null || source.trim().length() == 0)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        try {
            return sf.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    public static String getDateStr() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        // Date dBeginDate;
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    public static String getTimeStr() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
        // Date dBeginDate;
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    /**
     * 获取小时分钟秒
     *
     * @param date
     * @return hh:mm:ss
     * @author HanHao
     */
    public static String getTimeStrByDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        // Date dBeginDate;
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    public static Date getSysDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取当月第一天的日期
     */
    public static Date getFirstDateOfMonth() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(getSysDate()); // someDate 为你要获取的那个月的时间
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
        // ca.add(Calendar.MONTH,1);
        // ca.add(Calendar.DAY_OF_MONTH,-1);
        // Date lastDate = ca.getTime();
    }

    /**
     * 获取当月最后一天的日期
     */
    public static Date getLastDateOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getSysDate());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取传入日期月第一天的日期
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); // someDate 为你要获取的那个月的时间
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取传入日期月最后一天的日期
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取当年第一天的日期
     */
    public static Date getFirstDateOfYear() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH, 0);
        ca.roll(Calendar.DATE, -1);
        return ca.getTime();
    }

    /**
     * 获取当年最后一天的日期
     */
    public static Date getLastDateOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(addYear(getSysDate(), 1));
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 0);
        return cal.getTime();
    }

    /**
     * 获取传入日期的年第一天的日期
     */
    public static Date getFirstDateOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(DateUtils.formatDate(date, "yyyy")));
        return calendar.getTime();
    }

    /**
     * 获取传入日期的年最后一天的日期
     */
    public static Date getLastDateOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(DateUtils.formatDate(date, "yyyy")));
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    public static Date preMonthFirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return StrToDayStartDate(sdf.format(cal.getTime()));
    }

    public static Date stringToDate(String str_date) {
        if (str_date == null || str_date.equals("")) {
            System.out.println("转换的日期字符串为空!");
            return null;
        }
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
            dt = form.parse(str_date);
        } catch (ParseException e) {
            System.out.println("unparseable using " + form);
        }
        return dt;
    }

    public static Date stringToTime(String str_date) {
        if (str_date == null || str_date.equals("")) {
            // System.out.println("转换的日期字符串为空!");
            return null;
        }
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = null;
        try {
            dt = form.parse(str_date);
        } catch (ParseException e) {
            // System.out.println("unparseable using " + form);
        }
        return dt;
    }

    /**
     * (根据当前时间点为参照点) 得到任何日期时间,比如去年的今天的时候，上个月今天的时间、下个月当天时间
     *
     * @param field  Calendar.Year = 1; MONTH = 2; WEEK_OF_YEAR = 3;WEEK_OF_MONTH =
     *               4;DAY_OF_MONTH = 5;DAY_OF_YEAR = 6
     * @param amount : int
     * @return Date
     * @author gaojian
     * @date 2013-9-13
     * <p>
     * For instance: 得到昨天的日期 getAnyDateBy（Calendar.DAY_OF_MONTH,-1）;
     * 得到下个月日期 getAnyDateBy（Calendar.MONTH,+1）;
     */
    public static Date getAnyDateBy(int field, int amount) {
        // 默认格式
        Calendar c = Calendar.getInstance();
        c.add(field, amount);
        return c.getTime();
    }

    /**
     * 根据日期得到日期的年份
     *
     * @param date
     * @return int
     * @author gaojian
     * @date 2-13-9-14
     */
    public static int getYearTimeOfDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 根据日期得到月份
     *
     * @param date
     * @return
     * @author gaojian
     * @date 2013-9-14
     */
    public static int getMonthTimeOfDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * @param date
     * @return int 返回类型
     * @throws @create by Simon 2013-12-16上午10:54:01
     * @Title: getDayTimeOfDate
     * @Description: TODO(根据日子得到当日)
     */
    public static int getDayTimeOfDate(Date date) {
        Calendar c = Calendar.getInstance();
        if (date != null) {
            c.setTime(date);
        }
        return c.get(Calendar.DATE);
    }

    /**
     * @param date
     * @return int 返回类型
     * @throws @create by Simon 2013-12-16上午10:54:01
     * @Title: getDayTimeOfHour
     * @Description: TODO(根据日子得到小时)
     */
    public static int getDayTimeOfHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @param date
     * @return int 返回类型
     * @throws @create by Simon 2013-12-16上午10:54:01
     * @Title: getDayTimeOfMinute
     * @Description: TODO(根据日子得到分)
     */
    public static int getDayTimeOfMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 格式化日期类为yyyy-MM-dd格式日期类 liu_xs
     *
     * @param datetime 需要转化的日期
     * @return 转化后的日期
     */
    public static Date parseDate(Date datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if (datetime == null) {
            return null;
        } else {
            try {
                return formatter.parse(formatter.format(datetime));
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 2012-8-7 得到当前时间的格式化字符串
     *
     * @param type 日期格式
     * @return 指定日期格式的当前时间的字符串
     */
    public static String getFormatDate(String type) {
        return (formatDate(now(), type));
    }

    /**
     * 2012-8-7 得到当前时间的格式化字符串
     *
     * @return yyyy-MM-dd HH:mm:ss格式的当前时间的字符串
     */
    public static String getDefaultDate() {
        return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 2012-8-7 得到当前时间的格式化字符串
     *
     * @return yyyy-MM-dd格式的当前时间的字符串
     */
    public static String getFormatDate() {
        return (formatDate(now(), "yyyy-MM-dd"));
    }

    /**
     * 2012-8-7 得到当前时间的格式化字符串
     *
     * @return yyyyMM格式的当前时间的字符串
     */
    public static String getFormatDate1() {
        return (formatDate(now(), "yyyyMM"));
    }

    /**
     * 2012-8-7 根据传入的日期类型格式化日期
     *
     * @param date    需要格式化的日期
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null)
            return "";
        if (pattern == null)
            pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        // sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return (sdf.format(date));
    }

    /**
     * 2012-8-7 根据传入的日期类型格式化日期字符串
     *
     * @param dateStr 需要格式化的日期字符串
     * @param pattern 日期格式
     * @return 格式化后的日期
     */
    public static Date formatDate(String dateStr, String pattern) {
        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        // sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date d = null;
        try {
            if (dateStr == null) {
                d = null;
            } else {
                d = sdf.parse(dateStr);
            }
        } catch (ParseException e) {
            return null;
        }
        return d;
    }

    /**
     * 2012-8-7 将传入的日期格式化为yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param date 需要格式化的日期
     * @return 格式化后的日期字符串
     */
    public static String formatDateTime(Date date) {
        return (formatDate(date, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 2012-8-7 将当前日期格式化为yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @return 格式化后的日期字符串
     */
    public static String formatDateTime() {
        return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 2012-8-7 返回当前日期
     *
     * @return 当前日期
     */
    public static Date now() {
        return (new Date());
    }

    /**
     * 2012-8-7 将字符串转换成日期类(yyyy-MM-dd HH:mm:ss)
     *
     * @param datetime 需要转化的日期字符串
     * @return 转化后的日期
     */
    public static Date parseDateTime(String datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ((datetime == null) || (datetime.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(datetime);
            } catch (ParseException e) {
                return parseDate(datetime);
            }
        }
    }

    /**
     * 2012-8-7 将字符串转换成日期类(yyyy-MM-dd)
     *
     * @param date 需要转化的日期字符串
     * @return 转化后的日期
     */
    public static Date parseDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if ((date == null) || (date.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 2012-8-7 将字符串转换成日期类(yyyyMMdd)
     *
     * @param date 需要转化的日期字符串
     * @return 转化后的日期
     */
    public static Date parseDate2(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if ((date == null) || (date.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 2012-8-7 格式化日期类
     *
     * @param datetime 需要格式化的日期
     * @param str      日期格式
     * @return 转化后的日期
     */
    public static Date parseDate(Date datetime, String str) {
        if (str == null || "".equals(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(str);
        // formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if (datetime == null) {
            return null;
        } else {
            try {
                return formatter.parse(formatter.format(datetime));
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 2012-8-7 将传入的对象转成日期字符串（对象为空不转换）
     *
     * @param o 需要转化的对象
     * @return 转化后的日期字符
     */
    public static String formatDate(Object o) {
        if (o == null)
            return "";
        if (o.getClass() == String.class)
            return formatDate((String) o);
        else if (o.getClass() == Date.class)
            return formatDate((Date) o);
        else if (o.getClass() == Timestamp.class) {
            return formatDate(new Date(((Timestamp) o).getTime()));
        } else
            return o.toString();
    }

    public static String formatDate(Date date) {
        if (date == null)
            return "";
        String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
        if ("00:00:00".equals(dateStr)) {
            return (formatDate(date, "yyyy-MM-dd"));
        }
        return (formatDate(date, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 2012-8-7 给时间加上或减去指定毫秒，秒，分，时，天、月或年等，返回变动后的时间
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param field  时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
     *               Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return 变动后的时间
     */
    public static Date add(Date date, int field, int amount) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, amount);

        return cal.getTime();
    }

    /**
     * 2012-8-7 返回所传时间加上微秒的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addMilliSecond(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上秒的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addSecond(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上分钟的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addMiunte(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上小时的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addHour(Date date, int amount) {
        return add(date, Calendar.HOUR, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上天的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addDay(Date date, int amount) {
        return add(date, Calendar.DATE, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上月的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addMonth(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 2012-8-7 返回所传时间加上年的时间结果
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减
     * @return
     */
    public static Date addYear(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 2012-8-7 返回格式化为yyyy-MM-dd HH:mm:ss的字符串的当前日期
     *
     * @return 格式化后的日期
     */
    public static Date getDateTime() {
        return parseDateTime(formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 2012-8-7 返回格式化的字符串转化成的日期类
     *
     * @param d       需要转化的日期
     * @param pattern 日期格式
     * @return 格式化后的日期
     */
    public static Date getDateTime(Date d, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        return parseDateTime(formatDate(d, pattern));
    }

    /**
     * 2012-8-7 格式化特定格式的日期
     *
     * @param Date "20090214" or "20091225134520"
     * @return "2009-02-14" or "2009-12-25 13:45:20"
     */
    public static String formatDate2(String Date) {
        if ((null != Date) && (!(Date.equals(""))) && (Date.length() == 8) && !isNaN(Date)) {
            Date = Date.substring(0, 4) + "-" + Date.substring(4, 6) + "-" + Date.substring(6, 8);
        } else if ((null != Date) && (!(Date.equals(""))) && (Date.length() == 14) && !isNaN(Date)) {
            Date = Date.substring(0, 4) + "-" + Date.substring(4, 6) + "-" + Date.substring(6, 8) + " " + Date.substring(8, 10) + ":" + Date.substring(10, 12)
                    + ":" + Date.substring(12, 14);
        }
        return Date;
    }

    /**
     * 2012-8-7 判断所传入的字符串是否是数字，不是：true；是：false
     *
     * @param num 需要判断的字符串
     * @return 是否是数字
     */
    public static boolean isNaN(String num) {
        String number = "1234567890";
        for (int i = 0; i < num.length(); i++) {
            if (number.indexOf(num.charAt(i)) == -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2012-8-7 返回dateString指定部分的值，如果是week则返回周的第几天
     *
     * @param dateString 日期字符串
     * @param part       指明需要返回的是日期哪个部分的值
     * @return 指定部分的值
     */
    public static String getPart(String dateString, String part) {
        // yyyy-MM-dd HH:mm:ss
        String result = "";
        String[] parts = dateString.split("-| |:");
        if (parts.length >= 0 && part.equalsIgnoreCase("year")) {
            result = parts[0];
        }
        if (parts.length >= 1 && part.equalsIgnoreCase("month")) {
            result = parts[1];
        }
        if (part.equalsIgnoreCase("week")) {
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(DateUtils.parseDate(dateString));
                result = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
            } catch (Exception e) {
                return "0";
            }
        }
        if (parts.length >= 2 && part.equalsIgnoreCase("day")) {
            result = parts[2];
        }
        if (parts.length >= 3 && part.equalsIgnoreCase("Hour")) {
            result = parts[3];
        }
        if (parts.length >= 4 && part.equalsIgnoreCase("minute")) {
            result = parts[4];
        }
        if (parts.length >= 5 && part.equalsIgnoreCase("second")) {
            result = parts[5];
        }
        return result;
    }

    /**
     * 2012-8-7 将yyyy-MM-dd hh:mm:ss转换成yyyymmddhhmmss格式
     *
     * @param dateString 需要转化的日期字符
     * @return 转化后的日期字符
     */
    public static String formateToNumber(String dateString) {
        String result = null;
        if (dateString == null || dateString.trim().equals("")) {
            result = "";
        } else {
            result = dateString.replaceAll("[- :]", "");
        }
        return result;
    }

    /**
     * 2012-8-7 验证yyyyMMddHHmmss型字符串是否为合法的时间
     *
     * @param time 需要验证的日期字符
     * @return 验证结果
     */
    public static boolean isTrueTime(String time) {

        boolean b = true;

        // 判断是否全为数字
        if (isNaN(time))
            return false;

        // 根据位数做不同的验证
        int length = time.length();
        if (length == 12) {// 不包含秒
            b = isTrueTimeExceptSecond(time);
        } else if (length == 14) {
            boolean bSecond = true;
            int second = Integer.parseInt(time.substring(12, 14));// 获取秒
            if (second < 0 || second > 59) {// 秒超出范围
                bSecond = false;
            }
            b = isTrueTimeExceptSecond(time) && bSecond;
        } else {
            b = false;
        }
        return b;
    }

    /**
     * 2012-8-7 验证yyyyMMddHHmm型字符串是否为合法的时间
     *
     * @param time 需要验证的日期字符
     * @return 验证结果
     */
    private static boolean isTrueTimeExceptSecond(String time) {

        // 年月日 时 分
        int year = Integer.parseInt(time.substring(0, 4));
        int month = Integer.parseInt(time.substring(4, 6));
        int day = Integer.parseInt(time.substring(6, 8));
        int hour = Integer.parseInt(time.substring(8, 10));
        int minute = Integer.parseInt(time.substring(10, 12));

        if (month < 1 || month > 12 || day < 1 || day > 31) {// 月份和日期超出范围
            return false;
        }

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {// 时分超出范围
            return false;
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {// 闰年
            return checkDay(true, month, day);
        } else {
            return checkDay(false, month, day);
        }

    }

    /**
     * 2012-8-7 验证小月天数是否超出范围
     *
     * @param isLeapYear 是否为闰年
     * @param month      月份
     * @param day        日期
     * @return
     */
    private static boolean checkDay(boolean isLeapYear, int month, int day) {
        boolean b = true;
        int count = 28;
        if (isLeapYear == true) {
            count = 29;
        }
        switch (month) {
            case 2:
                if (day > count) {
                    b = false;
                }
                break;
            case 4:
                if (day > 30) {
                    b = false;
                }
                break;
            case 6:
                if (day > 30) {
                    b = false;
                }
                break;
            case 9:
                if (day > 30) {
                    b = false;
                }
                break;
            case 11:
                if (day > 30) {
                    b = false;
                }
                break;
            default:
                break;
        }
        return b;
    }

    /**
     * 获取时间在一年中是多少周 周一为开始，周日未结束
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        int week = g.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            g.setTime(addDay(date, -1));
            return g.get(Calendar.WEEK_OF_YEAR);
        } else {
            return g.get(Calendar.WEEK_OF_YEAR);
        }
    }

    /**
     * 某年第几周周一是XX年XX月XX日
     *
     * @param year    年份
     * @param weekNum 周数
     * @return
     */
    public static String getWeekFirst(int year, int weekNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year - 1, 11, 31);
        int lastWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.WEEK_OF_YEAR, weekNum - lastWeekNum);
        return formatDate(calendar.getTime(), "yyyy-MM-dd");
    }

    /**
     * 某年第几周第几天是XX年XX月XX日
     *
     * @param year    年份
     * @param weekNum 周数
     * @param num     天数
     * @return
     */
    public static String getDateOfWeek(int year, int weekNum, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year - 1, 11, 31);
        int lastWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);

        switch (num) {
            case 2:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case 3:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case 4:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case 5:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            case 6:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
            case 7:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            default:
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }
        if (num == 7) {
            weekNum += 1;
            calendar.add(Calendar.WEEK_OF_YEAR, weekNum - lastWeekNum);
            return formatDate(calendar.getTime(), "yyyy-MM-dd");
        } else {
            calendar.add(Calendar.WEEK_OF_YEAR, weekNum - lastWeekNum);
        }
        return formatDate(calendar.getTime(), "yyyy-MM-dd");
    }

    /***
     *
     * @Title: getFormerlyDateByNumber @Description:
     *         TODO(获取几天前后的日期) @param @param day 负数 为未来X天后的日期 ；正数为
     *         今天时间-X天的日期 @param @return 设定文件 @return String 返回类型 yyyy-MM-dd
     *         格式时间串 @throws
     */
    public static String getFormerlyDateByNumber(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -day);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /***
     * @Title: getLastDayByMonth @Description: TODO(根据传入的月份 获取 这个月的最后一天
     *         的日期) @param @param month 日期参数 格式 yyyy-mm 不需要传入日 @param @return
     *         设定文件 @return String 返回类型 yyyy-mm-dd @throws
     */
    public static String getLastDayByMonth(String month) {

        if (null == month || "".equals(month))
            return "";

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Calendar cale = Calendar.getInstance();

            cale.setTime(format.parse(month));

            cale.set(Calendar.DAY_OF_MONTH, 1);

            cale.roll(Calendar.DATE, -1);

            return formatDate(cale.getTime(), "yyyy-MM-dd");

        } catch (Exception e) {
            return "";
        }

    }

    /**
     * 以当前时间作比较 可以获取昨天、明天...的日期字符串
     *
     * @param number  0为当前时间不变，-1为昨天，-2为前天，1为明天，2为后天，以此类推
     * @param pattern 格式
     * @return
     */
    @SuppressWarnings("static-access")
    public static String getDateStrByNow(int number, String pattern) {
        Date date = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, number);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 返回上个月的第一天/最后一天的Date类型
     *
     * @param flag 1为第一天，2为最后一天
     * @return
     */
    public static Date getFirstDayOrLastDayOfLastMonth(int flag) {
        Calendar cal = Calendar.getInstance();
        // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        // cal.set(Calendar.YEAR,2012)
        // cal.set(Calendar.MONTH, 6);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();

        if (1 == flag) {
            return firstDate;
        } else if (2 == flag) {
            return lastDate;
        }

        return null;
    }

    /***
     * @Title: dayForWeek
     * @Description: TODO(获取日期字符串内 是星期几1 - 7)
     * @param pTime
     * @return
     * @throws Exception
     * @return int 返回类型
     * @throws @create
     *             by Simon 2013-12-14上午10:03:22
     */
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 获取当前日期是星期几
     *
     * @param dt 当前日期
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {

        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];

        /*
         * if (dt == null) return "";
         *
         * SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); return
         * sdf.format(dt);
         */

    }

    /**
     * 得到当前日期 的 上X个月 的第一天
     *
     * @param d
     * @param month
     * @return
     */
    public static Date getLastMonthStartDay(Date d, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MARCH, -month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static Date getDay(Date d, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    public static Date getLastMonthEndDay(Date d, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MARCH, -month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String getSimpleDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 计算日期相差天数
     *
     * @param early 开始日期
     * @param late  结束日期
     * @return 相差天数
     */
    public static final int daysBetween(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        // 得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24 + 1;

        return days;
    }

    /**
     * @方法描述： 判定时间是否有交叉
     * @创建人：LYJ @创建时间：2015-4-21 上午10:29:23
     * @修改人：LYJ @修改时间：2015-4-21 上午10:29:23 @修改备注： @param： @param List
     * <Date[][]> 时间段的List @param： @return 返回具体的时间段
     */
    public static String checkDateOverlap(List<Date[][]> datesList) {
        String dateResult = null;
        for (int i = 0; i < datesList.size() - 1; i++) {
            int a = i;
            for (int j = 0; j < datesList.size() - 1 - i; j++) {
                // 如果第一个时间段的结束时间大于第二个时间段的开始时间,存在交集
                if (datesList.get(i)[1][0].getTime() > datesList.get(a + 1)[0][0].getTime()) {
                    // 如果第一个时间段的开始时间小于第二个时间段的结束时间存在交集
                    if (datesList.get(i)[0][0].getTime() < datesList.get(a + 1)[1][0].getTime()) {
                        dateResult = formatDate(datesList.get(i)[0][0], "yyyy-MM-dd") + "到" + formatDate(datesList.get(i)[1][0], "yyyy-MM-dd");
                        break;
                    }
                } else {
                    // datesList.remove(i);
                }
                a++;
            }
        }
        return dateResult;
    }

    /**
     * @方法描述： 求时间差
     * @创建人：LYJ @创建时间：2015-4-21 下午3:16:05
     * @修改人：LYJ @修改时间：2015-4-21 下午3:16:05 @修改备注： @param： @param typeFlag 类型 0:秒;
     * 1:分钟; 2:小时; 3:天; @param： @param begin @param： @param
     * end @param： @return
     */
    public static final int datesBetween(int typeFlag, Date begin, Date end) {
        long result = 0;
        switch (typeFlag) {
            case 0:
                result = ((end.getTime()) - (begin.getTime())) / 1000;
                break;
            case 1:
                result = ((end.getTime()) - (begin.getTime())) / 1000 / 60;
                break;
            case 2:
                result = ((end.getTime()) - (begin.getTime())) / 1000 / 60 / 60;
                break;
            case 3:
                result = ((end.getTime()) - (begin.getTime())) / 1000 / 60 / 60 / 24;
                break;
            default:
                break;
        }
        return (int) result;
    }

    /**
     * @方法描述： 求时间差（注意：不是准确到时分秒的，如果是天，必须是一个月内的）
     * @创建人：LYJ
     * @创建时间：2015-7-9 上午10:37:17
     * @修改人：LYJ
     * @修改时间：2015-7-9 上午10:37:17 @修改备注： @param： @param typeFlag @param： @param
     * begin 开始时间 @param： @param end 结束时间 @param： @return
     */
    public static final int dateDiff(String typeFlag, Date begin, Date end) {
        int result = 0;
        if (!StringUtils.isBlank(typeFlag) && null != begin && null != end && begin.getTime() < end.getTime()) {
            if ("year".equals(typeFlag) || "y".equals(typeFlag)) {
                int beginTmp = Integer.valueOf(formatDate(begin, "yyyy"));
                int endTmp = Integer.valueOf(formatDate(end, "yyyy"));
                result = endTmp - beginTmp;
            }
            if ("month".equals(typeFlag) || "m".equals(typeFlag)) {
                int beginTmp = Integer.valueOf(formatDate(begin, "MM"));
                int endTmp = Integer.valueOf(formatDate(end, "MM"));
                result = endTmp - beginTmp;
            }
            if ("day".equals(typeFlag) || "d".equals(typeFlag)) {
                int beginTmp = Integer.valueOf(formatDate(begin, "dd"));
                int endTmp = Integer.valueOf(formatDate(end, "dd"));
                result = endTmp - beginTmp;
            }
        }
        return result;
    }

    public static String getHHMMSS(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String hour = "" + (c.get(Calendar.HOUR_OF_DAY) < 9 ? "0" + c.get(Calendar.HOUR_OF_DAY) : c.get(Calendar.HOUR_OF_DAY));
        String minute = "" + (c.get(Calendar.MINUTE) < 9 ? "0" + c.get(Calendar.MINUTE) : c.get(Calendar.MINUTE));
        String second = "" + (c.get(Calendar.SECOND) < 9 ? "0" + c.get(Calendar.SECOND) : c.get(Calendar.SECOND));
        return hour + ":" + minute + ":" + second;
    }

    public static String get(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String hour = "" + (c.get(Calendar.HOUR_OF_DAY) < 9 ? "0" + c.get(Calendar.HOUR_OF_DAY) : c.get(Calendar.HOUR_OF_DAY));
        String minute = "" + (c.get(Calendar.MINUTE) < 9 ? "0" + c.get(Calendar.MINUTE) : c.get(Calendar.MINUTE));
        String second = "" + (c.get(Calendar.SECOND) < 9 ? "0" + c.get(Calendar.SECOND) : c.get(Calendar.SECOND));
        return hour + ":" + minute + ":" + second;
    }

    /**
     * 获取两个时间段之间的每一天（返回的时间为startDate —— endDate-1）
     *
     * @param start
     * @param endDate
     * @author 柳松
     * @date 2015-5-26 下午7:59:41
     */
    public static List<Date> getDateArrays(Date start, Date endDate) {
        Date begin = DateUtils.dateToStartDay(start);
        Date end = DateUtils.dateToStartDay(endDate);

        List<Date> list = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(begin);

        while (calendar.getTime().before(end)) {
            list.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return list;
    }

    public static Map<String, Integer> compareTo(final Date date1, final Date date2) {
        if (date1 == null || date2 == null) {
            return null;
        }
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long time = Math.max(time1, time2) - Math.min(time1, time2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(YEAR, (calendar.get(Calendar.YEAR) - 1970) > 0 ? (calendar.get(Calendar.YEAR) - 1970) : 0);
        map.put(MONTH, (calendar.get(Calendar.MONTH) - 1) > 0 ? (calendar.get(Calendar.MONTH) - 1) : 0);
        map.put(DAY, (calendar.get(Calendar.DAY_OF_MONTH) - 1) > 0 ? (calendar.get(Calendar.DAY_OF_MONTH) - 1) : 0);
        map.put(HOUR, (calendar.get(Calendar.HOUR_OF_DAY) - 8) > 0 ? (calendar.get(Calendar.HOUR_OF_DAY) - 8) : 0);
        map.put(MINUTE, calendar.get(Calendar.MINUTE) > 0 ? calendar.get(Calendar.MINUTE) : 0);
        map.put(SECOND, calendar.get(Calendar.SECOND) > 0 ? calendar.get(Calendar.SECOND) : 0);
        map.put(MILL_SECOND, calendar.get(Calendar.MILLISECOND) > 0 ? calendar.get(Calendar.MILLISECOND) : 0);
        return map;
    }

    /**
     * 得到时间差异
     *
     * @param startDate
     * @param endDate
     * @return
     * @author 禹研超
     * @date 2013-12-13 下午5:37:40
     */

    public static String getDiffTimeDesc(Date startDate, Date endDate) {
        Map<String, Integer> map = compareTo(endDate, startDate);
        StringBuffer desc = new StringBuffer();
        if (map.get(DAY) > 0) {
            desc.append(map.get(DAY) + "天");
        }
        if (map.get(HOUR) > 0) {
            desc.append(map.get(HOUR) + "小时");
        }
        if (map.get(MINUTE) > 0) {
            desc.append(map.get(MINUTE) + "分钟");
        }
        if (map.get(SECOND) > 0) {
            desc.append(map.get(SECOND) + "秒");
        }
        if (map.get(MILL_SECOND) > 0) {
            desc.append(map.get(MILL_SECOND) + "毫秒");
        }
        return desc.toString();
    }

    /**
     * @param @return
     * @return int
     * @throws @author hzk
     * @Description: 获取当月天数
     * @date 2015-5-25
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * @param @return
     * @return int
     * @throws @author hzk
     * @Description: 获取昨天日期
     * @date 2015-5-25
     */
    public static Date getyesterdayDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        return parseDate(yesterday);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println(DateUtil.daysBetween(formatDate("2016-8-29
        // 15:34:20", "yyyy-MM-dd hh:mm:ss"),formatDate("2016-8-30 16:01:00",
        // "yyyy-MM-dd hh:mm:ss")));
        // System.out.println(DateUtil.datesBetween(3, formatDate("2022-8-29
        // 15:34:20", "yyyy-MM-dd hh:mm:ss"),formatDate("2023-8-29 15:34:21",
        // "yyyy-MM-dd hh:mm:ss"))) ;
        // System.out.println(DateUtil.datesBetween(3, formatDate("2022-8-29
        // 15:34:20", "yyyy-MM-dd hh:mm:ss"),
        // formatDate("2022-8-29 15:34:20", "yyyy-MM-dd hh:mm:ss")));

        // System.out.println(formatDae("2022-8-29 23:59:59", "yyyy-MM-dd
        // hh:mm:ss").compareTo(formatDate("2022-8-29 23:59:59", "yyyy-MM-dd
        // hh:mm:ss")));
        // System.out.println(DateUtil.daysBetween(DateUtil.stringToDate(DateUtil.dateToStr(new
        // Date())),
        // DateUtil.stringToDate(DateUtil.dateToStr(DateUtil.addDay(new Date(),
        // 1)))));
        // System.out.println(StringUtils.isNotBlank(" "));
        // Date attDate = DateUtil.formatDate("" + " 00:00:00", "yyyy-MM-dd
        // HH:mm:ss");
        // int size = 22;
        // StringBuffer hql = new StringBuffer();
        // hql.append(" and (sysPost.id in (");
        // StringBuffer question = new StringBuffer();
        // for (int i = 1; i <= size; i++) {
        // question.append("?,");
        // if (i % 5 == 0) {
        // question.delete(question.lastIndexOf(","), question.length());
        // question.append(")");
        // if (i != size) {
        // question.append(" or sysPost.id in (");
        // }
        // }
        // if (i == size && size % 5 != 0) {
        // question.delete(question.lastIndexOf(","), question.length());
        // question.append(")");
        // }
        // System.out.println(question.toString());
        // }
        // hql.append(question);
        // hql.append(")");
        // System.out.println(hql.toString());

        // int size = 6;
        // int max = 9;
        // int min = 1;
        // for (int i = 0; i < size; i++) {
        // Random random = new Random();
        // int randomInt = random.nextInt(max) % (max - min + 1) + min;
        // System.out.print(randomInt);
        // }
        // int days = DateUtil.datesBetween(3, getFirstDateOfMonth(),
        // DateUtil.addDay(getFirstDateOfMonth(), 3));
        // System.out.println(days);
//		String prefix="a.a.a..a.jpg".substring("a.a.a..a.jpg".lastIndexOf(".")+1);
//		System.out.println(prefix);

        //System.out.println(DateUtil.getDayTimeOfDate(new Date()));
        System.out.println(DateUtils.getYearAndMonthForMove(false));
    }

    /**
     * @param @param  beginDate
     * @param @param  endDate
     * @param @param  lDate
     * @param @return
     * @return List<String>
     * @throws @author hzk
     * @Description: 获取给定时间段内的 每天的日期集合
     * @date 2015-7-29
     */
    public static List<String> getDatesBetweenTwoDate(Date beginDate, Date endDate, List<String> lDate) {
        String beginStr = formatDate(beginDate, null);
        lDate.add(beginStr);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(formatDate(cal.getTime(), null));
            } else {
                break;
            }
        }
        if (!beginDate.equals(endDate)) {
            lDate.add(formatDate(endDate, null));// 把结束时间加入集合
        }
        return lDate;
    }

    /**
     * @param @param  beginDate
     * @param @return
     * @return String
     * @throws @author hzk
     * @Description: 获取下一天
     * @date 2015-7-29
     */
    public static String getNextDate(Date beginDate) {
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return formatDate(cal.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 判断时间是否在指定时间段内
     *
     * @param checkDate
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean checkDateBetweenDays(Date checkDate, Date beginDate, Date endDate) {
        if (!checkDate.before(beginDate) && !checkDate.after(endDate)) {
            return true;
        }
        return false;
    }

    public static Date getMonthStartTime() {
        return DateUtils.dateToDayStartDate(DateUtils.getFirstDateOfMonth());
    }

    public static Date getMonthStartTime(Date date) {
        return DateUtils.dateToDayStartDate(DateUtils.getFirstDateOfMonth(date));
    }

    public static String dateToMonthStr(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String lastMonthStr(Date date) {
        if (date != null) {
            date = DateUtils.addMonth(date, -1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            // Date dBeginDate;
            String dateStr = dateFormat.format(date);
            return dateStr;
        }
        return null;
    }

    public static String lastMonthStrByStr(String dateString) {
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        try {
            String date = DateUtils.formatDate(DateUtils.addMonth(DateUtils.parseDate(dateString), -1), "yyyy-MM");
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static int getMonthByNow() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;// 获取月份
    }

    public static String getYearAndMonthByDate(Date date) {
        try {
            String dateStr = DateUtils.formatDate(DateUtils.parseDate(date), "yyyy-MM");
            return dateStr;
        } catch (Exception e) {
            return null;
        }
    }

    public static int getMonthByDate(Date date) {
        try {
            String dateStr = DateUtils.formatDate(DateUtils.parseDate(date), "MM");
            return Integer.parseInt(dateStr);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取当前生效月份
     *
     * @param flag
     * @return
     * @Title: getYearAndMonthForMove
     * @author XuGuangHui
     */
    public static int getYearAndMonthForMove(boolean flag) {
        Calendar cal = Calendar.getInstance();
        if (flag) {
            cal.add(2, +1);
        }
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;// 获取月份
        if (month < 10) {
            return Integer.parseInt(year + "0" + month);
        } else {
            return Integer.parseInt(year + "" + month);
        }
    }

    /**
     * 获取当前生效月份
     *
     * @param startDate
     * @return
     * @Title: getYearAndMonthForMove
     * @author XuGuangHui
     */
    public static int getMonthsBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);

    }
    public static String getStartEndDate(String start, String end) {
        if (start == null) start = "";
        if (end == null) end = "";

        String d = start + "#" + end;
        if ("#".equals(d)) {
            return "";
        }
        return d;
    }
}
