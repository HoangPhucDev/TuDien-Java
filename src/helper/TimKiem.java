/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import javax.swing.DefaultListModel;


/**
 *
 * @author Admin
 */
public class TimKiem {

    public static int TimTuyenTinh(String string, DefaultListModel ds) {
        int vitri = 0;
        for (int i = 0; i < ds.getSize(); i++) {
            if (string.compareToIgnoreCase(ds.elementAt(i).toString()) == 0) {
                vitri = i;
                break;
            } 
            else {
                if(TimGanDung(string, ds.elementAt(i).toString()));
                {
                    vitri = i;
                }      
            }
        }
        return vitri;
    }

//    public static int TimNhiPhan(String string, DefaultListModel ds) {
//        int gioihantren = ds.getSize(),
//            gioihanduoi = 1,
//                vitri=0;
//
//        while (gioihantren < gioihanduoi) {
//            int diemgua = (int)Math.round(gioihanduoi + (gioihantren - gioihanduoi) / 2);
//            if (ds.indexOf(string) == string) {
//                vitri = diemgua;
//                break;
//            } else {
//                gioihanduoi = diemgua;
//                gioihantren = diemgua + 1;
//            }  
//        }
//        return vitri;
//    }

  
    
    public static boolean TimGanDung(String string1, String string2) {
        String s = string1;
        int i, j, k, loi, saiSo = (int) Math.round((s.length() * 0.3));
        if ((string2.length() < (s.length() - saiSo)) || (string2.length() > (s.length() + saiSo))) {
            return false;
        }

        i = j = loi = 0;

        while (i < s.length() && j < string2.length()) {

            if (s.charAt(i) != string2.charAt(j)) {

                loi++;

                for (k = 1; k <= saiSo; k++) {

                    if ((i + k < s.length()) && s.charAt(i + k) == string2.charAt(j)) {
                        i += k;
                        //loi += k – 1;
                        break;
                    } else if ((j + k < string2.length()) && s.charAt(i) == string2.charAt(j + k)) {
                        j += k;
                        //loi += k – 1;
                        break;
                    }
                }
            }
            i++;
            j++;
        }
        loi += s.length() - i + string2.length() - j;
        if (loi <= saiSo) {
            return true;
        } else {
            return false;
        }
    }

}
