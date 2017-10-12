package com.atguigu.fastdfs.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSUtils {

    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient storageClient;
    private static StorageServer storageServer;
    //文件上传,初始化一次
    static{
        String absolutePath = FastDFSUtils.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(absolutePath);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = null;
            storageClient = new StorageClient(trackerServer,storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    //文件上传
    public static String[] uploadFile(String oringinName,byte[] fileBytes){
        String extName = getExtName(oringinName);
        //byte数组形式的上传
        String[] resultArray = null;
        try {
            resultArray = storageClient.upload_file(fileBytes, extName, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
         return resultArray;
    }

    //获取文件的扩展名
    public static String getExtName(String originName){
        if(originName ==null || "".equals(originName)){
            return null;
        }
        int index = originName.lastIndexOf(".");
        String substring = originName.substring(index + 1);
        return substring;
    }


   /* public static void main(String[] args) {
        String extName = FastDFSUtils.getExtName("a.a.a.jpg");
        System.out.println(extName);
    }*/

}
