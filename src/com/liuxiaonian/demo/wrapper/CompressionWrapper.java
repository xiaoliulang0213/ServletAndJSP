package com.liuxiaonian.demo.wrapper;

import sun.awt.image.GifImageDecoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompressionWrapper extends HttpServletResponseWrapper{
    private GzipServletOutputStream gzipServletOutputStream;
    private PrintWriter printWriter;

    public CompressionWrapper(HttpServletResponse response) {
        super(response);
    }

    public ServletOutputStream getOutputStream() throws IOException {
        //����Servlet��׼ͬһ��������PrintWriter��ServletOutputStream����ֻ��ͬʱ����һ��
        if (printWriter != null){
            throw new IllegalStateException();
        }
        if (gzipServletOutputStream == null) {
            gzipServletOutputStream = new GzipServletOutputStream(getResponse().getOutputStream());
        }
        return gzipServletOutputStream;
    }
    
    /**
     * @Author chengpunan
     * @Description ��ȡPrintWriter����
     * @Date 17:34 2018/10/16
     * @Param []
     * @return java.io.PrintWriter
     **/
    public PrintWriter getWriter() throws IOException {
        //����Servlet��׼ͬһ��������PrintWriter��ServletOutputStream����ֻ��ͬʱ����һ��
        if (gzipServletOutputStream != null){
            throw new IllegalStateException();
        }
        if (printWriter == null){
            gzipServletOutputStream = new GzipServletOutputStream(getResponse().getOutputStream());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gzipServletOutputStream,getResponse().getCharacterEncoding());
            printWriter = new PrintWriter(outputStreamWriter);
        }
        return printWriter;
    }

    public void setContentLength(int len){}

    public GZIPOutputStream getGZIPOutputStream(){
        if (this.gzipServletOutputStream == null){
            return null;
        }
        return this.gzipServletOutputStream.getGzipOutputStream();
    }
}
