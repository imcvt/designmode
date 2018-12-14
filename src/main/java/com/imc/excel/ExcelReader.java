package com.imc.excel;

import java.sql.*;

/**
 * @author luoly
 * @date 2018/12/14 10:48
 * @description  代码仅代参考 实际运行并不成功
 */
public class ExcelReader {
    public static String readExcel(String ODBCEntry, String sheetNumber) {
        StringBuffer ret = new StringBuffer(1000);
        try{
            Class.forName("com.sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:"+ODBCEntry);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from [Sheet]"+ sheetNumber + "$]");
            ResultSetMetaData rsmetaData = rs.getMetaData();
            int numOfColumns = rsmetaData.getColumnCount();

            while(rs.next()) {
                for(int i = 1; i<= numOfColumns; i++) {
                    if(i == 1) ret.append(",");
                    ret.append(rs.getString(i));
                }
                ret.append("\n");
            }
            stmt.close();
            rs.close();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            return ret.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(readExcel("myExcelFile", "1"));
    }
}
