/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.service.LogService;
import apn.gob.pe.secajur.service.LogServiceImpl;
import apn.gob.pe.secajur.utiles.GestSesion;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;

/**
 *
 * @author eshupingahua
 */
@ManagedBean(name = "mbexportador")
public class MBExportador {

    private LogService logService = new LogServiceImpl();
    private GestSesion sesionusuario = new GestSesion();

    /**
     * Creates a new instance of MBExportador
     */
    public MBExportador() {
    }

    public void postExportarXLSSub(Object document) throws FileNotFoundException, IOException {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        wb.setSheetName(0, "Reporte Seguimiento Casos Legales - UAJ");
        HSSFSheet sheet = wb.getSheetAt(0);

        //agregar imagen
        //http://www.mysamplecode.com/2012/06/apache-poi-excel-insert-image.html
        /*  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        InputStream inputStream = new FileInputStream(externalContext.getRealPath("") + File.separator + "resources" + File.separator + "img/logotipo.jpg");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        CreationHelper helper = wb.getCreationHelper();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(1);
        anchor.setRow1(2);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();*/
        //terina agregar imagen
        // HEADER
        HSSFFont headerFont;
        headerFont = wb.createFont();
        headerFont.setFontName(HSSFFont.FONT_ARIAL);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setColor(HSSFColor.WHITE.index);

        HSSFCellStyle headerStyle;
        headerStyle = wb.createCellStyle();
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
        headerStyle.setFillBackgroundColor(HSSFColor.RED.index);

        HSSFCellStyle cellStyle_header = wb.createCellStyle();
        cellStyle_header.setFillForegroundColor(HSSFColor.RED.index);
        cellStyle_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_header.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setFillBackgroundColor(HSSFColor.WHITE.index);
        cellStyle_header.setWrapText(false);
        cellStyle_header.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn((short) i);
        }

        Font font_header = wb.createFont();
        font_header.setFontHeightInPoints((short) 12);
        // font_header.setFontName("Calibri Light");
        font_header.setItalic(true);
        font_header.setColor(HSSFColor.WHITE.index);
        cellStyle_header.setFont(font_header);

        //CABECERA
        for (int ii = 0; ii < sheet.getPhysicalNumberOfRows(); ii++) {
            for (int i = 0; i < sheet.getRow(ii).getPhysicalNumberOfCells(); i++) {
                HSSFCell cell = sheet.getRow(ii).getCell(i);
                if (cell.getRow().getCell(0).toString().equals("Expediente")) {
                    cell.setCellStyle(cellStyle_header);
                }
            }
        }

    }

    public void postExportarXLS(Object document) throws FileNotFoundException, IOException {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        wb.setSheetName(0, "Reporte Seguimiento Casos Legales - UAJ");
        HSSFSheet sheet = wb.getSheetAt(0);

        //agregar imagen
        //http://www.mysamplecode.com/2012/06/apache-poi-excel-insert-image.html
        /*  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        InputStream inputStream = new FileInputStream(externalContext.getRealPath("") + File.separator + "resources" + File.separator + "img/logotipo.jpg");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        CreationHelper helper = wb.getCreationHelper();
        Drawing drawing = sheet.createDrawingPatriarch(); 
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(1);
        anchor.setRow1(2);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();*/
        //terina agregar imagen
        // HEADER
        HSSFFont headerFont;
        headerFont = wb.createFont();
        headerFont.setFontName(HSSFFont.FONT_ARIAL);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setColor(HSSFColor.WHITE.index);

        HSSFCellStyle headerStyle;
        headerStyle = wb.createCellStyle();
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
        headerStyle.setFillBackgroundColor(HSSFColor.RED.index);

        HSSFCellStyle cellStyle_header = wb.createCellStyle();
        cellStyle_header.setFillForegroundColor(HSSFColor.RED.index);
        cellStyle_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_header.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_header.setFillBackgroundColor(HSSFColor.WHITE.index);
        cellStyle_header.setWrapText(false);
        cellStyle_header.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn((short) i);

        }

        Font font_header = wb.createFont();
        font_header.setFontHeightInPoints((short) 12);
        // font_header.setFontName("Calibri Light");
        font_header.setItalic(true);
        font_header.setColor(HSSFColor.WHITE.index);
        cellStyle_header.setFont(font_header);

        //CABECERA
        for (int ii = 0; ii < sheet.getPhysicalNumberOfRows(); ii++) {
            for (int i = 0; i < sheet.getRow(ii).getPhysicalNumberOfCells(); i++) {
                HSSFCell cell = sheet.getRow(ii).getCell(i);
                if (cell.getRow().getCell(0).toString().equals("Expediente")) {
                    cell.setCellStyle(cellStyle_header);
                }
            }
        }

        logService.grabarLogUser("Exportar", "El usuario exportó la información de todos los casos", sesionusuario.obtenerUsuarioSesion());

    }

}
