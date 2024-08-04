/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Panel;

import Controller.PhieuNhapController;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.Frame.fTrangChu;

/**
 *
 * @author Nguyen Khanh
 */
public class JPPhieuNhap_CTPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form JPNhapXuat_NhapHang
     */
    public JPPhieuNhap_CTPhieuNhap(fTrangChu fChu) {
        initComponents();
        this.fChu = fChu;
        new PhieuNhapController(this);
    }
    private fTrangChu fChu =null;

    public fTrangChu getfChu() {
        return fChu;
    }
    
    public void setActionCommand(){
        btnThem.setActionCommand("btnThemPN");
        btnSua.setActionCommand("btnSuaPN");
        btnXoa.setActionCommand("btnXoaPN");
        btnLammoi.setActionCommand("btnLammoiCTPN");
        btnThemCT.setActionCommand("btnThemCTPN");
        btnSuaCT.setActionCommand("btnSuaCTPN");
        btnXoaCT.setActionCommand("btnXoaCTPN");
        btnReset.setActionCommand("btnLammoiPN");
        btnTimkiem.setActionCommand("btnTimkiemPN");
        btnTimkiemCTPN.setActionCommand("btnTimkiemCTPN");
        btnMaNV.setActionCommand("btnMaNVPN");
        btnMaSach.setActionCommand("btnMaSach");
        btnTKMaNV.setActionCommand("btnTKMaNV");
        btnTKMaSach.setActionCommand("btnTKMaSach");
        rdbbinhthuong.setActionCommand("rdbBinhthuong");
        rdbkhoa.setActionCommand("rdbKhoa");
    }
    public JButton getBtnLammoi() {
        return btnLammoi;
    }

    public JPanel getJPCTPN() {
        return JPCTPN;
    }

    public JPanel getJPTKCTPN() {
        return JPTKCTPN;
    }

    public JPanel getJPTimkiem() {
        return JPTimkiem;
    }

    public JPanel getJPhieuNhap() {
        return JPhieuNhap;
    }
    

    public JButton getBtnMaNV() {
        return btnMaNV;
    }

    public JButton getBtnMaSach() {
        return btnMaSach;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JComboBox<String> getCbNCC() {
        return cbNCC;
    }
    
    public JButton getBtnSua() {
        return btnSua;
    }

    public JButton getBtnSuaCT() {
        return btnSuaCT;
    }

    public JButton getBtnTKMaNV() {
        return btnTKMaNV;
    }

    public JButton getBtnTKMaSach() {
        return btnTKMaSach;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public JButton getBtnThemCT() {
        return btnThemCT;
    }

    public JButton getBtnTimkiem() {
        return btnTimkiem;
    }

    public JButton getBtnTimkiemCTPN() {
        return btnTimkiemCTPN;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public JButton getBtnXoaCT() {
        return btnXoaCT;
    }

    public JComboBox<String> getCbMaPN() {
        return cbMaPN;
    }

    public JTextField getTxtMaNCC() {
        return txtMaNCC;
    }

    
    public JDateChooser getJdcNgayNhap() {
        return jdcNgayNhap;
    }

    public JDateChooser getJdcthoigianden() {
        return jdcthoigianden;
    }

    public JDateChooser getJdcthoigiantu() {
        return jdcthoigiantu;
    }

    public JRadioButton getRdbbinhthuong() {
        return rdbbinhthuong;
    }

    public JRadioButton getRdbkhoa() {
        return rdbkhoa;
    }

    public JTable getTbCTPN() {
        return tbCTPN;
    }

    public JTable getTbPN() {
        return tbPN;
    }

    public JTextField getTxtDongia() {
        return txtDongia;
    }

    public JTextField getTxtKhoangtienden() {
        return txtKhoangtienden;
    }

    public JTextField getTxtKhoangtientu() {
        return txtKhoangtientu;
    }

    public JTextField getTxtMaCTPN() {
        return txtMaCTPN;
    }

    public JTextField getTxtMaNV() {
        return txtMaNV;
    }

    public JTextField getTxtMaPN() {
        return txtMaPN;
    }

    public JTextField getTxtMaSach() {
        return txtMaSach;
    }

    public JTextField getTxtSoluong() {
        return txtSoluong;
    }

    public JTextField getTxtTKCTPN() {
        return txtTKCTPN;
    }

    public JTextField getTxtTKDongiaden() {
        return txtTKDongiaden;
    }

    public JTextField getTxtTKDongiatu() {
        return txtTKDongiatu;
    }

    public JTextField getTxtTKKhoangtongtientu() {
        return txtTKKhoangtongtientu;
    }

    public JTextField getTxtTKMaNV() {
        return txtTKMaNV;
    }

    public JTextField getTxtTKMaSach() {
        return txtTKMaSach;
    }

    public JTextField getTxtTKPN() {
        return txtMaNCC;
    }

    public JTextField getTxtThanhtien() {
        return txtThanhtien;
    }

    public JTextField getTxtTimkiemkhoangtongtienden() {
        return txtTimkiemkhoangtongtienden;
    }

    public JTextField getTxtTongphieunhap() {
        return txtTongphieunhap;
    }

    public JTextField getTxtTongtien() {
        return txtTongtien;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPhieuNhap = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        btnMaNV = new javax.swing.JButton();
        cbNCC = new javax.swing.JComboBox<>();
        rdbbinhthuong = new javax.swing.JRadioButton();
        rdbkhoa = new javax.swing.JRadioButton();
        txtTongtien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPN = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTongphieunhap = new javax.swing.JTextField();
        jdcNgayNhap = new com.toedter.calendar.JDateChooser();
        JPTimkiem = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtTKMaNV = new javax.swing.JTextField();
        btnTKMaNV = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtKhoangtientu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtKhoangtienden = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnTimkiem = new javax.swing.JButton();
        jdcthoigiantu = new com.toedter.calendar.JDateChooser();
        jdcthoigianden = new com.toedter.calendar.JDateChooser();
        txtTKPN1 = new javax.swing.JTextField();
        JPCTPN = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTPN = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMaCTPN = new javax.swing.JTextField();
        cbMaPN = new javax.swing.JComboBox<>();
        txtMaSach = new javax.swing.JTextField();
        txtDongia = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        txtThanhtien = new javax.swing.JTextField();
        btnMaSach = new javax.swing.JButton();
        btnThemCT = new javax.swing.JButton();
        btnSuaCT = new javax.swing.JButton();
        btnXoaCT = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        JPTKCTPN = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtTKCTPN = new javax.swing.JTextField();
        txtTKMaSach = new javax.swing.JTextField();
        btnTKMaSach = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtTKDongiatu = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTKDongiaden = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTKKhoangtongtientu = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTimkiemkhoangtongtienden = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnTimkiemCTPN = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(887, 716));

        JPhieuNhap.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("MÃ PHIẾU NHẬP:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MÃ NHÂN VIÊN:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("MÃ NCC:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NGÀY NHẬP:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("TRẠNG THÁI:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("TỔNG TIỀN:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PHIẾU NHẬP SÁCH");

        txtMaPN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.setEnabled(false);

        btnMaNV.setText("...");

        cbNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        rdbbinhthuong.setText("Bình Thường");

        rdbkhoa.setText("Khóa");

        txtTongtien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongtien.setEnabled(false);

        tbPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaPN", "MaNV", "MaNCC", "TrangThai", "TongTien", "NgayNhap"
            }
        ));
        jScrollPane1.setViewportView(tbPN);

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("TỔNG TIỀN ĐÃ NHẬP:");

        txtTongphieunhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongphieunhap.setEnabled(false);

        javax.swing.GroupLayout JPhieuNhapLayout = new javax.swing.GroupLayout(JPhieuNhap);
        JPhieuNhap.setLayout(JPhieuNhapLayout);
        JPhieuNhapLayout.setHorizontalGroup(
            JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPhieuNhapLayout.createSequentialGroup()
                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPhieuNhapLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPhieuNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPhieuNhapLayout.createSequentialGroup()
                        .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPhieuNhapLayout.createSequentialGroup()
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTongtien, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPhieuNhapLayout.createSequentialGroup()
                                        .addComponent(rdbbinhthuong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbkhoa)))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPhieuNhapLayout.createSequentialGroup()
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPhieuNhapLayout.createSequentialGroup()
                                        .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbNCC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMaNV))
                                    .addComponent(txtMaPN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jdcNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPhieuNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        JPhieuNhapLayout.setVerticalGroup(
            JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPhieuNhapLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPhieuNhapLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset))
                    .addGroup(JPhieuNhapLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPhieuNhapLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMaNV)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdbbinhthuong)
                                    .addComponent(rdbkhoa)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcNgayNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTongphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPTimkiem.setBackground(new java.awt.Color(153, 153, 153));
        JPTimkiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        JPTimkiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("MÃ PHIẾU NHẬP:");
        JPTimkiem.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 28, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("MÃ NHÂN VIÊN:");
        JPTimkiem.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 60, -1, -1));

        txtMaNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNCC.setToolTipText("");
        JPTimkiem.add(txtMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 91, -1));

        txtTKMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTKMaNV.setEnabled(false);
        JPTimkiem.add(txtTKMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 54, 91, -1));

        btnTKMaNV.setText("...");
        JPTimkiem.add(btnTKMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 57, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("MÃ NCC:");
        JPTimkiem.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 28, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("KHOẢNG TIỀN");
        JPTimkiem.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 28, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Từ:");
        JPTimkiem.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 57, -1, -1));

        txtKhoangtientu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JPTimkiem.add(txtKhoangtientu, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 54, 52, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Đến:");
        JPTimkiem.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 57, -1, -1));

        txtKhoangtienden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JPTimkiem.add(txtKhoangtienden, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 54, 58, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("KHOẢNG THỜI GIAN");
        JPTimkiem.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Từ:");
        JPTimkiem.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 57, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Đến:");
        JPTimkiem.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 54, -1, -1));

        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        JPTimkiem.add(btnTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 28, -1, 20));
        JPTimkiem.add(jdcthoigiantu, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 54, 73, 26));
        JPTimkiem.add(jdcthoigianden, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 54, 73, 26));

        txtTKPN1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTKPN1.setToolTipText("");
        JPTimkiem.add(txtTKPN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 22, 91, -1));

        JPCTPN.setBackground(new java.awt.Color(102, 102, 102));
        JPCTPN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT PHIẾU NHẬP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaCTPN", "MaPN", "MaSach", "DonGia", "Soluong", "ThanhTien"
            }
        ));
        jScrollPane2.setViewportView(tbCTPN);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("MÃ CHI TIẾT PHIẾU NHẬP:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("MÃ PHIẾU NHẬP:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("MÃ SÁCH:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("ĐƠN GIÁ:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("SỐ LƯỢNG:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("THÀNH TIỀN:");

        txtMaCTPN.setEnabled(false);

        cbMaPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        txtMaSach.setEnabled(false);

        txtThanhtien.setEnabled(false);

        btnMaSach.setText("...");

        btnThemCT.setText("Thêm");

        btnSuaCT.setText("Sửa");
        btnSuaCT.setEnabled(false);

        btnXoaCT.setText("Xóa");
        btnXoaCT.setEnabled(false);

        btnLammoi.setText("Reset");

        javax.swing.GroupLayout JPCTPNLayout = new javax.swing.GroupLayout(JPCTPN);
        JPCTPN.setLayout(JPCTPNLayout);
        JPCTPNLayout.setHorizontalGroup(
            JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCTPNLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPCTPNLayout.createSequentialGroup()
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JPCTPNLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaCTPN, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(JPCTPNLayout.createSequentialGroup()
                                .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMaPN, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtMaSach)
                                    .addComponent(txtDongia)
                                    .addComponent(txtSoluong)
                                    .addComponent(txtThanhtien))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaSach))
                    .addGroup(JPCTPNLayout.createSequentialGroup()
                        .addComponent(btnThemCT)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLammoi)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPCTPNLayout.setVerticalGroup(
            JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPCTPNLayout.createSequentialGroup()
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cbMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaSach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtThanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemCT)
                            .addComponent(btnSuaCT)
                            .addComponent(btnXoaCT)
                            .addComponent(btnLammoi))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        JPTKCTPN.setBackground(new java.awt.Color(153, 153, 153));
        JPTKCTPN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("MÃ SÁCH:");

        txtTKMaSach.setEnabled(false);

        btnTKMaSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTKMaSach.setText("...");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("TỪ:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("ĐẾN:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("TỪ:");

        txtTKKhoangtongtientu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKKhoangtongtientuActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("ĐẾN:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("KHOẢNG ĐƠN GIÁ");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("KHOẢNG TỔNG TIỀN");

        btnTimkiemCTPN.setText("Tìm kiếm");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("MÃ CTPN:");

        javax.swing.GroupLayout JPTKCTPNLayout = new javax.swing.GroupLayout(JPTKCTPN);
        JPTKCTPN.setLayout(JPTKCTPNLayout);
        JPTKCTPNLayout.setHorizontalGroup(
            JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTKCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTKMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTKMaSach)
                .addGap(41, 41, 41)
                .addGroup(JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTKCTPNLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTKDongiatu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTKDongiaden, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTKCTPNLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPTKCTPNLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTKKhoangtongtientu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimkiemkhoangtongtienden, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(btnTimkiemCTPN)
                .addGap(13, 13, 13))
        );
        JPTKCTPNLayout.setVerticalGroup(
            JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPTKCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPTKCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTKMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTKMaSach)
                    .addComponent(jLabel27)
                    .addComponent(txtTKKhoangtongtientu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtTimkiemkhoangtongtienden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTKDongiatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtTKDongiaden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap())
            .addGroup(JPTKCTPNLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnTimkiemCTPN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPTKCTPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPCTPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JPTKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTKKhoangtongtientuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKKhoangtongtientuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKKhoangtongtientuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCTPN;
    private javax.swing.JPanel JPTKCTPN;
    private javax.swing.JPanel JPTimkiem;
    private javax.swing.JPanel JPhieuNhap;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnMaNV;
    private javax.swing.JButton btnMaSach;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaCT;
    private javax.swing.JButton btnTKMaNV;
    private javax.swing.JButton btnTKMaSach;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCT;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnTimkiemCTPN;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaCT;
    private javax.swing.JComboBox<String> cbMaPN;
    private javax.swing.JComboBox<String> cbNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcNgayNhap;
    private com.toedter.calendar.JDateChooser jdcthoigianden;
    private com.toedter.calendar.JDateChooser jdcthoigiantu;
    private javax.swing.JRadioButton rdbbinhthuong;
    private javax.swing.JRadioButton rdbkhoa;
    private javax.swing.JTable tbCTPN;
    private javax.swing.JTable tbPN;
    private javax.swing.JTextField txtDongia;
    private javax.swing.JTextField txtKhoangtienden;
    private javax.swing.JTextField txtKhoangtientu;
    private javax.swing.JTextField txtMaCTPN;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTKCTPN;
    private javax.swing.JTextField txtTKDongiaden;
    private javax.swing.JTextField txtTKDongiatu;
    private javax.swing.JTextField txtTKKhoangtongtientu;
    private javax.swing.JTextField txtTKMaNV;
    private javax.swing.JTextField txtTKMaSach;
    private javax.swing.JTextField txtTKPN1;
    private javax.swing.JTextField txtThanhtien;
    private javax.swing.JTextField txtTimkiemkhoangtongtienden;
    private javax.swing.JTextField txtTongphieunhap;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
