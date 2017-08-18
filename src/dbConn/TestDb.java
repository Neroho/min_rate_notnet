package dbConn;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.RateDetail;
import entity.RateDetailProdItem;

import service.RateDAO;

public class TestDb {

	@Test
	public void testDbb() throws Exception {
		RateDAO rateDAO=new RateDAO();
		List<RateDetailProdItem> needList =new ArrayList<RateDetailProdItem>();
		try {
			needList=rateDAO.queryRateDetailInProd();
			System.out.println(needList.size());
			for(int i=0;i<needList.size();i++){
				rateDAO.insertRateDetailInProd(needList.get(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
