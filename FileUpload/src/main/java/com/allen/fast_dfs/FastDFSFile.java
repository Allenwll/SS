package com.allen.fast_dfs;

/**
 * 功能:
 *
 * @date: 2018-10-19 10:02
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class FastDFSFile {
    private String name;
    
    private byte[] content;
    
    private String ext;
    
    private String md5;
    
    private String author;
    
    public FastDFSFile(String name, byte[] content, String ext, String height,
        String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }
    
    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public byte[] getContent() {
        return content;
    }
    
    public void setContent(final byte[] content) {
        this.content = content;
    }
    
    public String getExt() {
        return ext;
    }
    
    public void setExt(final String ext) {
        this.ext = ext;
    }
    
    public String getMd5() {
        return md5;
    }
    
    public void setMd5(final String md5) {
        this.md5 = md5;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(final String author) {
        this.author = author;
    }
}
