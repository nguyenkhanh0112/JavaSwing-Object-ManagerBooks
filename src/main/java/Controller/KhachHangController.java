/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.KhachHangDAO;
import Model.KHACHHANG;
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
import java.util.ArrayList;
import java.util.Date;
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
import view.Panel.JPKhachHang;

/**
 *
 * @author Nguyen Khanh
 */
public class KhachHangController implements ActionListener,ListSelectionListener{
    private JPKhachHang viewKH = null;
    private KhachHangDAO modelKH = null;
    private DefaultTableModel defaultTableModel = null;
    private CellStyle cellStyleFormatNumber = null;
    private String excelFilePath = "D:\\xlsx\\KhachHangs.xlsx";
    private int count=0;
    public KhachHangController(JPKhachHang jPKhachHang) {
        this.viewKH = jPKhachHang;
        this.modelKH = new KhachHangDAO();
        
        defaultTableModel = (DefaultTableModel) this.viewKH.getTbKH().getModel();
        this.viewKH.getTbKH().getSelectionModel().addListSelectionListener(this);
        this.viewKH.setActionCommand();
        this.viewKH.getJdcNgaySinh().setDateFormatString("yyyy-MM-dd");
        
        this.viewKH.getBtnThem().addActionListener(this);
        this.viewKH.getBtnSua().addActionListener(this);
        this.viewKH.getBtnXoa().addActionListener(this);
        this.viewKH.getBtnNhapExcel().addActionListener(this);
        this.viewKH.getBtnXuatExcel().addActionListener(this);
        this.viewKH.getBtnTimkiem().addActionListener(this);
        this.viewKH.getRdbNam().addActionListener(this);
        this.viewKH.getRdbNu().addActionListener(this);
        this.viewKH.getRdbTimkiemNam().addActionListener(this);
        this.viewKH.getRdbTimkiemNu().addActionListener(this);
        this.viewKH.getBtnLammoi().addActionListener(this);
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
          case "btnNhapExcel":
              handleNhapExcel();
              break;
          case "btnXuatExcel":
              handleXuatExcel();
              break;
          case "btnLammoi":
              clearPanel();
              break;
          case "btnNu":
            handleNu();
              break;
          case "btnNam":
            handleNam();
              break;
          case "btnNamTK":
            handleNamTK();
              break;
          case "btnNuTK":
            handleNuTK();
              break;
          default:
              break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
               if(e.getSource() == viewKH.getTbKH().getSelectionModel()){
            if(!e.getValueIsAdjusting()){
                int selectedRow = viewKH.getTbKH().getSelectedRow();
                if(selectedRow!=-1){
                    viewKH.getBtnSua().setEnabled(true);
                    viewKH.getBtnXoa().setEnabled(true);
                    viewKH.getTxtMaKH().setText(defaultTableModel.getValueAt(selectedRow, 0).toString());
                    viewKH.getTxtHoKH().setText(defaultTableModel.getValueAt(selectedRow, 1).toString());
                    viewKH.getTxtTenKH().setText(defaultTableModel.getValueAt(selectedRow,2).toString());
                    viewKH.getTxtSDT().setText(defaultTableModel.getValueAt(selectedRow, 3).toString());
                    viewKH.getTxtEmail().setText(defaultTableModel.getValueAt(selectedRow, 4).toString());
                    if(defaultTableModel.getValueAt(selectedRow, 5).toString().equals(viewKH.getRdbNam().getText().toString())){
                        viewKH.getRdbNam().setSelected(true);
                        viewKH.getRdbNu().setSelected(false);
                    }else if(defaultTableModel.getValueAt(selectedRow, 5).toString().equals(viewKH.getRdbNu().getText().toString())){
                        viewKH.getRdbNu().setSelected(true);
                        viewKH.getRdbNam().setSelected(false);
                    }
                    viewKH.getTxtTongChi().setText(defaultTableModel.getValueAt(selectedRow, 6).toString());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try{
                        Date date = sdf.parse(defaultTableModel.getValueAt(selectedRow, 7).toString());
                        viewKH.getJdcNgaySinh().setDate(date);
                    }catch(ParseException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }  
    }
    public void loadData(){
        ArrayList<KHACHHANG> clients = modelKH.selectKHAll();
        count = modelKH.countNumbersKH();
        viewKH.getTxtSoluongKH().setText(String.valueOf(count));
        defaultTableModel.setRowCount(0);
        for(KHACHHANG client : clients){
            defaultTableModel.addRow(new Object[]{client.getMaKH(),client.getHoKH(),client.getTenKH(),client.getSDT(),client.getEmail(),client.getPhai(),client.getTongChi(),client.getNgaySinh().toString()});
        }
    }
    public void handleThem(){
//        clearPanel();
        String MaKH = viewKH.getTxtMaKH().getText().toString();
        String HoKH = viewKH.getTxtHoKH().getText().toString();
        String TenKH = viewKH.getTxtTenKH().getText().toString();
        String Email = viewKH.getTxtEmail().getText().toString();
        String SDT = viewKH.getTxtSDT().getText().toString();
        double Tongchi = Double.parseDouble(viewKH.getTxtTongChi().getText().toString());
        String Phai = null;
        if(viewKH.getRdbNam().isSelected()){
            Phai = viewKH.getRdbNam().getText().toString();
        }else if(viewKH.getRdbNu().isSelected()){
            Phai = viewKH.getRdbNu().getText().toString();
        }
        Date date =viewKH.getJdcNgaySinh().getDate();
        if(date==null){
             throw new IllegalArgumentException("Ngày sinh không hợp lệ!");
        }
        java.sql.Date dateNgaySinh = new java.sql.Date(date.getTime());
        if(MaKH!=null&&TenKH!=null&&Tongchi!=-1){
            Email = (Email == null || Email.isEmpty()? null:Email);
            Phai = (Phai == null || Phai.isEmpty() ? null:Phai);
            SDT = (SDT == null || SDT.isEmpty()?null:SDT);
            HoKH = (HoKH == null || HoKH.isEmpty()?null:HoKH);
            int resultSet = modelKH.insertKH(MaKH, HoKH, TenKH, SDT, Email, Phai, Tongchi, dateNgaySinh);
            if(resultSet!=0){
            JOptionPane.showMessageDialog(null, "Thêm thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            defaultTableModel.addRow(new Object[]{MaKH, HoKH, TenKH,SDT, Email, Tongchi, Phai, dateNgaySinh.toString()});
            defaultTableModel.fireTableRowsInserted(defaultTableModel.getRowCount()-1, defaultTableModel.getRowCount()-1);
            viewKH.getTxtSoluongKH().setText(String.valueOf(count++));
            clearPanel();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void handleSua(){
        int index = viewKH.getTbKH().getSelectedRow();
        if(index != -1){
            String MaKH = viewKH.getTxtMaKH().getText().toString();
            String HoKH = viewKH.getTxtHoKH().getText().toString();
            String TenKH = viewKH.getTxtTenKH().getText().toString();
            String Email = viewKH.getTxtEmail().getText().toString();
            String SDT = viewKH.getTxtSDT().getText().toString();
            double Tongchi = Double.parseDouble(viewKH.getTxtTongChi().getText().toString());
            String Phai = null;
            if(viewKH.getRdbNam().isSelected()){
                Phai = viewKH.getRdbNam().getText().toString();
            }else if(viewKH.getRdbNu().isSelected()){
                Phai = viewKH.getRdbNu().getText().toString();
            }
            Date date =viewKH.getJdcNgaySinh().getDate();
            java.sql.Date dateNgaySinh = new java.sql.Date(date.getTime());
            int resultSet = modelKH.updateKH(MaKH, HoKH, TenKH,SDT, Email, Phai, Tongchi, dateNgaySinh);
            if(resultSet!=0){
                JOptionPane.showMessageDialog(null, "Sửa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                defaultTableModel.removeRow(index);
                defaultTableModel.insertRow(index, new Object[]{MaKH, HoKH, TenKH,SDT, Email, Phai, Tongchi, dateNgaySinh.toString()});
                clearPanel();
                viewKH.getBtnSua().setEnabled(false);
                viewKH.getBtnXoa().setEnabled(false);
            }else{
                JOptionPane.showConfirmDialog(null, "Sửa thất bại!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleXoa(){
        int index = viewKH.getTbKH().getSelectedRow();
        if(index !=-1){
            String MaKH = viewKH.getTxtMaKH().getText().toString();
            int resultSet = modelKH.deleteKH(MaKH);
            if(resultSet!=0){
                defaultTableModel.removeRow(index);
                clearPanel();
                viewKH.getBtnSua().setEnabled(false);
                viewKH.getBtnXoa().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Xóa thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                viewKH.getTxtSoluongKH().setText(String.valueOf(count--));
            }else{
                JOptionPane.showMessageDialog(null, "Không thể xóa!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }  
        }
    }
    public void handleTimkiem(){
        String condition = viewKH.getCbTimkiem().getSelectedItem().toString();
        String MaKH = null;
        String TenKH = null;
        String Phai = null;
        String TongChiden = null;
        String TongChiTu = null;
        if(condition!=null||!condition.isEmpty()){
            if(condition.equals("MaKH")){
                MaKH = viewKH.getTxtTieuChiTimkiem().getText().toString();
            }else if(condition.equals("TenKH")){
                TenKH = viewKH.getTxtTieuChiTimkiem().getText().toString();
            }else if(condition.equals("TongChi")){
                TongChiden =  viewKH.getTxtTieuChiTimkiem().getText().toString();
            } 
        }
        if(viewKH.getRdbTimkiemNam().isSelected()){
            Phai = viewKH.getRdbNam().getText();
        }else if(viewKH.getRdbTimkiemNu().isSelected()){
             Phai = viewKH.getRdbNam().getText();
        }
        ArrayList<KHACHHANG> khachhangs = modelKH.searchClients(MaKH, TenKH, TongChiTu, TongChiden, Phai);
        defaultTableModel.setRowCount(0);
        for(KHACHHANG client : khachhangs){
            defaultTableModel.addRow(new Object[]{client.getMaKH(),client.getHoKH(),client.getTenKH(),client.getSDT(),client.getEmail(),client.getPhai(),client.getTongChi(),client.getNgaySinh().toString()});
        }
        viewKH.getCbTimkiem().setSelectedIndex(-1);
        viewKH.getRdbTimkiemNam().setSelected(false);
        viewKH.getRdbTimkiemNu().setSelected(false);
        viewKH.getTxtTieuChiTimkiem().setText("");
    }
    public void handleNhapExcel(){
        ArrayList<KHACHHANG> clients = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        // get file
        try {
            InputStream inputStream = new FileInputStream(new File(excelFilePath));
            //Get workclient
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);  
            // Get sheet
            XSSFSheet sheet = workbook.getSheet("Clients");
             // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while(iterator.hasNext()){
            Row nextRow  = iterator.next();
            if(nextRow.getRowNum() == 0){
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            // read cells and set value for client object
            KHACHHANG client = new KHACHHANG();                                   
            while(cellIterator.hasNext()){
                // read cell
                Cell cell = cellIterator.next();
                Object objectCellValue =getCellValue(cell);
                if (objectCellValue == null || objectCellValue.toString().isEmpty()) {
                    continue;
                }
                // set value for client object
                int columnIndex = cell.getColumnIndex();
                switch(columnIndex){
                    case 0:
                        client.setMaKH((String) getCellValue(cell));
                        break;
                    case 1:
                        client.setHoKH((String) getCellValue(cell));
                        break;
                    case 2:
                        client.setTenKH((String) getCellValue(cell));
                        break;   
                    case 3:
                        client.setSDT((String)getCellValue(cell));
                        break;  
                    case 4:
                        client.setEmail((String) getCellValue(cell));
                        break;
                    case 5:
                        client.setPhai((String)getCellValue(cell));
                        break;
                    case 6:
                        client.setTongChi(((Double) objectCellValue).intValue());
                        break;
                    case 7:
                        try{
                            date1 = sdf.parse((String)getCellValue(cell));
                            client.setNgaySinh(new java.sql.Date(date1.getTime()));
                        }catch(ParseException pe){
                            pe.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
            clients.add(client);
        }
        workbook.close();
        inputStream.close();
        for(int i=0;i< clients.size();i++){
           if(i>defaultTableModel.getRowCount()-1){
                String MaKH =  clients.get(i).getMaKH().toString().trim();
                String HoKH =  clients.get(i).getHoKH().toString().trim();
                String TenKH =  clients.get(i).getTenKH().toString().trim();
                String SDT =  clients.get(i).getSDT().toString().trim();
                String Email =  clients.get(i).getEmail().toString().trim();
                double Tongchi =  clients.get(i).getTongChi();
                String Phai = clients.get(i).getPhai();
                java.sql.Date NgaySinh = clients.get(i).getNgaySinh();
                int resultSet = modelKH.insertKH(MaKH, HoKH, TenKH,  SDT, Email,Phai, Tongchi, NgaySinh);
                defaultTableModel.addRow(new Object[]{MaKH, HoKH, TenKH,  SDT, Email, Phai, Tongchi, NgaySinh.toString()});
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void handleXuatExcel(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        ArrayList<KHACHHANG> clients = new ArrayList<>();
        for(int i=0;i<defaultTableModel.getRowCount();i++){
            String MaKH = defaultTableModel.getValueAt(i,0).toString();
            String HoKH =defaultTableModel.getValueAt(i, 1).toString();
            String TenKH = defaultTableModel.getValueAt(i, 2).toString();
            String SDT = defaultTableModel.getValueAt(i, 3).toString();
            String Email =defaultTableModel.getValueAt(i, 4).toString();
            String Phai = defaultTableModel.getValueAt(i, 5).toString();
            double Tongchi =(Double) defaultTableModel.getValueAt(i, 6);
            try{
                date = sdf.parse(defaultTableModel.getValueAt(i, 7).toString());
            }catch(ParseException ex){
                ex.printStackTrace();
            }
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            KHACHHANG client = new KHACHHANG(MaKH, HoKH, TenKH, SDT, Email, Phai,Tongchi, date1);
            clients.add(client);
        }
          // create workbook
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        
        // create sheet
        SXSSFSheet sheet = workbook.createSheet("Clients");
        
        // register the columns you wish to track and compute the column width
        sheet.trackAllColumnsForAutoSizing();
        
        int rowIndex = 0;
        
        // write header
        writeHeader(sheet, rowIndex);
        
        // write Data
        rowIndex++;
        for(KHACHHANG client : clients){
            SXSSFRow row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(client, row);
            rowIndex++;
        }
          // Auto resize column witdth
        int numberOfColumn = 8; // sheet.getRow(0).getPhysicalNumberOfCells();
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
        cell.setCellValue("MaKH");
        
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("HoKH");
        
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("TenKH");
        
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SDT");
        
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");
        
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Phai");
        
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("TongChi");
        
        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("NgaySinh");
 
    }
    // write data
    private  void writeBook(KHACHHANG client,SXSSFRow row){
        if(cellStyleFormatNumber == null){
            // định dạng số 
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            SXSSFWorkbook workclient = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workclient.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        SXSSFCell cell = row.createCell(0);
        cell.setCellValue(client.getMaKH());
        
        cell = row.createCell(1);
        cell.setCellValue(client.getHoKH());
        
        cell = row.createCell(2);
        cell.setCellValue(client.getTenKH());
   
        cell = row.createCell(3);
        cell.setCellValue(client.getEmail());
        
        cell = row.createCell(4);
        cell.setCellValue(client.getSDT());
        
        cell = row.createCell(5);
        cell.setCellValue(client.getPhai());
        
        cell = row.createCell(6);
        cell.setCellValue(client.getTongChi());
        
        cell = row.createCell(7);
        cell.setCellValue(client.getNgaySinh().toString());
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
        for(Component compoent : viewKH.getjPanel4().getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JDateChooser){
                ((JDateChooser) compoent).setDate(null);
            }else if(compoent instanceof JRadioButton){
                ((JRadioButton) compoent).setSelected(false);
            }
        }
    }
    public void handleNam(){
        if(viewKH.getRdbNam().isSelected()){
            viewKH.getRdbNu().setSelected(false);
        }
    }
    public void handleNu(){
        if(viewKH.getRdbNu().isSelected()){
            viewKH.getRdbNam().setSelected(false);
        }
    }
    public void handleNamTK(){
        if(viewKH.getRdbTimkiemNam().isSelected()){
            viewKH.getRdbTimkiemNu().setSelected(false);
        }
    }
    public void handleNuTK(){
        if(viewKH.getRdbTimkiemNu().isSelected()){
            viewKH.getRdbTimkiemNam().setSelected(false);
        }
    } 
}
