package com.app.HealthConsultancyServices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity  
	@Table 
	public class Prescription {
		
		@Id  
		@Column
		private int prescriptionid;
		@Column
		private String doctorname;
		@Column
		private String patientname;
		@Column
		private String date;
		@Column
		private String age;
		@Column
		private String gender;
		@Column
		private String department;
		@Column
		private String prescribe;
		public int getPrescriptionid() {
			return prescriptionid;
		}
		public void setPrescriptionid(int prescriptionid) {
			this.prescriptionid = prescriptionid;
		}
		public String getDoctorname() {
			return doctorname;
		}
		public void setDoctorname(String doctorname) {
			this.doctorname = doctorname;
		}
		public String getPatientname() {
			return patientname;
		}
		public void setPatientname(String patientname) {
			this.patientname = patientname;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getPrescribe() {
			return prescribe;
		}
		public void setPrescribe(String prescribe) {
			this.prescribe = prescribe;
		}
}
