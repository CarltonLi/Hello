package util;

/**
 * Created by lichao22 on 16/1/12.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;

import android.text.TextUtils;

public class StringUtil {

    private static final String TIMEFORMAT = "yyyy-MM-dd HH:mm";
    private static final String PASSWORD_PREFIX = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})";

    public static final String lineSeparator = System.getProperty("line.separator");

    public static String SimpleDateFormat(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat todayDateFormatter = new SimpleDateFormat(TIMEFORMAT);
        return todayDateFormatter.format(date);
    }

    public static final String string(Object... args) {
        if (args != null) {
            StringBuffer sb = new StringBuffer();
            for (Object obj : args) {
                if (obj != null) {
                    if (obj instanceof String) {
                        sb.append((String) obj);
                    } else {
                        sb.append(String.valueOf(obj));
                    }
                }
            }
            String temp = sb.toString();
            return temp;
        }
        return "";
    }

    public static String SimpleDateFormat(Date date, String dateformat) {
        if (date == null)
            return null;
        if (dateformat == null) {
            dateformat = TIMEFORMAT;
        }
        SimpleDateFormat todayDateFormatter = new SimpleDateFormat(dateformat);
        return todayDateFormatter.format(date);
    }

    public static final void clearStringBuilder(StringBuilder sb) {
        if (sb != null && sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }

    public static Date handleDate(String data) {
        return handleDate(data, TIMEFORMAT);

    }

    public static Date handleDate(String data, String dateformat) {
        if (dateformat == null) {
            dateformat = TIMEFORMAT;
        }
        if (data == null || data.length() == 0)
            return null;
        try {
            DateFormat df = new SimpleDateFormat(dateformat);
            Date d_date = df.parse(data);
            return d_date;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNull(String str) {
        boolean b = false;
        if (str == null || str.trim().length() == 0)
            b = true;

        return b;
    }

    public static boolean isNULL(String str) {
        boolean b = false;
        if (str == null)
            b = true;

        return b;
    }

    public static boolean isNull(String str, boolean bValidNullString) {
        boolean b = false;
        if (str == null || str.trim().length() == 0)
            b = true;
        if (!b && bValidNullString) {
            if (str != null && str.equalsIgnoreCase("null"))
                b = true;
        }
        return b;
    }

    // i < 60
    private static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    /**
     * Translate the time in seconds into the (HH:)MM:SS format, cut if more
     * than "99:59:59"
     *
     * @param seconds
     * @return
     */
    public static String translateSecondsToString(int seconds) {
        String ret;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (seconds <= 0) {
            ret = "00:00";
        } else {
            minute = seconds / 60;
            if (minute < 60) {
                second = seconds % 60;
                ret = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    ret = "99:59:59";
                } else {
                    minute = minute % 60;
                    second = seconds - hour * 3600 - minute * 60;
                    ret = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
                }
            }
        }

        return ret;
    }

    /**
     * 判断一个字符是否为中文字符
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(String.valueOf(c));
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个String对象是否是JSONArray
     *
     * @param resource
     * @return
     */
    public static boolean isJSONArray(final String resource) {
        if (TextUtils.isEmpty(resource)) {
            return false;
        }

        try {
            JSONArray array = new JSONArray(resource);
            if (array.length() <= 0 || array.getJSONObject(0) == null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        } catch (Error e) {
            return false;
        }

        return true;
    }

    /**
     * 判断一个String对象是否是合法的<b><u>支付</b></u>密码（至少包含一个数字和一个字母，长度在6~20之间）
     */
    public static boolean isValidPassWord(final String password) {
        if (TextUtils.isEmpty(password) || password.contains(" ")) {
            return false;
        }
        return password.matches(PASSWORD_PREFIX);
    }

    /**
     * 获取当前的时间戳（精确到小时）
     */
    public static long getyyyyMMddHHTimeForNow() {
        Calendar c = Calendar.getInstance();

        long result = 0;
        result += c.get(Calendar.YEAR) * 1000000L;
        result += (c.get(Calendar.MONTH) + 1) * 10000L;
        result += c.get(Calendar.DAY_OF_MONTH) * 100L;
        result += c.get(Calendar.HOUR_OF_DAY);

        return result;
    }
}