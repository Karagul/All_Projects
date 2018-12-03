package digilib.view;

/**
 * Title:        D I G I L I B - Views Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.sql.Types;
import digilib.util.DBConnectionManager;

public class View {
  /**View Properties*/
  protected String TableName = "";
  protected String OrderBy = " ";

  /**Records options*/
  private int MaxRows = 1000;
  private int PageSize = 20;
  private int TotalPages = 0;
  private int Page = 1;
  private int Row = 0;
  private String Criteria = null;

  /**Data Storage*/
  private Connection conn = null;
  private Statement stm = null;
  private ResultSet rs = null;

  public View() {
  }

  /**Records navigation*/
  public boolean first() throws SQLException {
    boolean result = false;
    Row = 1;
    if (Page > 0) {
      result = rs.absolute(Page * PageSize + Row);
    } else {
      result = rs.first();
    }
    return result;
  }

  public boolean last() throws SQLException {
    boolean result = false;
    Row = PageSize;
    if (Page < TotalPages) {
      result = rs.absolute(Page * PageSize + Row);
    } else {
      result = rs.last();
    }
    return result;
  }

  public boolean previous() throws SQLException {
    boolean result = false;
    if (Row > 1) {
      Row--;
      result = rs.previous();
    } else {
      result = false;
    }
    return result;
  }

  public boolean next() throws SQLException {
    boolean result = false;
    if (Row < PageSize) {
      Row++;
      result = rs.next();
    } else {
      result = false;
    }
    return result;
  }

  public boolean absolute(int row) throws SQLException {
    boolean result = false;
    if (row > 0 && row <= PageSize) {
      Row = row;
      result = rs.absolute(Page * PageSize + Row);
    } else {
      result = false;
    }
    return result;
  }

  public boolean relative(int rows) throws SQLException {
    boolean result = false;
    if (Row + rows > 0 && Row + rows <= PageSize) {
      Row += rows;
      result = rs.relative(rows);
    } else {
      result = false;
    }
    return result;
  }

  public boolean page(int newPage) throws SQLException {
    boolean result = true;
    if (newPage > 0 && newPage <= TotalPages) {
      Page = newPage;
      Row = 0;
      if (Page > 1) {
        result = rs.absolute((Page - 1) * PageSize);
      } else {
        rs.beforeFirst();
        result = true;
      }
    }
    else {
      result = false;
    }
    return result;
  }

  /**Data Options*/
  public int getMaxRows() {
    return MaxRows;
  }

  public int getPageSize() {
    return PageSize;
  }

  public void setPageSize(int newPageSize) {
    if (newPageSize > 0) {
      PageSize = newPageSize;
    }
  }

  public int getPage() {
    return Page;
  }

  public void setPage(int newPage) {
    if (newPage > 0) {
      Page = newPage;
    }
  }

  public int getTotalPages() {
    return TotalPages;
  }

  public String getCriteria() {
    return Criteria;
  }

  public void setCriteria(String newCriteria) {
    Criteria = newCriteria;
  }

  /**Data Actions*/
  public boolean open() throws Exception {
    conn = DBConnectionManager.getInstance().getConnection();
    stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_UPDATABLE);
    stm.setMaxRows(MaxRows);
    stm.setFetchSize(PageSize);
    stm.setFetchDirection(ResultSet.FETCH_FORWARD);
    String stCriteria = "";
    if (Criteria != null && !Criteria.trim().equals("")) {
      stCriteria += " WHERE ";
      stCriteria += Criteria;
    }
    rs = stm.executeQuery("select count(ROWNUM) from " + TableName + " " + stCriteria);
    rs.next();
    MaxRows = rs.getInt(1);
    rs = stm.executeQuery("select * from " + TableName + " " + stCriteria + " " + OrderBy);
    if (MaxRows > stm.getMaxRows()) {
      MaxRows = stm.getMaxRows();
    }
    TotalPages = (MaxRows / PageSize) + ((MaxRows % PageSize == 0 ? 0 : 1));
    if (Page > TotalPages) {
      Page = TotalPages;
    }
    this.page(Page);
    return true;
  }

  public boolean close() throws Exception {
    rs.close();
    stm.close();
    DBConnectionManager.getInstance().freeConnection(conn);
    return true;
  }

  public boolean refresh() throws Exception {
    return (close() && open());
  }

  /**Data Manipulation**/
  protected String getString(int Field) throws SQLException {
    return rs.getString(Field);
  }

  protected String getString(String Field) throws SQLException {
    return rs.getString(Field);
  }

  protected Date getDate(int Field) throws SQLException {
    return new Date(rs.getTimestamp(Field).getTime());
  }

  protected Date getDate(String Field) throws SQLException {
    return new Date(rs.getTimestamp(Field).getTime());
  }

  protected Integer getInteger(int Field) throws SQLException {
    return new Integer(rs.getInt(Field));
  }

  protected Integer getInteger(String Field) throws SQLException {
    return new Integer(rs.getInt(Field));
  }

  protected Long getLong(int Field) throws SQLException {
    return new Long(rs.getLong(Field));
  }

  protected Long getLong(String Field) throws SQLException {
    return new Long(rs.getLong(Field));
  }

  protected Blob getBlob(int Field) throws SQLException {
    return rs.getBlob(Field);
  }

  protected Blob getBlob(String Field) throws SQLException {
    return rs.getBlob(Field);
  }
}