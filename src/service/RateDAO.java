package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dbConn.DBConn_csm;
import dbConn.DBConn_yh;
import entity.RateDetail;
import entity.RateDetailProdItem;

public class RateDAO {
	private Connection conn_csm = null;
	private Connection conn_yh = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	public RateDAO() {
		try {
			this.conn_yh = DBConn_yh.getConnection();
			this.conn_csm = DBConn_csm.getConnection();
		} catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
		}
	}
	
	
	public List<RateDetail> queryRateDetail() throws SQLException{
		List<RateDetail> retuenList=new ArrayList<RateDetail>();
		PreparedStatement pstmt=null;
		try{
			if(conn_yh==null)
				conn_yh=DBConn_yh.getConnection();
			String sql ="select A_PROD_ID,A_PKG_ID,B_RATE_ID,B_ITEM_CODE,C_RATE_ID,C_CURVE_ID,C_DESC," +
					"ROW_ID,CURVE_ID,SEGMENT_ID,START_VAL,END_VAL,BASE_VAL,RATE_VAL,CYCLE_UNIT,TAIL_UNIT,TAIL_ROUND,TAIL_RATE," +
					"DESCRIPTION,MODIFY_date,CALC_TYPE,FORMULA_ID,SHARE_NUM,TAIL_PRECISION,CREATE_date,DEL_FLAG,CREATER,MODIFIER" +
					" from hjp_ratedetail a order by a.a_prod_id,a.a_pkg_id,a.b_item_code,a.segment_id asc";
			pstmt=conn_yh.prepareStatement(sql);
			ResultSet rs = null;  
			rs = pstmt.executeQuery();  
            while(rs.next()){  
            	retuenList.add(new RateDetail(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
            			rs.getInt(5),rs.getInt(6),rs.getString(7), rs.getLong(8),rs.getInt(9),rs.getInt(10),
            			rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),
            			rs.getInt(16),rs.getInt(17),rs.getInt(18), rs.getString(19),rs.getDate(20),rs.getInt(21),
            			rs.getInt(22),rs.getInt(23),rs.getInt(24),rs.getDate(25),rs.getString(26),
            			rs.getInt(27),rs.getInt(28)));  
            }
			return retuenList;
		}catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
			return null;
		}finally {
			if (pstmt != null){
				pstmt.close();
			}
		}
	}
	
	public List<RateDetailProdItem> queryRateDetailInProd() throws SQLException{
		List<RateDetailProdItem> retuenList=new ArrayList<RateDetailProdItem>();
		PreparedStatement pstmt=null;
		try{
			if(conn_yh==null)
				conn_yh=DBConn_yh.getConnection();
			String sql ="select * from hjp_ratedetail_prod_item a order by a.a_prod_id,a.b_item_code asc";
			pstmt=conn_yh.prepareStatement(sql);
			ResultSet rs = null;  
			rs = pstmt.executeQuery();  
            while(rs.next()){  
            	retuenList.add(new RateDetailProdItem(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),
            			rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getInt(11),
            			rs.getInt(12),rs.getString(13),rs.getString(14), rs.getInt(15), rs.getInt(16)));  
            }
			return retuenList;
		}catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
			return null;
		}finally {
			if (pstmt != null){
				pstmt.close();
			}
		}
	}
	public void updateRateDetailInProd(RateDetailProdItem data) throws SQLException{
		PreparedStatement pstmt=null;
		try{
			if(conn_yh==null)
				conn_yh=DBConn_yh.getConnection();
			String sql ="update hjp_ratedetail_prod_item set minrate=?,rate_val=?,cycle_unit=?,free_minrate=?," +
					"free_rate_val=?,free_cycle_unit=?,busy_minrate=?,busy_rate_val=?,busy_cycle_unit=?," +
					"segment_val=?,all_desc=?,start_val=?,end_val=? where a_prod_id=? and b_item_code=?";
			pstmt=conn_yh.prepareStatement(sql);
			pstmt.setString(1, data.getMinrate());
			pstmt.setInt(2, data.getRate_val());
			pstmt.setInt(3, data.getCycle_unit());
			pstmt.setString(4, data.getFree_minrate());
			pstmt.setInt(5, data.getFree_rate_val());
			pstmt.setInt(6, data.getFree_cycle_unit());
			pstmt.setString(7, data.getBusy_minrate());
			pstmt.setInt(8, data.getBusy_rate_val());
			pstmt.setInt(9, data.getBusy_cycle_unit());
			pstmt.setString(10, data.getSegment_val());
			pstmt.setString(11, data.getAll_desc());
			pstmt.setInt(12, data.getStart_val());
			pstmt.setInt(13, data.getEnd_val());
			pstmt.setInt(14, data.getA_prod_id());
			pstmt.setInt(15, data.getB_item_code());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
		}finally {
			if (pstmt != null){
				pstmt.close();
			}
		}
	}
	
	
	public void insertRateDetailInProd(RateDetailProdItem data) throws SQLException{
		PreparedStatement pstmt=null;
		try{
			if(conn_csm==null)
				conn_csm=DBConn_csm.getConnection();
			String sql ="insert into hjp_ratedetail_prod_item (a_prod_id,b_item_code,a_seg_id,minrate,rate_val,cycle_unit,free_minrate," +
					"free_rate_val,free_cycle_unit,busy_minrate,busy_rate_val,busy_cycle_unit," +
					"segment_val,all_desc,start_val,end_val) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn_csm.prepareStatement(sql);
			pstmt.setInt(1, data.getA_prod_id());
			pstmt.setInt(2, data.getB_item_code());
			pstmt.setInt(3, data.getSeg_id());
			pstmt.setString(4, data.getMinrate());
			pstmt.setInt(5, data.getRate_val());
			pstmt.setInt(6, data.getCycle_unit());
			pstmt.setString(7, data.getFree_minrate());
			pstmt.setInt(8, data.getFree_rate_val());
			pstmt.setInt(9, data.getFree_cycle_unit());
			pstmt.setString(10, data.getBusy_minrate());
			pstmt.setInt(11, data.getBusy_rate_val());
			pstmt.setInt(12, data.getBusy_cycle_unit());
			pstmt.setString(13, data.getSegment_val());
			pstmt.setString(14, data.getAll_desc());
			pstmt.setInt(15, data.getStart_val());
			pstmt.setInt(16, data.getEnd_val());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
		}finally {
			if (pstmt != null){
				pstmt.close();
			}
		}
	}
	
	public void updateTest() throws SQLException{
		PreparedStatement pstmt=null;
		try{
			if(conn_csm==null)
				conn_csm=DBConn_csm.getConnection();
			String sql ="update hjp_ratedetail_prod_item set minrate=1,rate_val=1,cycle_unit=1,free_minrate=1,free_rate_val=1,free_cycle_unit=1,busy_minrate=1,busy_rate_val=1,"+
					"busy_cycle_unit=1,segment_val=1,all_desc=1 where a_prod_id=0 and b_item_code=43025101";
			pstmt=conn_csm.prepareStatement(sql);
			
			pstmt.executeUpdate();  
		}catch (Exception e) {
			System.out.println("在DAO中获取数据库链接失败");
			e.printStackTrace();
		}finally {
			if (pstmt != null){
				pstmt.close();
			}
		}
	}
}
