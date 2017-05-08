/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
public class ReadPropertiesLibrary {

    //hỗ trợ đọc file Properties phục vụ việc đóng gói
    public static Properties readFileProperties() {
		
		
                Properties properties = new Properties();
                File file = new File("");
                try{
                properties.load(new FileReader(new File("./config.properties")));
                String user = properties.getProperty("user");
                String pass = properties.getProperty("pass");
                String url = properties.getProperty("url");
                }catch(IOException ex)
                {
                    JOptionPane.showMessageDialog(null, "Lỗi: Không Tìm Thấy File \n"
                            + "Vui Lòng Kiểm Tra Lại File config.properties\n"
                            + "Trong Thư Mục: "+file.getAbsolutePath(),
                            "Thông Báo", 0);
 
                }
		return properties; 
	}

}
