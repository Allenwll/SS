package com.allen.fast_dfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能:
 *
 * @date: 2018-10-19 10:03
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class FastDFSClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FastDFSClient.class);
    
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            LOGGER.error("FastDFS Client INit Fail", e);
        }
    }
    
    public static String[] upload(FastDFSFile file) {
        LOGGER.info("File Name:" + file.getName() + "File Length:" + file.getContent().length);
        
        NameValuePair[] meta_list = new NameValuePair[1];
        
        meta_list[0] = new NameValuePair("author", file.getAuthor());
        
        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        StorageClient storageClient = null;
        try {
            storageClient = getTrackerClient();
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (IOException e) {
            LOGGER.error("IO Exception when uploading the file:" + file.getName(), e);
        } catch (Exception e) {
            LOGGER.error("Non IO Exception when uploading the file:" + file.getName(), e);
        }
        
        LOGGER.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + "ms");
        
        if (uploadResults == null && storageClient != null) {
            LOGGER.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];
        
        LOGGER.info("upload file successfully!!!" + "group_name:" + groupName + ",remoteFileName:" + " " + remoteFileName);
        return uploadResults;
    }
    
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            LOGGER.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            LOGGER.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }
    
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (IOException e) {
            LOGGER.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            LOGGER.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }
    
    public static void deleteFile(String groupName, String remoteFileName) throws Exception {
        StorageClient storageClient = getTrackerClient();
        int i = storageClient.delete_file(groupName, remoteFileName);
        LOGGER.info("delete file successfully!!!" + i);
    }
    
    public static StorageServer[] getStoreStorages(String groupName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }
    
    public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }
    
    public static String getTrackerUrl() throws IOException {
        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }
    
    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }
    
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }
}
