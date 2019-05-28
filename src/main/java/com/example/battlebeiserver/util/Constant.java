package com.example.battlebeiserver.util;

/**
 *@ClassName Constant
 *@Description TODO
 *@author perth
 *@Date 2019/5/14 21:16
 **/
public class Constant {
    public static final String CET4="cet4";
    public static final String CET6="cet6";
    public static final String IELTS="ielts";
    public static final String TOEFL="toefl";
    /**
     * 学习单词，一组的个数
     */
    public static final Long WORDNUMBER=7L;
    /**
     * 默认每日学习词汇量
     */
    public static final Long DAILYNUM=100L;
    public static final Long PACESTART=1L;
    /**
     * 用户不认识单词加入user_word的初始weight
     */
    public static final int SMALLWEIGTH=1;
    /**
     * user_word中单词的最大weight，超过则删除
     */
    public static final int BIGWEIGHT=6;
    /**
     * 复习，一次性获取的单词数
     */
    public static final Long REVIEWNUM=10L;
    /**
     * 获取其他用户生词本中单词个数进行battle
     */
    public static final Long BATTLENUM=10L;
    /**
     * battle时，正确个数处以这个数为得分
     */
    public static final Long BATTLEGRADENUM=10L;
}
