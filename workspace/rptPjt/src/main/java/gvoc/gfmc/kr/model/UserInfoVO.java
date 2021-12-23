package gvoc.gfmc.kr.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoVO implements UserDetails {

	/**
	 * This VO is for security.
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String pw;
	private String userNm;
	private String userOgdp;
	private String userTeam;
	private String userTelno;
	private String applyYn;
	private String inptUser;
	private String inptDt;
	private String updtUser;
	private String updtDt;
	private String userRoles;

	public String getInptUser() {
		return inptUser;
	}

	public void setInptUser(String inptUser) {
		this.inptUser = inptUser;
	}

	public String getUpdtUser() {
		return updtUser;
	}

	public void setUpdtUser(String updtUser) {
		this.updtUser = updtUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(userRoles));
		return auth;
	}


	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", pw=" + pw + ", userNm=" + userNm + ", userOgdp=" + userOgdp + ", userTeam="
				+ userTeam + ", userTelno=" + userTelno + ", applyYn=" + applyYn + ", inptUser=" + inptUser
				+ ", inptDt=" + inptDt + ", updtUser=" + updtUser + ", updtDt=" + updtDt + ", userRoles=" + userRoles
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserOgdp() {
		return userOgdp;
	}

	public void setUserOgdp(String userOgdp) {
		this.userOgdp = userOgdp;
	}

	public String getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(String userTeam) {
		this.userTeam = userTeam;
	}

	public String getUserTelno() {
		return userTelno;
	}

	public void setUserTelno(String userTelno) {
		this.userTelno = userTelno;
	}

	public String getApplyYn() {
		return applyYn;
	}

	public void setApplyYn(String applyYn) {
		this.applyYn = applyYn;
	}

	public String getInptDt() {
		return inptDt;
	}

	public void setInptDt(String inptDt) {
		this.inptDt = inptDt;
	}

	public String getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userNm;
	}

}