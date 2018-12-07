import java.io.File;

/**
 * 功能: 删除Maven仓库无用的版本
 *
 * @date: 2018-11-16 11:50
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class DelNoneJar {
    
    // 仓库根目录
    static String root = "D:/Allen/Java/Maven/maven_repo/repository";
    
    public static void main(String[] args) {
        
        File file = new File(root);
        
        File[] _files = file.listFiles();
        if (_files != null && _files.length > 0) {
            for (File _file : _files) {
                validate(_file);
            }
        }
        
    }
    
    public static boolean validate(File file) {
        boolean isHaveJar = false;
        File[] _files = file.listFiles();
        if (_files != null && _files.length > 0) {
            // 判断是否有*jar 是否是有文件夹
            for (File _file : _files) {
                if (_file.getName().endsWith(".jar")) {
                    isHaveJar = true;
                }
                if (_file.isDirectory()) {
                    boolean isNextHaveJar = validate(_file);
                    if (isNextHaveJar) {
                        isHaveJar = true;
                    }
                }
            }
        }
        if (!isHaveJar) {
            delete(file);
        }
        return isHaveJar;
    }
    
    public static void delete(File file) {
        File[] _files = file.listFiles();
        if (_files != null && _files.length > 0) {
            for (File _file : _files) {
                if (_file.isDirectory()) {
                    delete(_file);
                }
                _file.delete();
            }
        } else {
            file.delete();
        }
    }
}
