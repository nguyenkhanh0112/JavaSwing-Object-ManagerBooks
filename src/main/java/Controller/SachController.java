/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.NhaXuatBanDAO;
import DAO.SachDAO;
import DAO.TacGiaDAO;
import DAO.TheLoaiDAO;
import Model.NHAXUATBAN;
import Model.SACH;
import Model.TACGIA;
import Model.THELOAI;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionListener;
import view.Panel.JPQuanLySach;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** 
 *
 * @author Nguyen Khanh
 */
public class SachController implements ActionListener,ListSelectionListener{
    private SachDAO modelSach;
    private JPQuanLySach viewQuanLySach;
    private DefaultTableModel defaultTableModel;
    private NhaXuatBanDAO modelNXB;
    private TheLoaiDAO modelTL;
    private TacGiaDAO modelTG;
    private ArrayList<NHAXUATBAN> nhaxuatbans;
    private ArrayList<THELOAI> categorys;
    private ArrayList<TACGIA> authors;
    private CellStyle cellStyleFormatNumber = null;
    private Image img =null;
    private String excelFilePath = "D:\\xlsx\\Books.xlsx";
    private String pathImageBook = "C:\\Users\\Nguyen Khanh\\OneDrive\\Documents\\NetBeansProjects\\BookStore1\\src\\main\\java\\img\\Book_img\\";
          
    private int Index;

