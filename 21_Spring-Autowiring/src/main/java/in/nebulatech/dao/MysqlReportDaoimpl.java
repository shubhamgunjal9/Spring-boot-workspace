package in.nebulatech.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("mysql")
@Primary
public class MysqlReportDaoimpl implements ReportDao {
	
	public MysqlReportDaoimpl()
	{
		System.out.println("MysqlReportDaoimpl :: constructor");
	}

	@Override
	public String findData() {
		System.out.println("fetching report from mysql db.....");
		return "report data....";
	}

}
