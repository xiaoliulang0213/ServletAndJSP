package com.liuxiaonian.demo.util;

public class Utils {
    /**
     * @Author chengpunan
     * @Description 检查Email是否合法
     * @Date 11:12 2018/10/19
     * @Param [email]
     * @return boolean
     **/
    public static boolean checkEmailFormat(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }
}
