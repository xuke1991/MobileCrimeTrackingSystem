package com.amaker.util;

public class FormFile {
	/* Data */
	private byte[] data;
	/* Name */
	private String filname;
	/* Formname */
	private String formname;
	/* Type*/
	private String contentType = "application/octet-stream"; 

	public FormFile(String filname, byte[] data, String formname,
			String contentType) {
		this.data = data;
		this.filname = filname;
		this.formname = formname;
		if (contentType != null)
			this.contentType = contentType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFilname() {
		return filname;
	}

	public void setFilname(String filname) {
		this.filname = filname;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
