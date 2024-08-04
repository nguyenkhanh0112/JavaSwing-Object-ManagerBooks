/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package view.Dialog;

import DAO.ChiTietHoaDonDAO;
import Model.CTHOADON;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Khanh
 */
public class DThemCTHD extends java.awt.Dialog {

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
    /**
     * Creates new form DThemCTHD
     */
    public DThemCTHD(java.awt.Frame parent, boolean modal,ArrayList<CTHOADON> list,double phantramgg,String MaHD) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        loadData(list,phantramgg);
        valueChanged();
        btn(MaHD);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtDongia = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        btnMaSach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        btnXacNhan = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(630, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM CHI TIẾT HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("MaHD:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MaSach:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("TenSach:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Dongia:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giamgia:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Soluong:");

        txtMaHD.setEnabled(false);

        txtMaSach.setEnabled(false);

        txtTenSach.setEnabled(false);
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        txtDongia.setEnabled(false);

        txtGiamGia.setEnabled(false);

        txtSoluong.setEnabled(false);

        btnMaSach.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtDongia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaSach))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 620, 230);

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "MaSach", "TenSach", "Soluong", "Dongia", "Giamgia", "Thanhtien"
            }
        ));
        jScrollPane1.setViewportView(tbCTHD);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 600, 280);

        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        add(btnXacNhan);
        btnXacNhan.setBounds(140, 530, 110, 50);

        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDong.setText("Đóng");
        add(btnDong);
        btnDong.setBounds(300, 530, 110, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void loadData(ArrayList<CTHOADON> list,double phantramgg){
       iList = new ArrayList<>();
       phantramGG = phantramgg;
       this.dsSanPham = new DSanPham(this,"Them CTHD",true);
       modelCTHD = new ChiTietHoaDonDAO();
       defaultTableModel = (DefaultTableModel)tbCTHD.getModel();
       defaultTableModel.setRowCount(0);
       ArrayList<CTHOADON> cthoadons = list;
       for(CTHOADON cthoadon : cthoadons){
           defaultTableModel.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
       }
    }
    public void valueChanged(){
        tbCTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectRow = tbCTHD.getSelectedRow();
                    if(selectRow!=-1){
                    }
                }
            }
        });
    }
    public void btn(String MaHD){
        btnXacNhan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtSoluong.getText()!=null&&!txtSoluong.getText().isEmpty()){
                    double sotienGG = cthoadon.getSotienGG(phantramGG, Double.parseDouble(txtDongia.getText()));
                    int soluong = Integer.parseInt(txtSoluong.getText());
                    double dongia = Double.parseDouble(txtDongia.getText());
                    double Thanhtien = cthoadon.Thanhtien(soluong,dongia,sotienGG);
                    cthoadon.setMaHD(MaHD);
                    cthoadon.setMaSach(txtMaSach.getText());
                    cthoadon.setTenSach(txtTenSach.getText());
                    cthoadon.setSoLuong(Integer.parseInt(txtSoluong.getText()));
                    cthoadon.setDonGia(Double.parseDouble(txtDongia.getText()));
                    cthoadon.setGiamGia(Double.parseDouble(txtGiamGia.getText()));
                    cthoadon.setThanhTien(soluong*(dongia-sotienGG));
                    iList.add(cthoadon);
                    defaultTableModel.addRow(new Object[]{txtMaHD.getText(),txtMaSach.getText(),txtTenSach.getText(),txtSoluong.getText(),txtDongia.getText(),txtGiamGia.getText(),String.valueOf(Thanhtien)});
                    JOptionPane.showMessageDialog(null, "Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    check = true;
                    txtSoluong.setEnabled(false);
                    clearJpanel(jPanel1);
                    tbCTHD.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(null, "Thiếu dữ liệu!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        btnDong.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 for(int i =0;i<defaultTableModel.getRowCount();i++){
                        int soluong = Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString());
                        double sotienGg = Double.parseDouble(defaultTableModel.getValueAt(i, 5).toString());
                        double dongia = Double.parseDouble(defaultTableModel.getValueAt(i, 4).toString());
                        Tongtien+=(dongia*soluong);
                        Giamgia+=(soluong*sotienGg);
                        Thanhtien+=(soluong*(dongia-sotienGg));
                    }
                check = false;
                setVisible(false);
                dispose();
            }
            
        });
        btnMaSach.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSoluong.setEnabled(true);
                dsSanPham.setVisible(true);
                txtSoluong.setText(null);
                if(dsSanPham.isCheck()){
                    cthoadon = new CTHOADON();
                    ArrayList<String> list = dsSanPham.getText();
                    String MaSach = list.get(0).toString();
                    String TenSach = list.get(1).toString();
                    double dongia = Double.parseDouble(list.get(2).toString());
                    double sotienGG = cthoadon.getSotienGG(phantramGG, dongia);
                    txtMaHD.setText(MaHD);
                    txtMaSach.setText(MaSach);
                    txtTenSach.setText(TenSach);
                    txtDongia.setText(String.valueOf(dongia));
                    txtGiamGia.setText(String.valueOf(sotienGG));
                }
            }
        });
    }

    /**
     * Closes the dialog
     */
    public void clearJpanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }
        }
    }
    public ArrayList<CTHOADON> getiList() {
        return iList;
    }

    public double getDongia1() {
        return Dongia1;
    }

    public Boolean getCheck() {
        return check;
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

    public JButton getBtnDong() {
        return btnDong;
    }

    public JButton getBtnMaSach() {
        return btnMaSach;
    }

    public JButton getBtnXacNhan() {
        return btnXacNhan;
    }

    public JTable getTbCTHD() {
        return tbCTHD;
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

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnMaSach;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTextField txtDongia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
