/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Panel;

import Controller.SachController;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Frame.fTrangChu;

/**
 *
 * @author Nguyen Khanh
 */
public class JPQuanLySach extends javax.swing.JPanel {

    /**
     * Creates new form JPQuanLySach
     */

    private fTrangChu fTrangChu1;
    public JPQuanLySach(fTrangChu fTrangChu) {
        initComponents();
        this.fTrangChu1 = fTrangChu;
        showButton();
        labelLinkAnh.setText("null");
        labelLinkAnh.setIcon(null);
        SachController controller = new SachController(this);
       
    }
    public void addButtonListener(JButton button ,ActionListener actionListener){
        button.addActionListener(actionListener);
    }  
    public JTable getjTable1() {
        return jTable1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }
    
    public JLabel getLabelLinkAnh() {
        return labelLinkAnh;
    }
    
    public JButton getBtnChonAnh() {
        return btnChonAnh;
    }

    public JButton getBtnLammoi() {
        return btnLammoi;
    }

    public JButton getBtnNhapExcel() {
        return btnNhapExcel;
    }

    public JButton getBtnQuayLaij() {
        return btnQuayLaij;
    }

    public JButton getBtnSua() {
        return btnSua;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public JButton getBtnThongKe() {
        return btnThongKe;
    }

    public JButton getBtnTimKiem() {
        return btnTimKiem;
    }

    public JButton getBtnXacNhan() {
        return btnXacNhan;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public JButton getBtnXuatExcel() {
        return btnXuatExcel;
    }

    public JComboBox<String> getCbMaNXB() {
        return cbMaNXB;
    }

    public JComboBox<String> getCbMaTG() {
        return cbMaTG;
    }

    public JComboBox<String> getCbMaTL() {
        return cbMaTL;
    }

    public JComboBox<String> getCbMasNXB() {
        return cbMasNXB;
    }

    public JComboBox<String> getCbMasTG() {
        return cbMasTG;
    }

    public JComboBox<String> getCbMasTL() {
        return cbMasTL;
    }

    public JTextField getTxtDonGia() {
        return txtDonGia;
    }

    public JTextField getTxtDonGiaCaoNhat() {
        return txtDonGiaCaoNhat;
    }

    public JTextField getTxtGiaThapNhat() {
        return txtGiaThapNhat;
    }

    public JTextField getTxtKhoangGia1() {
        return txtKhoangGia1;
    }

    public JTextField getTxtKhoangGia2() {
        return txtKhoangGia2;
    }

    public JTextField getTxtMaSach() {
        return txtMaSach;
    }

    public JTextField getTxtMaSsach() {
        return txtMaSsach;
    }

    public JTextField getTxtNXB() {
        return txtNXB;
    }

    public JTextField getTxtNamXB1() {
        return txtNamXB1;
    }

    public JTextField getTxtNamXB2() {
        return txtNamXB2;
    }

    public JTextField getTxtSoLoaiSach() {
        return txtSoLoaiSach;
    }

    public JTextField getTxtSoLuong() {
        return txtSoLuong;
    }

    public JTextField getTxtTenSach() {
        return txtTenSach;
    }

    public JTextField getTxtTenSsach() {
        return txtTenSsach;
    }

    public JTextField getTxtTongSoSach() {
        return txtTongSoSach;
    }
    

   
        public void showButtonThemSua(){
        btnThem.setEnabled(false);
        btnThem.setVisible(false);
        btnSua.setEnabled(false);
        btnSua.setVisible(false);
        btnXoa.setEnabled(false);
        btnXoa.setVisible(false);
        btnChonAnh.setEnabled(true);
        btnChonAnh.setVisible(true);
        btnQuayLaij.setVisible(true);
        btnQuayLaij.setEnabled(true);
        btnXacNhan.setVisible(true);
        btnXacNhan.setEnabled(true);
    }
    public void showButton(){
        btnChonAnh.setEnabled(false);
        btnChonAnh.setVisible(false);
        btnQuayLaij.setVisible(false);
        btnQuayLaij.setEnabled(false);
        btnXacNhan.setVisible(false);
        btnXacNhan.setEnabled(false);
        btnThem.setEnabled(true);
        btnThem.setVisible(true);
        btnSua.setEnabled(false);
        btnSua.setVisible(true);
        btnXoa.setEnabled(false);
        btnXoa.setVisible(true);
    }
    public void setEnabledTrue(){
        txtMaSach.setEnabled(true);
        cbMaNXB.setEnabled(true);
        cbMaTG.setEnabled(true);
        cbMaTL.setEnabled(true);
        txtTenSach.setEnabled(true);
        txtNXB.setEnabled(true);
        txtSoLuong.setEnabled(true);
        txtDonGia.setEnabled(true);
        labelLinkAnh.setEnabled(true);
    }
    public void setEnabledFalse(){
        txtMaSach.setEnabled(false);
        cbMaNXB.setEnabled(false);
        cbMaTG.setEnabled(false);
        cbMaTL.setEnabled(false);
        txtTenSach.setEnabled(false);
        txtNXB.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtDonGia.setEnabled(false);
        labelLinkAnh.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cbMaNXB = new javax.swing.JComboBox<>();
        cbMaTL = new javax.swing.JComboBox<>();
        cbMaTG = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelLinkAnh = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        btnChonAnh = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnQuayLaij = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaSsach = new javax.swing.JTextField();
        cbMasTG = new javax.swing.JComboBox<>();
        cbMasNXB = new javax.swing.JComboBox<>();
        cbMasTL = new javax.swing.JComboBox<>();
        txtTenSsach = new javax.swing.JTextField();
        txtNamXB1 = new javax.swing.JTextField();
        txtNamXB2 = new javax.swing.JTextField();
        txtKhoangGia2 = new javax.swing.JTextField();
        txtKhoangGia1 = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThongKe = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtGiaThapNhat = new javax.swing.JTextField();
        txtSoLoaiSach = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDonGiaCaoNhat = new javax.swing.JTextField();
        txtTongSoSach = new javax.swing.JTextField();

        jButton7.setText("jButton7");

        setPreferredSize(new java.awt.Dimension(887, 716));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã NXB:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 83, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Thể Loại:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Tác Giả:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 152, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên Sách:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 186, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Năm Xuất Bản:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 215, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã Sách:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 51, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số Lượng:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Đơn Giá:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 282, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ SÁCH");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 881, -1));

        txtMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSach.setEnabled(false);
        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 48, 190, -1));

        txtTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSach.setEnabled(false);
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });
        jPanel1.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 180, 190, -1));

        txtNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNXB.setEnabled(false);
        txtNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNXBActionPerformed(evt);
            }
        });
        jPanel1.add(txtNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 212, 190, -1));

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDonGia.setEnabled(false);
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 276, 190, -1));

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuong.setEnabled(false);
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 244, 190, -1));

        cbMaNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMaNXB.setEnabled(false);
        jPanel1.add(cbMaNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 80, 190, -1));

        cbMaTL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMaTL.setEnabled(false);
        jPanel1.add(cbMaTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 117, 190, -1));

        cbMaTG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMaTG.setEnabled(false);
        jPanel1.add(cbMaTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 149, 190, -1));

        btnSua.setText("SỬA");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 151, 34));

        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 151, 34));

        btnXoa.setText("XÓA");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 151, 34));

        btnLammoi.setText("LÀM MỚI");
        jPanel1.add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 151, 34));

        jPanel2.setLayout(new java.awt.CardLayout());

        labelLinkAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(labelLinkAnh, "card2");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 48, 170, 190));

        btnXuatExcel.setText("XUẤT EXCEL");
        jPanel1.add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 48, 128, 35));

        btnNhapExcel.setText("NHẬP EXCEL");
        jPanel1.add(btnNhapExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 89, 128, 35));

        btnChonAnh.setText("CHỌN ẢNH");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        jPanel1.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 151, 34));

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 151, 34));

        btnQuayLaij.setText("QUAY LẠI");
        btnQuayLaij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaijActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuayLaij, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 151, 34));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 308));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Đến:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 25, 30, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã Sách:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 60, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Mã NXB:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 60, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mã TG:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 25, 48, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Năm XB Từ:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 65, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tên Sách:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 25, 60, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Khoảng Giá:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 25, 80, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Năm XB Đến:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 65, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Từ:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 25, 20, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Mã TL:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 65, 48, -1));

        txtMaSsach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtMaSsach, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 22, 120, -1));

        cbMasTG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(cbMasTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 22, 120, -1));

        cbMasNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(cbMasNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 62, 120, -1));

        cbMasTL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(cbMasTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 62, 120, -1));

        txtTenSsach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtTenSsach, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 22, 128, -1));

        txtNamXB1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtNamXB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 62, 40, -1));

        txtNamXB2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamXB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamXB2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtNamXB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 62, 40, -1));

        txtKhoangGia2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtKhoangGia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 22, 49, -1));

        txtKhoangGia1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtKhoangGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 22, 49, -1));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nguyen Khanh\\OneDrive\\Documents\\NetBeansProjects\\BookStore1\\src\\main\\java\\img\\seo.png")); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setToolTipText("");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 54, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 314, 920, 100));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SÁCH", "MÃ NXB", "MÃ THỂ LOẠI", "MÃ TÁC GIẢ", "TÊN SÁCH", "NĂM XUẤT BẢN", "SỐ LƯỢNG", "ĐƠN GIÁ", "HÌNH ẢNH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 920, 178));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nguyen Khanh\\OneDrive\\Documents\\NetBeansProjects\\BookStore1\\src\\main\\java\\img\\analysis.png")); // NOI18N
        btnThongKe.setText("Thông Kê");
        jPanel5.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Đơn Giá Thấp Nhất:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 22, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Số Loại Sách: ");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 60, -1, -1));

        txtGiaThapNhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(txtGiaThapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 19, 183, -1));

        txtSoLoaiSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(txtSoLoaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 57, 183, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Đơn Giá Cao Nhất:");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 22, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tổng Số Sách:");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 60, -1, -1));

        txtDonGiaCaoNhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(txtDonGiaCaoNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 19, 184, -1));

        txtTongSoSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel5.add(txtTongSoSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 57, 184, -1));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 604, 918, 119));
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNXBActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
   
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtNamXB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamXB2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamXB2ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        showButtonThemSua();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnQuayLaijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaijActionPerformed
//        showButton();
    }//GEN-LAST:event_btnQuayLaijActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnQuayLaij;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cbMaNXB;
    private javax.swing.JComboBox<String> cbMaTG;
    private javax.swing.JComboBox<String> cbMaTL;
    private javax.swing.JComboBox<String> cbMasNXB;
    private javax.swing.JComboBox<String> cbMasTG;
    private javax.swing.JComboBox<String> cbMasTL;
    private javax.swing.JButton jButton7;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelLinkAnh;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonGiaCaoNhat;
    private javax.swing.JTextField txtGiaThapNhat;
    private javax.swing.JTextField txtKhoangGia1;
    private javax.swing.JTextField txtKhoangGia2;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaSsach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNamXB1;
    private javax.swing.JTextField txtNamXB2;
    private javax.swing.JTextField txtSoLoaiSach;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenSsach;
    private javax.swing.JTextField txtTongSoSach;
    // End of variables declaration//GEN-END:variables
}
