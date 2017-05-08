/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author Admin
 */
public class xulychuoi {
    public static String xuly(String chuoi)
    {
        String chuoidaxuly="";
       
     int vitridau =  chuoi.indexOf("- ");
     int vitricuoi =  chuoi.indexOf("\n",vitridau);
     
     if(vitricuoi<1)
     {
        chuoidaxuly = chuoi.substring(vitridau+1);
     }else {
         chuoidaxuly = chuoi.substring(vitridau+1,vitricuoi);
     }
        return chuoidaxuly.trim();
    }
    
    public static String xulyTuDien(String chuoi)
    {
    return chuoi.replace("<br />", "\n");
    }
    
   
   
}
