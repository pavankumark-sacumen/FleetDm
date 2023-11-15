package com.brinqua.project;

import com.google.gson.annotations.SerializedName;

public class SoftwareValue {
		@SerializedName("id")
	    private int id;

	    @SerializedName("name")
	    private String name;

	    @SerializedName("version")
	    private String version;

	    @SerializedName("source")
	    private String source;

	    @SerializedName("generated_cpe")
	    private String generatedCpe;

	    @SerializedName("vulnerabilities")
	    private Object vulnerabilities; // Change to the appropriate type if you have a class for vulnerabilities

	    @SerializedName("hosts_count")
	    private int hostsCount;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getGeneratedCpe() {
			return generatedCpe;
		}

		public void setGeneratedCpe(String generatedCpe) {
			this.generatedCpe = generatedCpe;
		}

		public Object getVulnerabilities() {
			return vulnerabilities;
		}

		public void setVulnerabilities(Object vulnerabilities) {
			this.vulnerabilities = vulnerabilities;
		}

		public int getHostsCount() {
			return hostsCount;
		}

		public void setHostsCount(int hostsCount) {
			this.hostsCount = hostsCount;
		}
	    

}
