package com.pxx.util;

import java.io.*;


public class FileSystemManage {


    /**
     * create file
     * @param path
     * file path
     * @param fileName
     * file name
     * @return
     * @throws Exception
     */
    public String createFile(String path, String fileName) throws Exception{
        File filePath = new File(path);

        if(!filePath.exists()){
            filePath.mkdirs();
        }

        File newFile = new File(filePath, fileName);

        if(!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e  ){
                e.printStackTrace();
                System.out.println("package com.pxx.util.FileSystem createFile ");
            }
        }

        return  path + fileName ;

    }


    /**
     * write content into file
     * @param path
     * file path
     * @param fileName
     * file name
     * @param content
     * file content
     * @throws Exception
     */
    public void writeFile(String path, String fileName, String content) throws Exception {
        System.out.println("package com.pxx.util.FileSystem writeFile");
        try {

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path + fileName),"UTF-8");
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
