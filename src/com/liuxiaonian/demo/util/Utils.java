package com.liuxiaonian.demo.util;

public class Utils {
    /**
     * @Author chengpunan
     * @Description ���Email�Ƿ�Ϸ�
     * @Date 11:12 2018/10/19
     * @Param [email]
     * @return boolean
     **/
    public static boolean checkEmailFormat(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }
}
