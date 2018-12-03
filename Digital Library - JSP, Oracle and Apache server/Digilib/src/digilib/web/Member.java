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

public class Member {
	private String MemberID = null;
	private String Name = null;
	private int Gender = -1;
	private Date Birthday = null;
	private String Address = null;
	private String Phone = null;
	private String Fax = null;
	private String Email = null;
	private String Password = null;
	private String PictureType = null;
	private byte[] Picture = null;
	private Date IssuedDate = null;
	private Date ExpireDate = null;
	private int Status = -1;
	private String GroupID = null;
	private String GroupName = null;
	private int Priority = -1;
	private int MaxBookings = -1;
	private int MaxLoans = -1;
	private int MaxExpansions = -1;
	private int BookingDuration = -1;
	private int LoanDuration = -1;
	private int ExpansionDuration = -1;
	private int MembershipDuration = -1;
	private int ChargeRate = -1;
	private String AudUser = null;
	private Date AudTime = null;
	private boolean Validated = false;

  	public Member() {
  	}

  	private void getData(String newMemberID) throws Exception {
  		digilib.view.Member currentMember = new digilib.view.Member();
  		currentMember.setCriteria("MEMBERID = '" + newMemberID + "'");
  		currentMember.open();
  		if (currentMember.next()) {
  			MemberID = currentMember.getMemberID();
  			Name = currentMember.getName();
  			Gender = currentMember.getGender().intValue();
  			Birthday = currentMember.getBirthday();
  			Address = currentMember.getAddress();
  			Phone = currentMember.getPhone();
  			Fax = currentMember.getFax();
  			Email = currentMember.getEmail();
  			Password = currentMember.getPassword();
  			try {
  				PictureType = currentMember.getPictureType();
  				Picture = currentMember.getPicture();
  			} catch (NullPointerException npe) {}
  			IssuedDate = currentMember.getIssuedDate();
  			ExpireDate = currentMember.getExpireDate();
  			Status = currentMember.getStatus().intValue();
  			GroupID = currentMember.getGroupID();
  			GroupName = currentMember.getGroupName();
  			Priority = currentMember.getPriority().intValue();
  			MaxBookings = currentMember.getMaxBookings().intValue();
  			MaxLoans = currentMember.getMaxLoans().intValue();
  			MaxExpansions = currentMember.getMaxExpansions().intValue();
  			BookingDuration = currentMember.getBookingDuration().intValue();
  			LoanDuration = currentMember.getLoanDuration().intValue();
  			ExpansionDuration = currentMember.getExpansionDuration().intValue();
  			MembershipDuration = currentMember.getMembershipDuration().intValue();
  			ChargeRate = currentMember.getChargeRate().intValue();
  			AudUser = currentMember.getAudUser();
  			AudTime = currentMember.getAudTime();
  		}
  		currentMember.close();
  	}

  	private void freeData() {
		MemberID = null;
		Name = null;
		Gender = -1;
		Birthday = null;
		Address = null;
		Phone = null;
		Fax = null;
		Email = null;
		Password = null;
		PictureType = null;
		Picture = null;
		IssuedDate = null;
		ExpireDate = null;
		Status = -1;
		GroupID = null;
		GroupName = null;
		Priority = -1;
		MaxBookings = -1;
		MaxLoans = -1;
		MaxExpansions = -1;
		BookingDuration = -1;
		LoanDuration = -1;
		ExpansionDuration = -1;
		MembershipDuration = -1;
		ChargeRate = -1;
		AudUser = null;
		AudTime = null;
  	}

  	public boolean validate(String newMemberID,
  						    String newPassword) throws Exception {
  		try {
  			Validated = digilib.view.Member.validate(newMemberID, newPassword);
  			getData(newMemberID);
  		} catch (Exception e) {
  			Validated = false;
  			freeData();
  		}

  		return Validated;
  	}

  	public void invalidate() {
  		Validated = false;
  		freeData();
  	}

  	public boolean isValidated() {
	  	return Validated;
  	}

  	public String getMemberID() {
  		return MemberID;
  	}

  	public String getName() {
  		return Name;
  	}

  	public int getGender() {
  		return Gender;
  	}

  	public Date getBirthday() {
  		return Birthday;
  	}

  	public String getAddress() {
  		return Address;
  	}

  	public String getPhone() {
  		return Phone;
  	}

  	public String getFax() {
  		return Fax;
  	}

  	public String getEmail() {
  		return Email;
  	}

  	public String getPassword() {
  		return Password;
  	}

  	public String getPictureType() {
  		return PictureType;
  	}

  	public byte[] getPicture() {
  		return Picture;
  	}

  	public Date getIssuedDate() {
  		return IssuedDate;
  	}

  	public Date getExpireDate() {
  		return ExpireDate;
  	}

  	public int getStatus() {
  		return Status;
  	}

  	public String getGroupID() {
  		return GroupID;
  	}

  	public String getGroupName() {
  		return GroupName;
  	}

  	public int getPriority() {
  		return Priority;
  	}

  	public int getMaxBookings() {
  		return MaxBookings;
  	}

  	public int getMaxLoans() {
  		return MaxLoans;
  	}

  	public int getMaxExpansions() {
  		return MaxExpansions;
  	}

  	public int getBookingDuration() {
  		return BookingDuration;
  	}

  	public int getLoanDuration() {
  		return LoanDuration;
  	}

  	public int getExpansionDuration() {
  		return ExpansionDuration;
  	}

  	public int getMembershipDuration() {
  		return MembershipDuration;
  	}

  	public int getChargeRate() {
  		return ChargeRate;
  	}

  	public String getAudUser() {
  		return AudUser;
  	}

  	public Date getAudTime() {
  		return AudTime;
  	}
}