    public SachController(JPQuanLySach quanLySach) {
        this.modelSach = new SachDAO();
        this.modelNXB = new NhaXuatBanDAO();
        this.modelTG = new TacGiaDAO();
        this.modelTL = new TheLoaiDAO();
        this.viewQuanLySach = quanLySach;
        defaultTableModel = (DefaultTableModel) viewQuanLySach.getjTable1().getModel();
        
        // add button
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnThem(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnSua(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnXoa(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnTimKiem(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnXacNhan(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnChonAnh(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnLammoi(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnNhapExcel(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnQuayLaij(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnThongKe(), this);
        this.viewQuanLySach.addButtonListener(viewQuanLySach.getBtnXuatExcel(), this);
        this.viewQuanLySach.getjTable1().getSelectionModel().addListSelectionListener(this);
        
        // add combox
        loadSachToTable();
        loadComboBox();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "THÊM":               
                Index =1;
                viewQuanLySach.showButtonThemSua();
                viewQuanLySach.setEnabledTrue();
                viewQuanLySach.setEnabled(false);
                clearPanel(viewQuanLySach.getjPanel1());
                viewQuanLySach.getBtnLammoi().setEnabled(false);
                break;
            case "SỬA":
                Index=0;
                viewQuanLySach.showButtonThemSua();
                viewQuanLySach.setEnabledTrue();
                viewQuanLySach.setEnabled(false);
                viewQuanLySach.getBtnLammoi().setEnabled(false);
                break;
            case "XÓA":
                handleXoa();
                break;
            case "LÀM MỚI":
                handleLamMoi();
                break;
            case "XÁC NHẬN":
                if(Index==1){
                    handleThem();
                    viewQuanLySach.showButton();
                }
                if(Index==0){
                    handleSuaXacNhan();
                    viewQuanLySach.showButton();
                }
                break;
            case "CHỌN ẢNH":
                handleChonAnh();
                break;
            case "QUAY LẠI":
                viewQuanLySach.showButton();
                viewQuanLySach.setEnabledFalse();
                clearPanel(viewQuanLySach.getjPanel1());
                viewQuanLySach.getBtnLammoi().setEnabled(true);
                break;
            case "XUẤT EXCEL":
                handleXuatExcel();
                break;
            case "NHẬP EXCEL":            
                handleNhapExcel();
                break;
            case "Tìm Kiếm":
                handleTimKiem();
                break;
            case "Thông Kê":
                handleThongKe();
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource()==viewQuanLySach.getjTable1().getSelectionModel()){
            if(!e.getValueIsAdjusting()){
                int selectedRow = viewQuanLySach.getjTable1().getSelectedRow();
                if(selectedRow != -1){
                    viewQuanLySach.getBtnSua().setEnabled(true);
                    viewQuanLySach.getBtnXoa().setEnabled(true);
                    viewQuanLySach.getTxtMaSach().setText(defaultTableModel.getValueAt(selectedRow,0).toString());
                    viewQuanLySach.getCbMaNXB().setSelectedItem(defaultTableModel.getValueAt(selectedRow, 1).toString());
                    viewQuanLySach.getCbMaTL().setSelectedItem(defaultTableModel.getValueAt(selectedRow, 2).toString());
                    viewQuanLySach.getCbMaTG().setSelectedItem(defaultTableModel.getValueAt(selectedRow, 3).toString());
                    viewQuanLySach.getTxtTenSach().setText(defaultTableModel.getValueAt(selectedRow, 4).toString());
                    viewQuanLySach.getTxtNXB().setText(defaultTableModel.getValueAt(selectedRow, 5).toString());
                    viewQuanLySach.getTxtSoLuong().setText(defaultTableModel.getValueAt(selectedRow, 6).toString());
                    viewQuanLySach.getTxtDonGia().setText(defaultTableModel.getValueAt(selectedRow, 7).toString());
                    viewQuanLySach.getLabelLinkAnh().setText( defaultTableModel.getValueAt(selectedRow, 8).toString());
                    String imagePath =pathImageBook + defaultTableModel.getValueAt(selectedRow, 8).toString();
                    try{
                       img = ImageIO.read(new File(imagePath));
                    }catch(IOException exception){
                        exception.printStackTrace();
                    }
                    if(img!=null){
                        Image image = img.getScaledInstance(300,200, Image.SCALE_SMOOTH);   
                        ImageIcon icon = new ImageIcon(image);
                        viewQuanLySach.getLabelLinkAnh().setIcon(icon);  
                    }
                }
            }
        }
    }
    
    public void loadSachToTable(){
        ArrayList<SACH> listBook = modelSach.selectAllSach();
        defaultTableModel.setRowCount(0);
        for(SACH book : listBook){
            defaultTableModel.addRow(new Object[]{book.getMaSach(),book.getMaNXB(),book.getMaTL(),book.getMaTG(),book.getTenSach(),book.getNamXB(),book.getSoLuong(),book.getDonGia(),book.getHinhAnh()});
        }
    }
    public void loadComboBox(){
        nhaxuatbans = modelNXB.selectAllNXB();
        authors = modelTG.selectAllTG();
        categorys =  modelTL.selectAllTL();
        loadComBoBoxNXB();
        loadComBoBoxTG();
        loadComBoBoxTL();
        loadComBoBoxNXBSearch();
        loadComBoBoxTGSearch();
        loadComBoBoxTLSearch(); 
    }
    public void handleThem(){
        String MaSach = viewQuanLySach.getTxtMaSach().getText().toString().trim();
        String NXB = viewQuanLySach.getCbMaNXB().getSelectedItem().toString().trim();
        String MaTL = viewQuanLySach.getCbMaTL().getSelectedItem().toString().trim();
        String MaTG = viewQuanLySach.getCbMaTG().getSelectedItem().toString().trim();
        String TenSach = viewQuanLySach.getTxtTenSach().getText().toString().trim();
        int NamXB = Integer.parseInt(viewQuanLySach.getTxtNXB().getText().toString().trim());
        int SoLuong = Integer.parseInt(viewQuanLySach.getTxtSoLuong().getText().toString().trim());
        double DonGia = Double.parseDouble(viewQuanLySach.getTxtDonGia().getText().toString().trim());
        String HinhAnh = viewQuanLySach.getLabelLinkAnh().getText().toString().trim();
        if(MaSach!=null&&NXB!=null&&MaTL!=null&&MaTG!=null&&TenSach!=null && NamXB!=-1 &&SoLuong!=-1 && DonGia!=-1 && HinhAnh!=null){
            int resultSet = modelSach.insertSach(MaSach,NXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh);
            if(resultSet!=0){
                Object[] objects = new Object[]{MaSach,NXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh};
                defaultTableModel.addRow(objects);
                defaultTableModel.fireTableRowsInserted(defaultTableModel.getRowCount()-1, defaultTableModel.getRowCount()-1);
                clearPanel(viewQuanLySach.getjPanel1());
                viewQuanLySach.getBtnSua().setEnabled(false);
                viewQuanLySach.getBtnXoa().setEnabled(false);
                viewQuanLySach.getBtnLammoi().setEnabled(true);
                JOptionPane.showMessageDialog(viewQuanLySach, "Thêm Thành công!");
            }else{
                JOptionPane.showMessageDialog(viewQuanLySach, "Thêm Thất bại!");
            }
        }
    }
    public void handleSuaXacNhan(){
        int selectRow = viewQuanLySach.getjTable1().getSelectedRow();
        if(selectRow == -1){
            JOptionPane.showMessageDialog(viewQuanLySach, "Vui lòng chọn một hàng để sửa!");
            return;
        }
        String MaSach = viewQuanLySach.getTxtMaSach().getText().toString().trim();
        String NXB = viewQuanLySach.getCbMaNXB().getSelectedItem().toString().trim();
        String MaTL = viewQuanLySach.getCbMaTL().getSelectedItem().toString().trim();
        String MaTG = viewQuanLySach.getCbMaTG().getSelectedItem().toString().trim();
        String TenSach = viewQuanLySach.getTxtTenSach().getText().toString().trim();
        int NamXB = Integer.parseInt(viewQuanLySach.getTxtNXB().getText().toString().trim());
        int SoLuong = Integer.parseInt(viewQuanLySach.getTxtSoLuong().getText().toString().trim());
        double DonGia = Double.parseDouble(viewQuanLySach.getTxtDonGia().getText().toString().trim());
        String HinhAnh = viewQuanLySach.getLabelLinkAnh().getText().toString().trim();
        int ressultSet = modelSach.updateSach(MaSach, NXB, MaTL, MaTG, TenSach, NamXB, SoLuong, DonGia,HinhAnh);
        if(ressultSet!=0){
            Object[] objects = new Object[]{MaSach,NXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh};
            defaultTableModel.removeRow(selectRow);
            defaultTableModel.insertRow(selectRow, objects);
            clearPanel(viewQuanLySach.getjPanel1());
            viewQuanLySach.getBtnSua().setEnabled(false);
            viewQuanLySach.getBtnXoa().setEnabled(false);
            viewQuanLySach.getBtnLammoi().setEnabled(true);
            JOptionPane.showMessageDialog(viewQuanLySach,"Sửa Thành Công!");
        }else{
            JOptionPane.showMessageDialog(viewQuanLySach, "Sửa Thất Bại!");
        }
    }
    public void handleChonAnh(){
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp")); 
        int returnValue = jFileChooser.showOpenDialog(null);
        if(returnValue==JFileChooser.APPROVE_OPTION){
            File selecFile = jFileChooser.getSelectedFile();
            String FilePath = selecFile.getAbsolutePath();
            viewQuanLySach.getLabelLinkAnh().setText(selecFile.getName());
            try{
                img = ImageIO.read(new File(FilePath));
                
            }catch(IOException exception){
                exception.printStackTrace();
            }
            if(img!=null){
                Image image = img.getScaledInstance(300,200, Image.SCALE_SMOOTH);   
                ImageIcon icon = new ImageIcon(image);
                viewQuanLySach.getLabelLinkAnh().setIcon(icon);  
            }
        }
    }
    public void handleXoa(){
        int selectRow = viewQuanLySach.getjTable1().getSelectedRow();
        if(selectRow == -1){
            JOptionPane.showMessageDialog(viewQuanLySach, "Vui lòng chọn một hàng để xóa! ");
            return;
        }
        String MaSach = viewQuanLySach.getTxtMaSach().getText().toString().trim();
        int resultSet = modelSach.deleteSach(MaSach);
        if(resultSet!=0){
            defaultTableModel.removeRow(selectRow);
            clearPanel(viewQuanLySach.getjPanel1());
            viewQuanLySach.getBtnSua().setEnabled(false);
            viewQuanLySach.getBtnXoa().setEnabled(false);
            JOptionPane.showMessageDialog(viewQuanLySach, "Xóa Thành Công!");
        }
    }
    public void handleTimKiem(){
        ArrayList<SACH> listBook = new ArrayList<>();
        String MaSach = viewQuanLySach.getTxtMaSsach().getText().toString().trim();
        String MaNXB = viewQuanLySach.getCbMasNXB().getSelectedItem().toString().trim();
        String MaTL = viewQuanLySach.getCbMasTL().getSelectedItem().toString().trim();
        String MaTG = viewQuanLySach.getCbMasTG().getSelectedItem().toString().trim();
        String TenSach = viewQuanLySach.getTxtTenSsach().getText().toString().trim();
        String KhoangGiaTu = viewQuanLySach.getTxtKhoangGia1().getText().trim();
        String KhoangGiaDen = viewQuanLySach.getTxtKhoangGia2().getText().trim();
        String NamXBTu = viewQuanLySach.getTxtNamXB1().getText().trim();
        String NamXBDen = viewQuanLySach.getTxtNamXB2().getText().trim();
        listBook = modelSach.searchSach(MaSach, MaNXB, MaTL, MaTG, TenSach, KhoangGiaTu, KhoangGiaDen, NamXBTu, NamXBDen);
        defaultTableModel.setRowCount(0);
        for(SACH book : listBook){
            defaultTableModel.addRow(new Object[]{book.getMaSach(),book.getMaNXB(),book.getMaTL(),book.getMaTG(),book.getTenSach(),book.getNamXB(),book.getSoLuong(),book.getDonGia(),book.getHinhAnh()});
        }
    }
    public void handleNhapExcel(){
        List<SACH> listBooks = new ArrayList<>();
        // get file
        try {
            InputStream inputStream = new FileInputStream(new File(excelFilePath));
            //Get workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);  
            // Get sheet
            XSSFSheet sheet = workbook.getSheet("Books");
             // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while(iterator.hasNext()){
            Row nextRow  = iterator.next();
            if(nextRow.getRowNum() == 0){
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            // read cells and set value for book object
            SACH book = new SACH();
            while(cellIterator.hasNext()){
                // read cell
                Cell cell = cellIterator.next();
                Object objectCellValue =getCellValue(cell);
                if (objectCellValue == null || objectCellValue.toString().isEmpty()) {
                    continue;
                }
                // set value for book object
                int columnIndex = cell.getColumnIndex();
                switch(columnIndex){
                    case 0:
                        book.setMaSach((String) getCellValue(cell));
                        break;
                    case 1:
                        book.setMaNXB((String) getCellValue(cell));
                        break;
                    case 2:
                        book.setMaTL((String) getCellValue(cell));
                        break;
                    case 3:
                         book.setMaTG((String) getCellValue(cell));
                        break;    
                    case 4:
                        book.setTenSach((String)getCellValue(cell));
                        break;    
                    case 5:
                        if(objectCellValue instanceof Double){
                            book.setNamXB(((Double) objectCellValue).intValue());
                        } else {
                            book.setNamXB((Integer) objectCellValue);
                        }
                        break;
                    case 6:
                        if(objectCellValue instanceof Double) {
                            book.setSoLuong(((Double) objectCellValue).intValue());
                        } else {
                            book.setSoLuong((Integer) objectCellValue);
                        }
                        break;
                    case 7:
                        book.setDonGia((Double)getCellValue(cell));
                        break;
                    case 8:
                        book.setHinhAnh((String)getCellValue(cell));
                        break;
                    default:
                        break;
                }
            }
            listBooks.add(book);
        }
        workbook.close();
        inputStream.close();
        for(int i=0;i<listBooks.size();i++){
           if(i>defaultTableModel.getRowCount()-1){
                String MaSach = listBooks.get(i).getMaSach().toString().trim();
                String NXB = listBooks.get(i).getMaNXB().toString().trim();
                String MaTL = listBooks.get(i).getMaTL().toString().trim();
                String MaTG = listBooks.get(i).getMaTG().toString().trim();
                String TenSach = listBooks.get(i).getTenSach().toString().trim();
                int NamXB = listBooks.get(i).getNamXB();
                int SoLuong = listBooks.get(i).getSoLuong();
                double DonGia =listBooks.get(i).getDonGia();
                String HinhAnh = listBooks.get(i).getHinhAnh().toString().trim();
                int resultSet = modelSach.insertSach(MaSach,NXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh);
                defaultTableModel.addRow(new Object[]{MaSach,NXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void handleXuatExcel(){
        ArrayList<SACH> books = new ArrayList<>();
        for(int i=0;i<defaultTableModel.getRowCount();i++){
            String MaSach = (String)defaultTableModel.getValueAt(i, 0);
            String MaNXB = (String) defaultTableModel.getValueAt(i, 1);
            String MaTL = (String)defaultTableModel.getValueAt(i, 2);
            String MaTG = (String)defaultTableModel.getValueAt(i, 3);
            String TenSach =(String)defaultTableModel.getValueAt(i, 4);
            int NamXB = (Integer)defaultTableModel.getValueAt(i, 5);
            int SoLuong = (Integer)defaultTableModel.getValueAt(i, 6);
            double DonGia = (Double)defaultTableModel.getValueAt(i, 7);
            String HinhAnh = (String)defaultTableModel.getValueAt(i, 8);
            
            SACH book = new SACH(MaSach,MaNXB,MaTL,MaTG,TenSach,NamXB,SoLuong,DonGia,HinhAnh);
            books.add(book);
        }
        
        // create workbook
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        
        // create sheet
        SXSSFSheet sheet = workbook.createSheet("Books");
        
        // register the columns you wish to track and compute the column width
        sheet.trackAllColumnsForAutoSizing();
        
        int rowIndex = 0;
        
        // write header
        writeHeader(sheet, rowIndex);
        
        // write Data
        rowIndex++;
        for(SACH book : books){
            SXSSFRow row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(book, row);
            rowIndex++;
        }
        
         // Auto resize column witdth
        int numberOfColumn = 9; // sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        
         // Create file excel
        try{
            File file = new File("D:\\xlsx\\Books.xlsx");
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
        cell.setCellValue("MaSach");
        
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("MaNXB");
        
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("MaTL");
        
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("MaTG");
        
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("TenSach");
        
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("NamXB");
        
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SoLuong");
        
        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("DonGia");
        
        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("AnhSach");
 
    }
    // write data
    private  void writeBook(SACH book,SXSSFRow row){
        if(cellStyleFormatNumber == null){
            // định dạng số 
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            SXSSFWorkbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        SXSSFCell cell = row.createCell(0);
        cell.setCellValue(book.getMaSach());
        
        cell = row.createCell(1);
        cell.setCellValue(book.getMaNXB());
        
        cell = row.createCell(2);
        cell.setCellValue(book.getMaTL());
        
        cell = row.createCell(3);
        cell.setCellValue(book.getMaTG());
        
        cell = row.createCell(4);
        cell.setCellValue(book.getTenSach());
        
        cell = row.createCell(5);
        cell.setCellValue(book.getNamXB());
        
        cell = row.createCell(6);
        cell.setCellValue(book.getSoLuong());
        
        cell = row.createCell(7);
        cell.setCellValue(book.getDonGia());
        
        cell = row.createCell(8);
        cell.setCellValue(book.getHinhAnh());
        

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
    public void handleLamMoi(){
        clearPanel(viewQuanLySach.getjPanel1());
        loadSachToTable();
    }
    public void handleThongKe(){
        ArrayList<String> statisticals = modelSach.ThongKeSach();
        viewQuanLySach.getTxtGiaThapNhat().setText(statisticals.get(0));
        viewQuanLySach.getTxtDonGiaCaoNhat().setText(statisticals.get(1));
        viewQuanLySach.getTxtSoLoaiSach().setText(statisticals.get(2));
        viewQuanLySach.getTxtTongSoSach().setText(statisticals.get(3));
    }
    public void loadComBoBoxNXB(){
        JComboBox<String> cbNXB = viewQuanLySach.getCbMaNXB();
        cbNXB.removeAllItems();
        cbNXB.addItem("");
        for(NHAXUATBAN nhaxuatban : nhaxuatbans){
            cbNXB.addItem(nhaxuatban.getMaNXB());
        }
       
    }
    public void loadComBoBoxTG(){
        JComboBox<String> cbTG = viewQuanLySach.getCbMaTG();
        cbTG.removeAllItems();
        cbTG.addItem("");
         for(TACGIA author : authors){
            cbTG.addItem(author.getMaTG());
        }
    }
    public void loadComBoBoxTL(){
        JComboBox<String> cbTL = viewQuanLySach.getCbMaTL();
        cbTL.removeAllItems();
        cbTL.addItem("");
         for(THELOAI category : categorys){
            cbTL.addItem(category.getMaTL());
        }
    }
    public void loadComBoBoxTLSearch(){
        JComboBox<String> cbTL = viewQuanLySach.getCbMasTL();
        cbTL.removeAllItems();
        cbTL.addItem("");
         for(THELOAI category : categorys){
            cbTL.addItem(category.getMaTL());
        }  
    }
    public void loadComBoBoxTGSearch(){
        JComboBox<String> cbTG = viewQuanLySach.getCbMasTG();
        cbTG.removeAllItems();
        cbTG.addItem("");
         for(TACGIA author : authors){
            cbTG.addItem(author.getMaTG());
        }
    }    
    public void loadComBoBoxNXBSearch(){
        JComboBox<String> cbNXB = viewQuanLySach.getCbMasNXB();
        cbNXB.removeAllItems();
        cbNXB.addItem("");
        for(NHAXUATBAN nhaxuatban : nhaxuatbans){
            cbNXB.addItem(nhaxuatban.getMaNXB());
        }
    }
    public void clearPanel(JPanel jPanel){
        for(Component compoent : jPanel.getComponents()){
            if(compoent instanceof JTextField){
                ((JTextField) compoent).setText("");
            }else if(compoent instanceof JComboBox){
                ((JComboBox) compoent).setSelectedIndex(-1);
            }else if(compoent instanceof JLabel){
                viewQuanLySach.getLabelLinkAnh().setIcon(null);
                viewQuanLySach.getLabelLinkAnh().setText("null");      
            }
        }
    }
}
