package digilib.view;

/**
 * Title:        D I G I L I B - Views Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.io.*;
import java.sql.*;
import java.util.Date;
import oracle.sql.BLOB;
import digilib.util.DBConnectionManager;

public class Registration extends View {
  /**Registration Properties**/
  private static String RegistrationNo = "REGISTRATIONNO";
  private static String Name = "NAME";
  private static String Gender = "GENDER";
  private static String Birthday = "BIRTHDAY";
  private static String Address = "ADDRESS";
  private static String Phone = "PHONE";
  private static String Fax = "FAX";
  private static String Email = "EMAIL";
  private static String Password = "PASSWORD";
  private static String PictureType = "PICTURETYPE";
  private static String Picture = "PICTURE";

  public Registration() {
    this.TableName = "REGISTRATION";
    this.OrderBy = "ORDER BY REGISTRATIONNO";
  }

  public static boolean add(String newName,
                            Integer newGender,
                            Date newBirthday,
                            String newAddress,
                            String newPhone,
                            String newFax,
                            String newEmail,
                            String newPassword,
                            String newPictureType,
                            byte[] newPicture) throws Exception {
    boolean result = false;
    Connection conn = DBConnectionManager.getInstance().getConnection();
    CallableStatement cstm = conn.prepareCall("{?=call REGISTRATIONS.ADD(?,?,?,?,?,?,?,?,?,?)}");
    cstm.registerOutParameter(1, Types.INTEGER);
    cstm.setString(2, newName);
    cstm.setInt(3, newGender.intValue());
    cstm.setDate(4, new java.sql.Date(newBirthday.getTime()));
    cstm.setString(5, newAddress);
    cstm.setString(6, newPhone);
    cstm.setString(7, newFax);
    cstm.setString(8, newEmail);
    cstm.setString(9, newPassword);
    cstm.setString(10, newPictureType);
    if (newPicture != null && newPicture.length > 0) {
      ByteArrayInputStream bPicture = new ByteArrayInputStream(newPicture);
      cstm.setBinaryStream(11,  bPicture, newPicture.length);
    } else {
      cstm.setBlob(11, (Blob)BLOB.empty_lob());
    }
    cstm.execute();
    if (cstm.getInt(1) == 1) {
      result = true;
    }
    cstm.close();
    DBConnectionManager.getInstance().freeConnection(conn);
    return result;
  }
  
  public static boolean remove(Long newRegistrationNo,
  							   String newAudUser) throws Exception {
    boolean result = false;
    Connection conn = DBConnectionManager.getInstance().getConnection();
    CallableStatement cstm = conn.prepareCall("{?=call REGISTRATIONS.REMOVE(?,?)}");
    cstm.registerOutParameter(1, Types.INTEGER);
    cstm.setLong(2, newRegistrationNo.longValue());
    cstm.setString(3, newAudUser);
    cstm.execute();
    if (cstm.getInt(1) == 1) {
      result = true;
    }
    cstm.close();
    DBConnectionManager.getInstance().freeConnection(conn);
    return result;
  }

  public Long getRegistrationNo() throws SQLException {
    return this.getLong(RegistrationNo);
  }

  public String getName() throws SQLException {
    return this.getString(Name);
  }

  public Integer getGender() throws SQLException {
    return this.getInteger(Gender);
  }

  public Date getBirthday() throws SQLException {
    return this.getDate(Birthday);
  }

  public String getAddress() throws SQLException {
    return this.getString(Address);
  }

  public String getPhone() throws SQLException {
    return this.getString(Phone);
  }

  public String getFax() throws SQLException {
    return this.getString(Fax);
  }

  public String getEmail() throws SQLException {
    return this.getString(Email);
  }

  public String getPassword() throws SQLException {
    return this.getString(Password);
  }

  public String getPictureType() throws SQLException {
    return this.getString(PictureType);
  }

  public byte[] getPicture() throws SQLException {
    Blob blobPicture = this.getBlob(Picture);
    byte[] bPicture = new byte[(int)blobPicture.length()];
    bPicture = blobPicture.getBytes(1, (int)blobPicture.length());
    return bPicture;
  }
}