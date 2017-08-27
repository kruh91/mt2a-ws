package hr.optimit.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class UtProjectDTO.
 */
public class UtProjectDTO {
	
	/** The id. */
	private Long id;
	
	/** The project name. */
	private String projectName;
	
	/** The project shortname. */
	private String projectShortname;
	
	/** The project start date. */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectStartDate;
	
	/** The project end date. */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectEndDate;
	
	/** The partner id. */
	private Long partnerId;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName the new project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the project shortname.
	 *
	 * @return the project shortname
	 */
	public String getProjectShortname() {
		return projectShortname;
	}

	/**
	 * Sets the project shortname.
	 *
	 * @param projectShortname the new project shortname
	 */
	public void setProjectShortname(String projectShortname) {
		this.projectShortname = projectShortname;
	}

	/**
	 * Gets the project start date.
	 *
	 * @return the project start date
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * Sets the project start date.
	 *
	 * @param projectStartDate the new project start date
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * Gets the project end date.
	 *
	 * @return the project end date
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * Sets the project end date.
	 *
	 * @param projectEndDate the new project end date
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	/**
	 * Gets the partner id.
	 *
	 * @return the partner id
	 */
	public Long getPartnerId() {
		return partnerId;
	}
	
	/**
	 * Sets the partner id.
	 *
	 * @param partnerId the new partner id
	 */
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
}
