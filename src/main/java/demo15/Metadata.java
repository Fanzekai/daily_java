package demo15;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/1  21:15
 */
class Metadata {
    private Long elementId;
    private Long elementPid;
    private String metadataName;
    private int sortNum;
    private String restrictFlag;
    private String metadataParam;
    private String dataType;
    private int dataLength;
    private String checkScript;

    // Constructor, getters, and setters

    public Metadata(Long elementId, Long elementPid, String metadataName, int sortNum, String restrictFlag,
                    String metadataParam, String dataType, int dataLength, String checkScript) {
        this.elementId = elementId;
        this.elementPid = elementPid;
        this.metadataName = metadataName;
        this.sortNum = sortNum;
        this.restrictFlag = restrictFlag;
        this.metadataParam = metadataParam;
        this.dataType = dataType;
        this.dataLength = dataLength;
        this.checkScript = checkScript;
    }

    public Long getElementId() {
        return elementId;
    }

    public Long getElementPid() {
        return elementPid;
    }

    public String getMetadataName() {
        return metadataName;
    }

    public int getSortNum() {
        return sortNum;
    }

    public String getRestrictFlag() {
        return restrictFlag;
    }

    public String getMetadataParam() {
        return metadataParam;
    }

    public String getDataType() {
        return dataType;
    }

    public int getDataLength() {
        return dataLength;
    }

    public String getCheckScript() {
        return checkScript;
    }
}
