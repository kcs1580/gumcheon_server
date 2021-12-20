package gvoc.gfmc.kr.model;



public class SignVO {

    private String result, message, rscode, token;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRscode() {
		return rscode;
	}

	public void setRscode(String rscode) {
		this.rscode = rscode;
	}

	@Override
	public String toString() {
		return "SignVO [result=" + result + ", message=" + message + ", rscode=" + rscode + ", token=" + token + "]";
	}

	
}