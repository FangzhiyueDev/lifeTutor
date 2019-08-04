package com.rcs.nchumanity.entity;


/**
 * 网络连接的接口实现
 * 提供的是一堆的常量
 */
public class NetConnectionUrl {


    /**
     * 快递查询的相关的接口信息常量
     */
    public static interface ExpressInter {

        //电商ID
        public static final String EBusinessID = "1339086";
        //电商加密私钥，快递鸟提供，注意保管，不要泄漏
        public static final String AppKey = "fb870cad-a9c8-4540-a3ed-4f0e6d5d252d";
        //请求url
        public static final String ReqURL = "http://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx";
    }

    /**
     * 百度地图的相关的常量
     */
    public static interface BaiduMapInter {

    }

    /**
     * 极光推送的相关的常量
     */
    public static interface JGPullInter {

    }

    /**
     * mob
     * 短信验证登录相关的接口
     */
    public static interface SmsVerficaInter {

    }

    /**
     * 微信支付相关的接口
     */
    public static interface WeChatPayInter {

    }


    /**
     * 阿里支付接口
     */
    public static interface AliPayInter {

    }

    /**
     * 服务器的主地址
     */
    public static final String ROOT_SERVER = "http://193.112.182.184:8888/ncrd/api/";

    /**
     * 登录的接口
     * 登录传递的是
     * <p>
     * send 数据
     */
    public static String LOGIN = ROOT_SERVER + "userLogin?mobilephone=%s&password=%s";
    /**
     * 注册的接口
     */
    public static String REGISTER = ROOT_SERVER + "userRegister?mobilephone=%s&password=%s";
    /**
     * 主页查询分类信息对应的数据接口
     */
    public static String MAIN_CLASS = "";

    /**
     * 主页的banner的接口
     */
    public static String MAIN_BANNER = "";

    /**
     * 响应求救信息 响应求救信息之后跳转到百度地图的定位界面
     */
    public static String CRY_HELPER_RESP = "";

    /**
     * 查看求救信息的响应
     */
    public static String CRY_HELPER_QUERY = "";

    /**
     * 我的课程
     */
    public static String ME_COURSE = "";
    /**
     * 我的考核结果的接口
     */
    public static String ME_ASSESS_RESULT = "";

    /**
     * 我的证书的接口
     */
    public static String ME_CERTIFICATE = "";

    /**
     * 提交留言反馈的接口
     */
    public static String ME_FEEDBACK_SUBMIT = "";

    /**
     * 获得留言反馈的接口
     * 获得的是我们提交的留言系统后台恢复的反馈
     */

    public static String ME_FEEDBACK_GET = "";

    /**
     * 基础培训报名
     * 使用的是post请求，需要涉及到文件的上传
     * 同时传递对应的详细信息
     */
    public static String TRAIN_SIGN_UP = "";

    /**
     * 复训的接口
     * 同上面一样，同样涉及到文件上传的,传递的是用户证件照
     */
    public static String TRAIN_RETRAIN = "";

    /**
     * 线上课程的数据，传递的是视频的基本的信息，
     * 通过点击对应的列表，进入视频的详细数据的显示
     * 包括必修课程和选修课程
     */
    public static String ONLINE_TRAIN_VIDEO_LIST = "";


    /**
     * 获得在线视频的详细信息
     * 包括视频的url，视频的相关信息，以及对应视频可能存在的习题信息
     */
    public static String ONLINE_TRAIN_VIDEO_DETAIL = "";


    /**
     * 线上考核的接口，该条存在歧义，明天会议讨论
     */
    public static String ONLINE_ASSESS = "";

    /**
     * 心肺复苏课程列表
     * 获得的是课程的相关的数据，以及对应地区
     */
    public static String CPR_COURSE_LIST = "";

    /**
     * 心肺复苏课程的详情数据
     */
    public static String CPR_COURSE_DETAIL = "";

    /**
     * 课程签到接口
     * 因为签到需要实现的是
     * 心肺复苏的签到和
     * 创伤救护课程的签到，所以需要课程的id和用户的id
     */
    public static String CPR_COURSE_SIGN_IN = "";

    /**
     * aed的分布的列表，当前的aed分布的列表依赖于当前用户的位置
     */
    public static String AED_DISTRIBUTE_LIST;

    /**
     * 急救知识列表
     */
    public static String CRY_HELPER_KNOWLEDGE_LIST;

    /**
     * 急救知识的详情信息
     * 急救知识的详情信息和培训视频的相关信息是差不多的，一定情况可以接口复用
     */
    public static String CRY_HELPER_KNOWLEDGE_LIST_DETAIL;

    /**
     * 献血位置列表，用来对百度地图进行标记
     */
    public static String BLOOD_DONATION_POSITION_LIST;

    /**
     * 获得当前用户的注册状态、
     * 传递的参数是用户的phoneNumber
     * 返回的参数是json格式的数据 格式是BasicResponse类的实现
     * <p>
     * 参数
     * mobilephone=
     */
    public static final String REGISTER_STATUS = ROOT_SERVER + "getUserRegisterStatus?mobilephone=%s";

    static {


    }


}
