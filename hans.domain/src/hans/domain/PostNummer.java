package hans.domain;
/**
 * Domain-class for concept postnummer
 * 
 * @author hi
 *
 */
public class PostNummer {
	private String postnr;
	private String by;
	
	
	public String getPostnr() {
		return postnr;
	}
	public void setPostnr(String postnr) {
		this.postnr = postnr;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	@Override
	public String toString() {
		return "PostNummer [postnr=" + postnr + ", by=" + by + "]";
	}
	
}
