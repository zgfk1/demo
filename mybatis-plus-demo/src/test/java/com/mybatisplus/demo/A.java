package com.mybatisplus.demo;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.PdfHeaderSource;
import com.spire.pdf.tables.PdfTable;
import com.spire.pdf.tables.PdfTableDataSourceType;
import com.spire.pdf.tables.PdfTableLayoutFormat;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

/**
 * @author zgf
 * @description TODO
 * @time 2020/9/29 9:33
 */
@Slf4j
public class A {


    public static void main(String[] args) {
        //通过公历构建
        ChineseDate chineseDate = new ChineseDate(DateUtil.parseDate("1997-11-22"));
//        ChineseDate chineseDate = new ChineseDate(DateUtil.parseDate("1994-05-03"));
        // 一月
        System.out.println(chineseDate.getChineseMonth());
        // 正月
        System.out.println(chineseDate.getChineseMonthName());
        // 初一
        System.out.println(chineseDate.getChineseDay());
        // 庚子
        System.out.println(chineseDate.getCyclical());
        // 生肖：鼠
        System.out.println(chineseDate.getChineseZodiac());
        // 传统节日（部分支持，逗号分隔）：春节
        System.out.println(chineseDate.getFestivals());
        // 庚子鼠年 正月初一
        System.out.println(chineseDate.toString());
        // 庚子年甲申月癸卯日
        String cyclicalYMD = chineseDate.getCyclicalYMD();
        System.out.println(cyclicalYMD);
        /*//create a PDF document 创建一个PDF文件
        PdfDocument doc = new PdfDocument();

        //set page margins 设置页边距
        doc.getPageSettings().setMargins(30f,30f,30f,30f);

        //add a page 添加页面
        PdfPageBase page = doc.getPages().add();

        //initialize y coordinate 初始化y坐标
        float y = 0;

        //create a brush 创建画笔
        PdfBrush brush = PdfBrushes.getBlack();

        //create four types of fonts 创建四种类型的字体
        PdfTrueTypeFont titleFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfTrueTypeFont tableFont= new PdfTrueTypeFont(new Font("Arial", 0, 10));
        PdfTrueTypeFont headerFont= new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11));
        PdfTrueTypeFont textFont= new PdfTrueTypeFont(new Font("Arial", 0, 12));

        //draw title on the center of the page 在页面中央绘制标题
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Employee Table", titleFont, brush, page.getCanvas().getClientSize().getWidth() / 2, y, format);

        //calculate y coordinate 计算y坐标
        y = y + (float) titleFont.measureString("Employee Table", format).getHeight();
        y = y + 5;

        //create a PdfTable instance
        PdfTable table = new PdfTable();

        //set the default cell style and row style
        table.getStyle().setCellPadding(2);
        table.getStyle().setBorderPen(new PdfPen(brush, 0.75f));
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getWhite());
        table.getStyle().getDefaultStyle().setFont(tableFont);
        table.getStyle().getDefaultStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightGray());
        table.getStyle().getAlternateStyle().setFont(tableFont);
        table.getStyle().getAlternateStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        //set the header style
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getPurple());
        table.getStyle().getHeaderStyle().setFont(headerFont);
        table.getStyle().getHeaderStyle().setTextBrush(PdfBrushes.getWhite());
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

        //show header at every page
        table.getStyle().setShowHeader(true);

        //connect to database
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + "C:\\Users\\Administrator\\Documents\\data.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement sta = conn.createStatement();
                ResultSet resultSet = sta.executeQuery("select * from user_info ");
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                //export data from database to datatable
                jdbcAdapter.fillDataTable(dataTable, resultSet);
                table.setDataSourceType(PdfTableDataSourceType.Table_Direct);
                //fill the table with datatable
                table.setDataSource(dataTable);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //paginate table
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setLayout(PdfLayoutType.Paginate);

        //draw table at the specified x, y coordinates
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

        //calculate y coordinate
        y = (float) result.getBounds().getHeight() + 5;

        //draw text under the table
        result.getPage().getCanvas().drawString(String.format("* %1$s employees in the list.", table.getRows().getCount()), textFont, brush, 5, y);

        //save pdf file.
        doc.saveToFile("ExportDataToPdf.pdf");*/
    }


}
