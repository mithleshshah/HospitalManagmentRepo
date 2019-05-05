package com.mith.model;

public class BedAllotment {

public static String Bno;
public static String Ward;
public static String patient;
public static String AllotmentDate;
public static String DischargeDate;
public static String getBno() {
	return Bno;
}
public static void setBno(String bno) {
	Bno = bno;
}

public static String getWard() {
	return Ward;
}
public static void setWard(String ward) {
	Ward = ward;
}
public static String getPatient() {
	return patient;
}
public static void setPatient(String patient) {
	BedAllotment.patient = patient;
}
public static String getAllotmentDate() {
	return AllotmentDate;
}
public static void setAllotmentDate(String allotmentDate) {
	AllotmentDate = allotmentDate;
}
public static String getDischargeDate() {
	return DischargeDate;
}
public static void setDischargeDate(String dischargeDate) {
	DischargeDate = dischargeDate;
}


}
