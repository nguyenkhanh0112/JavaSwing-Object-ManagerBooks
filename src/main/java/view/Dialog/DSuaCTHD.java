/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package view.Dialog;

import DAO.ChiTietHoaDonDAO;
import Model.CTHOADON;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Khanh
 */
public class DSuaCTHD extends java.awt.Dialog {

    private DefaultTableModel defaultTableModel = null;
    private ChiTietHoaDonDAO modelCTHD = null;
    private DSanPham dsSanPham = null;
    private ArrayList<CTHOADON> iList = null;
    private double Dongia1 = 0.0;
    private double sotienGiamGia = 0.0;
    private double phantramGG = 0.0;
    private CTHOADON cthoadon = null;
    private int selectRow = -1;
    private Boolean check = null;
    private double Tongtien = 0.0;
    private double Giamgia = 0.0;
    private double Thanhtien = 0.0;
    public DSuaCTHD(java.awt.Frame parent, boolean modal,ArrayList<CTHOADON> list) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        loadData(list);
        valueChanged();
        btn();
    }
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXacNhan = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Dongia = new javax.swing.JLabel();
        giamgia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtDongia = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTDH = new javax.swing.JTable();
        btnMaSach = new javax.swing.JButton();
        txtSoluong = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setText("Xác Nhận");

        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDong.setText("Đóng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("MaHD:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MaSach:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("TenSach:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Soluong:");

        Dongia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Dongia.setText("DonGia:");

        giamgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        giamgia.setText("GiamGia:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SỬA CHI TIẾT HÓA ĐƠN");

        txtMaHD.setEnabled(false);

        txtMaSach.setEnabled(false);

        txtTenSach.setEnabled(false);

        txtDongia.setEnabled(false);

        txtGiamGia.setEnabled(false);

        tbCTDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "MaSach", "TenSach", "Soluong", "Dongia", "Giamgia", "Thanhtien"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCTDH);

        btnMaSach.setText("...");
        btnMaSach.setEnabled(false);

        txtSoluong.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txtTenSach)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(btnMaSach)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giamgia)
                                    .addComponent(Dongia))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(txtDongia))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMaSach))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Dongia))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(giamgia))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<CTHOADON> getiList() {
        return iList;
    }

    public Boolean getCheck() {
        return check;
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    public void loadData(ArrayList<CTHOADON> list){
       iList = new ArrayList<>();
       cthoadon = new CTHOADON();
       this.dsSanPham = new DSanPham(this,"Sua CTHD",true);
       modelCTHD = new ChiTietHoaDonDAO();
       defaultTableModel = (DefaultTableModel)tbCTDH.getModel();
       defaultTableModel.setRowCount(0);
       ArrayList<CTHOADON> cthoadons = list;
       for(CTHOADON cthoadon : cthoadons){
           defaultTableModel.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
       }
    }
    public void valueChanged(){
        tbCTDH.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectRow = tbCTDH.getSelectedRow();
                    if(selectRow!=-1){
                       btnMaSach.setEnabled(true);
                       txtSoluong.setEnabled(true);
                       sotienGiamGia = Double.parseDouble(defaultTableModel.getValueAt(selectRow, 5).toString());
                       Dongia1 = Double.parseDouble(defaultTableModel.getValueAt(selectRow, 4).toString());
                       txtMaHD.setText(defaultTableModel.getValueAt(selectRow,0).toString());
                       txtMaSach.setText(defaultTableModel.getValueAt(selectRow, 1).toString());
                       txtTenSach.setText(defaultTableModel.getValueAt(selectRow, 2).toString());
                       txtSoluong.setText(defaultTableModel.getValueAt(selectRow, 3).toString());
                       txtDongia.setText(defaultTableModel.getValueAt(selectRow, 4).toString());
                       txtGiamGia.setText(defaultTableModel.getValueAt(selectRow, 5).toString());
                    }
                }
            }
        });
    }
    public void btn(){
        btnXacNhan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtSoluong.getText()!=null&&!txtSoluong.getText().isEmpty()){
                    phantramGG = cthoadon.getPhanTramGG(sotienGiamGia, Dongia1);
                    double sotienGG = cthoadon.getSotienGG(phantramGG, Double.parseDouble(txtDongia.getText()));
                    int soluong = Integer.parseInt(txtSoluong.getText());
                    double dongia = Double.parseDouble(txtDongia.getText());
                    double Thanhtien = cthoadon.Thanhtien(soluong,dongia,sotienGG);
                    defaultTableModel.setValueAt(txtMaHD.getText(), selectRow,0);
                    defaultTableModel.setValueAt(txtMaSach.getText(),selectRow,1);
                    defaultTableModel.setValueAt(txtTenSach.getText(),selectRow,2);
                    defaultTableModel.setValueAt(txtSoluong.getText(),selectRow,3);
                    defaultTableModel.setValueAt(txtDongia.getText(),selectRow,4);
                    defaultTableModel.setValueAt(txtGiamGia.getText(),selectRow,5);
                    defaultTableModel.setValueAt(Thanhtien,selectRow,6);
                    JOptionPane.showMessageDialog(null, "Sửa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    check = true;
                    btnMaSach.setEnabled(false);
                    txtSoluong.setEnabled(false);
                    txtMaHD.setText("");
                    txtMaSach.setText("");
                    txtTenSach.setText("");
                    txtDongia.setText("");
                    txtGiamGia.setText("");
                    txtSoluong.setText("");
                    tbCTDH.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(null, "Thiếu dữ liệu!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        btnDong.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 for(int i =0;i<defaultTableModel.getRowCount();i++){
                        CTHOADON cthoadon = new CTHOADON();
                        int soluong = Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString());
                        double sotienGg = Double.parseDouble(defaultTableModel.getValueAt(i, 5).toString());
                        double dongia = Double.parseDouble(defaultTableModel.getValueAt(i, 4).toString());
                        cthoadon.setMaHD(defaultTableModel.getValueAt(i, 0).toString());
                        cthoadon.setMaSach(defaultTableModel.getValueAt(i, 1).toString());
                        cthoadon.setTenSach(defaultTableModel.getValueAt(i, 2).toString());
                        cthoadon.setSoLuong(Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString()));
                        cthoadon.setDonGia(Double.parseDouble(defaultTableModel.getValueAt(i, 4).toString()));
                        cthoadon.setGiamGia(Double.parseDouble(defaultTableModel.getValueAt(i, 5).toString()));
                        cthoadon.setThanhTien(soluong*(dongia-sotienGg));
                        Tongtien+=cthoadon.getDonGia();
                        Giamgia+=cthoadon.getGiamGia();
                        Thanhtien+=cthoadon.getThanhTien();
                        iList.add(cthoadon);
                    }
                check = false;
                setVisible(false);
                dispose();
            }
            
        });
        btnMaSach.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dsSanPham.setVisible(true);
                txtSoluong.setText(null);
                if(dsSanPham.isCheck()){
                    ArrayList<String> list = dsSanPham.getText();
                    String MaHD = txtMaHD.getText();
                    String MaSach = list.get(0).toString();
                    String TenSach = list.get(1).toString();
                    double dongia = Double.parseDouble(list.get(2).toString());
                    phantramGG = cthoadon.getPhanTramGG(sotienGiamGia, Dongia1);
                    double sotienGG = cthoadon.getSotienGG(phantramGG, dongia);
                    txtMaSach.setText(MaSach);
                    txtTenSach.setText(TenSach);
                    txtDongia.setText(String.valueOf(dongia));
                    txtGiamGia.setText(String.valueOf(sotienGG));
                }
            }
        });
    }

    public double getTongtien() {
        return Tongtien;
    }

    public double getGiamgia() {
        return Giamgia;
    }

    public double getThanhtien() {
        return Thanhtien;
    }
    
    public JButton getBtnMaSach() {
        return btnMaSach;
    }
    
    public JTable getTbCTDH() {
        return tbCTDH;
    }

    public JTextField getTxtDongia() {
        return txtDongia;
    }

    public JTextField getTxtGiamGia() {
        return txtGiamGia;
    }

    public JTextField getTxtMaHD() {
        return txtMaHD;
    }

    public JTextField getTxtMaSach() {
        return txtMaSach;
    }

    public JTextField getTxtSoluong() {
        return txtSoluong;
    }

    public JTextField getTxtTenSach() {
        return txtTenSach;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }
    public boolean check(String text){
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dongia;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnMaSach;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel giamgia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCTDH;
    private javax.swing.JTextField txtDongia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
