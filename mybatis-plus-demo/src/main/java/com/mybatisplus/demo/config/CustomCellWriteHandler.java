package com.mybatisplus.demo.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zgf
 * @description TODO
 * @time 2020/9/18 10:37
 */
@Slf4j
public class CustomCellWriteHandler /*implements CellWriteHandler*/ {
    /*//标黄行宽集合
    private Set<Integer> yellowRowIndexs;

    //构造
    public CustomCellWriteHandler(Set<Integer> yellowRowIndexs) {
        this.yellowRowIndexs = yellowRowIndexs;
    }

    public CustomCellWriteHandler() {
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head,
                                 Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
        log.info("beforeCellCreate~~~~");
    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
                                Head head, Integer relativeRowIndex, Boolean isHead) {
        log.info("afterCellCreate~~~~");
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                       CellData cellData, Cell cell, Head head, Integer relativeRowIndex,
                                       Boolean isHead) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList,
                                 Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        // 这里可以对cell进行任何操作
        log.info("第{}行，第{}列写入完成。", cell.getRowIndex(), cell.getColumnIndex());
        if (CollectionUtils.isNotEmpty(yellowRowIndexs)) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            //字体
            Font cellFont = workbook.createFont();
            cellFont.setBold(true);
            cellStyle.setFont(cellFont);
            //标黄,要一起设置
            //设置前景填充样式
            //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //前景填充色
            //cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());

            if (yellowRowIndexs.contains(cell.getRowIndex())) {
                cell.setCellStyle(cellStyle);
            }
        }
    }*/
}
