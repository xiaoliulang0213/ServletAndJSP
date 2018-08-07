package com.liuxiaonian.httpservletrequest.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet{

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException,IOException{
        //读取body
        byte[] body = readBody(httpServletRequest);
        //页面以UTF-8编码方式提交文件，body字节数组是经过Tomcat中ISO-8859-1编码过的，所以乱码，故需要用UTF-8解码字节数组
        String textBody = new String(body,"UTF-8");
        //获取文件名
        String filename = getFileName(textBody);
        //获取文件字节的开始与结束位置
        Position position = getPosition(httpServletRequest,textBody);
        writeToFile(filename,body,position);
    }

    public Position getPosition(HttpServletRequest httpServletRequest, String textBody) throws IOException {
        String contentType = httpServletRequest.getContentType();
        String boundaryText = contentType.substring(contentType.lastIndexOf("=")+1,contentType.length());
        //body体中文件名字向后找三个\n就是文件内容的开始位置
        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n",pos) + 1;
        pos = textBody.indexOf("\n",pos) + 1;
        pos = textBody.indexOf("\n",pos) + 1;
        //文件内容的结束位置
        int boundaryLoc = textBody.indexOf(boundaryText,pos) - 4;
        //在控制台看一下body体的结构
        System.err.println(textBody);
        int begin = (textBody.substring(0,pos)).getBytes("ISO-8859-1").length;
        int end = (textBody.substring(0,boundaryLoc)).getBytes("ISO-8859-1").length;
        return new Position(begin,end);
    }

    //获取body体
    public byte[] readBody(HttpServletRequest httpServletRequest) throws IOException {
        int formDataLength = httpServletRequest.getContentLength();
        DataInputStream dataInputStream = new DataInputStream(httpServletRequest.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while (totalBytes < formDataLength){
            int bytes = dataInputStream.read(body,totalBytes,formDataLength);
            totalBytes += bytes;
        }
        return body;
    }

    //获取文件名
    private String getFileName(String reqBody){
        //找到filename="的位置
        //+10是为了从"后面开始截取字符串
        String filename = reqBody.substring(reqBody.indexOf("filename=\"")+10);
        //截取到换行的位置
        filename = filename.substring(0,filename.indexOf("\n"));
        filename = filename.substring(filename.lastIndexOf("\\")+1, filename.indexOf("\""));
        return filename;
    }

    //把内容写到文件中
    private void writeToFile(String fileName,byte[] body,Position position) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/" + fileName);
        fileOutputStream.write(body,position.begin,position.end);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    //位置内部类
    class Position {
        private int begin;
        private int end;

        Position(int begin,int end){
            this.begin = begin;
            this.end = end;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
