/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelform;


import DAO.DAODanhSachTuDienYeuThich;
import DAO.DAOTuDien;
import DAO.DAOTuYeuThich;
import helper.TimKiem;
import helper.xulychuoi;

import java.awt.Component;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.DanhSachTuDienYeuThich;
import model.TuYeuThich;
import model.TuDien;






/**
 *
 * @author Admin
 */
public class pnDich extends javax.swing.JPanel {
    
   
    
    private List<TuDien> ListTudien;
    
    private List<DanhSachTuDienYeuThich> DSYeuThich;
    
    private final DefaultListModel dlm = new DefaultListModel();        
    
    private final DefaultComboBoxModel cbm= new DefaultComboBoxModel();

    public DefaultComboBoxModel getCbm() {
        return cbm;
    }

    public void setCbm(List list) {
        list.forEach((item) -> {
            this.cbm.addElement(item);
        });
    }
   

    public DefaultListModel getDlm() {
        return dlm;
    }

    public void setDlm(List list) {
        list.forEach((item) -> {
            this.dlm.addElement(item);
        });
    }
 


    private void loadListTudien()
    {
        try {
            ListTudien = DAOTuDien.getListTudien();
            DSYeuThich = DAODanhSachTuDienYeuThich.getListTudien();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không Thể Kết Nối SQLServer \n"+ex, "Thông Báo", 0);
        }
      
              
      //load dữ liệu vào Jlist danh sách từ
      setDlm(ListTudien);
      lstDS.setModel(dlm);
      lstDS.setSelectedIndex(0);
      
      //load dữ liệu vào jcombobox DS nhóm từ yêu thích
      setCbm(DSYeuThich);
      cbbDS.setModel(cbm);
      
      
    }
    public pnDich() {
        
      initComponents();  
      loadListTudien();
    }


  

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        lstDS = new javax.swing.JList<>();
        txtWord = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnDanhDau = new javax.swing.JButton();
        cbbDS = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKQ = new javax.swing.JTextArea();

        jScrollPane1.setAutoscrolls(true);

        lstDS.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list,Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof model.TuDien){
                    model.TuDien tudien = (model.TuDien) value;
                    this.setText(tudien.getWord());
                }
                return this;
            }
        });
        lstDS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstDS.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstDS);

        txtWord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWordKeyReleased(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1490705930_circle-edit-search-thin.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnDanhDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1490704353_Star_Gold.png"))); // NOI18N
        btnDanhDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhDauActionPerformed(evt);
            }
        });

        cbbDS.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list,Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof model.DanhSachTuDienYeuThich){
                    model.DanhSachTuDienYeuThich ds = (model.DanhSachTuDienYeuThich) value;
                    this.setText(ds.getName());
                }
                return this;
            }
        });
        cbbDS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDSActionPerformed(evt);
            }
        });

        txtKQ.setColumns(20);
        txtKQ.setRows(5);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstDS, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.detail}"), txtKQ, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(txtKQ);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(txtWord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDanhDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDS, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cbbDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDanhDau)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       int kq = TimKiem.TimTuyenTinh(txtWord.getText(), dlm);
       
       if(kq>1)
       {
            lstDS.setSelectedValue(dlm.elementAt(kq), true);
       }
       else
       {
           txtKQ.setText("Không Tìm Thấy");
       }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnDanhDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhDauActionPerformed

        cbbDS.showPopup();
        
    }//GEN-LAST:event_btnDanhDauActionPerformed

    private void cbbDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDSActionPerformed
       
     
        int Checkrs = 0;
        try {
            Checkrs = DAOTuYeuThich.Insert(
                    Integer.valueOf(cbbDS.getSelectedItem().toString()),
                    String.valueOf(lstDS.getSelectedValue()),
                    xulychuoi.xuly(txtKQ.getText())
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không Thể Kết Nối SQLServer \n"+ex, "Thông Báo", 0);
        }
        if(Checkrs == 1)
        {   
            JOptionPane.showMessageDialog(null, "Thêm Thành Công", "Thông Báo", 1);
        }else
        {
            JOptionPane.showMessageDialog(null, "Lỗi: Không Thể Thêm", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_cbbDSActionPerformed

    private void txtWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWordKeyReleased
        int kq = TimKiem.TimTuyenTinh(txtWord.getText(), dlm);
       
       if(kq>1)
       {
            lstDS.setSelectedValue(dlm.elementAt(kq), true);
       }
       else
       {
           txtKQ.setText("Không Tìm Thấy");
       }
    }//GEN-LAST:event_txtWordKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhDau;
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cbbDS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstDS;
    private javax.swing.JTextArea txtKQ;
    private javax.swing.JTextField txtWord;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables




}
