package com.atguigu.fastdfs.test;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FastDFSTest {

    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient storageClient;
    private StorageServer storageServer;

   @Before
    public void init() throws IOException, MyException {
        String configPath = "/tracker.conf";
        String absolutePath = FastDFSTest.class
                   .getResource(configPath).getPath(); //为啥getClassLoader会空指针
         //执行初始化操作,并创建用到的四个对象
       ClientGlobal.init(absolutePath);
       trackerClient = new TrackerClient();
       trackerServer = trackerClient.getConnection();
       //trackerServer里应该有storageServer的信息,所以可以为null
       storageServer = null;
       storageClient = new StorageClient(trackerServer,storageServer);
   }

   @Test
    public void testUpload() throws IOException, MyException {
        String local_filename = "F:\\IdeaProject\\FastDFSTest\\1.jpg" ;
        //文件的扩展名不带"."
        String file_ext_name = "jpg";
       NameValuePair[] meta_list = null;
       String[] resultArray = storageClient.upload_file(local_filename, file_ext_name, meta_list);
       for (String result:resultArray){
           System.out.println(result);
       }
   }

}
