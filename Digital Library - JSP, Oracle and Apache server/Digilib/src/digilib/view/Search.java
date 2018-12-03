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
import java.util.StringTokenizer;
import digilib.web.Format;

public class Search {
	private static String[] sFields =  {"PRIMARYTITLE",
										"OTHERTITLE",
										"NOTE",
										"EDITION",
										"IMPRINT",
										"PHYSICALDESCRIPTION",
										"AUTHOR",
										"LANGUAGE",
										"FORMAT",
										"DDCID",
										"CLASSIFICATION",
										"KEYWORD"};
	
	public static String doQuickSearch(String newSearchCondition,
									   String newSearchType,
									   String newSearchContent) throws Exception {

		String sSearchContent = digilib.web.Format.replace(newSearchContent, "'", "''");									 
		
		int Condition = Integer.parseInt(newSearchCondition);
		int Type = Integer.parseInt(newSearchType);
		
		StringTokenizer Content = new StringTokenizer(newSearchContent, " ");
		
		int totalWords = Content.countTokens();
		
		String[] sContent = new String[totalWords];
		
		for (int i = 0; i < totalWords; i++) {
			sContent[i] = (String)Content.nextElement();
		}
		
		String sCriteria = "SELECT DISTINCT ITEMNO FROM SEARCHVIEW ";
		String sOperator = "";
		if (Type == 1 && Condition == 0) { //bang chuoi
			for (int i = 0; i < 12; i++) {
				if (i > 0) {
					sOperator += " OR ";
				}
				sOperator += "lower(" + sFields[i] + ") = lower('" + sSearchContent.toLowerCase() + "') ";
			}
		} else if (Type == 0 && Condition == 0) { //bang tu
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < totalWords; j++) {
					if (!(i + j == 0)) {
						sOperator += " OR ";
					}
					sOperator += "lower(" + sFields[i] + ") = lower('" + sContent[j].toLowerCase() + "') ";
				}
			}
		} else if (Type == 1 && Condition == 1) { //chua chuoi
			for (int i = 0; i < 12; i++) {
				if (i > 0) {
					sOperator += " OR ";
				}
				sOperator += "lower(" + sFields[i] + ")like lower('%" + sSearchContent.toLowerCase() + "%') ";
			}
		} else if (Type == 0 && Condition == 1) { //chua tu
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < totalWords; j++) {
					if (!(i + j == 0)) {
						sOperator += " OR ";
					}
					sOperator += "lower(" + sFields[i] + ") like lower('%" + sContent[j].toLowerCase() + "%') ";
				}
			}
		}
		
		if (!sOperator.trim().equals("")) {
			sCriteria += " WHERE " + sOperator;
		}
		
		return (sCriteria);
		
	}
	
}