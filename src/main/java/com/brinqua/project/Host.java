package com.brinqua.project;

public class Host {
	private String created_at;
	private String updated_at;
	private String software_updated_at;
	private int id;
//	private String detail_updated_at;
//	private String label_updated_at;
//	private String policy_updated_at;
//	private String last_enrolled_at;
//	private String seen_time;
//	private boolean refetch_requested;
	private String hostname;
	private String uuid;
	private String platform;
	private String osquery_version;
	private String os_version;
	private String build;
	private String platform_like;
	private String code_name;
	private long uptime;
	private long memory;
	private String cpu_type;
	private String cpu_subtype;
	private String cpu_brand;
	private int cpu_physical_cores;
	private int cpu_logical_cores;
	private String hardware_vendor;
	private String hardware_model;
	private String hardware_version;
	private String hardware_serial;
	private String computer_name;
	private String public_ip;
	private String primary_ip;
	private String primary_mac;
	private int distributed_interval;
	private int config_tls_refresh;
	private int logger_tls_period;
	private String team_id;
	private String team_name;
	private double gigs_disk_space_available;
	private int percent_disk_space_available;
	private Issues issues;
	private Mdm mdm;
	private String refetch_critical_queries_until;
	private String status;
	private String display_text;
	private String display_name;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getSoftware_updated_at() {
		return software_updated_at;
	}

	public void setSoftware_updated_at(String software_updated_at) {
		this.software_updated_at = software_updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getDetail_updated_at() {
//		return detail_updated_at;
//	}
//
//	public void setDetail_updated_at(String detail_updated_at) {
//		this.detail_updated_at = detail_updated_at;
//	}
//
//	public String getLabel_updated_at() {
//		return label_updated_at;
//	}
//
//	public void setLabel_updated_at(String label_updated_at) {
//		this.label_updated_at = label_updated_at;
//	}
//
//	public String getPolicy_updated_at() {
//		return policy_updated_at;
//	}
//
//	public void setPolicy_updated_at(String policy_updated_at) {
//		this.policy_updated_at = policy_updated_at;
//	}
//
//	public String getLast_enrolled_at() {
//		return last_enrolled_at;
//	}
//
//	public void setLast_enrolled_at(String last_enrolled_at) {
//		this.last_enrolled_at = last_enrolled_at;
//	}
//
//	public String getSeen_time() {
//		return seen_time;
//	}
//
//	public void setSeen_time(String seen_time) {
//		this.seen_time = seen_time;
//	}
//
//	public boolean isRefetch_requested() {
//		return refetch_requested;
//	}
//
//	public void setRefetch_requested(boolean refetch_requested) {
//		this.refetch_requested = refetch_requested;
//	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOsquery_version() {
		return osquery_version;
	}

	public void setOsquery_version(String osquery_version) {
		this.osquery_version = osquery_version;
	}

	public String getOs_version() {
		return os_version;
	}

	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getPlatform_like() {
		return platform_like;
	}

	public void setPlatform_like(String platform_like) {
		this.platform_like = platform_like;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public long getUptime() {
		return uptime;
	}

	public void setUptime(long uptime) {
		this.uptime = uptime;
	}

	public long getMemory() {
		return memory;
	}

	public void setMemory(long memory) {
		this.memory = memory;
	}

	public String getCpu_type() {
		return cpu_type;
	}

	public void setCpu_type(String cpu_type) {
		this.cpu_type = cpu_type;
	}

	public String getCpu_subtype() {
		return cpu_subtype;
	}

	public void setCpu_subtype(String cpu_subtype) {
		this.cpu_subtype = cpu_subtype;
	}

	public String getCpu_brand() {
		return cpu_brand;
	}

	public void setCpu_brand(String cpu_brand) {
		this.cpu_brand = cpu_brand;
	}

	public int getCpu_physical_cores() {
		return cpu_physical_cores;
	}

	public void setCpu_physical_cores(int cpu_physical_cores) {
		this.cpu_physical_cores = cpu_physical_cores;
	}

	public int getCpu_logical_cores() {
		return cpu_logical_cores;
	}

	public void setCpu_logical_cores(int cpu_logical_cores) {
		this.cpu_logical_cores = cpu_logical_cores;
	}

	public String getHardware_vendor() {
		return hardware_vendor;
	}

	public void setHardware_vendor(String hardware_vendor) {
		this.hardware_vendor = hardware_vendor;
	}

	public String getHardware_model() {
		return hardware_model;
	}

	public void setHardware_model(String hardware_model) {
		this.hardware_model = hardware_model;
	}

	public String getHardware_version() {
		return hardware_version;
	}

	public void setHardware_version(String hardware_version) {
		this.hardware_version = hardware_version;
	}

	public String getHardware_serial() {
		return hardware_serial;
	}

	public void setHardware_serial(String hardware_serial) {
		this.hardware_serial = hardware_serial;
	}

	public String getComputer_name() {
		return computer_name;
	}

	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}

	public String getPublic_ip() {
		return public_ip;
	}

	public void setPublic_ip(String public_ip) {
		this.public_ip = public_ip;
	}

	public String getPrimary_ip() {
		return primary_ip;
	}

	public void setPrimary_ip(String primary_ip) {
		this.primary_ip = primary_ip;
	}

	public String getPrimary_mac() {
		return primary_mac;
	}

	public void setPrimary_mac(String primary_mac) {
		this.primary_mac = primary_mac;
	}

	public int getDistributed_interval() {
		return distributed_interval;
	}

	public void setDistributed_interval(int distributed_interval) {
		this.distributed_interval = distributed_interval;
	}

	public int getConfig_tls_refresh() {
		return config_tls_refresh;
	}

	public void setConfig_tls_refresh(int config_tls_refresh) {
		this.config_tls_refresh = config_tls_refresh;
	}

	public int getLogger_tls_period() {
		return logger_tls_period;
	}

	public void setLogger_tls_period(int logger_tls_period) {
		this.logger_tls_period = logger_tls_period;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public double getGigs_disk_space_available() {
		return gigs_disk_space_available;
	}

	public void setGigs_disk_space_available(double gigs_disk_space_available) {
		this.gigs_disk_space_available = gigs_disk_space_available;
	}

	public int getPercent_disk_space_available() {
		return percent_disk_space_available;
	}

	public void setPercent_disk_space_available(int percent_disk_space_available) {
		this.percent_disk_space_available = percent_disk_space_available;
	}

	public Issues getIssues() {
		return issues;
	}

	public void setIssues(Issues issues) {
		this.issues = issues;
	}

	public Mdm getMdm() {
		return mdm;
	}

	public void setMdm(Mdm mdm) {
		this.mdm = mdm;
	}

	public String getRefetch_critical_queries_until() {
		return refetch_critical_queries_until;
	}

	public void setRefetch_critical_queries_until(String refetch_critical_queries_until) {
		this.refetch_critical_queries_until = refetch_critical_queries_until;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplay_text() {
		return display_text;
	}

	public void setDisplay_text(String display_text) {
		this.display_text = display_text;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}
