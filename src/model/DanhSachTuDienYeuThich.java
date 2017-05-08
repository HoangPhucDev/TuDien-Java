/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Admin
 */
public class DanhSachTuDienYeuThich {
    
    private int Id;

    private String Name;
    
    public DanhSachTuDienYeuThich() {
        
    }
    
    public DanhSachTuDienYeuThich(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    @Override
    public String toString() {
        return String.valueOf(getId()); 
    }
    
  
}
