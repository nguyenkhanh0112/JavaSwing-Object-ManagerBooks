/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CTGiamGiaDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.SachDAO;
import Model.CTGIAMGIA;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Dialog.DSanPham;
import view.Dialog.DsGiamGia;
import view.Dialog.DsKhachHang;
import view.Dialog.DsNhanVien;
import view.Frame.fTrangChu;
import view.Panel.JPBanHang;
/**
 *
 * @author Nguyen Khanh
 */
public class BanHangController implements ActionListener,ListSelectionListener{
    private HoaDonDAO modelHD = null;
    private JPBanHang viewBanHang = null;
    private DefaultTableModel defaultTableModel = null;
    private DsGiamGia dsGiamGia;
    private CTGiamGiaDAO modelCTGG = null;
    private DsKhachHang dsKhachHang = null;
    private DsNhanVien dsNhanVien = null;
    private DSanPham dsSanPham = null;
    private Image img =null;
    private String pathImageBook = "C:\\Users\\Nguyen Khanh\\OneDrive\\Documents\\NetBeansProjects\\BookStore1\\src\\main\\java\\img\\Book_img\\";
    private Double TongTienSP = 0.00;
    private Double ThanhTienSP = 0.00;
    private Double ThanhTienGiamGiaSP = 0.00;
    private LocalDate date = null;
    private LocalDate dateBD = null;
    private LocalDate dateKT = null;
    private Image image = null;
    private ImageIcon icon =null;
    private ChiTietHoaDonDAO modelCTHoaDon;
    public BanHangController(JPBanHang sell) {
        this.modelHD = new HoaDonDAO();
        this.modelCTHoaDon = new ChiTietHoaDonDAO();
        this.viewBanHang = sell;
        
        viewBanHang.getTbBanHang().getSelectionModel().addListSelectionListener(this);
        this.defaultTableModel = (DefaultTableModel) viewBanHang.getTbBanHang().getModel();
        
        this.viewBanHang.addActionListener(viewBanHang.getBtnTaoHoaDon(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnHuy(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnMaGG(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnMaKH(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnMaNV(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnSua(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnThem(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnXacNhan(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnXoa(), this);
        this.viewBanHang.addActionListener(viewBanHang.getBtnMaSach(), this);
        
        loadDiaglog();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();  
        switch(command){
            case "TẠO HÓA ĐƠN":
                handleTaoHoaDon();
                break;
            case "Thêm":
                handleThem();
                break;
            case "Xác nhận":
                handleXacNhan();
                this.dsGiamGia.loadData();
                this.dsKhachHang.loadData();
                this.dsNhanVien.loadData();
                break;
            case "Hủy":
                handleHuy();
                break;
            case "Sửa":
                handleSua();
                break;
            case "Xóa":
                handleXoa();
                break;
            case "btnMaGG":
                viewBanHang.getTbBanHang().clearSelection();
                handleBtnMaGG();
                break;
            case "btnMaNV":
                viewBanHang.getTbBanHang().clearSelection();                
                handleBtnMaNV();
                break;
            case "btnMaKH":
                viewBanHang.getTbBanHang().clearSelection();
                handleBtnMaKH();
                break;
            case "btnMaSach":
                viewBanHang.getTbBanHang().clearSelection();
                this.dsSanPham.setVisible(true);
                handleBtnMaSach();
                break;
            default: 
                break;
                
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource()==viewBanHang.getTbBanHang().getSelectionModel()){
            if(!e.getValueIsAdjusting()){
                int selectRow = viewBanHang.getTbBanHang().getSelectedRow();
                if(selectRow!=-1){
                    viewBanHang.getBtnSua().setEnabled(true);
                    viewBanHang.getBtnXoa().setEnabled(true);
                    viewBanHang.getTxtMaSach().setText(defaultTableModel.getValueAt(selectRow, 0).toString());
                    viewBanHang.getTxtTenSach().setText(defaultTableModel.getValueAt(selectRow,1).toString());
                    viewBanHang.getTxtSoLuong().setText(defaultTableModel.getValueAt(selectRow, 2).toString());
                    viewBanHang.getTxtDonGia().setText(defaultTableModel.getValueAt(selectRow, 3).toString());
                    try {
                        String nameAnh = dsSanPham.getTextAnh(defaultTableModel.getValueAt(selectRow, 0).toString());
                        String pathImage = pathImageBook + nameAnh;
                        img = ImageIO.read(new File(pathImage));
                        if(img!=null){
                            image = img.getScaledInstance(250,150, Image.SCALE_SMOOTH);   
                            icon = new ImageIcon(image);
                            viewBanHang.getTxtLinkanh().setIcon(icon);
                            viewBanHang.getTxtLinkanh().setText(nameAnh);
                        }
                    } catch(IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
    public void handleTaoHoaDon(){
       if(viewBanHang.getTxtMaNV().getText()==null || viewBanHang.getTxtMaNV().getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Hãy chọn Nhân viên Cần thanh toán!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
       }else{
            int count = modelHD.countNumbers();
            if(count<9){
                viewBanHang.getTxtMaHD().setText("HD00"+String.valueOf(count++));
            }else{
                viewBanHang.getTxtMaHD().setText("HD0"+String.valueOf(count++));
            }
            viewBanHang.showPanel();
            viewBanHang.getTxtNgayLap().setText(getFormatDate());
            viewBanHang.getBtnMaKH().setEnabled(false);
            viewBanHang.getBtnMaGG().setEnabled(false);
       }
    }
    public void handleThem(){
        String MaSach = viewBanHang.getTxtMaSach().getText().toString();
        String TenSach = viewBanHang.getTxtTenSach().getText().toString();
        double DonGia = Double.parseDouble(viewBanHang.getTxtDonGia().getText().toString());
        String MaGG = viewBanHang.getTxtMaGG().getText().toString();
        if(check(viewBanHang.getTxtSoLuong().getText().toString())){
            int SoLuong = Integer.parseInt(viewBanHang.getTxtSoLuong().getText().toString());
            if(MaGG!=null&&!MaGG.isEmpty()){
                date = LocalDate.parse(viewBanHang.getTxtNgayLap().getText());
                dateBD =LocalDate.parse(dsGiamGia.getDateFrist());
                dateKT =LocalDate.parse(dsGiamGia.getDateLast());
                if(date.isEqual(dateBD)||date.isEqual(dateKT)||(date.isAfter(dateBD)&&date.isBefore(dateKT))){
                    CTGIAMGIA ctgg = modelCTGG.getPhanTramGG(MaGG, MaSach);
                    Double PhanTramGG = ctgg.getPhanTramGG()/100;
                    ThanhTienSP += (SoLuong * DonGia) - PhanTramGG*(SoLuong*DonGia);
                    TongTienSP += SoLuong * DonGia;
                    ThanhTienGiamGiaSP +=PhanTramGG*(SoLuong*DonGia);
                    defaultTableModel.addRow(new Object[]{MaSach,TenSach,SoLuong,DonGia,PhanTramGG,((SoLuong * DonGia) - PhanTramGG*(SoLuong*DonGia))});
                }
            }else{
                Double PhanTramGG = 0.0;
                ThanhTienSP += SoLuong * DonGia;
                TongTienSP += SoLuong* DonGia;
                ThanhTienGiamGiaSP +=PhanTramGG*(SoLuong*DonGia);
                defaultTableModel.addRow(new Object[]{MaSach,TenSach,SoLuong,DonGia,PhanTramGG,(SoLuong*DonGia)});
            }  
            viewBanHang.getTxtThanhTien().setText(String.valueOf(ThanhTienSP));
            viewBanHang.getTxtTongTien().setText(String.valueOf(TongTienSP));
            viewBanHang.getTxtGiamGia().setText(String.valueOf(ThanhTienGiamGiaSP));
        }else{
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ!","Thông Báo",JOptionPane.INFORMATION_MESSAGE);
        } 
    }
    public void handleXacNhan(){ 
        try{
            String MaHD = viewBanHang.getTxtMaHD().getText().toString();
            String MaKH = viewBanHang.getTxtMaKH().getText().toString();
            String MaNV = viewBanHang.getTxtMaNV().getText().toString();
            String MaGG = viewBanHang.getTxtMaGG().getText().toString();
            
            MaKH = (MaKH == null || MaKH.trim().isEmpty()) ? null : MaKH;
            MaGG = (MaGG == null || MaGG.trim().isEmpty()) ? null : MaGG;

            double TongTienSP1 = Double.parseDouble(viewBanHang.getTxtTongTien().getText().toString());
            double TienGG = Double.parseDouble(viewBanHang.getTxtGiamGia().getText().toString());
            double ThanhTien1 = Double.parseDouble(viewBanHang.getTxtThanhTien().getText().toString());
            

            String NgayLap = viewBanHang.getTxtNgayLap().getText().toString();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(NgayLap);
            java.sql.Date SqlDate = new java.sql.Date(utilDate.getTime());

            if (MaKH != null) {
                double TongChi = dsKhachHang.getTongChi() + TongTienSP;
                dsKhachHang.ThemTongChi(MaKH, TongChi);
            }
            int resultSetHD = modelHD.insertHD(MaHD, MaKH, MaNV, MaGG, SqlDate, TongTienSP1, TienGG, ThanhTien1);
            if (resultSetHD != 0) {
                for (int i = 0; i < defaultTableModel.getRowCount(); i++) { 
                    String MaSach = defaultTableModel.getValueAt(i, 0).toString();
                    String TenSach = defaultTableModel.getValueAt(i, 1).toString();
                    int soluong = Integer.parseInt(defaultTableModel.getValueAt(i, 2).toString());
                    double DonGia = Double.parseDouble(defaultTableModel.getValueAt(i, 3).toString());
                    double GiamGia = Double.parseDouble(defaultTableModel.getValueAt(i, 4).toString())*DonGia;
                    double ThanhTien = Double.parseDouble(defaultTableModel.getValueAt(i, 5).toString());
                    int resultSetCTHD = modelCTHoaDon.insertCTHOADON(MaHD, MaSach, TenSach, soluong, DonGia, GiamGia, ThanhTien);
                }
                JOptionPane.showMessageDialog(null, "Tạo Thành Công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            for(Component compoent : viewBanHang.getPanel().getComponents()){
                if(compoent instanceof JTextField){
                    ((JTextField) compoent).setText("");
                }
            }
            for(Component compoent : viewBanHang.getPaneTaoHoaDon().getComponents()){
                if(compoent instanceof JTextField){
                    ((JTextField) compoent).setText("");
                }else if(compoent instanceof  JLabel){
                    viewBanHang.getTxtLinkanh().setText("null");
                    viewBanHang.getTxtLinkanh().setIcon(null);
                }else if(compoent instanceof JScrollPane){
                    defaultTableModel.setRowCount(0);
                }
            }
            viewBanHang.hiddenPanel();
            ThanhTienSP = 0.00;
            TongTienSP = 0.00;
            ThanhTienGiamGiaSP =0.00;
            viewBanHang.getTxtThanhTien().setText(String.valueOf(ThanhTienSP));
            viewBanHang.getTxtTongTien().setText(String.valueOf(TongTienSP));
            viewBanHang.getTxtGiamGia().setText(String.valueOf(ThanhTienGiamGiaSP));
            }else{
                JOptionPane.showMessageDialog(null,"Tạo Thất Bại!","Thông Báo",JOptionPane.INFORMATION_MESSAGE);
            } 
        }catch(ParseException e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void handleHuy(){
        int respone = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa!","Thông báo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone ==JOptionPane.YES_OPTION){
            for(Component compoent : viewBanHang.getPanel().getComponents()){
                if(compoent instanceof JTextField){
                    ((JTextField) compoent).setText("");
                }
            }
            for(Component compoent : viewBanHang.getPaneTaoHoaDon().getComponents()){
                if(compoent instanceof JTextField){
                    ((JTextField) compoent).setText("");
                }else if(compoent instanceof  JLabel){
                    viewBanHang.getTxtLinkanh().setText("null");
                    viewBanHang.getTxtLinkanh().setIcon(null);
                }else if(compoent instanceof JScrollPane){
                    defaultTableModel.setRowCount(0);
                }
            }
            viewBanHang.hiddenPanel();
            ThanhTienSP = 0.00;
            TongTienSP = 0.00;
            ThanhTienGiamGiaSP =0.00;
            viewBanHang.getTxtThanhTien().setText(String.valueOf(ThanhTienSP));
            viewBanHang.getTxtTongTien().setText(String.valueOf(TongTienSP));
            viewBanHang.getTxtGiamGia().setText(String.valueOf(ThanhTienGiamGiaSP)); 
            viewBanHang.getBtnMaKH().setEnabled(true);
            viewBanHang.getBtnMaGG().setEnabled(true);
        }
    }
    public void handleSua(){
        int index = viewBanHang.getTbBanHang().getSelectedRow();
        if(index !=-1){
            double temp =Double.parseDouble(defaultTableModel.getValueAt(index, 4).toString());
            handleThanhTienSP(index, temp);
            String MaSach = viewBanHang.getTxtMaSach().getText().toString();
            String TenSach = viewBanHang.getTxtTenSach().getText().toString();
            int SoLuong = Integer.parseInt(viewBanHang.getTxtSoLuong().getText().toString());
            double DonGia = Double.parseDouble(viewBanHang.getTxtDonGia().getText().toString());
            if(temp>0){
            Double PhanTramGG = temp/100;
            ThanhTienSP += (SoLuong * DonGia) - PhanTramGG*(SoLuong*DonGia);
            TongTienSP += SoLuong * DonGia;
            ThanhTienGiamGiaSP +=PhanTramGG*(SoLuong*DonGia);
            defaultTableModel.removeRow(index);
            defaultTableModel.insertRow(index, new Object[]{MaSach,TenSach,SoLuong,DonGia,PhanTramGG,(SoLuong*DonGia)});
            }else if(temp == 0){
                Double PhanTramGG = temp;
                ThanhTienSP += SoLuong * DonGia;
                TongTienSP += SoLuong* DonGia;
                ThanhTienGiamGiaSP +=PhanTramGG*(SoLuong*DonGia);
                defaultTableModel.removeRow(index);
                defaultTableModel.insertRow(index, new Object[]{MaSach,TenSach,SoLuong,DonGia,PhanTramGG,(SoLuong*DonGia)});
            }
        viewBanHang.getTxtThanhTien().setText(String.valueOf(ThanhTienSP));
        viewBanHang.getTxtTongTien().setText(String.valueOf(TongTienSP));
        viewBanHang.getTxtGiamGia().setText(String.valueOf(ThanhTienGiamGiaSP)); 
        viewBanHang.getBtnSua().setEnabled(false);
        viewBanHang.getBtnXoa().setEnabled(false);
        viewBanHang.getTbBanHang().clearSelection();
        }
    }
    public void handleXoa(){    
        int index = viewBanHang.getTbBanHang().getSelectedRow();
        if(index!=-1){
            double PhanTramGG =Double.parseDouble(defaultTableModel.getValueAt(index, 4).toString())/100;
            handleThanhTienSP(index, PhanTramGG);
            defaultTableModel.removeRow(index);
            viewBanHang.getTxtThanhTien().setText(String.valueOf(ThanhTienSP));
            viewBanHang.getTxtTongTien().setText(String.valueOf(TongTienSP));
            viewBanHang.getTxtGiamGia().setText(String.valueOf(ThanhTienGiamGiaSP));
            viewBanHang.getTxtMaSach().setText("");
            viewBanHang.getTxtSoLuong().setText("");
            viewBanHang.getTxtTenSach().setText("");
            viewBanHang.getTxtDonGia().setText("");
            viewBanHang.getTxtLinkanh().setText("null");
            viewBanHang.getTxtLinkanh().setIcon(null);
            viewBanHang.getBtnSua().setEnabled(false);
            viewBanHang.getBtnXoa().setEnabled(false);
            viewBanHang.getTbBanHang().clearSelection();
        }
    }
    public void handleBtnMaGG(){
        this.dsGiamGia.setVisible(true);
        if(dsGiamGia.isCheck()){
            viewBanHang.getTxtMaGG().setText(dsGiamGia.getText());
        }
    }
    public void handleBtnMaKH(){
        this.dsKhachHang.setVisible(true);
        if(dsKhachHang.getCheck()){
            viewBanHang.getTxtMaKH().setText(dsKhachHang.getText());
        }
    }
    public void handleBtnMaNV(){
        this.dsNhanVien.setVisible(true);
        if(dsNhanVien.isCheck()){
            viewBanHang.getTxtMaNV().setText(dsNhanVien.getText());
        }
    }
    public void handleBtnMaSach(){
        viewBanHang.getTxtSoLuong().setText(null);
        if(dsSanPham.isCheck()){
            ArrayList<String> list = dsSanPham.getText();
            viewBanHang.getTxtMaSach().setText(list.get(0).toString());
            viewBanHang.getTxtTenSach().setText(list.get(1).toString());
            viewBanHang.getTxtDonGia().setText(list.get(2).toString());
            viewBanHang.getTxtLinkanh().setText(list.get(3).toString());
            try {
                String pathImage = pathImageBook + list.get(3).toString();
                img = ImageIO.read(new File(pathImage));
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            if(img!=null){
                image = img.getScaledInstance(250,150, Image.SCALE_SMOOTH);   
                icon = new ImageIcon(image);
                viewBanHang.getTxtLinkanh().setIcon(icon);
            }
        }
    }
    public String getFormatDate(){
        // lấy ra ngày hiện tại 
        LocalDate currentDate = LocalDate.now();
        // định dạng ngày tháng năm 
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // chuyển đổi ngày hiện tại thành chuối theo định dạng 
        String formattedDate = currentDate.format(dateTimeFormatter);
        return formattedDate;
    }
    public void handleThanhTienSP(int index,double PhanTramGG){
         double thanhtiensp = Double.parseDouble(defaultTableModel.getValueAt(index, 5).toString());
         ThanhTienSP -=(thanhtiensp*PhanTramGG);
         TongTienSP -=thanhtiensp;
         ThanhTienGiamGiaSP -=(PhanTramGG*thanhtiensp);
    }
    public boolean check(String text){
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void loadDiaglog(){
        this.dsGiamGia = new DsGiamGia(this.viewBanHang.getfTrangChu(),true);
        this.dsKhachHang = new DsKhachHang(this.viewBanHang.getfTrangChu(), true);
        this.dsNhanVien = new DsNhanVien(this.viewBanHang.getfTrangChu(), true);
        this.dsSanPham = new DSanPham(this.viewBanHang.getfTrangChu(),true);
    }
}
