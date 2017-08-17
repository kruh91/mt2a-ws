package hr.optimit.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UtProjectDTO {
	
	private Long id;
	
	private String projectName;
	
	private String projectShortname;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectStartDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectEndDate;
	
	private Long partnerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectShortname() {
		return projectShortname;
	}

	public void setProjectShortname(String projectShortname) {
		this.projectShortname = projectShortname;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public Long getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
}
