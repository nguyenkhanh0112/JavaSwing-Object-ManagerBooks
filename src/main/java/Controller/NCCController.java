/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.NhaCCDAO;
import Model.NCC;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.Panel.JPNCC;

/**
 *
 * @author Nguyen Khanh
 */
public class NCCController implements ActionListener,ListSelectionListener{
    private JPNCC view =null;
    private NhaCCDAO model = null;
    private DefaultTableModel defaultTableModel = null;

    public NCCController(JPNCC jpncc) {
        this.view = jpncc;
        model = new NhaCCDAO();
        defaultTableModel = (DefaultTableModel) view.getjTable1().getModel();
        view.getjTable1().getSelectionModel().addListSelectionListener(this);
        view.getBtnThem().addActionListener(this);
        view.getBtnSua().addActionListener(this);
        view.getBtnXoa().addActionListener(this);
        view.setActionCommand();
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
            default:
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()&&e.getSource()==view.getjTable1().getSelectionModel()){
            int index = view.getjTable1().getSelectedRow();{
                if(index!=-1){
                    view.getBtnSua().setEnabled(true);
                    view.getBtnXoa().setEnabled(true);
                    view.getTxtMaNCC().setText(defaultTableModel.getValueAt(index, 0).toString());
                    view.getTxtTenNCC().setText(defaultTableModel.getValueAt(index, 1).toString());
                    view.getTxtDiaChi().setText(defaultTableModel.getValueAt(index, 2).toString());
                    view.getTxtSDT().setText(defaultTableModel.getValueAt(index, 3).toString());
                    view.getTxtEmai().setText(defaultTableModel.getValueAt(index, 4).toString());
                    view.getTxtNguoilienhe().setText(defaultTableModel.getValueAt(index, 5).toString());
                }
            }
        }
    }
    
    public void loadData(){
        ArrayList<NCC> nccs = model.selectAll();
        defaultTableModel.setRowCount(0);
        for (NCC ncc : nccs) {
            defaultTableModel.addRow(new Object[]{ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiaChi(),ncc.getSDT(),ncc.getEmail(),ncc.getNguoiLienHe()});
        }
    }
    public void handleThem(){
        String MaNCC = view.getTxtMaNCC().getText();
        String TenNCC = view.getTxtTenNCC().getText();
        String Diachi = view.getTxtDiaChi().getText();
        String SDT = view.getTxtSDT().getText();
        String Email = view.getTxtEmai().getText();
        String nguoilienhe = view.getTxtNguoilienhe().getText();
        if(MaNCC!=null&&!MaNCC.isEmpty()&&TenNCC!=null&&!TenNCC.isEmpty()&&!Diachi.isEmpty()&&Diachi!=null&&Email!=null&&!Email.isEmpty()&&nguoilienhe!=null&&!nguoilienhe.isEmpty()){
            int resultSet = model.insertNCC(MaNCC, TenNCC, Diachi, SDT, Email, nguoilienhe);
            if(resultSet!=0){
                defaultTableModel.addRow(new Object[]{MaNCC, TenNCC, Diachi, SDT, Email, nguoilienhe});
                clearPanel(view.getjPanel2());
                JOptionPane.showConfirmDialog(null,"thêm thành công","thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showConfirmDialog(null,"không thể thêm","thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    public void handleSua(){
        int index = view.getjTable1().getSelectedRow();
        String MaNCC = view.getTxtMaNCC().getText();
        String TenNCC = view.getTxtTenNCC().getText();
        String Diachi = view.getTxtDiaChi().getText();
        String SDT = view.getTxtSDT().getText();
        String Email = view.getTxtEmai().getText();
        String nguoilienhe = view.getTxtNguoilienhe().getText();
        int resultSet = model.updateNCC(MaNCC, TenNCC, Diachi, SDT, Email, nguoilienhe);
        if(resultSet!=0){
            defaultTableModel.removeRow(index);
            defaultTableModel.insertRow(index,new Object[]{MaNCC, TenNCC, Diachi, SDT, Email, nguoilienhe});
            clearPanel(view.getjPanel2());
            JOptionPane.showConfirmDialog(null,"sửa thành công","thông báo",JOptionPane.INFORMATION_MESSAGE);
            view.getBtnSua().setEnabled(false);
            view.getBtnXoa().setEnabled(false);
        }else{
            JOptionPane.showConfirmDialog(null,"không thể sửa","thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void handleXoa(){
        int index = view.getjTable1().getSelectedRow();
        String MaNCC = view.getTxtMaNCC().getText();
        int resultSet = model.deleteNCC(MaNCC);
        if(resultSet!=0){
            defaultTableModel.removeRow(index);
            clearPanel(view.getjPanel2());
            JOptionPane.showConfirmDialog(null,"sửa thành công","thông báo",JOptionPane.INFORMATION_MESSAGE);
            view.getBtnSua().setEnabled(false);
            view.getBtnXoa().setEnabled(false);
            clearPanel(view.getjPanel2());
        }else{
            JOptionPane.showConfirmDialog(null,"không thể sửa","thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void clearPanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }
        }
    }
}
