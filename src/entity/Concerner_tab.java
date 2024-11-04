package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Concerner_tab implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="Numcom")
	private long Numcom;
	@Column(name="Numfact")
	private long Numfact;
	@Column(name="Codeart")
	private long Codeart;
	
	public Concerner_tab() {}
	public Concerner_tab(long numcom, long numfact, long codeart) {
		super();
		Numcom = numcom;
		Numfact = numfact;
		Codeart = codeart;
	}
	public long getNumcom() {
		return Numcom;
	}
	public void setNumcom(long numcom) {
		Numcom = numcom;
	}
	public long getNumfact() {
		return Numfact;
	}
	public void setNumfact(long numfact) {
		Numfact = numfact;
	}
	public long getCodeart() {
		return Codeart;
	}
	public void setCodeart(long codeart) {
		Codeart = codeart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
