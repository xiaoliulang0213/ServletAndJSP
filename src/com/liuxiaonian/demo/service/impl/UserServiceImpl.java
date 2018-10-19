package com.liuxiaonian.demo.service.impl;

import com.liuxiaonian.demo.data.User;
import com.liuxiaonian.demo.service.UserService;
import com.liuxiaonian.demo.util.Utils;
import com.sun.org.apache.bcel.internal.generic.IFLE;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.security.action.PutAllAction;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class UserServiceImpl implements UserService{
    private String filePath;

    public UserServiceImpl(String filePath){
        if (filePath.endsWith("/")){
            this.filePath = filePath;
        }else {
            this.filePath = filePath + "/";
        }
    }

    /**
     * @Author chengpunan
     * @Description 检查用户是否存在
     * @Date 10:52 2018/10/19
     * @Param [userName]
     * @return boolean
     **/
    public boolean isInvalidUsername(String userName){
        for (String file : new File(filePath).list()){
            if (userName.equals(file)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * @Author chengpunan
     * @Description 创建用户
     * @Date 10:53 2018/10/19
     * @Param [email, userName, password]
     * @return void
     **/
    public void createUserData(String email,String userName,String password,String phone) throws IOException{
        boolean emailLegal =  Utils.checkEmailFormat(email);
        if (emailLegal){
            throw new RuntimeException("Email格式不正确!");
        }
        boolean isExist = isInvalidUsername(userName);
        if (isExist){
            throw new RuntimeException("该用户已经创建,不允许重复创建!");
        }

        File userInformation = new File(filePath+userName);
        userInformation.mkdir();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userInformation + "/profile"));
        bufferedWriter.write("userName:"+userName+"\n"+"password:"
                +password+"\n"+"phone:"+phone+"\n"+"email:"+email);
        bufferedWriter.close();
    }
    
    /**
     * @Author chengpunan
     * @Description 检查用户登录
     * @Date 11:26 2018/10/19
     * @Param []
     * @return boolean
     **/
    public boolean checkLogin(String userName,String password) throws IOException{
        if (userName != null && password != null){
            for (String userInformation : new File(filePath).list()){
                if (userInformation.equals(userName)){
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath+userInformation+"/profile"));
                    String result = "";
                    String item = null;
                    while ((item = bufferedReader.readLine()) != null) {
                        result += item+":";
                    }
                    String passwordFile =  result.split(":")[3];
                    if (passwordFile.equals(password)){
                        return true;
                    }
                    bufferedReader.close();
                }
            }
        }
        return false;
    }

    private class TxtFilenameFileter implements FilenameFilter{
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    }

    private TxtFilenameFileter txtFilenameFileter = new TxtFilenameFileter();

    private class DateComparator implements Comparator<Date>{
        public int compare(Date d1,Date d2){
            return -d1.compareTo(d2);
        }
    }
    private DateComparator dateComparator = new DateComparator();

    public Map<Date,String> readMessage(String userName) throws IOException{
        File border = new File(filePath + userName);
        String[] txts = border.list(txtFilenameFileter);
        Map<Date,String> message = new TreeMap<Date,String>(dateComparator);
        for (String txt: txts){
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(filePath+userName+"/"+txt),"UTF-8"));
            String text = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((text = bufferedReader.readLine()) != null){
                stringBuilder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0,txt.indexOf(".txt"))));
            message.put(date,stringBuilder.toString());
            bufferedReader.close();
        }
        return message;
    }

    public void addMessage(String userName,String message)throws IOException{
        String fileName = filePath+userName+"/"+new Date().getTime()+".txt";
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
        bufferedWriter.write(message);
        bufferedWriter.close();
    }

    public void deleteMessage(String userName,String message){
        File file = new File(filePath+userName + "/" +message + ".txt");
        if (file.exists()){
            file.delete();
        }
    }
}
