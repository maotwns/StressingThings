/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubesif7_apkkoperasi;
    import java.io.FileInputStream;
    import java.util.Properties;
    import javax.swing.JOptionPane;

/**
 *
 * @author RANI AMALIYAH
 */
public class koneksi {
    public Properties mypanel, myLanguage;
    private String strNamePanel;
    public koneksi(){
    
        
    }
    public String SettingPanel(String nmPanel){
    
        try{
        
            mypanel = new Properties();
            mypanel.load(getClass().getClassLoader().getResourceAsStream("lib/database.ini"));
            strNamePanel = mypanel.getProperty(nmPanel);
        }
        catch(Exception e){
        
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return strNamePanel;
    }
}