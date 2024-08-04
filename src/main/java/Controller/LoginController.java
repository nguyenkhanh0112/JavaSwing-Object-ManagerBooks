/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.TaiKhoanDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Frame.fLogin;
import view.Frame.fTrangChu;

/**
 *
 * @author Nguyen Khanh
 */
public class LoginController extends MouseAdapter implements ActionListener{
    private TaiKhoanDAO modelTaiKhoan;
    private fLogin viewLogin;

    public LoginController(fLogin fLogin1) {
        this.modelTaiKhoan = new TaiKhoanDAO();
        this.viewLogin = fLogin1;
        this.viewLogin.addbtnDangNhapListener(this);
        this.viewLogin.addLoginMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource()==viewLogin.getShow_eye()&&e.getButton()== MouseEvent.BUTTON1){
           viewLogin.showPassword();
       }else if(e.getSource()==viewLogin.getDisable()&&e.getButton()==MouseEvent.BUTTON1){
           viewLogin.disablePassword();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String usename = viewLogin.getTxtUsername();
       char[] passwordChars = viewLogin.getTxtPasswords();
       String password = new String(passwordChars);
       if(modelTaiKhoan.authenticate(usename, password)){
           JOptionPane.showMessageDialog(null,"Đăng Nhập Thành Công!");
           fTrangChu fTrangChu1 = new fTrangChu();
           fTrangChu1.setVisible(true);
       }else{
           JOptionPane.showMessageDialog(null,"Đăng Nhập thất bại, hãy kiểm tra lại tài khoản mật khẩu!");
       }
    }
}
