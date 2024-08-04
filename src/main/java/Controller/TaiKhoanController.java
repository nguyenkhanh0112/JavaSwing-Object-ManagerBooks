/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.TaiKhoanDAO;
import Model.TAIKHOAN;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Panel.JPTaiKhoan;

/**
 *
 * @author Nguyen Khanh
 */
public class TaiKhoanController implements ActionListener,ListSelectionListener{
    private TaiKhoanDAO modelTaiKhoan = null;
    private JPTaiKhoan viewTaikhoan = null;
    private DefaultTableModel defaultTableModel = null;
    private int index = 0;
    private int resultSet  = 0;
    private int TrangThai = -1;

    public TaiKhoanController(JPTaiKhoan pTaiKhoan) {
        this.viewTaikhoan = pTaiKhoan;
        this.modelTaiKhoan = new TaiKhoanDAO();
        
        this.viewTaikhoan.getTbTK().getSelectionModel().addListSelectionListener(this);
        defaultTableModel = (DefaultTableModel) viewTaikhoan.getTbTK().getModel();

        
        this.viewTaikhoan.getBtnThem().addActionListener(this);
        this.viewTaikhoan.getBtnSua().addActionListener(this);
        this.viewTaikhoan.getBtnXoa().addActionListener(this);
        this.viewTaikhoan.getRbBinhthuong().addActionListener(this);
        this.viewTaikhoan.getRbKhoa().addActionListener(this);
        
        loadData();
        viewTaikhoan.setActioncommand();
        
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
            case "btnBinhthuong":
                handleBinhThuong();
                break;
            case "btnKhoa":
                handleKhoa();
                break;
            default: 
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
       if(e.getSource()==viewTaikhoan.getTbTK().getSelectionModel()&& !e.getValueIsAdjusting()){
           index = viewTaikhoan.getTbTK().getSelectedRow();
           if(index !=-1){
                viewTaikhoan.getBtnSua().setEnabled(true);
                viewTaikhoan.getBtnXoa().setEnabled(true);
                viewTaikhoan.getTxtMaTK().setText(defaultTableModel.getValueAt(index, 0).toString());
                viewTaikhoan.getTxtTenDN().setText(defaultTableModel.getValueAt(index, 1).toString());
                viewTaikhoan.getTxtMK().setText(defaultTableModel.getValueAt(index, 2).toString());
                viewTaikhoan.getCbQuyen().setSelectedItem(defaultTableModel.getValueAt(index, 3));
                if(Integer.parseInt(defaultTableModel.getValueAt(index, 4).toString())==1){
                    viewTaikhoan.getRbBinhthuong().setSelected(true);
                    viewTaikhoan.getRbKhoa().setSelected(false);
                }else if(Integer.parseInt(defaultTableModel.getValueAt(index, 4).toString())==0){
                    viewTaikhoan.getRbBinhthuong().setSelected(false);
                    viewTaikhoan.getRbKhoa().setSelected(true);
                }
           }
       }
    }
    public void loadData(){
        ArrayList<TAIKHOAN> accounts = modelTaiKhoan.loadingTaiKhoan();
        defaultTableModel.setRowCount(0);
        for (TAIKHOAN account : accounts) {
            defaultTableModel.addRow(new Object[]{account.getMaTK(),account.getTenTK(),account.getMATKHAU(),account.getQuyen(),account.getTrangThaiString()});
        }
    }
    public void handleThem(){
        String MaTK = viewTaikhoan.getTxtMaTK().getText();
        String TenTK = viewTaikhoan.getTxtTenDN().getText();
        String MK = viewTaikhoan.getTxtMK().getText();
        String Quyen = viewTaikhoan.getCbQuyen().getSelectedItem().toString();
        if(MaTK!=null&&!MaTK.isEmpty()&&TenTK!=null&&!TenTK.isEmpty()&&MK!=null&&!MK.isEmpty()&&Quyen!=null&&!Quyen.isEmpty()&&TrangThai!=-1){
           resultSet = modelTaiKhoan.insertTaiKhoang(MaTK, TenTK, MK, Quyen, TrangThai);
           if(resultSet != 0){
               defaultTableModel.addRow(new Object[]{MaTK,TenTK,MK,Quyen,TrangThai});
               clearPanel(viewTaikhoan.getjPanel1());
               viewTaikhoan.getBtnSua().setEnabled(false);
               viewTaikhoan.getBtnXoa().setEnabled(false);
               JOptionPane.showMessageDialog(null, "Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
               JOptionPane.showMessageDialog(null, "Không thể thêm!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
           }
        }else{
             JOptionPane.showMessageDialog(null, "Thiếu dữ liệu!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    public void handleSua(){
        index = viewTaikhoan.getTbTK().getSelectedRow();
        if(index!=-1&&index < defaultTableModel.getRowCount()){
            String MaTK = viewTaikhoan.getTxtMaTK().getText().toString();
            String TenTK = viewTaikhoan.getTxtTenDN().getText().toString();
            String MK = viewTaikhoan.getTxtMK().getText().toString();
            String Quyen = viewTaikhoan.getCbQuyen().getSelectedItem().toString();
            if(TrangThai!=-1){
                resultSet = modelTaiKhoan.updateTaikhoan(MaTK, TenTK, MK, Quyen, TrangThai);
                if(resultSet!=0){
                    defaultTableModel.setValueAt(MaTK, index, 0);
                    defaultTableModel.setValueAt(TenTK, index, 1);
                    defaultTableModel.setValueAt(MK, index, 2);
                    defaultTableModel.setValueAt(Quyen, index, 3);
                    defaultTableModel.setValueAt(TrangThai, index, 4);
                    viewTaikhoan.getTbTK().clearSelection();
                    clearPanel(viewTaikhoan.getjPanel1());
                    viewTaikhoan.getBtnSua().setEnabled(false);
                    viewTaikhoan.getBtnXoa().setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Sửa Thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }else{
                     JOptionPane.showMessageDialog(null, "Không thể sửa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }   
    }
    public void handleXoa(){
        index = viewTaikhoan.getTbTK().getSelectedRow();
        if(index!=-1){
            String MaTK = viewTaikhoan.getTxtMaTK().getText();
            resultSet = modelTaiKhoan.deleteTaiKhoan(MaTK);
            if(resultSet!=0){
                defaultTableModel.removeRow(index);
                clearPanel(viewTaikhoan.getjPanel1());
                viewTaikhoan.getBtnSua().setEnabled(false);
                viewTaikhoan.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Xóa Thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Không thể xóa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void clearPanel(JPanel jp){
         for(Component compoent : jp.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JComboBox){
                ((JComboBox) compoent).setSelectedIndex(-1);
            }else if(compoent instanceof JRadioButton){
                ((JRadioButton) compoent).setSelected(false);
            }
        }
    }
    public void handleKhoa(){
       if(viewTaikhoan.getRbKhoa().isSelected()){
           viewTaikhoan.getRbBinhthuong().setSelected(false);
           TrangThai = 0;
       }
    }
    public void handleBinhThuong(){
        if(viewTaikhoan.getRbBinhthuong().isSelected()){
           viewTaikhoan.getRbKhoa().setSelected(false);
           TrangThai = 1;
       }
    }
}
