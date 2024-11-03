package ecole;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Noter_PK implements Serializable{
	private static final long serialVersionUID= 1L;
	@Column(name="codeMat")
	private String codeMat;
	@Column(name="apogeeEtd")
	private int apogeeEtd;
	
	public Noter_PK(String codeMat, int apogeeEtd) {
		this.codeMat = codeMat;
		this.apogeeEtd = apogeeEtd;
	}
	
	public Noter_PK() {super();}
	
	public String getCodeMat() {return codeMat;}
	public void setCodeMat(String codeMat) {
		this.codeMat = codeMat;
	}
	public int getApogeeEtd() {
		return apogeeEtd;
	}
	public void setApogeeEtd(int apogeeEtd) {
		this.apogeeEtd = apogeeEtd;
	}
}
