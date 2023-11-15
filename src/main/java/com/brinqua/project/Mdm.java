package com.brinqua.project;

public class Mdm {
	private String enrollment_status;
	private String server_url;
	private String name;
	private boolean encryption_key_available;

	public String getEnrollment_status() {
		return enrollment_status;
	}

	public void setEnrollment_status(String enrollment_status) {
		this.enrollment_status = enrollment_status;
	}

	public String getServer_url() {
		return server_url;
	}

	public void setServer_url(String server_url) {
		this.server_url = server_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEncryption_key_available() {
		return encryption_key_available;
	}

	public void setEncryption_key_available(boolean encryption_key_available) {
		this.encryption_key_available = encryption_key_available;
	}

}
