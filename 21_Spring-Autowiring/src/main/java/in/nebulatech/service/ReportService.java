package in.nebulatech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import in.nebulatech.dao.ReportDao;
  
@Service
public class ReportService {
	
	private ReportDao reportDao;
	//@Autowired
	//@Qualifier("mysql")
	public ReportService(ReportDao reportDao)
	{
		System.out.println("ReportService :: parameter constructor");
		this.reportDao=reportDao;
	}
	
	public void generateReport()
	{
		reportDao.findData();
		System.out.println("generating report....");
	}
}
