/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CTGiamGiaDAO;
import DAO.GiamGiaDAO;
import Model.CTGIAMGIA;
import Model.GIAMGIA;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Dialog.DSanPham;
import view.Panel.JPGiamGia;

/**
 *
 * @author Nguyen Khanh
 */
public class GiamGiaController implements ActionListener,ListSelectionListener{
    private JPGiamGia viewGG = null;
    private GiamGiaDAO modelGG = null;
    private CTGiamGiaDAO modelCTGG = null;
    private DefaultTableModel defaultTableModelGG = null;
    private DefaultTableModel defaultTableModelCTGG = null;
    private int index =0;
    private SimpleDateFormat sdf =null;
    private Date dateBD = null;
    private Date dateKT = null;
    private int ResultSet = 0;
    private DSanPham dsSanPham = null;
    public GiamGiaController(JPGiamGia jPGiamGia) {
        this.viewGG = jPGiamGia;
        this.modelGG = new GiamGiaDAO();
        this.modelCTGG = new CTGiamGiaDAO();
        
        this.defaultTableModelCTGG = (DefaultTableModel) viewGG.getTbCTGG().getModel();
        this.defaultTableModelGG =(DefaultTableModel)viewGG.getTbGG().getModel();
        this.viewGG.getTbCTGG().getSelectionModel().addListSelectionListener(this);
        this.viewGG.getTbGG().getSelectionModel().addListSelectionListener(this);
        
        
        this.viewGG.getBtnThem().addActionListener(this);
        this.viewGG.getBtnXoa().addActionListener(this);
        this.viewGG.getBtnSua().addActionListener(this);
        this.viewGG.getBtnLamMoi().addActionListener(this);
        this.viewGG.getBtnTimKiem().addActionListener(this);
        this.viewGG.getBtnXoaPhanTramGG().addActionListener(this);
        this.viewGG.getBtnThemPhanTramGG().addActionListener(this);
        this.viewGG.getBtnhhidenSach().addActionListener(this);
        this.viewGG.setActioncommand();
        this.viewGG.getJdcNgayBD().setDateFormatString("yyyy-MM-dd");
        this.viewGG.getJdcNgayKT().setDateFormatString("yyyy-MM-dd");
        this.viewGG.getJdcNgayKTTimkiem().setDateFormatString("yyy-MM-dd");
        this.viewGG.getJdcTimKiemNgayBD().setDateFormatString("yyyy-MM-dd");
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dsSanPham = new DSanPham(this.viewGG.getfTrangChu(),true);
        loadData();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();  
        switch(command){
            case "btnThem":
                handleThem();
                break;
            case "btnSua":
                handleSua();
                break;
            case "btnXoa":
                handleXoa();
                break;
            case "btnLammoi":
                handleLammoi();
                break;
            case "btnTimkiem":
                handleTimkiem();
                break;
            case "btnThemPhanTramGG":
                handleThemPhanTramGG();
                break;
            case "btnXoaPhanTramGG":
                handleXoaPhanTramGG();
                break;
            case "btnhidenSach":
                handleHiddenSach();
                break;
            default: 
                break;
                
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource()==viewGG.getTbGG().getSelectionModel()&&!e.getValueIsAdjusting()){
            index = viewGG.getTbGG().getSelectedRow();
            if(index!=-1){
                viewGG.getBtnSua().setEnabled(true);
                viewGG.getBtnXoa().setEnabled(true);
                clearPanel(viewGG.getjPanel3());
                viewGG.getBtnXoaPhanTramGG().setEnabled(false);
                viewGG.getTxtMaGG().setText(defaultTableModelGG.getValueAt(index, 0).toString());
                viewGG.getTxtTenCT().setText(defaultTableModelGG.getValueAt(index, 1).toString());
                viewGG.getTxtLoaiCT().setText(defaultTableModelGG.getValueAt(index, 2).toString());
                try{
                    dateBD = sdf.parse(defaultTableModelGG.getValueAt(index, 3).toString());
                    dateKT = sdf.parse(defaultTableModelGG.getValueAt(index, 4).toString());
                    viewGG.getJdcNgayBD().setDate(dateBD);
                    viewGG.getJdcNgayKT().setDate(dateKT);
                }catch(ParseException ex){
                    ex.printStackTrace();
                }
                loadDataCTGGbyMaGG();
            }
        }
        if(e.getSource()==viewGG.getTbCTGG().getSelectionModel()&&!e.getValueIsAdjusting()){
            index = viewGG.getTbCTGG().getSelectedRow();
            if(index!=-1){
                viewGG.getBtnXoaPhanTramGG().setEnabled(true);
                viewGG.getTxtMaSach().setText(defaultTableModelCTGG.getValueAt(index, 1).toString());
                viewGG.getTxtCtPhanTramGG().setText(defaultTableModelCTGG.getValueAt(index, 2).toString());
            }
        }
    }
    public void loadData(){
        ArrayList<GIAMGIA> discounts = modelGG.selectAll();
        ArrayList<CTGIAMGIA> discountDetails = modelCTGG.selectAll();
        defaultTableModelCTGG.setRowCount(0);
        defaultTableModelGG.setRowCount(0);
        for (CTGIAMGIA discountDetail : discountDetails) {
            defaultTableModelCTGG.addRow(new Object[]{discountDetail.getMaGG(),discountDetail.getMaSach(),discountDetail.getPhanTramGG()});
        }
        for (GIAMGIA discount : discounts) {
            defaultTableModelGG.addRow(new Object[]{discount.getMaGG(),discount.getTenCT(),discount.getLoaiCT(),discount.getNgayBD(),discount.getNgayKT()});
        }
    }
    public void loadDataCTGGbyMaGG(){
        String MaGG = defaultTableModelGG.getValueAt(index, 0).toString();
        ArrayList<CTGIAMGIA> details = modelCTGG.select_by_MaGG(MaGG);
        defaultTableModelCTGG.setRowCount(0);
        for (CTGIAMGIA detail : details) {
            defaultTableModelCTGG.addRow(new Object[]{detail.getMaGG(),detail.getMaSach(),detail.getPhanTramGG()});
        }
    }
    public void handleThem(){
        String MaGG = viewGG.getTxtMaGG().getText().toString();
        String TenCT = viewGG.getTxtTenCT().getText().toString();
        String LoaiCT =viewGG.getTxtLoaiCT().getText().toString();
        Date dateBD = viewGG.getJdcNgayBD().getDate();
        Date dateKT =  viewGG.getJdcNgayKT().getDate();
        if(MaGG!=null&&TenCT!=null&&LoaiCT!=null&&dateBD!=null&&dateKT!=null){
            if(dateBD.after(dateKT)){
                java.sql.Date NgayBD = new java.sql.Date(dateBD.getTime());
                java.sql.Date NgayKT = new java.sql.Date(dateKT.getTime());
                ResultSet = modelGG.insertGG(MaGG, TenCT, LoaiCT, NgayBD, NgayKT);
                if(ResultSet!=0){
                    defaultTableModelGG.addRow(new Object[]{MaGG, TenCT, LoaiCT, NgayBD.toString(), NgayKT.toString()});
                    clearPanel(viewGG.getjPanel1());
                    viewGG.getBtnSua().setEnabled(false);
                    viewGG.getBtnXoa().setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm Không Thành Công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        }else{
             JOptionPane.showMessageDialog(null, "Thiếu dữ liệu!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    public void handleSua(){
        index = viewGG.getTbGG().getSelectedRow();
        if(index!=-1){
            String MaGG = viewGG.getTxtMaGG().getText().toString();
            String TenCT = viewGG.getTxtTenCT().getText().toString();
            String LoaiCT =viewGG.getTxtLoaiCT().getText().toString();
            java.sql.Date NgayBD = new java.sql.Date(dateBD.getTime());
            java.sql.Date NgayKT = new java.sql.Date(dateKT.getTime());
            ResultSet = modelGG.updateGG(MaGG, TenCT, LoaiCT, NgayBD, NgayKT);
            if(ResultSet!=0){
                defaultTableModelGG.removeRow(index);
                defaultTableModelGG.insertRow(index,new Object[]{MaGG, TenCT, LoaiCT, NgayBD.toString(), NgayKT.toString()});
                clearPanel(viewGG.getjPanel1());
                viewGG.getBtnSua().setEnabled(false);
                viewGG.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Sửa Thành Công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Không Thể Sửa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleXoa(){
        index = viewGG.getTbGG().getSelectedRow();
        if(index!=-1){
            String MaGG =  viewGG.getTxtMaGG().getText().toString();
            ResultSet = modelGG.deleteGG(MaGG);
            if(ResultSet!=0){
                defaultTableModelGG.removeRow(index);
                clearPanel(viewGG.getjPanel1());
                viewGG.getBtnSua().setEnabled(false);
                viewGG.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Xóa Thành Công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Không Thể Xóa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    public void handleTimkiem(){
        dateBD = viewGG.getJdcTimKiemNgayBD().getDate();
        dateKT = viewGG.getJdcNgayKTTimkiem().getDate();
        ArrayList<GIAMGIA> discounts = null;
        if(dateBD == null && dateKT == null){
            discounts = modelGG.getListDiscount(null,null);
        }else if(dateBD!=null && dateKT == null){
            discounts = modelGG.getListDiscount(dateBD,null);
        }else if(dateBD==null && dateKT!= null){
            discounts = modelGG.getListDiscount(null,dateKT);
        }else if(dateBD!=null && dateKT!= null){
            discounts = modelGG.getListDiscount(dateBD,dateKT);
        }
        if(discounts.size()>0){
          defaultTableModelGG.setRowCount(0);
            for(GIAMGIA discount : discounts){
                defaultTableModelGG.addRow(new Object[]{discount.getMaGG(),discount.getTenCT(),discount.getLoaiCT(),discount.getNgayBD().toString(),discount.getNgayKT().toString()});
            }   
        }
    }
    public void handleThemPhanTramGG(){
        index = viewGG.getTbGG().getSelectedRow();
        String MaGG = defaultTableModelGG.getValueAt(index, 0).toString();
        String MaSach = viewGG.getTxtMaSach().getText().toString();
        String PhanTram1 =viewGG.getTxtCtPhanTramGG().getText().toString();
        if(MaGG!=null&&!MaGG.isEmpty()&&MaSach!=null&&!MaSach.isEmpty()&&PhanTram1!=null&&!PhanTram1.isEmpty()){
            Double PhanTram =Double.parseDouble(PhanTram1);
            ResultSet = modelCTGG.insertCTGG(MaGG, MaSach, PhanTram);
            if(ResultSet!=0){
                clearPanel(viewGG.getjPanel3());
                viewGG.getBtnXoaPhanTramGG().setEnabled(false);
                JOptionPane.showMessageDialog(null,"Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Thêm thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleXoaPhanTramGG(){
        index = viewGG.getTbCTGG().getSelectedRow();
        String MaGG = defaultTableModelCTGG.getValueAt(index, 0).toString();
        String MaSach = defaultTableModelCTGG.getValueAt(index, 1).toString();
        ResultSet = modelCTGG.deleteCTGG(MaGG,MaSach);
        if(ResultSet!=0){
            viewGG.getBtnXoaPhanTramGG().setEnabled(false);
            clearPanel(viewGG.getjPanel3());
            defaultTableModelCTGG.removeRow(index);
            JOptionPane.showMessageDialog(null,"Xóa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Xóa thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void handleHiddenSach(){
        this.dsSanPham.setVisible(true);
        if(this.dsSanPham.isCheck()){
            viewGG.getTxtMaSach().setText(this.dsSanPham.getMaSach());
        }
        viewGG.getTbCTGG().clearSelection();
    }
    public void handleLammoi(){
        loadData();
        clearPanel(viewGG.getjPanel1());
    }
    public void clearPanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JDateChooser){
                ((JDateChooser) compoent).setDate(null);
            }
        }
    }
}
