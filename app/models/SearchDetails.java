package models;


public class SearchDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904680028570191877L;
	private  String keyword;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchDetails [keyword=" + keyword + "]";
	}

}
