package digilib.util;

/**
 * Title:        D I G I L I B - Utilities Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.util.*;
import java.sql.*;
import digilib.util.*;

public class DBConnectionManager extends ConnectionPool {
  private static DBConnectionManager instance = null;

  private static String driver = null;
  private static String url = null;
  private static String username = null;
  private static String password = null;
  private static int initialConnections = 0;
  private static int maxConnections = 0;
  private static boolean waitIfBusy = false;

  private DBConnectionManager(String driver,
                              String url,
                              String username,
                              String password,
                              int initialConnections,
                              int maxConnections,
                              boolean waitIfBusy) throws SQLException {
    super(driver, url, username, password, initialConnections, maxConnections, waitIfBusy);
  }

  public static void setParameters(String newDriver,
                              	   String newUrl,
                              	   String newUsername,
                              	   String newPassword,
                              	   int newInitialConnections,
                              	   int newMaxConnections,
                              	   boolean newWaitIfBusy) {
    driver = newDriver;
    url = newUrl;
    username = newUsername;
    password = newPassword;
    initialConnections = newInitialConnections;
    maxConnections = newMaxConnections;
    waitIfBusy = newWaitIfBusy;
  }

  public static DBConnectionManager getInstance() throws Exception {
    if (instance == null) {
      instance = new DBConnectionManager(driver,
                                         url,
                                         username,
                                         password,
                                         initialConnections,
                                         maxConnections,
                                         waitIfBusy);
    }
    return instance;
  }
}