package cn.maitian.bss.modules.office.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateHutoolUtils {

    /**
     * 获取每季度的起始日期
     * @param now
     * @return
     */
    public static Date getDateBySeason(Date now) {
        int month = DateUtil.month(now);
        Date beginDay = DateUtil.beginOfYear(now);
        if(month < 3){
            return beginDay;
        }else if(month < 6){
            return DateUtil.offsetMonth(beginDay,3);
        }else if(month < 9){
            return DateUtil.offsetMonth(beginDay,6);
        }else{
            return DateUtil.offsetMonth(beginDay,9);
        }
    }

    /**
     * 获取每半年的起始日期
     * @return
     * @param now
     */
    public static Date getDateByHalfYear(Date now) {
        int month = DateUtil.month(now);
        Date beginDay = DateUtil.beginOfYear(now);
        if(month > 5){
            return DateUtil.offsetMonth(beginDay,6);
        }else {
            return beginDay;
        }
    }
}
