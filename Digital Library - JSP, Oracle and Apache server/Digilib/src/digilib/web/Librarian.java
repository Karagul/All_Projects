package digilib.web;

/**
 * Title:        D I G I L I B - Web Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import digilib.view.*;
import java.util.Date;

public class Librarian {
	private String LibrarianID = null;
	private String Name = null;
	private String Password = null;
	private int Status = -1;
	private String AudUser = null;
	private Date AudTime = null;
	private boolean Validated = false;

	public Librarian() {
  	}

  	private void getData(String newLibrarianID) throws Exception {
  		digilib.view.Librarian currentLibrarian = new digilib.view.Librarian();
  		currentLibrarian.setCriteria("LIBRARIANID = '" + newLibrarianID.toUpperCase() + "'");
  		currentLibrarian.open();
  		if (currentLibrarian.next()) {
  			LibrarianID = currentLibrarian.getLibrarianID();
  			Name = currentLibrarian.getName();
  			Password = currentLibrarian.getPassword();
  			Status = currentLibrarian.getStatus().intValue();
  			AudUser = currentLibrarian.getAudUser();
  			AudTime = currentLibrarian.getAudTime();
  		}
  		currentLibrarian.close();
  		currentLibrarian = null;
  	}

  	private void freeData() {
  		LibrarianID = null;
  		Name = null;
  		Password = null;
  		Status = -1;
  		AudUser = null;
  		AudTime = null;
  	}

  	public boolean validate(String newLibrarianID,
  							String newPassword) {
		try {
			Validated = digilib.view.Librarian.validate(newLibrarianID, newPassword);
			if (Validated) {
				getData(newLibrarianID);
			}
		} catch (Exception e) {
			Validated = false;
			freeData();
		}
		return Validated;
  	}

  	public boolean isValidated() {
  		return Validated;
  	}

  	public void invalidate() {
  		Validated = false;
  		freeData();
  	}

  	public String getLibrarianID() {
  		return LibrarianID;
  	}

  	public String getName() {
  		return Name;
  	}

  	public String getPassword() {
  		return Password;
  	}

  	public int getStatus() {
  		return Status;
  	}

  	public String getAudUser() {
  		return AudUser;
  	}

  	public Date getAudTime() {
  		return AudTime;
  	}
}