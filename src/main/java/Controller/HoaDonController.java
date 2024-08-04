/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CTGiamGiaDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import Model.CTGIAMGIA;
import Model.CTHOADON;
import Model.HOADON;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Dialog.DSuaCTHD;
import view.Dialog.DThemCTHD;
import view.Dialog.DsGiamGia;
import view.Dialog.DsKhachHang;
import view.Dialog.DsNhanVien;
import view.Panel.JPHoaDon_CTHoaDon;

/**
 *
 * @author Nguyen Khanh
 */
public class HoaDonController implements ActionListener,ListSelectionListener{
    private JPHoaDon_CTHoaDon view = null;
    private HoaDonDAO modelHD = null;
    private ChiTietHoaDonDAO modelCTHD = null;
    private DefaultTableModel defaultTableModelHD = null;
    private DefaultTableModel defaultTableModelCTHD = null;
    private SimpleDateFormat sdf =null;
    private int resultSet = 0;
    private Date NgayLap = null;
    private DsKhachHang dsKhachHang = null;
    private DsNhanVien dsNhanVien = null;
    private DsGiamGia dsGiamGia = null;
    private DSuaCTHD dSuaCTHD = null;
    private DThemCTHD dThemCTHD = null;
    private CTGiamGiaDAO modelCTGG = null;
    private int index = -1;
    private double tongtiencachoadon = 0.0;
    private double tongtienchitiethoadon = 0.0;

