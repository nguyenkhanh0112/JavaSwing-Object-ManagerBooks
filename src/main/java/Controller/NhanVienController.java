/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.NhanVienDAO;
import Model.NHANVIEN;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.ERROR;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import static org.apache.poi.ss.usermodel.CellType._NONE;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.Panel.JPNhanVien;

/**
 *
 * @author Nguyen Khanh
 */
public class NhanVienController implements ActionListener,ListSelectionListener{
    private JPNhanVien viewNhanVien=null;
    private NhanVienDAO modelNV =null;
    private DefaultTableModel defaultTableModel = null;
    private CellStyle cellStyleFormatNumber = null;
    private String excelFilePath = "D:\\xlsx\\staffs.xlsx";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public NhanVienController(JPNhanVien jPNhanVien) {
        this.viewNhanVien = jPNhanVien;
        this.modelNV = new NhanVienDAO();
        
        this.viewNhanVien.getBtnThem().addActionListener(this);
        this.viewNhanVien.getBtnSua().addActionListener(this);
        this.viewNhanVien.getBtnXoa().addActionListener(this);
        this.viewNhanVien.getBtnNhapExcel().addActionListener(this);
        this.viewNhanVien.getBtnXuatExcel().addActionListener(this);
        this.viewNhanVien.getBtnTimKiem().addActionListener(this);
        this.viewNhanVien.getRbtNam().addActionListener(this);
        this.viewNhanVien.getRbtNu().addActionListener(this);
        
        this.viewNhanVien.getTbNhanVien().getSelectionModel().addListSelectionListener(this);
        this.defaultTableModel = (DefaultTableModel) this.viewNhanVien.getTbNhanVien().getModel();
        this.viewNhanVien.setActionCommand();
        this.viewNhanVien.getJdcNgaySinh().setDateFormatString("yyyy-MM-dd");
        
        
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
          case "btnTimkiem":
              handleTimkiem();
              break;
          case "btnCondition1":
              break;
          case "btnCondition2":
              break;
          case "btnNhapExcel":
              handleNhapExcel();
              break;
          case "btnXuatExcel":
              handleXuatExcel();
              break;
          case "rdbNam":
              handleRdbNam();
              break;
          case "rdbNu":
              handleRdbNu();
              break;
          default:
              break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e){
        if(e.getSource() == viewNhanVien.getTbNhanVien().getSelectionModel()){
            if(!e.getValueIsAdjusting()){
                int selectedRow = viewNhanVien.getTbNhanVien().getSelectedRow();
                if(selectedRow!=-1){
                    viewNhanVien.getBtnSua().setEnabled(true);
                    viewNhanVien.getBtnXoa().setEnabled(true);
                    viewNhanVien.getTxtMaNV().setText(defaultTableModel.getValueAt(selectedRow, 0).toString());
                    viewNhanVien.getTxtHoNV().setText(defaultTableModel.getValueAt(selectedRow, 1).toString());
                    viewNhanVien.getTxtTenNV().setText(defaultTableModel.getValueAt(selectedRow,2).toString());
                    viewNhanVien.getTxtChucVu().setText(defaultTableModel.getValueAt(selectedRow,3).toString());
                    viewNhanVien.getTxtEmail().setText(defaultTableModel.getValueAt(selectedRow, 4).toString());
                    viewNhanVien.getTxtSDT().setText(defaultTableModel.getValueAt(selectedRow, 5).toString());
                    viewNhanVien.getTxtLuong().setText(defaultTableModel.getValueAt(selectedRow, 6).toString());
                    if(defaultTableModel.getValueAt(selectedRow, 7).toString().equals(viewNhanVien.getRbtNam().getText().toString())){
                        viewNhanVien.getRbtNam().setSelected(true);
                        viewNhanVien.getRbtNu().setSelected(false);
                    }else if(defaultTableModel.getValueAt(selectedRow, 7).toString().equals(viewNhanVien.getRbtNu().getText().toString())){
                        viewNhanVien.getRbtNu().setSelected(true);
                        viewNhanVien.getRbtNam().setSelected(false);
                    }
                    try{
                        Date date = sdf.parse(defaultTableModel.getValueAt(selectedRow, 8).toString());
                        viewNhanVien.getJdcNgaySinh().setDate(date);
                    }catch(ParseException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }     
    }
    public void loadData(){
        ArrayList<NHANVIEN> staffs = modelNV.selectNVAll();
        defaultTableModel.setRowCount(0);
        for(NHANVIEN staff : staffs){
            defaultTableModel.addRow(new Object[]{staff.getMaNV(),staff.getHoNV(),staff.getTenNV(),staff.getChucVu(),staff.getEmail(),staff.getSDT(),staff.getLuong(),staff.getPhai(),staff.getNgaySinh().toString()});
        }
    }
    public void handleThem(){
        String MaNV = viewNhanVien.getTxtMaNV().getText().toString();
        String HoNV = viewNhanVien.getTxtHoNV().getText().toString();
        String TenNV = viewNhanVien.getTxtTenNV().getText().toString();
        String ChucVu = viewNhanVien.getTxtChucVu().getText().toString();
        String Email = viewNhanVien.getTxtEmail().getText().toString();
        String SDT = viewNhanVien.getTxtSDT().getText().toString();
        double Luong = Double.parseDouble(viewNhanVien.getTxtLuong().getText().toString());
        String Phai = null;
        if(viewNhanVien.getRbtNam().isSelected()){
            Phai = viewNhanVien.getRbtNam().getText().toString();
        }else if(viewNhanVien.getRbtNu().isSelected()){
            Phai = viewNhanVien.getRbtNu().getText().toString();
        }
        Date date =viewNhanVien.getJdcNgaySinh().getDate();
        if(date==null){
             throw new IllegalArgumentException("Ngày sinh không hợp lệ!");
        }
        java.sql.Date dateNgaySinh = new java.sql.Date(date.getTime());
        if(MaNV!=null&&HoNV!=null&&TenNV!=null&&ChucVu!=null&&Luong!=-1&&SDT!=null){
            Email = (Email == null || Email.isEmpty()? null:Email);
            Phai = (Phai == null || Phai.isEmpty() ? null:Phai);
            int resultSet = modelNV.insertNV(MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, dateNgaySinh);
            if(resultSet!=0){
            JOptionPane.showMessageDialog(null, "Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            defaultTableModel.addRow(new Object[]{MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, dateNgaySinh.toString()});
            defaultTableModel.fireTableRowsInserted(defaultTableModel.getRowCount()-1, defaultTableModel.getRowCount()-1);
            clearPanel();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void handleSua(){
        int index = viewNhanVien.getTbNhanVien().getSelectedRow();
        if(index != -1){
            String MaNV = viewNhanVien.getTxtMaNV().getText().toString();
            String HoNV = viewNhanVien.getTxtHoNV().getText().toString();
            String TenNV = viewNhanVien.getTxtTenNV().getText().toString();
            String ChucVu = viewNhanVien.getTxtChucVu().getText().toString();
            String Email = viewNhanVien.getTxtEmail().getText().toString();
            String SDT = viewNhanVien.getTxtSDT().getText().toString();
            double Luong = Double.parseDouble(viewNhanVien.getTxtLuong().getText().toString());
            String Phai = null;
            if(viewNhanVien.getRbtNam().isSelected()){
                Phai = viewNhanVien.getRbtNam().getText().toString();
            }else if(viewNhanVien.getRbtNu().isSelected()){
                Phai = viewNhanVien.getRbtNu().getText().toString();
            }
            Date date =viewNhanVien.getJdcNgaySinh().getDate();
            java.sql.Date dateNgaySinh = new java.sql.Date(date.getTime());
            int resultSet = modelNV.updateNV(MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, dateNgaySinh);
            if(resultSet!=0){
                JOptionPane.showMessageDialog(null, "Sửa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                defaultTableModel.removeRow(index);
                defaultTableModel.insertRow(index, new Object[]{MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, dateNgaySinh.toString()});
                clearPanel();
                viewNhanVien.getBtnSua().setEnabled(false);
                viewNhanVien.getBtnXoa().setEnabled(false);
            }else{
                JOptionPane.showConfirmDialog(null, "Sửa thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    public void handleXoa(){
        int index = viewNhanVien.getTbNhanVien().getSelectedRow();
        if(index !=-1){
            String MaNV = viewNhanVien.getTxtMaNV().getText().toString();
            int resultSet = modelNV.deleteNV(MaNV);
            if(resultSet!=0){
                defaultTableModel.removeRow(index);
                clearPanel();
                viewNhanVien.getBtnSua().setEnabled(false);
                viewNhanVien.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Xóa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Không thể xóa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }  
        }
    }
    public void handleTimkiem(){ 
    //    ArrayList<NHANVIEN> staffs = modelNV.searchStaff(MaNV, TenNV, ChucVu, LuongTu, LuongDen, Phai, namsinhtu, namsinhden);
        String condition1 = viewNhanVien.getCbTimkiem1().getSelectedItem().toString();
        String condition2 = viewNhanVien.getCbTimkiem2().getSelectedItem().toString();
        if(!condition1.isEmpty()||!condition2.isEmpty()){
            ArrayList<String> listSearch = isCheck(condition1, condition2);
            String MaNV = null;
            String TenNV = null;
            String ChucVu = null;
            String Phai = null;
            String LuongBD = null;
            String LuongDen = null;
            Date NgaySinhTu = null;
            Date NgaySinhDen = null;
            for(int i=0;i<listSearch.size();i++){
                String s =listSearch.get(i).toString();
                if(s.equals("MaNV")){
                    MaNV = viewNhanVien.getTxtTimkiem1().getText().toString();
                }else if(s.equals("TenNV")){
                    TenNV = viewNhanVien.getTxtTimkiem1().getText().toString();
                }else if(s.equals("ChucVu")){
                    ChucVu = viewNhanVien.getTxtTimkiem1().getText().toString();
                }else if(s.equals("Phai")){
                    Phai = viewNhanVien.getTxtTimkiem1().getText().toString();
                }else if(s.equals("Luong")){
                    LuongBD = viewNhanVien.getTxtTimkiem2().getText().toString();
                    LuongDen = viewNhanVien.getTxtimkiem3().getText().toString();
                }     
            }   
            ArrayList<NHANVIEN> staffs =  modelNV.searchStaff(MaNV, TenNV, ChucVu, LuongBD, LuongDen, Phai);
            if(staffs.size()>0){
                defaultTableModel.setRowCount(0);
                for(NHANVIEN staff :staffs){
                    defaultTableModel.addRow(new Object[]{staff.getMaNV(),staff.getHoNV(),staff.getTenNV(),staff.getChucVu(),staff.getEmail(),staff.getSDT(),staff.getLuong(),staff.getPhai(),staff.getNgaySinh().toString()});
                }
            }
        }
    }
    public void handlebtnCondition1(){
    }
    public void handlebtnCondition2(){ 
    }
    public void handleNhapExcel(){
        ArrayList<NHANVIEN> staffs = new ArrayList<>();
        // get file
        try {
            InputStream inputStream = new FileInputStream(new File(excelFilePath));
            //Get workstaff
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);  
            // Get sheet
            XSSFSheet sheet = workbook.getSheet("Staffs");
             // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while(iterator.hasNext()){
            Row nextRow  = iterator.next();
            if(nextRow.getRowNum() == 0){
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            // read cells and set value for staff object
            NHANVIEN staff = new NHANVIEN();
            while(cellIterator.hasNext()){
                // read cell
                Cell cell = cellIterator.next();
                Object objectCellValue =getCellValue(cell);
                if (objectCellValue == null || objectCellValue.toString().isEmpty()) {
                    continue;
                }
                // set value for staff object
                int columnIndex = cell.getColumnIndex();
                switch(columnIndex){
                    case 0:
                        staff.setMaNV((String) getCellValue(cell));
                        break;
                    case 1:
                        staff.setHoNV((String) getCellValue(cell));
                        break;
                    case 2:
                        staff.setTenNV((String) getCellValue(cell));
                        break;
                    case 3:
                         staff.setChucVu((String) getCellValue(cell));
                        break;    
                    case 4:
                        staff.setEmail((String)getCellValue(cell));
                        break;  
                    case 5:
                        staff.setSDT((String) getCellValue(cell));
                        break;
                    case 6:
                        staff.setLuong(((Double) objectCellValue).intValue());
                        break;
                    case 7:
                        staff.setPhai((String)getCellValue(cell));
                        break;
                    case 8:
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try{
                            Date date1 = sdf.parse((String)getCellValue(cell));
                            staff.setNgaySinh(new java.sql.Date(date1.getTime()));
                        }catch(ParseException pe){
                            pe.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
            staffs.add(staff);
        }
        workbook.close();
        inputStream.close();
        for(int i=0;i< staffs.size();i++){
           if(i>defaultTableModel.getRowCount()-1){
                String MaNV =  staffs.get(i).getMaNV().toString().trim();
                String HoNV =  staffs.get(i).getHoNV().toString().trim();
                String TenNV =  staffs.get(i).getTenNV().toString().trim();
                String ChucVu =  staffs.get(i).getChucVu().toString().trim();
                String Email =  staffs.get(i).getEmail().toString().trim();
                String SDT =  staffs.get(i).getSDT().toString().trim();
                double Luong =  staffs.get(i).getLuong();
                String Phai = staffs.get(i).getPhai();
                java.sql.Date NgaySinh = staffs.get(i).getNgaySinh();
                int resultSet = modelNV.insertNV(MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, NgaySinh);
                defaultTableModel.addRow(new Object[]{MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, NgaySinh.toString()});
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void handleXuatExcel(){
        ArrayList<NHANVIEN> staffs = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for(int i=0;i<defaultTableModel.getRowCount();i++){
            String MaNV = defaultTableModel.getValueAt(i,0).toString();
            String HoNV =defaultTableModel.getValueAt(i, 1).toString();
            String TenNV = defaultTableModel.getValueAt(i, 2).toString();
            String ChucVu = defaultTableModel.getValueAt(i, 3).toString();
            String Email =defaultTableModel.getValueAt(i, 4).toString();
            String SDT = defaultTableModel.getValueAt(i, 5).toString();
            double Luong =(Double) defaultTableModel.getValueAt(i, 6);
            String Phai = defaultTableModel.getValueAt(i, 7).toString();
            try{
                date = sdf.parse(defaultTableModel.getValueAt(i, 8).toString());
            }catch(ParseException ex){
                ex.printStackTrace();
            }
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            NHANVIEN staff = new NHANVIEN(MaNV, HoNV, TenNV, ChucVu, Email, SDT, Luong, Phai, date1);
            staffs.add(staff);
        }
          // create workbook
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        
        // create sheet
        SXSSFSheet sheet = workbook.createSheet("Staffs");
        
        // register the columns you wish to track and compute the column width
        sheet.trackAllColumnsForAutoSizing();
        
        int rowIndex = 0;
        
        // write header
        writeHeader(sheet, rowIndex);
        
        // write Data
        rowIndex++;
        for(NHANVIEN staff : staffs){
            SXSSFRow row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(staff, row);
            rowIndex++;
        }
          // Auto resize column witdth
        int numberOfColumn = 9; // sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        
         // Create file excel
        try{
            File file = new File(excelFilePath);
            OutputStream os = new FileOutputStream(file);
            workbook.write(os);
            workbook.close();
            os.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void writeHeader(SXSSFSheet sheet,int rowIndex){
         // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
 
        // Create row
        SXSSFRow row = sheet.createRow(rowIndex);
        
        // Create cells
        SXSSFCell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("MaNV");
        
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("HoNV");
        
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("TenNV");
        
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ChucVu");
        
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");
        
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SDT");
        
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Luong");
        
        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Phai");
        
        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("NgaySinh");
 
    }
    // write data
    private  void writeBook(NHANVIEN staff,SXSSFRow row){
        if(cellStyleFormatNumber == null){
            // định dạng số 
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            SXSSFWorkbook workstaff = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workstaff.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        SXSSFCell cell = row.createCell(0);
        cell.setCellValue(staff.getMaNV());
        
        cell = row.createCell(1);
        cell.setCellValue(staff.getHoNV());
        
        cell = row.createCell(2);
        cell.setCellValue(staff.getTenNV());
        
        cell = row.createCell(3);
        cell.setCellValue(staff.getChucVu());
        
        cell = row.createCell(4);
        cell.setCellValue(staff.getEmail());
        
        cell = row.createCell(5);
        cell.setCellValue(staff.getSDT());
        
        cell = row.createCell(6);
        cell.setCellValue(staff.getLuong());
        
        cell = row.createCell(7);
        cell.setCellValue(staff.getPhai());
        
        cell = row.createCell(8);
        cell.setCellValue(staff.getNgaySinh().toString());
    }
     // Create CellStyle for header
    private CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     // Auto resize column width
    private void autosizeColumn(SXSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
    // get cell value
    private Object getCellValue(Cell cell){
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
            }
        return cellValue;
    }
    public void clearPanel(){
        for(Component compoent : viewNhanVien.getjPanel1().getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JDateChooser){
                ((JDateChooser) compoent).setDate(null);
            }else if(compoent instanceof JRadioButton){
                ((JRadioButton) compoent).setSelected(false);
            }
        }
    }
    public ArrayList<String> isCheck(String s1,String s2){
        ArrayList<String> s = new ArrayList<>();
        if(!s1.isEmpty()){
            s.add(s1);
        }else if(!s2.isEmpty()){
            s.add(s2);
        }
        return s;
    }
    public void handleRdbNam(){
        if(viewNhanVien.getRbtNam().isSelected()){
            viewNhanVien.getRbtNu().setSelected(false);
        }
    }
    public void handleRdbNu(){
        if(viewNhanVien.getRbtNu().isSelected()){
            viewNhanVien.getRbtNam().setSelected(false);
        }
    }
}
