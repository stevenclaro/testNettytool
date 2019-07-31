package enumok;
//枚举类可以有更多的参数

public enum  enumte {
    /**
     * 未查到有关银行卡信息
     */
    NOT_FIND(1000, "未查到有关银行卡信息 !"),
    /**
     * 操作成功
     */
    SUCCESS(1002, "OPERATION SUCCESS!"),
    /**
     * 操作失败
     */
    FAIL(-1002, "OPERATION FAIL!"),
    /**
     * 系统异常
     */
    EXCEPTION(-8888, "哎呀！系统开小差啦!"),

    /**
     * 登陆失败
     */
    LOGIN_FAIL(-1015, "登陆失败！请检查用户名或密码是否正确！"),
    /**
     * 未登陆
     */
    NO_LOGIN(-1019, "您还没有登陆，请登录后重试！"),
    /**
     * 缺少参数
     */
    LOSE_NECESSARY_PARAMETERS(-1020, "缺少必要参数，请检查！"),
    /**
     * 手机号格式不正确
     */
    PHONE_FORMAT_ERROR(-1021, "手机号格式不正确，请检查！"),
    /**
     * 手机号被占用
     */
    PHONE_OCCUPY(-1022, "手机号已注册，请登陆！"),
    /**
     * 验证码不正确
     */
    VERIFICATION_CODE_ERROR(-1023, "验证码不正确或已失效！"),
    /**
     * 原始密码错误
     */
    ORIGINAL_PWD_ERROR(-1024, "原始密码错误，请检查！"),
    /**
     * 图片验证码不正确
     */
    IMAGE_CODE_ERROR(-1025, "图片验证码不正确或已失效！");
    private String mode;
    private int code;

    private enumte(int code, String mode) {
        this.code = code;
        this.mode = mode;
    }

    /**
     * <p>Title: getMode</p>
     * <p>Description: 获取描述</p>
     *
     * @return
     */
    public String getMode() {
        return mode;
    }

    public void setMode(int code, String mode) {
        this.code = code;
        this.mode = mode;
    }

    /**
     * <p>Title: operation</p>
     * <p>Description: 获取描述</p>
     *
     * @return
     */
    public String operation() {
        return this.mode;
    }

    /**
     * <p>Title: getCode</p>
     * <p>Description: 获取CODE</p>
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