    public HoaDonController(JPHoaDon_CTHoaDon jPHoaDon_CTHoaDon) {
        this.view = jPHoaDon_CTHoaDon;
        modelCTHD = new ChiTietHoaDonDAO();
        modelHD = new HoaDonDAO();
        
        this.view.getTbHD().getSelectionModel().addListSelectionListener(this);
        this.view.getTbCTHD().getSelectionModel().addListSelectionListener(this);
        
        this.view.getBtnSua().addActionListener(this);
        this.view.getBtnXoa().addActionListener(this);
        this.view.getBtnXuat().addActionListener(this);
        this.view.getBtnLammoi().addActionListener(this);
        this.view.getBtnTimkiem().addActionListener(this);
        this.view.getBtnSuaCT().addActionListener(this);
        this.view.getBtnXoaCT().addActionListener(this);
        this.view.getBtnLoadCTHD().addActionListener(this); 
        this.view.getBtnMaKH().addActionListener(this);
        this.view.getBtnMaNV().addActionListener(this);
        this.view.getBtnThemCT().addActionListener(this);
        defaultTableModelHD = (DefaultTableModel) this.view.getTbHD().getModel();
        defaultTableModelCTHD = (DefaultTableModel) this.view.getTbCTHD().getModel();
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
        view.setDateFormatString();
        view.setActionCommand();
        
        
        loadData();
        
        this.dsGiamGia = new DsGiamGia(this.view.getfTrangChu1(),true);
        this.dsKhachHang = new DsKhachHang(this.view.getfTrangChu1(), true);
        this.dsNhanVien = new DsNhanVien(this.view.getfTrangChu1(), true);
        this.modelCTGG = new CTGiamGiaDAO();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "btnSua":
                handleSua();
                break;
            case "btnXoa":
                handleXoa();
                break;
            case "btnXuat":
                handleXuat();
                break;
            case "btnLammoi":
                handleLammoi();
                break;    
            case "btnTimkiem":
                handleTimkiem();
                break;
            case "btnLoadCTHD":
                handleLoadCTHDbyIndex(null);
                view.getTbHD().clearSelection();
                break;
            case "btnSuaCTHD":
                handleSuaCTHD();
                break;
            case "btnXoaCTHD":
                handleXoaCTHD();
                break;
            case "btnMaGG":
                handleBtnMaGG();
                break;
            case "btnMaKH":
                handleBtnMaKH();
                break;
            case "btnMaNV":
                handleBtnMaNV();
                break;
            case "btnThemCT":
                handleBtnThemCTHD();
                break;
            default:
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if((e.getSource()==view.getTbHD().getSelectionModel())&&!e.getValueIsAdjusting()){
            index = view.getTbHD().getSelectedRow();
            if(index!=-1){
                view.getBtnSua().setEnabled(true);
                view.getBtnXoa().setEnabled(true);
                view.getBtnSuaCT().setEnabled(true);
                view.getBtnThemCT().setEnabled(true);
                String MaHD = defaultTableModelHD.getValueAt(index, 0).toString();
                Object MaKH =  defaultTableModelHD.getValueAt(index, 1);
                Object MaGG = defaultTableModelHD.getValueAt(index, 3);
                if(MaGG!=null && MaKH!=null){
                    view.getTxtMaGG().setText(MaGG.toString());
                    view.getTxtMaKH().setText(MaKH.toString());
                }else{
                    view.getTxtMaKH().setText("");
                    view.getTxtMaGG().setText("");
                }
                view.getTxtMaHD().setText(MaHD);
                view.getTxtMaNV().setText(defaultTableModelHD.getValueAt(index, 2).toString());
                try{
                    NgayLap = sdf.parse(defaultTableModelHD.getValueAt(index, 4).toString());
                    view.getJdcNgayLap().setDate(NgayLap);
                }catch(ParseException p){
                    p.printStackTrace();
                }
                view.getTxtTongTien().setText(defaultTableModelHD.getValueAt(index, 5).toString());
                view.getTxtPhanTramGG().setText(defaultTableModelHD.getValueAt(index, 6).toString());
                view.getTxtThanhtien().setText(defaultTableModelHD.getValueAt(index, 7).toString());
                handleLoadCTHDbyIndex(MaHD);
                
                
                view.getTxtCTHD().setText(MaHD);
                view.getTxtTongSP().setText(String.valueOf(defaultTableModelCTHD.getRowCount()));
                view.getTxtTongtienHD().setText(defaultTableModelHD.getValueAt(index, 5).toString());
                
            }   
        }
        if((e.getSource()==view.getTbCTHD().getSelectionModel())&&!e.getValueIsAdjusting()){
            int index = view.getTbCTHD().getSelectedRow();
            if(index!=-1){
                view.getBtnXoaCT().setEnabled(true);
            }
        }
    }
    private void handleSua() {
        int index = view.getTbHD().getSelectedRow();
        if(index!=-1){
            String MaHD = view.getTxtMaHD().getText();
            String MaKH = view.getTxtMaKH().getText();
            String MaNV = view.getTxtMaNV().getText();
            String MaGG = view.getTxtMaGG().getText();
            NgayLap = view.getJdcNgayLap().getDate();
            Double Tongtien = Double.parseDouble(view.getTxtTongTien().getText());
            Double GiamGia = Double.parseDouble(view.getTxtPhanTramGG().getText());
            Double Thanhtien = Double.parseDouble(view.getTxtThanhtien().getText());
            MaKH = (MaKH == null || MaKH.trim().isEmpty()) ? null : MaKH;
            MaGG = (MaGG == null || MaGG.trim().isEmpty()) ? null : MaGG;
            java.sql.Date NgayLapDate  = new java.sql.Date(NgayLap.getTime());
            resultSet = modelHD.updateHD(MaHD, MaKH, MaNV, MaGG, NgayLapDate, Tongtien, GiamGia, Thanhtien);
            if(resultSet!=0){
                defaultTableModelHD.removeRow(index);
                defaultTableModelHD.insertRow(index,new Object[]{MaHD, MaKH, MaNV, MaGG, NgayLapDate, Tongtien, GiamGia, Thanhtien});
                clearJpanel(view.getjPQLHD());
                view.getBtnSua().setEnabled(false);
                view.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null,"Sửa thành công","thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Không thể sửa","thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void handleXoa() {
        String MaHD = view.getTxtMaHD().getText();
        int respone = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa!","Thông báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION&&defaultTableModelCTHD.getRowCount()==0){
            modelHD.deleteHD(MaHD);
            defaultTableModelHD.removeRow(index);
            clearJpanel(view.getjPQLHD());
            JOptionPane.showMessageDialog(null, "Xóa Thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "không thể xóa!","thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
        view.getBtnSua().setEnabled(false);
        view.getBtnXoa().setEnabled(false);
        for(int i =0;i<defaultTableModelHD.getRowCount();i++){
            tongtiencachoadon+=Double.parseDouble(defaultTableModelHD.getValueAt(i, 5).toString());
        }
        view.getTxtTongTienHD().setText(String.valueOf(tongtiencachoadon));  
        view.getTxtSoluonHD().setText(String.valueOf(defaultTableModelHD.getRowCount()));
    }

    private void handleXuat() {
       
    }

    private void handleTimkiem() {
        String MaHD = view.getTxtTKMaHD().getText();
        String MakH = view.getTxtTKMaKH().getText();
        String MaNV = view.getTxtTKMaNV().getText();
        String GiaTienTu = view.getTxtGiaTien1().getText();
        String Giatienden = view.getTxtGiaTien2().getText();
        Date thoigiantu = view.getJdcTime1().getDate();
        Date thoigianden = view.getJdcTime2().getDate();
        ArrayList<HOADON> hoadons = modelHD.searchHD(MaHD,MakH,MaNV,thoigiantu,thoigianden,GiaTienTu,Giatienden);
        defaultTableModelHD.setRowCount(0);
        for (HOADON hoadon : hoadons) {
            defaultTableModelHD.addRow(new Object[]{hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaNV(),hoadon.getMaGG(),hoadon.getNgayLapDate().toString(),hoadon.getTongTien(),hoadon.getGiamGia(),hoadon.getThanhTien()});
        } 
    }


    private void handleSuaCTHD() {
        String MaHD = defaultTableModelHD.getValueAt(index, 0).toString();
        ArrayList<CTHOADON> list = modelCTHD.select_CTHD_byMaHD(MaHD);
        this.dSuaCTHD = new DSuaCTHD(this.view.getfTrangChu1(),true,list);
        dSuaCTHD.setVisible(true);
        if(!dSuaCTHD.getCheck()){
            defaultTableModelCTHD.setRowCount(0);
            ArrayList<CTHOADON> list1 = dSuaCTHD.getiList();
            for (CTHOADON cthoadon : list1) {
                modelCTHD.updateCTHOADON(cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien());
                defaultTableModelCTHD.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
            }
            Double Tongtien = dSuaCTHD.getTongtien();
            Double GiamGia = dSuaCTHD.getGiamgia();
            Double Thanhtien = dSuaCTHD.getThanhtien();
            defaultTableModelHD.setValueAt(Tongtien, index, 5);
            defaultTableModelHD.setValueAt(GiamGia, index, 6);
            defaultTableModelHD.setValueAt(Thanhtien, index, 7);
            String MaKH = view.getTxtMaKH().getText();
            String MaNV = view.getTxtMaNV().getText();
            String MaGG = view.getTxtMaGG().getText();
            NgayLap = view.getJdcNgayLap().getDate();
            java.sql.Date NgayLapDate  = new java.sql.Date(NgayLap.getTime());
            MaKH = (MaKH == null || MaKH.trim().isEmpty()) ? null : MaKH;
            MaGG = (MaGG == null || MaGG.trim().isEmpty()) ? null : MaGG;
            modelHD.updateHD(MaHD, MaKH, MaNV,MaGG,NgayLapDate,Tongtien,GiamGia,Thanhtien);
            for(int i =0;i<defaultTableModelHD.getRowCount();i++){
                tongtiencachoadon+=Double.parseDouble(defaultTableModelHD.getValueAt(i, 5).toString());
            }
            view.getTxtTongTienHD().setText(String.valueOf(tongtiencachoadon));
            view.getTxtTongtienHD().setText(String.valueOf(Tongtien));
            view.getTxtTongSP().setText(String.valueOf(defaultTableModelCTHD.getRowCount()));
        }
    }
    private void handleBtnThemCTHD(){
        String MaHD = defaultTableModelHD.getValueAt(index, 0).toString();
        ArrayList<CTHOADON> list = modelCTHD.select_CTHD_byMaHD(MaHD);
        String MaGG = view.getTxtMaGG().getText();
        MaGG = (MaGG == null || MaGG.trim().isEmpty()) ? null : MaGG;     
        String MaKH = view.getTxtMaKH().getText();
        String MaNV = view.getTxtMaNV().getText();
        NgayLap = view.getJdcNgayLap().getDate();
        java.sql.Date NgayLapDate  = new java.sql.Date(NgayLap.getTime());
        MaKH = (MaKH == null || MaKH.trim().isEmpty()) ? null : MaKH;        
        double PhantramGG =0.0;   
        if(MaGG!=null&&!MaGG.isEmpty()){
            LocalDate date = LocalDate.parse(defaultTableModelHD.getValueAt(index, 4).toString());
            LocalDate dateBD =LocalDate.parse(dsGiamGia.getDateFrist());
            LocalDate dateKT =LocalDate.parse(dsGiamGia.getDateLast());
            if(date.isEqual(dateBD)||date.isEqual(dateKT)||(date.isAfter(dateBD)&&date.isBefore(dateKT))){
                ArrayList<CTGIAMGIA> ctgiamgia  = modelCTGG.select_by_MaGG(MaGG);
                for (int i = 0; i < ctgiamgia.size(); i++) {
                    PhantramGG = ctgiamgia.get(i).getPhanTramGG();
                    break;
                }
            }
        }
        this.dThemCTHD = new DThemCTHD(this.view.getfTrangChu1(),true,list,PhantramGG,MaHD);
        dThemCTHD.setVisible(true);
        if(!dThemCTHD.getCheck()){
            ArrayList<CTHOADON> list1 = dThemCTHD.getiList();
            for (CTHOADON cthoadon : list1) {
                modelCTHD.insertCTHOADON(cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien());
                defaultTableModelCTHD.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
            }
            Double Tongtien = dThemCTHD.getTongtien();
            Double GiamGia = dThemCTHD.getGiamgia();
            Double Thanhtien = dThemCTHD.getThanhtien();
            defaultTableModelHD.setValueAt(Tongtien, index, 5);
            defaultTableModelHD.setValueAt(GiamGia, index, 6);
            defaultTableModelHD.setValueAt(Thanhtien, index, 7);
            modelHD.updateHD(MaHD, MaKH, MaNV,MaGG,NgayLapDate,Tongtien,GiamGia,Thanhtien);
        }
    }

    private void handleXoaCTHD() {
            int index = view.getTbCTHD().getSelectedRow();
            int index1 = view.getTbHD().getSelectedRow();
            int soluong = Integer.parseInt(defaultTableModelCTHD.getValueAt(index, 3).toString());
            Double dongia = Double.parseDouble(defaultTableModelCTHD.getValueAt(index, 4).toString());
            Double Tongtiencua1sp = soluong*dongia;
            Double GiamGiaSP = soluong*Double.parseDouble(defaultTableModelCTHD.getValueAt(index, 5).toString());
            Double Thanhtiencuasp = Double.parseDouble(defaultTableModelCTHD.getValueAt(index, 6).toString());
            String MaSach = defaultTableModelCTHD.getValueAt(index,1).toString();
            String MaHD = view.getTxtMaHD().getText();
            String MaKH = view.getTxtMaKH().getText();
            String MaNV = view.getTxtMaNV().getText();
            String MaGG = view.getTxtMaGG().getText();
            NgayLap = view.getJdcNgayLap().getDate();
            Double Tongtien = Double.parseDouble(defaultTableModelHD.getValueAt(index1, 5).toString());
            Double GiamGia = Double.parseDouble(defaultTableModelHD.getValueAt(index1, 6).toString());
            Double Thanhtien = Double.parseDouble(defaultTableModelHD.getValueAt(index1, 7).toString());
            MaKH = (MaKH == null || MaKH.trim().isEmpty()) ? null : MaKH;
            MaGG = (MaGG == null || MaGG.trim().isEmpty()) ? null : MaGG;
            java.sql.Date NgayLapDate  = new java.sql.Date(NgayLap.getTime());
           int respone = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa!","Thông báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
           if(respone==JOptionPane.OK_OPTION){
                double tongtien = Tongtien-Tongtiencua1sp;
                double giamgia =  GiamGia-GiamGiaSP;
                double thanhtien = Thanhtien-Thanhtiencuasp;
                modelCTHD.deleteCTHOADON(MaHD,MaSach);
                defaultTableModelCTHD.removeRow(index);
                modelHD.updateHD(MaHD, MaKH, MaNV, MaGG, NgayLapDate,Math.abs(tongtien),Math.abs(giamgia),Math.abs(thanhtien));
                defaultTableModelHD.setValueAt(Math.abs(tongtien), index1, 5);
                defaultTableModelHD.setValueAt(Math.abs(giamgia), index1, 6);
                defaultTableModelHD.setValueAt(Math.abs(thanhtien), index1, 7);
                JOptionPane.showMessageDialog(null, "Xóa Thành công!","thông báo",JOptionPane.INFORMATION_MESSAGE);
           }
           view.getBtnXoaCT().setEnabled(false);
    }
    public void handleBtnMaKH(){
        this.dsKhachHang.setVisible(true);
        if(dsKhachHang.getCheck()){
            view.getTxtMaKH().setText(dsKhachHang.getText());
        }
    }
    public void handleBtnMaNV(){
        this.dsNhanVien.setVisible(true);
        if(dsNhanVien.isCheck()){
            view.getTxtMaNV().setText(dsNhanVien.getText());
        }
    }
    public void handleBtnMaGG(){
        this.dsGiamGia.setVisible(true);
        if(!dsGiamGia.isCheck()){
            view.getTxtMaGG().setText(dsGiamGia.getText());
        }
    }    
    public void clearJpanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JDateChooser){
                ((JDateChooser) compoent).setDate(null);
            }
        }
    }  
    public void loadData(){
        ArrayList<HOADON> hoadons = modelHD.selectALL();
        ArrayList<CTHOADON> cthoadons = modelCTHD.selectAll();
        defaultTableModelCTHD.setRowCount(0);
        defaultTableModelHD.setRowCount(0);
        for (HOADON hoadon : hoadons) {
            defaultTableModelHD.addRow(new Object[]{hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaNV(),hoadon.getMaGG(),hoadon.getNgayLapDate().toString(),hoadon.getTongTien(),hoadon.getGiamGia(),hoadon.getThanhTien()}); 
            tongtiencachoadon+=hoadon.getTongTien();
        }
        for (CTHOADON cthoadon : cthoadons) {
            defaultTableModelCTHD.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
        }
        view.getTxtSoluonHD().setText(String.valueOf(defaultTableModelHD.getRowCount()));
        view.getTxtTongTienHD().setText(String.valueOf(tongtiencachoadon));
    }
    private void handleLoadCTHDbyIndex(String MaHD) {
        ArrayList<CTHOADON> cthoadons  = modelCTHD.select_CTHD_byMaHD(MaHD);
        defaultTableModelCTHD.setRowCount(0);
        for (CTHOADON cthoadon : cthoadons) {
            defaultTableModelCTHD.addRow(new Object[]{cthoadon.getMaHD(),cthoadon.getMaSach(),cthoadon.getTenSach(),cthoadon.getSoLuong(),cthoadon.getDonGia(),cthoadon.getGiamGia(),cthoadon.getThanhTien()});
        }
    }
    private void handleLammoi() {
       loadData();
       clearJpanel(view.getjPQLHD());
    }    
}
