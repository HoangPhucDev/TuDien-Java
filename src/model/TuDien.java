/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class TuDien implements Comparable<TuDien>{

    private String Word;

    private String Detail;

    private int Id;

        public String getWord() {
        return Word;
    }

    public void setWord(String Word) {
        this.Word = Word;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return getWord(); 
    }

    @Override
    public int compareTo(TuDien o) {
        int result = getWord().compareTo(o.getWord());
        if (result != 0) return result;
        return result;
    }


}
