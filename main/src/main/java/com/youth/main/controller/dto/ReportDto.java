package com.youth.main.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
	
	   private String productname;

	   private String report;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	   

}
