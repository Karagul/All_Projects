package digilib.web;

/**
 * Title:        D I G I L I B - Web Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.util.Date;
import digilib.view.Registration;

public class Guess {

  public static boolean register(String newName,
                                 int newGender,
                                 Date newBirthday,
                                 String newAddress,
                                 String newPhone,
                                 String newFax,
                                 String newEmail,
                                 String newPassword,
                                 String newPictureType,
                                 byte[] newPicture) throws Exception {
    return Registration.add(newName,
                            new Integer(newGender),
                            newBirthday,
                            newAddress,
                            newPhone,
                            newFax,
                            newEmail,
                            newPassword,
                            newPictureType,
                            newPicture);
  }
}