package br.com.customerbase.models;

import java.io.Serializable;

public class Email implements Serializable{

	private static final long serialVersionUID = 6191860679724251651L;
	
	
	private String address;
	private String username;
	private String domain;
	private String md5Hash;
	private String suggestion;
	private Boolean validFormat;
	private Boolean deliverable;
	private Boolean fullInbox;
	private Boolean hostExists;
	private Boolean catchAll;
	private Boolean gravatar;
	private Boolean role;
	private Boolean disposable;
	private Boolean free;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getMd5Hash() {
		return md5Hash;
	}
	public void setMd5Hash(String md5Hash) {
		this.md5Hash = md5Hash;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public Boolean getValidFormat() {
		return validFormat;
	}
	public void setValidFormat(Boolean validFormat) {
		this.validFormat = validFormat;
	}
	public Boolean getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(Boolean deliverable) {
		this.deliverable = deliverable;
	}
	public Boolean getFullInbox() {
		return fullInbox;
	}
	public void setFullInbox(Boolean fullInbox) {
		this.fullInbox = fullInbox;
	}
	public Boolean getHostExists() {
		return hostExists;
	}
	public void setHostExists(Boolean hostExists) {
		this.hostExists = hostExists;
	}
	public Boolean getCatchAll() {
		return catchAll;
	}
	public void setCatchAll(Boolean catchAll) {
		this.catchAll = catchAll;
	}
	public Boolean getGravatar() {
		return gravatar;
	}
	public void setGravatar(Boolean gravatar) {
		this.gravatar = gravatar;
	}
	public Boolean getRole() {
		return role;
	}
	public void setRole(Boolean role) {
		this.role = role;
	}
	public Boolean getDisposable() {
		return disposable;
	}
	public void setDisposable(Boolean disposable) {
		this.disposable = disposable;
	}
	public Boolean getFree() {
		return free;
	}
	public void setFree(Boolean free) {
		this.free = free;
	}
	
	
}
