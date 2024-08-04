/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CTPhieuNhapDAO;
import DAO.NhaCCDAO;
import DAO.PhieuNhapDAO;
import Model.CTPHIEUNHAP;
import Model.NCC;
import Model.PHIEUNHAP;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Dialog.DSanPham;
import view.Dialog.DsNhanVien;
import view.Panel.JPPhieuNhap_CTPhieuNhap;

/**
 *
 * @author Nguyen Khanh
 */
public class PhieuNhapController implements ActionListener,ListSelectionListener{
    private PHIEUNHAP phieunhap = null;
    private CTPHIEUNHAP ctphieunhap = null;
    private DefaultTableModel defaultTableModelPN = null;
    private DefaultTableModel defaultTableModelCTPN = null;
    private PhieuNhapDAO modelPN = null;
    private CTPhieuNhapDAO modelCTPN = null;
    private JPPhieuNhap_CTPhieuNhap view =null;
    private SimpleDateFormat sdf =null;
    private NhaCCDAO  modelNCC= null;
    private DSanPham dSanPham = null;
    private DsNhanVien dsNhanVien = null;
    private double tongtien = 0.0;
    

    public PhieuNhapController(JPPhieuNhap_CTPhieuNhap view) {
        this.view = view;
        modelCTPN = new CTPhieuNhapDAO();
        modelPN = new PhieuNhapDAO();
        
        defaultTableModelPN = (DefaultTableModel) view.getTbPN().getModel();
        defaultTableModelCTPN = (DefaultTableModel) view.getTbCTPN().getModel();
        this.view.getTbPN().getSelectionModel().addListSelectionListener(this);
        this.view.getTbCTPN().getSelectionModel().addListSelectionListener(this);
        
        this.view.getBtnThem().addActionListener(this);
        this.view.getBtnSua().addActionListener(this);
        this.view.getBtnXoa().addActionListener(this);
        this.view.getBtnThemCT().addActionListener(this);
        this.view.getBtnXoaCT().addActionListener(this);
        this.view.getBtnSuaCT().addActionListener(this);
        this.view.getBtnLammoi().addActionListener(this);
        this.view.getBtnReset().addActionListener(this);
        this.view.getBtnTimkiemCTPN().addActionListener(this);
        this.view.getBtnTKMaNV().addActionListener(this);
        this.view.getBtnTKMaSach().addActionListener(this);
        this.view.getBtnMaSach().addActionListener(this);
        this.view.getBtnMaNV().addActionListener(this);
        this.view.getRdbbinhthuong().addActionListener(this);
        this.view.getRdbkhoa().addActionListener(this);
        this.view.getBtnTimkiem().addActionListener(this);
//        this.view.getCbNCC().addActionListener(this);
        
        
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");   
        this.view.getJdcNgayNhap().setDateFormatString("yyyy-MM-dd");
        this.view.getJdcthoigiantu().setDateFormatString("yyyy-MM-dd");
        this.view.getJdcthoigianden().setDateFormatString("yyyy-MM-dd");
        this.dsNhanVien = new DsNhanVien(view.getfChu(), true);
        this.dSanPham = new DSanPham(view.getfChu(), true);
        loadData();
        loadCombobox();
        view.setActionCommand();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "btnThemPN":
                handleThemPN();
                break;
            case "btnSuaPN":
                handleSuaPN();
                break;
            case "btnXoaPN":
                handleXoaPN();
                break;
            case "btnLammoiCTPN":
                clerPanel(view.getJPCTPN());
                ArrayList<CTPHIEUNHAP>ctphieunhaps = modelCTPN.selectAll();
                defaultTableModelCTPN.setRowCount(0);
                for (CTPHIEUNHAP ctphieunhap : ctphieunhaps) {
                    defaultTableModelCTPN.addRow(new Object[]{ctphieunhap.getMaCTPN(),ctphieunhap.getMaPN(),ctphieunhap.getMaSach(),ctphieunhap.getDonGia(),ctphieunhap.getSoLuong(),ctphieunhap.getThanhTien()});
                }
                view.getBtnSuaCT().setEnabled(false);
                view.getBtnXoaCT().setEnabled(false);
                view.getTbPN().clearSelection();
                view.getTbCTPN().clearSelection();
                break;    
            case "btnThemCTPN":
                handleThemMaCTPN();
                break;
            case "btnSuaCTPN":
                handleSuaCTPN();
                break;
            case "btnXoaCTPN":
                handleXoaCTPN();
                break;
            case "btnLammoiPN":
                clerPanel(view.getJPhieuNhap()); 
                view.getTbPN().clearSelection();
                view.getTbCTPN().clearSelection();
                view.getBtnSua().setEnabled(false);
                view.getBtnXoa().setEnabled(false);
                ArrayList<PHIEUNHAP> phieunhaps = modelPN.selectAll();
                defaultTableModelPN.setRowCount(0);
                for (PHIEUNHAP phieunhap : phieunhaps) {
                    defaultTableModelPN.addRow(new Object[]{phieunhap.getMaPN(),phieunhap.getMaNV(),phieunhap.getMaNCC(),phieunhap.getTrangThai(),phieunhap.getTongTien(),phieunhap.getNgayNhap()});

                }
                loadTongtienDanhap();
                break;
            case "btnTimkiemPN":
                handleBtnTimkiemPN();
                break;
            case "btnTimkiemCTPN":
                handleBtnTimkiemCTPN();
                break;
            case "btnMaNVPN":
                handleBtnMaNV();
                break;
            case "btnMaSach":
                handleBtnMaSach();
                break;
            case "btnTKMaNV":
                handleBtnTkMaNV();
                break;                
            case "btnTKMaSach":
                handleBtnTKMaSach();
                break;  
            case "rdbBinhthuong":
                handleBtnrdbBinhthuong();
                break; 
            case "rdbKhoa":
                handleBtnrdbKhoa();
                break; 
            default:
                break;    
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e){
        if(!e.getValueIsAdjusting()&&e.getSource()==view.getTbPN().getSelectionModel()){
            int index = view.getTbPN().getSelectedRow();
            if(index!=-1){
                view.getBtnSua().setEnabled(true);
                view.getBtnXoa().setEnabled(true);
                view.getTxtMaPN().setText(defaultTableModelPN.getValueAt(index, 0).toString());
                view.getTxtMaNV().setText(defaultTableModelPN.getValueAt(index, 1).toString());
                view.getCbNCC().setSelectedItem(defaultTableModelPN.getValueAt(index, 2).toString());
                if(Double.parseDouble(defaultTableModelPN.getValueAt(index, 3).toString()) == 1){
                    view.getRdbbinhthuong().setSelected(true);
                    view.getRdbkhoa().setSelected(false);
                }else if(Double.parseDouble(defaultTableModelPN.getValueAt(index, 3).toString())== 0){
                    view.getRdbkhoa().setSelected(true);
                    view.getRdbbinhthuong().setSelected(false);
                }
                view.getTxtTongtien().setText(defaultTableModelPN.getValueAt(index, 4).toString());
                try{
                    Date date = sdf.parse(defaultTableModelPN.getValueAt(index, 5).toString());
                    view.getJdcNgayNhap().setDate(date);
                }catch(ParseException ex){
                    ex.printStackTrace();
                }
                loadDataByMPN(defaultTableModelPN.getValueAt(index, 0).toString());
                clerPanel(view.getJPCTPN());
            }
        }
        if(!e.getValueIsAdjusting()&&e.getSource()==view.getTbCTPN().getSelectionModel()){
            int index = view.getTbCTPN().getSelectedRow();
            if(index!=-1){
                view.getBtnSuaCT().setEnabled(true);
                view.getBtnXoaCT().setEnabled(true);
                view.getTxtMaCTPN().setText(defaultTableModelCTPN.getValueAt(index, 0).toString());
                view.getCbMaPN().setSelectedItem(defaultTableModelCTPN.getValueAt(index, 1).toString());
                view.getTxtDongia().setText(defaultTableModelCTPN.getValueAt(index, 3).toString());
                view.getTxtSoluong().setText(defaultTableModelCTPN.getValueAt(index, 4).toString());
                view.getTxtThanhtien().setText(defaultTableModelCTPN.getValueAt(index, 5).toString());
                view.getTxtMaSach().setText(defaultTableModelCTPN.getValueAt(index, 2).toString());
            }
        }
       
    }
    public void loadData(){
        ArrayList<PHIEUNHAP> phieunhaps = modelPN.selectAll();
        ArrayList<CTPHIEUNHAP>ctphieunhaps = modelCTPN.selectAll();
        defaultTableModelPN.setRowCount(0);
        defaultTableModelCTPN.setRowCount(0);
        for (PHIEUNHAP phieunhap : phieunhaps) {
            defaultTableModelPN.addRow(new Object[]{phieunhap.getMaPN(),phieunhap.getMaNV(),phieunhap.getMaNCC(),phieunhap.getTrangThai(),phieunhap.getTongTien(),phieunhap.getNgayNhap()});
            view.getCbMaPN().addItem(phieunhap.getMaPN());
            tongtien+=phieunhap.getTongTien();
        }
        for (CTPHIEUNHAP ctphieunhap : ctphieunhaps) {
            defaultTableModelCTPN.addRow(new Object[]{ctphieunhap.getMaCTPN(),ctphieunhap.getMaPN(),ctphieunhap.getMaSach(),ctphieunhap.getDonGia(),ctphieunhap.getSoLuong(),ctphieunhap.getThanhTien()});
        }
        view.getTxtTongphieunhap().setText(String.valueOf(tongtien));
    }
    public void loadCombobox(){
        this.modelNCC = new NhaCCDAO();
        ArrayList<NCC> nccs = modelNCC.selectAll();
        for (NCC ncc : nccs){
            view.getCbNCC().addItem(ncc.getMaNCC());
        }
        
//        view.getCbNCC().setSelectedIndex(-1);
//        view.getCbTKNCC().setSelectedIndex(-1);
    }
    public void handleBtnMaNV(){
        this.dsNhanVien.setVisible(true);
        if(dsNhanVien.isCheck()){
            view.getTxtMaNV().setText(dsNhanVien.getText());
        }
        dsNhanVien.getTbNV().clearSelection();
    }
    public void handleBtnTkMaNV(){
        this.dsNhanVien.setVisible(true);
        if(dsNhanVien.isCheck()){
            view.getTxtTKMaNV().setText(dsNhanVien.getText());
        }
        dsNhanVien.getTbNV().clearSelection();
    }
    public void handleBtnMaSach(){
        this.dSanPham.setVisible(true);
        if(dSanPham.isCheck()){
           view.getTxtMaSach().setText(dSanPham.getMaSach());
        }
        dSanPham.getTbSach().clearSelection();
        
    }
    public void  handleBtnTKMaSach(){
        this.dSanPham.setVisible(true);
        if(dSanPham.isCheck()){
           view.getTxtTKMaSach().setText(dSanPham.getMaSach());
        } 
        dSanPham.getTbSach().clearSelection();
    }
    public void clerPanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof  JComboBox){
                ((JComboBox) compoent).setSelectedIndex(-1);
            }else if(compoent instanceof JDateChooser){
                ((JDateChooser) compoent).setDate(null);
            }else if(compoent instanceof JRadioButton){
                ((JRadioButton) compoent).setSelected(false);
            }
        }
    }
    public void handleBtnrdbKhoa(){
        if(view.getRdbkhoa().isSelected()){
            view.getRdbbinhthuong().setSelected(false);
        }
    }
    public void handleBtnrdbBinhthuong(){
        if(view.getRdbbinhthuong().isSelected()){
            view.getRdbkhoa().setSelected(false);
        }
    }
    public void handleBtnTimkiemPN(){
        String MaPN = view.getTxtTKPN().getText();
        String MaNCC = view.getTxtMaNCC().getText();
        System.out.println(MaNCC);
        String MaNV = view.getTxtTKMaNV().getText();
        String khoangtientu = view.getTxtKhoangtientu().getText();
        String khoangtienden = view.getTxtKhoangtienden().getText();
        Date time1 = view.getJdcthoigiantu().getDate();
        Date time2 = view.getJdcthoigianden().getDate();
        ArrayList<PHIEUNHAP>phieunhaps = modelPN.searchPN(MaPN,MaNV,MaNCC, khoangtientu, khoangtienden, time1, time2);
        defaultTableModelPN.setRowCount(0);
        for (PHIEUNHAP phieunhap : phieunhaps) {
            defaultTableModelPN.addRow(new Object[]{phieunhap.getMaPN(),phieunhap.getMaNV(),phieunhap.getMaNCC(),phieunhap.getTrangThai(),phieunhap.getTongTien(),phieunhap.getNgayNhap()});  
        }
    }
    public void handleBtnTimkiemCTPN(){
        String MaCTPN = view.getTxtTKCTPN().getText();
        String MaSach = view.getTxtTKMaSach().getText();
        String dongiatu = view.getTxtTKDongiatu().getText();
        String dongiaden = view.getTxtTKDongiaden().getText();
        String tongtientu = view.getTxtTKKhoangtongtientu().getText();
        String tongtienden = view.getTxtTimkiemkhoangtongtienden().getText();
        ArrayList<CTPHIEUNHAP> ctphieunhaps = modelCTPN.searchCTPN(MaCTPN, MaSach, dongiatu, dongiaden, tongtientu, tongtienden);
        defaultTableModelCTPN.setRowCount(0);
        for (CTPHIEUNHAP ctphieunhap : ctphieunhaps) {
            defaultTableModelCTPN.addRow(new Object[]{ctphieunhap.getMaCTPN(),ctphieunhap.getMaPN(),ctphieunhap.getMaSach(),ctphieunhap.getDonGia(),ctphieunhap.getSoLuong(),ctphieunhap.getThanhTien()});    
        }
    }
    public void handleThemPN(){
        String MaPN = view.getTxtMaPN().getText();
        String MaNV = view.getTxtMaNV().getText();
        String MaNCC = view.getCbNCC().getSelectedItem().toString();
        int Trangthai = 0;
        if(view.getRdbbinhthuong().isSelected()){
            Trangthai = 1;
        }else if(view.getRdbkhoa().isSelected()){
            Trangthai = 0;
        }
        double tongtien = 0.0;
        Date NgayNhap =view.getJdcNgayNhap().getDate();
        java.sql.Date date = new java.sql.Date(NgayNhap.getTime());
        if(MaPN!=null&&!MaPN.isEmpty()&&!MaNV.isEmpty()&&MaNV!=null && MaNCC!=null && !MaNCC.isEmpty()&&date!=null){
            int resultSet = modelPN.insertPN(MaPN, MaNV, MaNCC, Trangthai, tongtien, date);
            if(resultSet !=0){
                defaultTableModelPN.addRow(new Object[]{MaPN,MaNV,MaNCC,Trangthai,tongtien,date.toString()});
                JOptionPane.showMessageDialog(null,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                clerPanel(view.getJPhieuNhap());
            }else{
                JOptionPane.showMessageDialog(null,"Không thể thêm","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleSuaPN(){
        int index = view.getTbPN().getSelectedRow();
        String MaPN = view.getTxtMaPN().getText();
        String MaNV = view.getTxtMaNV().getText();
        String MaNCC = view.getCbNCC().getSelectedItem().toString();
        int Trangthai = 0;
        if(view.getRdbbinhthuong().isSelected()){
            Trangthai = 1;
        }else if(view.getRdbkhoa().isSelected()){
            Trangthai = 0;
        }
        double tongtien = 0.0;
        Date NgayNhap = view.getJdcNgayNhap().getDate();
        java.sql.Date date = new java.sql.Date(NgayNhap.getTime());
        if(MaPN.equals(defaultTableModelPN.getValueAt(index, 0))){
            int resultSet = modelPN.updatePN(MaPN, MaNV, MaNCC, Trangthai, tongtien, date);
            if(resultSet !=0){
                defaultTableModelPN.removeRow(index);
                defaultTableModelPN.insertRow(index, new Object[]{MaPN, MaNV, MaNCC, Trangthai, tongtien, date.toString()});
                JOptionPane.showMessageDialog(null,"Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                clerPanel(view.getJPhieuNhap());
                view.getBtnSua().setEnabled(false);
                view.getBtnXoa().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"Không thể sửa","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleXoaPN(){
        int index = view.getTbPN().getSelectedRow();
        String MaPN = view.getTxtMaPN().getText();
        if(MaPN.equals(defaultTableModelPN.getValueAt(index, 0))){
            int resultSet = modelPN.deletePN(MaPN);
            if(resultSet !=0){
                defaultTableModelPN.removeRow(index);
                JOptionPane.showMessageDialog(null,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                clerPanel(view.getJPhieuNhap());
                view.getBtnSua().setEnabled(false);
                view.getBtnXoa().setEnabled(false);
            }else{
                 JOptionPane.showMessageDialog(null,"Không thể xóa","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            } 
        } 
    }
    public void handleThemMaCTPN(){
        int index = view.getTbPN().getSelectedRow();
        String MaCTPN = MaCTPN();
        String MaPN = view.getCbMaPN().getSelectedItem().toString();
        String MaSach = view.getTxtMaSach().getText();
        double Dongia = Double.parseDouble(view.getTxtDongia().getText());
        int soluong = Integer.parseInt(view.getTxtSoluong().getText());
        if(MaCTPN!=null&&!MaCTPN.isEmpty()&&MaPN!=null&&!MaPN.isEmpty()&&MaSach!=null&&!MaSach.isEmpty()&&view.getTxtDongia().getText()!=null&&!view.getTxtDongia().getText().isEmpty()&&view.getTxtSoluong().getText()!=null && !view.getTxtSoluong().getText().isEmpty()){
            double thanhtien = soluong * Dongia;
            int resultSet = modelCTPN.insertCTPN(MaCTPN, MaPN, MaSach, Dongia, soluong, thanhtien);
            if(resultSet!=0){
                defaultTableModelCTPN.addRow(new Object[]{MaCTPN, MaPN, MaSach, Dongia, soluong, thanhtien});
                int resultSet1 = modelPN.updatePN(MaPN,thanhtien);
                if(resultSet1!=0){
                    defaultTableModelPN.setValueAt(thanhtien, index, 4);
                    JOptionPane.showMessageDialog(null,"Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    clerPanel(view.getJPCTPN());
                }
            }else{
                JOptionPane.showMessageDialog(null,"không thể thêm!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
            loadTongtienDanhap();
        }
        
    }
    public void handleSuaCTPN(){
        int index1 = view.getTbCTPN().getSelectedRow();
        int index2 = view.getTbPN().getSelectedRow();
        String MaCTPN = view.getTxtMaCTPN().getText();
        String MaPN = view.getCbMaPN().getSelectedItem().toString();
        String MaSach = view.getTxtMaSach().getText();
        double Dongia = Double.parseDouble(view.getTxtDongia().getText());
        int soluong = Integer.parseInt(view.getTxtSoluong().getText());
        if(MaCTPN.equals(defaultTableModelCTPN.getValueAt(index1, 0))){
            double thanhtien = soluong * Dongia;
            double Tongtien = Double.parseDouble(defaultTableModelPN.getValueAt(index2, 4).toString());
            double tongtienms =Math.abs(Tongtien - thanhtien);
            int resultSet = modelCTPN.updateCTPN(MaCTPN, MaPN, MaSach, Dongia, soluong, thanhtien);
            if(resultSet!=0){
                defaultTableModelCTPN.removeRow(index1);
                defaultTableModelCTPN.insertRow(index1, new Object[]{MaCTPN, MaPN, MaSach, Dongia, soluong, thanhtien});
                int resultSet1 = modelPN.updatePN(MaPN,tongtienms);
                if(resultSet1!=0){
                     defaultTableModelPN.setValueAt(tongtienms, index2, 4);
                    JOptionPane.showMessageDialog(null,"Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    clerPanel(view.getJPCTPN());
                }
                view.getBtnSuaCT().setEnabled(false);
                view.getBtnXoaCT().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"không thể thêm!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
            loadTongtienDanhap();
        }
    }
    public void handleXoaCTPN(){
        int index1 = view.getTbCTPN().getSelectedRow();
        int index2 = view.getTbPN().getSelectedRow();
        String MaCTPN = view.getTxtMaCTPN().getText();
        String MaPN = view.getCbMaPN().getSelectedItem().toString();
        String MaSach = view.getTxtMaSach().getText();
        double Dongia = Double.parseDouble(view.getTxtDongia().getText());
        int soluong = Integer.parseInt(view.getTxtSoluong().getText());
        if(MaCTPN.equals(defaultTableModelCTPN.getValueAt(index1, 0))){
            double thanhtien = soluong * Dongia;
            double Tongtien = Double.parseDouble(defaultTableModelPN.getValueAt(index2, 4).toString());
            double tongtienms =Math.abs(Tongtien - thanhtien);
            int resultSet = modelCTPN.deleteCTPN(MaCTPN);
            if(resultSet!=0){
                defaultTableModelCTPN.removeRow(index1);
                int resultSet1 = modelPN.updatePN(MaPN,tongtienms);
                if(resultSet1!=0){
                     defaultTableModelPN.setValueAt(tongtienms, index2, 4);
                    JOptionPane.showMessageDialog(null,"Xóa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    clerPanel(view.getJPCTPN());
                }
                view.getBtnSuaCT().setEnabled(false);
                view.getBtnXoaCT().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"không thể xóa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
            loadTongtienDanhap();
        }
    }
    public void loadDataByMPN(String MaPN){
        ArrayList<CTPHIEUNHAP> phieunhaps = modelPN.select_by_MaPN(MaPN);
        defaultTableModelCTPN.setRowCount(0);
        for (CTPHIEUNHAP ctphieunhap : phieunhaps) {
            defaultTableModelCTPN.addRow(new Object[]{ctphieunhap.getMaCTPN(),ctphieunhap.getMaPN(),ctphieunhap.getMaSach(),ctphieunhap.getDonGia(),ctphieunhap.getSoLuong(),ctphieunhap.getThanhTien()});
        }
    }
    public String MaCTPN(){
        int count = modelCTPN.countCTPN();
        String MaCTPN = null;
        if(count<10){
            MaCTPN = "CTPN00" + count;
        }else if(count>=10){
            MaCTPN = "CTPN0"+count;
        }
        return MaCTPN;
    }
    public void loadTongtienDanhap(){
        for(int i =0;i<defaultTableModelCTPN.getRowCount();i++){
            tongtien += Double.parseDouble(defaultTableModelCTPN.getValueAt(i, 4).toString());
        }
        view.getTxtTongphieunhap().setText(String.valueOf(tongtien));
    }
}
