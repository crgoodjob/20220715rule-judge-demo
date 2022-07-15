package cn.maitian.bss.modules.office.utils;

import java.util.HashMap;
import java.util.Map;

public class AssetConstant {

    //办公用品申请编号的前缀
    public static final String OFFICE_NO_PREFIX = "BGYP";

    //超限量的错误提示代码
    public static final Integer OUT_LIMIT_CODE = 501000;

    //办公用品默认图片，是否外网：麦脉外网访问
    public static final Boolean OFFICE_IS_OUT = true;

    //查询来源:1.公盘端;2.麦脉端
    public static final String SOURCE_TYPE_PC = "1";
    public static final String SOURCE_TYPE_MAIMAI = "2";

    //有效状态:0：有效；1：无效
    public static final String STATUS_YES = "0";// 有效
    public static final String STATUS_NO = "1";// 无效

    //收货地址、图片、已选办公用品，是否删除:0：否；1：已删除
    public static final String DEL_FLAG_NO = "0";// 否,正常
    public static final String DEL_FLAG_YES = "1";// 已删除

    //收货地址，是否默认:0：否；1：默认
    //商品信息，新增标识：0：否；1：是
    public static final String IS_DEFAULT_NO = "0";// 否
    public static final String IS_DEFAULT_YES = "1";// 默认

    //办公用品领用申请，状态:0.限量初始化完成;1.已选商品;2.已申请;3.已删除
    public static final String APPLY_STATUS_INIT = "0";// 限量初始化完成
    public static final String APPLY_STATUS_NO = "1";// 已选商品,未提交
    public static final String APPLY_STATUS_YES = "2";// 已申请
    public static final String APPLY_STATUS_DELETE = "3";// 已删除

    //办公用品领用申请，是否本月申请:0：历史月；1：本月
    public static final String CURRENT_MONTH_HIS = "0";// 历史月
    public static final String CURRENT_MONTH_NOW = "1";// 本月

    //办公用品申请开关:0：关：1：开
    public static final String APPLY_SWITCH_OFF = "0";// 关
    public static final String APPLY_SWITCH_ON = "1";// 开

    //办公用品领用，是否限量翻倍：0：否；1：是
    public static final String IS_DOUBLE_NO = "0";//否
    public static final String IS_DOUBLE_YES = "1";//是

    //图片类型:1.办公用品库;2.资产;3.申请报废的附件;4.申请转移的附件
    public static final String IMAGE_TYPE_OFFICE= "1";//办公用品库
    public static final String IMAGE_TYPE_ASSET= "2";//资产
    public static final String IMAGE_TYPE_DISCARD= "3";//申请报废的附件
    public static final String IMAGE_TYPE_CHANGE= "4";//申请转移的附件

    //办公用品，仅限事业部:0：否；1：是
    public static final String LIMIT_LARGE_AREA_NO = "0";//否
    public static final String LIMIT_LARGE_AREA_YES = "1";//是，仅限事业部领用

    //办公用品，是否计算限额：0：否；1：是
    public static final String IS_CALCULATE_NO = "0";//否
    public static final String IS_CALCULATE_YES = "1";//是

    //节点层级：0：根节点；1：一级节点；2：二级节点
    public static final String NODE_LEVEL_ROOT = "0";//根节点
    public static final String NODE_LEVEL_FIRST = "1";//一级节点
    public static final String NODE_LEVEL_SECOND = "2";//二级节点

    //节点树类型:1：资产；2：办公用品
    public static final String NODE_TYPE_ASSET = "1";// 资产
    public static final String NODE_TYPE_OFFICE = "2";// 办公用品

    //是否最末级节点：1.是；2.否
    //是否有子分类：1.是；2.否
    //是否有商品：1.是；2.否
    public static final String IS_END_NODE_YES = "1";//是
    public static final String IS_END_NODE_NO = "2";//否

    //办公用品分类、办公用品，启停状态（startStopStatus）：0.停用；1.启用
    public static final String SSS_STOP = "0";//停用
    public static final String SSS_START = "1";//启用

    //限量方式:1.不限制;2.每月;3.每季度;4.每半年;5.每年;6.每二年
    public static final String LIMIT_TYPE_NO = "1"; //不限制
    public static final String LIMIT_TYPE_MONTH = "2"; //每月
    public static final String LIMIT_TYPE_SEASON = "3"; //每季度
    public static final String LIMIT_TYPE_HALF_YEAR = "4"; //每半年
    public static final String LIMIT_TYPE_YEAR = "5"; //每年
//    public static final String LIMIT_TYPE_TWO_YEAR = "6"; //每二年

    //限量方式
    public static final Map<String,String> RELOOP_LIMIT_TYPE = new HashMap<String,String>() {
        {
            put("1","不限制");
            put("2","每月");
            put("3","每季度");
            put("4","每半年");
            put("5","每年");
//            put("6","每二年");
        }
    };

    // 资产、办公用品图片ID（图片服务器使用）
    public static final String ZC_SERVER_IMAGE_ID = "ASSETSDC1F2288E28D5186E053830C10";
    public static final String ZC_DATA_SOURCE_ID =  "00000000000000000000000000000001";

    //组织类型：1.店组；2.事业部
    public static final String ORG_TYPE_SHOP = "1"; //店组
    public static final String ORG_TYPE_LARGE_AREA = "2"; //事业部

}
