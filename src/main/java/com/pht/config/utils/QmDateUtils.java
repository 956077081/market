package com.pht.config.utils;

import com.pht.base.frame.LoggerFormator;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class QmDateUtils extends DateUtils {

    private static LoggerFormator log = LoggerFormator.getLogger(QmDateUtils.class);
    private static final String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMdd", "yyyyMMddHHmmss"};

    private static final String MONTH_PATTERN = "yyyy-MM";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final long SECONDS_OF_DAY = 24 * 60 * 60;
    private static final long MILLI_SECONDS = 1000;

    /**
     * 得到两个日期的相差天数
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long getDaysFromDate(String beginDate, String endDate) {
        try {
            Date begin = parseDate(beginDate, DATE_PATTERN);
            Date end = parseDate(endDate, DATE_PATTERN);
            return getDaysFromDate(begin, end);
        } catch (ParseException e) {
            log.error("parse date error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到两个日期的相差天数
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long getDaysFromDate(Date beginDate, Date endDate) {
        return (endDate.getTime() - beginDate.getTime()) / MILLI_SECONDS / SECONDS_OF_DAY;
    }

    /**
     * 获取相对于今天的某一天的时间
     * @param days
     * @return
     */
    public static Date getDateTimeFromDays(int days) {
        Date date = QmDateUtils.addDays(new Date(), days);
        return date;
    }

    /**
     * 获取相对于的某一天的时间
     * @param days
     * @return
     */
    public static Date getDateTimeFromDays(Date dt, int days) {
        Date date = QmDateUtils.addDays(dt, days);
        return date;
    }

    /**
     * 获取当前的日期的字符串（yyyy-MM）
     * @return
     */
    public static String getNowMonth() {
        return DateFormatUtils.format(new Date(), MONTH_PATTERN);
    }

    /**
     * 获取当前的日期的字符串（yyyy-MM-dd）
     * @return
     */
    public static String getNowDate() {
        return DateFormatUtils.format(new Date(), DATE_PATTERN);
    }

    /**
     * 获取当前的日期的字符串（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getNowDateTime() {
        return DateFormatUtils.format(new Date(), DATE_TIME_PATTERN);
    }

    /**
     * 获取当前的日期的字符串（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getNowDateTime(String pattern) {
        Date now = new Date();
        return DateFormatUtils.format(now, pattern);
    }

    public static Date getDateAddSecond(Date beforeDate) {
        Date afterDate = new Date(beforeDate.getTime() + 1000);
        return afterDate;
    }

    /**
     * 时间相加与当前时间比对
     * @param days
     * @return
     */
    public static Boolean compareDateAddDay(Date chargeTime, int days) {
        Date date = QmDateUtils.addDays(chargeTime, days);
        if (date.getTime() < new Date().getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 时间相加与当前时间比对
     * @param
     * @return
     */
    public static Boolean compareDateAddMinutes(Date chargeTime, int minutes) {
        Date date = QmDateUtils.addMinutes(chargeTime, minutes);
        if (date.getTime() < new Date().getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 字串时间比较（1：大于 -1小于 0等于 -2时间格式转换出错）
     * @param startDate
     * @param endDate
     * @return
     */
    public static int compareDate(String startDate, String endDate) {
        try {
            Date start = parseDate(startDate, DATE_PATTERN);
            Date end = parseDate(endDate, DATE_PATTERN);
            if (start.getTime() > end.getTime()) {
                return 1;
            } else if (start.getTime() < end.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            return -2; // 时间格式转换出错
        }
    }

    /**
     * 获取当前年份最后一天的时间
     * @param year 年份
     * @return
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * 获取系统日期（ yyyy-MM-dd）
     */
    public static String getSysDate() {
        return formatDate(new Date());
    }

    /**
     * 获取系统时间（HH:mm:ss）
     */
    public static String getSysTime() {
        return formatTime(new Date());
    }

    /**
     * 获取系统时间（yyyy-MM-dd HH:mm:ss）
     */
    public static String getSysDateTime() {
        return formatDateTime(new Date());
    }

    /**
     * 获取系统下一日（yyyy-MM-dd）
     */
    public static String getNextDate() {
        return getNextDate(new Date());
    }

    /**
     * 获取下一日（yyyy-MM-dd）
     */
    public static String getNextDate(Date date) {
        return formatDate(addDays(date, 1));
    }

    /**
     * 获取下一日（yyyy-MM-dd）
     */
    public static String getNextDate(String date) {
        return getNextDate(parse(date));
    }

    /**
     * 获取下N日（yyyy-MM-dd）
     */
    public static String getNextDate(Date date, int n) {
        return formatDate(addDays(date, n));
    }

    /**
     * 获取下N日（yyyy-MM-dd）
     */
    public static String getNextDate(String date, int n) {
        return getNextDate(parse(date), n);
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 得到日期时间字符串，转换格式（HH:mm:ss）
     */
    public static String formatTime(Date date) {
        return format(date, "HH:mm:ss");
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取系统日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getSysDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String format(Date date, String... pattern) {
        if (date == null) {
            return null;
        }
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0]);
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parse(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将无分隔符的日期字符串转换成日期
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        if (date == null) {
            return null;
        }
        Calendar cldCalendar = convToCalender(date, "yyyyMMddhhmmss");
        return cldCalendar.getTime();

    }

    /**
     * 把指定格式的日期字符串转日期类型
     * @param str
     * @param template
     * @return
     */
    public static Calendar convToCalender(String str, String template) {

        SimpleDateFormat sdf;
        Date date;
        Calendar cltResult = Calendar.getInstance();

        sdf = new SimpleDateFormat(template, Locale.getDefault());
        try {
            date = sdf.parse(str);

            cltResult.setTime(date);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cltResult;
    }

    /**
     * 日期型字符串转化为日期 格式
     * @param str
     * @param pattern
     * @return
     */
    public static Date parse(Object str, String... pattern) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的月数
     * @param date
     * @return
     */
    public static int pastMonths(Date date) {
        Calendar calbeg = Calendar.getInstance();
        Calendar calend = Calendar.getInstance();
        calbeg.setTime(date);
        calend.setTime(new Date());
        int m_beg = calbeg.get(Calendar.MONTH) + 1;
        int m_end = calend.get(Calendar.MONTH) + 1;
        return m_end - m_beg + (calend.get(Calendar.YEAR) - calbeg.get(Calendar.YEAR)) * 12;
    }

    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static Long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        long remainder = t % (60 * 1000);
        long integer = t / (60 * 1000);
        return remainder == 0 ? integer : integer + 1;
    }

    /**
     * 比较两个日期大小
     * @param date
     * @param date2
     * @return >0 大于；0 相等；<0 小于
     */
    public static int compare(Date date, Date date2) {
        if (date.getTime() > date2.getTime()) {
            return 1;
        }
        if (date.getTime() < date2.getTime()) {
            return -1;
        }
        return 0;
    }

    /**
     * 比较两个日期相差天数
     * @param date
     * @param date2
     * @param isPrecise 是否精确比较,比较时分秒
     * @return
     */
    public static int differDay(Date date, Date date2, boolean isPrecise) {
        if (!isPrecise) {
            date = parse(formatDate(date), DATE_PATTERN);
            date2 = parse(formatDate(date2), DATE_PATTERN);
        }
        int days = (int) ((date.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        return days < 0 ? days * -1 : days;
    }

    /**
     * 比较两个日期大小
     * @param date
     * @param date2
     * @return >0 大于；0 相等；<0 小于
     */
    public static int compare(String date, String date2) {
        return compare(parse(date), parse(date2));
    }

    /**
     * 判断时间是否过期
     * @param expiredTime
     * @return
     */
    public static boolean isExpired(Date expiredTime) {
        if (expiredTime == null) {
            return false;
        }
        Date sysDate = new Date();
        if (QmDateUtils.compare(sysDate, expiredTime) < 0) {
            return false;
        }
        return true;
    }

    /**
     * 判断时间是否超过有效期
     * @param timeStr
     * @param intevalMins
     * @return
     */
    public static boolean caluMin(String timeStr, int intevalMins) {
        long time = Long.valueOf(timeStr);
        long currTimes = new Date().getTime();
        if ((currTimes - time) < intevalMins * 60 * 1000) {
            return true;
        }
        return false;
    }

    /**
     * 判断时间是否在两个时间点之间
     * @return
     */
    public static boolean isNowBetween(Date start, Date end) {
        if (null == start || null == end) {
            return false;
        }
        Date now = new Date();
        if (now.before(start) || now.after(end)) {
            return false;
        }
        return true;
    }

    /**
     * 当前日期加减天数
     * @param dailyDate
     * @param i
     * @return
     */
    public static String addDays(String dailyDate, int i) {
        try {
            Date date = parseDate(dailyDate, DATE_PATTERN);
            return DateFormatUtils.format(addDays(date, i), DATE_PATTERN);
        } catch (ParseException e) {
            log.error("parse date error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取第二天凌晨的时间
     * @return
     */
    public static Date getNextEarlyMorningDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 改成这样就好了
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取第二天凌晨的秒数
     * @return
     */
    public static Long getSecondsNextEarlyMorning() {
        Long seconds = (getNextEarlyMorningDate().getTime() - System.currentTimeMillis()) / 1000;
        return seconds.longValue();
    }

    /**
     * 获取当前日期所在月第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 获取当前日期所在月最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    /**
     * 判断当前时间是否为所在月第一天
     * @return
     */
    public static boolean isFirstDayOfMonth() {
        Calendar ca = Calendar.getInstance();
        int idx = ca.get(Calendar.DAY_OF_MONTH);
        if (1 == idx) {
            return true;
        }
        return false;
    }

    /**
     * 判断时间格式是否正确
     * @param dateStr 时间字符串
     * @param pattern 格式
     * @return
     */
    public static boolean isValidDate(String dateStr, String pattern) {
        try {
            DateUtils.parseDate(dateStr, pattern);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取当天是星期几<br>
     * 注意：<br>
     * 1 -> 星期一 <br>
     * 2 -> 星期二<br>
     * ...<br>
     * 7 -> 星期日
     * @return
     */
    public static int getDayOfWeek() {
        Calendar ca = Calendar.getInstance();
        int day = ca.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == day) {
            return 7;
        } else {
            return day - 1;
        }
    }

    /**
     * 获取日期是星期几<br>
     * 注意：<br>
     * 1 -> 星期一 <br>
     * 2 -> 星期二<br>
     * ...<br>
     * 7 -> 星期日
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int day = ca.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == day) {
            return 7;
        } else {
            return day - 1;
        }
    }

    /**
     * 获取日期 例如 ： 2019年01月01日01时01分01秒
     * @param times
     * @return
     */
    public static String getChinsesTime(long times) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(times);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return year + "年" + (month + 1) + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";

    }

    /**
     * 设置更新时间
     * @param entity
     */
    public static void setUpdateTime(Object entity) {
        if (entity == null) {
            return;
        }
        Class<? extends Object> clazz = entity.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField("updateTime");
        } catch (Exception e) {
        }
        if (field == null) {
            // 得到父类,然后赋给自己
            Class<?> tempClazz = clazz.getSuperclass();
            while (tempClazz != null) {
                try {
                    field = tempClazz.getDeclaredField("updateTime");
                } catch (Exception e) {
                }
                if (field == null) {
                    tempClazz = tempClazz.getSuperclass();
                    continue;
                }
                break;
            }

        }
        if (field != null) {
            try {
                field.setAccessible(true);
                if (field.getType() == Date.class) {
                    field.set(entity, new Date());
                }
            } catch (Exception e) {
            }
        }
    }
}
