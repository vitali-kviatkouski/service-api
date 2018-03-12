/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.tables.pojos;

import com.epam.ta.reportportal.store.jooq.enums.JIssueGroupEnum;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.10.4" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JIssueType implements Serializable {

	private static final long serialVersionUID = -638107265;

	private Integer id;
	private JIssueGroupEnum issueGroup;
	private String locator;
	private String issueName;
	private String abbreviation;
	private String hexColor;

	public JIssueType() {
	}

	public JIssueType(JIssueType value) {
		this.id = value.id;
		this.issueGroup = value.issueGroup;
		this.locator = value.locator;
		this.issueName = value.issueName;
		this.abbreviation = value.abbreviation;
		this.hexColor = value.hexColor;
	}

	public JIssueType(Integer id, JIssueGroupEnum issueGroup, String locator, String issueName, String abbreviation, String hexColor) {
		this.id = id;
		this.issueGroup = issueGroup;
		this.locator = locator;
		this.issueName = issueName;
		this.abbreviation = abbreviation;
		this.hexColor = hexColor;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JIssueGroupEnum getIssueGroup() {
		return this.issueGroup;
	}

	public void setIssueGroup(JIssueGroupEnum issueGroup) {
		this.issueGroup = issueGroup;
	}

	public String getLocator() {
		return this.locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getIssueName() {
		return this.issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getHexColor() {
		return this.hexColor;
	}

	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("JIssueType (");

		sb.append(id);
		sb.append(", ").append(issueGroup);
		sb.append(", ").append(locator);
		sb.append(", ").append(issueName);
		sb.append(", ").append(abbreviation);
		sb.append(", ").append(hexColor);

		sb.append(")");
		return sb.toString();
	}
}