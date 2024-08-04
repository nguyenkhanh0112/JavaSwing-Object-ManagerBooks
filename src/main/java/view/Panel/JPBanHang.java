/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Panel;

import Controller.BanHangController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.Frame.fTrangChu;

/**
 *
 * @author Nguyen Khanh
 */
public class JPBanHang extends javax.swing.JPanel {

    /**
     * Creates new form JPBanHang
     */
    public JPBanHang(fTrangChu frame) {
        initComponents();
        this.fTrangChu = frame;
        setEnable();
        setProduct();
        setActionCommand();
        new BanHangController(this);
    }
    private fTrangChu fTrangChu; 

    public fTrangChu getfTrangChu() {
        return fTrangChu;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaGG = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        btnMaNV = new javax.swing.JButton();
        btnMaKH = new javax.swing.JButton();
        btnMaGG = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        paneTaoHoaDon = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBanHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtLinkanh = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMaSach = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(887, 716));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TẠO HÓA ĐƠN BÁN HÀNG ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã HĐ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("MaNV:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("MaKH:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã GG:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày Lập:");

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHD.setEnabled(false);

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.setEnabled(false);

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKH.setEnabled(false);

        txtMaGG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaGG.setEnabled(false);
        txtMaGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGGActionPerformed(evt);
            }
        });

        txtNgayLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayLap.setEnabled(false);

        btnMaNV.setText("...");
        btnMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaNVActionPerformed(evt);
            }
        });

        btnMaKH.setText("...");
        btnMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaKHActionPerformed(evt);
            }
        });

        btnMaGG.setText("...");
        btnMaGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaGGActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoHoaDon.setText("TẠO HÓA ĐƠN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnMaNV)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnMaKH)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(txtMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnMaGG))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addComponent(btnMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txtNgayLap)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 890, 140);

        paneTaoHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        paneTaoHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXacNhan.setText("Xác nhận");

        btnHuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuy.setText("Hủy");

        tbBanHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Giảm giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbBanHang);

        jPanel4.setLayout(new java.awt.CardLayout());

        txtLinkanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLinkanh.setText("null");
        jPanel4.add(txtLinkanh, "card2");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mã Sách:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tên Sách:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Số Lượng:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Đơn Giá:");

        txtMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Thành Tiền:");

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThanhTien.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giảm Giá:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tổng tiền:");

        txtGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiamGia.setEnabled(false);

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongTien.setEnabled(false);

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);

        btnMaSach.setText("...");
        btnMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneTaoHoaDonLayout = new javax.swing.GroupLayout(paneTaoHoaDon);
        paneTaoHoaDon.setLayout(paneTaoHoaDonLayout);
        paneTaoHoaDonLayout.setHorizontalGroup(
            paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnThem)
                                .addGap(137, 137, 137))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTaoHoaDonLayout.createSequentialGroup()
                                .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDonGia))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneTaoHoaDonLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMaSach))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneTaoHoaDonLayout.createSequentialGroup()
                                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenSach)
                                            .addComponent(txtSoLuong))))
                                .addGap(57, 57, 57))))
                    .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTaoHoaDonLayout.createSequentialGroup()
                        .addComponent(btnXacNhan)
                        .addGap(30, 30, 30)
                        .addComponent(btnHuy)
                        .addGap(65, 65, 65)
                        .addComponent(btnSua)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTaoHoaDonLayout.createSequentialGroup()
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        paneTaoHoaDonLayout.setVerticalGroup(
            paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnXacNhan)
                            .addComponent(btnHuy)))
                    .addGroup(paneTaoHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        add(paneTaoHoaDon);
        paneTaoHoaDon.setBounds(0, 150, 890, 560);
    }// </editor-fold>//GEN-END:initComponents
    public void addActionListener(JButton button,ActionListener actionListener){
        button.addActionListener(actionListener);
        
    }
    public void setEnable(){
        txtMaHD.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtMaGG.setEnabled(false);
        txtNgayLap.setEnabled(false);
        paneTaoHoaDon.setVisible(false);
        paneTaoHoaDon.setEnabled(false);
    }
    public void setProduct(){
        txtTenSach.setEnabled(false);
        txtDonGia.setEnabled(false);
        txtMaSach.setEnabled(false);
        txtThanhTien.setEnabled(false);
        txtTongTien.setEnabled(false);
        txtGiamGia.setEnabled(false);
    }
    public void setActionCommand(){
        btnMaGG.setActionCommand("btnMaGG");
        btnMaKH.setActionCommand("btnMaKH");
        btnMaNV.setActionCommand("btnMaNV");
        btnMaSach.setActionCommand("btnMaSach");
    }
    public void showPanel(){
        paneTaoHoaDon.setVisible(true);
        paneTaoHoaDon.setEnabled(true);
        paneTaoHoaDon.revalidate();
        paneTaoHoaDon.repaint();
    }
    public void hiddenPanel(){
        paneTaoHoaDon.setVisible(false);
        paneTaoHoaDon.setEnabled(false);
        paneTaoHoaDon.revalidate();
        paneTaoHoaDon.repaint();
    }
    
    public JButton getBtnHuy() {
        return btnHuy;
    }
    public JButton getBtnMaSach() {
        return btnMaSach;
    }
    
    public JButton getBtnMaGG() {
        return btnMaGG;
    }

    public JButton getBtnMaKH() {
        return btnMaKH;
    }

    public JButton getBtnMaNV() {
        return btnMaNV;
    }

    public JButton getBtnSua() {
        return btnSua;
    }

    public JButton getBtnTaoHoaDon() {
        return btnTaoHoaDon;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public JButton getBtnXacNhan() {
        return btnXacNhan;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public JTable getTbBanHang() {
        return tbBanHang;
    }

    public JTextField getTxtDonGia() {
        return txtDonGia;
    }

    public JTextField getTxtGiamGia() {
        return txtGiamGia;
    }

    public JLabel getTxtLinkanh() {
        return txtLinkanh;
    }

    public JTextField getTxtMaGG() {
        return txtMaGG;
    }

    public JTextField getTxtMaHD() {
        return txtMaHD;
    }

    public JTextField getTxtMaKH() {
        return txtMaKH;
    }

    public JTextField getTxtMaNV() {
        return txtMaNV;
    }

    public JTextField getTxtMaSach() {
        return txtMaSach;
    }

    public JTextField getTxtNgayLap() {
        return txtNgayLap;
    }

    public JTextField getTxtSoLuong() {
        return txtSoLuong;
    }

    public JTextField getTxtTenSach() {
        return txtTenSach;
    }

    public JTextField getTxtThanhTien() {
        return txtThanhTien;
    }

    public JTextField getTxtTongTien() {
        return txtTongTien;
    }

    public JPanel getPaneTaoHoaDon() {
        return paneTaoHoaDon;
    }
    public JPanel getPanel(){
        return jPanel1;
    }
    private void btnMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaNVActionPerformed

    private void btnMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaKHActionPerformed

    private void btnMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaGGActionPerformed

    private void btnMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaSachActionPerformed

    private void txtMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnMaGG;
    private javax.swing.JButton btnMaKH;
    private javax.swing.JButton btnMaNV;
    private javax.swing.JButton btnMaSach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paneTaoHoaDon;
    private javax.swing.JTable tbBanHang;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JLabel txtLinkanh;
    private javax.swing.JTextField txtMaGG;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
