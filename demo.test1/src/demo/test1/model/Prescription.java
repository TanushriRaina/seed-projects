package demo.test1.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Prescription_tbl")
public class Prescription {
	
	@Id
	@Column(name="presId")
	private int presId;
	
	@Column(name="presDate")
	private Date presDate;
	
	//@ManyToOne(cascade = CascadeType.ALL)  
	//@JoinColumn(name="patientId")
	private int patientId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="medicineName")
	private String[] medicineName;
	
	public Prescription() {
		
	}

	public Prescription(int presId, Date presDate) {
		super();
		this.presId = presId;
		this.presDate = presDate;
	}

	public int getPresId() {
		return presId;
	}

	public void setPresId(int presId) {
		this.presId = presId;
	}

	public Date getPresDate() {
		return presDate;
	}

	public void setPresDate(Date presDate) {
		this.presDate = presDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String[] getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String[] medicineName) {
		this.medicineName = medicineName;
	}

	@Override
	public String toString() {
		return "Prescription [presId=" + presId + ", presDate=" + presDate + ", patientId=" + patientId
				+ ", medicineName=" + Arrays.toString(medicineName) + "]";
	}
	
	
}
