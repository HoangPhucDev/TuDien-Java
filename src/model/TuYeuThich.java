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
public class TuYeuThich {

    
    private String Word;
    
    private String Detail;
    
    private int Id;
    
    
    private DanhSachTuDienYeuThich GroupFAV;

    public TuYeuThich(String Word, String Detail, int Id, DanhSachTuDienYeuThich GroupFAV) {
        this.Word = Word;
        this.Detail = Detail;
        this.Id = Id;
        this.GroupFAV = GroupFAV;
    }
    
    
    
    public TuYeuThich() {
        GroupFAV = new DanhSachTuDienYeuThich();
    }

    public DanhSachTuDienYeuThich getGroupFAV() {
        return GroupFAV;
    }

    public void setGroupFAV(DanhSachTuDienYeuThich GroupFAV) {
        this.GroupFAV = GroupFAV;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getWord() {
        return Word;
    }
    
    public void setWord(String Word) {
        this.Word = Word;
    }

}
