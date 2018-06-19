package com.hemant.struts2.action;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.hemant.struts2.util.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UploadMultipleFileAction extends ActionSupport implements ServletContextAware {

	private static final long serialVersionUID = 1L;

	private File[] file;
	private String[] fileContentType;
	private String[] fileFileName;
	private String filesPath;
	private ServletContext context;

	@Override
	public String execute() {
		System.out.println("No of files=" + getFile().length);
		System.out.println("File Names are:" + Arrays.toString(getFileFileName()));

		for (int i = 0; i < getFile().length; i++) {
			System.out.println("File Name is:" + getFileFileName()[i]);
			System.out.println("File ContentType is:" + getFileContentType()[i]);
			System.out.println("Files Directory is:" + filesPath);
			try {
				FileUtil.saveFile(getFile()[i], getFileFileName()[i],
						context.getRealPath("") + File.separator + filesPath);
			} catch (IOException e) {
				e.printStackTrace();
				return INPUT;
			}
		}
		return SUCCESS;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

}
