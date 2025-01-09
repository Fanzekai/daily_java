package lineWell.demo06;

import java.util.Date;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/7  17:45
 */
public class ObjectInfo {
    /**
     * 对象最后修改时间
     */
    private Date lastModified;
    /**
     * 对象大小
     */
    private long size;
    /**
     * 对象url地址
     */
    private String url;
    /**
     * 对象endPoint
     */
    private String endPoint;
    /**
     * 对象名称
     */
    private String name;
    /**
     * 对象地址
     */
    private String path;
    /**
     * 桶名称
     */
    private String bucketName;
    /**
     * 对象文件后缀
     */
    private String suffix;

    /**
     * 源路径
     */
    private String sourcePath;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
}
