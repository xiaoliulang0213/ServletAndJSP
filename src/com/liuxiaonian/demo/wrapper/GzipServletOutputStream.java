package com.liuxiaonian.demo.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GzipServletOutputStream extends ServletOutputStream{
    private GZIPOutputStream gzipOutputStream;


    public GzipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException{
        this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
    }

    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    public GZIPOutputStream getGzipOutputStream() {
        return gzipOutputStream;
    }
}
