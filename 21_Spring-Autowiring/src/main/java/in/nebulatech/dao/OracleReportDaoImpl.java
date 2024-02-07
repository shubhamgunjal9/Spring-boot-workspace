package in.nebulatech.dao;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleReportDaoImpl implements ReportDao {
	
	public OracleReportDaoImpl()
	{
		System.out.println("oraclereortdaoimpl :: constructor");
	}
	
	@Override
	public String findData() {
		System.out.println("fetching report from oracle db.....");
		return "report data....";
	}

}
