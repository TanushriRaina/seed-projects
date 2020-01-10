package demo.test1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicine_tbl")
public class Medicine {

	@Id
	@Column(name="medicineId")
	private int medicineId;
	
	@Column(name="medicineName")
	private String medicineName;
	
	public Medicine() {
		
	}

	public Medicine(int medicineId, String medicineName) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + "]";
	}
	
	

}
