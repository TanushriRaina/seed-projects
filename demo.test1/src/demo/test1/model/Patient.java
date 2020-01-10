package demo.test1.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Patient_tbl")
public class Patient {
	
	@Id
	@Column(name="patientId")
	private int patientId;
	
	@Column(name="patientName")
	private String patientName;
	
	@Column(name="patientEmail")
	private String patientEmail;
	
	@Column(name="patientDate")
	private String patientDate;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="prescription")
	List<Prescription> pres;
	
	public Patient() {
		
	}

	public Patient(int patientId, String patientName, String patientEmail, String patientDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientDate = patientDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientDate() {
		return patientDate;
	}

	public void setPatientdate(String patientDate) {
		this.patientDate = patientDate;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientEmail=" + patientEmail
				+ ", patientDate=" + patientDate + "]";
	}
	
}
