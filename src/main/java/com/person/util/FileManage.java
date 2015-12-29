package com.person.util;


import com.pxx.util.FileSystemManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileManage {


    @Value("#{fileManageProperties['fileManage.md.savePath']}")
    private String mdPath;

    @Value("#{fileManageProperties['fileManage.md.htmlPath']}")
    private String htmlPath;

    @Value("#{fileManageProperties['fileManage.md.viewHtmlPath']}")
    private String viewHtmlPath;

    @Autowired
    FileSystemManage fileSystem;

    private String mdFileName;

    private String htmlFileName;

    private static final Map fileType = new HashMap();

    static {
        fileType.put("md", ".md");
        fileType.put("html", ".html");
    }

    protected static final Logger logger = LoggerFactory.getLogger(FileManage.class);

    /**
     * create markdown file
     *
     * @return
     * @throws Exception
     */
    public String createMdFile() throws Exception {

        this.setMdFileName();

        logger.info("create markdown file : " + mdPath + this.getMdFileName());

        return fileSystem.createFile(mdPath, this.getMdFileName());

    }

    /**
     * create html file
     *
     * @return
     * @throws Exception
     */
    public String createHtmlFile() throws Exception {

        this.setHtmlFileName();

        logger.info("create html file : " + this.htmlPath + this.htmlFileName);

        fileSystem.createFile(htmlPath, this.htmlFileName);

        return htmlPath + this.getMdFileName();

    }

    /**
     * get md file name by last create
     * @return
     */
    public String getMdFileName() {
        return mdFileName;
    }

    /**
     * auto set md file name
     */
    public void setMdFileName() {
        this.mdFileName = Long.toString(System.currentTimeMillis()) + this.fileType.get("md");
    }


    /**
     * write markdown
     *
     * @param content File content
     * @throws Exception
     */
    public void writeMdFile(String content) throws Exception {
        logger.info("write file :" + this.mdPath + this.mdFileName + " with " + content);
        fileSystem.writeFile(this.mdPath, this.mdFileName, content);
    }

    /**
     * write content into html file
     *
     * @param content
     * write content
     * @throws Exception
     */
    public void writeHtmlFile(String content) throws Exception {
        logger.info("write file :" + this.htmlPath + this.htmlFileName + " with " + content);
        fileSystem.writeFile(this.htmlPath, this.htmlFileName, content);
    }

    /**
     * get md save path
     * @return
     */
    public String getMdPath() {
        return mdPath;
    }

    /**
     * get html save path
     * @return
     */
    public String getHtmlPath() {
        return htmlPath;
    }

    /**
     * get html file name by last create
     * @return
     */
    public String getHtmlFileName() {
        return htmlFileName;
    }

    /**
     * auto ser html file name
     */
    public void setHtmlFileName() {
        this.htmlFileName = Long.toString(System.currentTimeMillis()) + this.fileType.get("html");
    }

    /**
     * reade file content
     * @param filePath
     * file path
     * @return
     */
    public String readFile(String filePath) {

        logger.info("读取文件:" + filePath);
        StringBuffer stringBuffer = new StringBuffer();
        String tempstr = null;
        File file = new File(filePath);

        try {
            if (!file.exists())
                throw new FileNotFoundException();
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            while ((tempstr = br.readLine()) != null)
                stringBuffer.append(tempstr + "\n");
        } catch (IOException ex) {
            logger.error(ex.getStackTrace().toString());
        }

        logger.info("读取结果:" + stringBuffer.toString());

        return stringBuffer.toString();
    }

    public String getViewHtmlPath() {
        return viewHtmlPath;
    }

    @Override
    public String toString() {
        return "FileManage{" +
                "mdFileName:'" + mdFileName + '\'' +
                ", mdPath:'" + mdPath + '\'' +
                ", viewPath:'" + htmlPath + '\'' +
                '}';
    }
}
