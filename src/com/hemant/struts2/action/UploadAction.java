package com.hemant.struts2.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.hemant.struts2.util.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport implements ServletContextAware {

	private static final long serialVersionUID = 1L;

	private ServletContext context;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String filesPath;

	/**
	 * The three variables that are set by fileUpload and params interceptors are
	 * File, file name and content type. If the file element name in request is
	 * “pic” then these variables should be – File pic, String picContentType and
	 * String picFileName. Since our uploadFile.jsp file element name is “file”, we
	 * have variables file, fileFileName and fileContentType with their getter and
	 * setters.
	 * 
	 */
	
	@Override
	public String execute(){
		System.out.println("File Name is:"+ getFileFileName());
		System.out.println("File ContentType is:"+ getFileContentType());
		System.out.println("Files Directory is:"+ filesPath);
		try {
			FileUtil.saveFile(getFile(), getFileFileName(), context.getRealPath("") + File.separator + filesPath);
		} catch (IOException e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
		
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.setContext(context);
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}
}
