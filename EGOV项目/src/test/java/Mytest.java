import com.qjx.utils.DateUtils;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Mytest {


    @Test
    public void myTest(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void myTes1t(){
        System.out.println(DateUtils.getDate());
    }

    @Test
    public void myTest2() throws IOException, URISyntaxException {
        //获取文件的类路径
        String paht = Thread.currentThread().getContextClassLoader().getResource("orgtype.properties").toURI().getPath();
        Reader in = new FileReader(new File(paht));
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("0"));
    }

    @Test
    public void myTest3(){
        ResourceBundle bundle = ResourceBundle.getBundle("properties/orgtype");
        System.out.println(bundle.getString("0"));
    }
}
