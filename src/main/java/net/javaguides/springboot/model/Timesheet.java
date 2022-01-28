package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timesheets")
public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "login_time")
	private String loginTime;

	@Column(name = "logout_time")
	private String logoutTime;

	@Column(name = "curr_date")
	private String currentDate;

	public Timesheet() {

	}

	public Timesheet(String loginTime, String logoutTime, String currentDate) {
		super();
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.currentDate = currentDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getCurrDate() {
		return currentDate;
	}

	public void setCurrDate(String currentDate) {
		this.currentDate = currentDate;
	}
}
