package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.RateDAO;
import entity.RateDetail;
import entity.RateDetailProdItem;

public class MinRateCompare extends Thread{
	
	public static void main(String[] args) {
		RateDAO rateDAO=new RateDAO();
		List<RateDetail> dataList=new ArrayList<RateDetail>();
		try {
			dataList=rateDAO.queryRateDetail();
		} catch (SQLException e1) {
			System.out.println("获取产品费率连接表错误");
		}
		System.out.println(dataList.size());
		List<RateDetail> list1=new ArrayList<RateDetail>();
		List<RateDetail> list2=new ArrayList<RateDetail>();
		List<RateDetail> list3=new ArrayList<RateDetail>();
		List<RateDetail> list4=new ArrayList<RateDetail>();
		List<RateDetail> list5=new ArrayList<RateDetail>();
		List<RateDetail> list6=new ArrayList<RateDetail>();
		List<RateDetail> list7=new ArrayList<RateDetail>();
		List<RateDetail> list8=new ArrayList<RateDetail>();
		List<RateDetail> list9=new ArrayList<RateDetail>();
		List<RateDetail> list10=new ArrayList<RateDetail>();
		for(int i=0;i<dataList.size();i++){
			long n=dataList.get(i).getA_prod_id();
			if(n%10==0){
				list1.add(dataList.get(i));
			}else if(n%10==1){
				list2.add(dataList.get(i));
			}else if(n%10==2){
				list3.add(dataList.get(i));
			}else if(n%10==3){
				list4.add(dataList.get(i));
			}else if(n%10==4){
				list5.add(dataList.get(i));
			}else if(n%10==5){
				list6.add(dataList.get(i));
			}else if(n%10==6){
				list7.add(dataList.get(i));
			}else if(n%10==7){
				list8.add(dataList.get(i));
			}else if(n%10==8){
				list9.add(dataList.get(i));
			}else if(n%10==9){
				list10.add(dataList.get(i));
			}
		}
		Thread thread1 = new MinRateCompare(list1); 
		Thread thread2 = new MinRateCompare(list2);
		Thread thread3 = new MinRateCompare(list3);
		Thread thread4 = new MinRateCompare(list4);
		Thread thread5 = new MinRateCompare(list5);
		Thread thread6 = new MinRateCompare(list6); 
		Thread thread7 = new MinRateCompare(list7);
		Thread thread8 = new MinRateCompare(list8);
		Thread thread9 = new MinRateCompare(list9);
		Thread thread10 = new MinRateCompare(list10);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		
	}

	
	public MinRateCompare(List<RateDetail> dataLists) {
		super();
		this.dataLists = dataLists;
	}

	private List<RateDetail> dataLists=new ArrayList<RateDetail>();
	
	
	
	
	
	public void run(){
		RateDAO rateDAO=new RateDAO();
		List<RateDetail> prodList=new ArrayList<RateDetail>();
		List<RateDetail> itemList=new ArrayList<RateDetail>();
		boolean usual=false;
		int prod_id=dataLists.get(0).getA_prod_id();
		for(int i=0;i<dataLists.size();i++){
						
			if(prod_id==dataLists.get(i).getA_prod_id())//选出相同的产品
			{
				prodList.add(dataLists.get(i));
			}
			if(dataLists.size()==i+1 || prod_id!=dataLists.get(i).getA_prod_id()){//当取到另一产品时，更新prod_id，并将前一产品的费率进行比较
				prod_id=dataLists.get(i).getA_prod_id();
				if(i>0 && i!=dataLists.size()-1)
					i--;
				if(prod_id!=prodList.get(0).getA_prod_id() && i==dataLists.size()-1)
					i--;
				int tmp_minrate=99999;
				String minrate="";
				int tmp_rateval=-1;
				int tmp_cycleunit=-1;
				
				String tmp_desc="";
					
				int tmp_free_minrate=99999;
				String free_minrate="";
				int tmp_free_rateval=-1;
				int tmp_free_cycleunit=-1;
					
				int tmp_busy_minrate=99999;
				String busy_minrate="";
				int tmp_busy_rateval=-1;
				int tmp_busy_cycleunit=-1;
				int tmp_start_val=-1;
				int tmp_end_val=-1;	
				String segment_val="";
				RateDetailProdItem rateMin=null;
				int item_id=prodList.get(0).getB_item_code();
				for(int j=0;j<prodList.size();j++){
					if(item_id==prodList.get(j).getB_item_code())//选出相同的科目
					{
						itemList.add(prodList.get(j));
					}
					if(prodList.size()==j+1 || item_id!=prodList.get(j).getB_item_code()){//同一科目做比较 分出是普通资费还是分时段的资费
						item_id=prodList.get(j).getB_item_code();
						if(j>0 && j!=prodList.size()-1) 
							j--;
						if(j==prodList.size()-1&&itemList.get(0).getB_item_code()!=item_id)
							j--;
						tmp_minrate=99999;
						minrate="-1";
						tmp_rateval=-1;
						tmp_cycleunit=-1;
						tmp_desc="";
						
						tmp_free_minrate=99999;
						free_minrate="-1";
						tmp_free_rateval=-1;
						tmp_free_cycleunit=-1;
						
						tmp_busy_minrate=99999;
						busy_minrate="-1";
						tmp_busy_rateval=-1;
						tmp_busy_cycleunit=-1;
						segment_val="";
						tmp_start_val=-1;
						tmp_end_val=-1;
						if(itemList.size()>1){
							for(int k=0;k<itemList.size();k++)
							{
								RateDetail rateDetail=itemList.get(k);
								if(tmp_desc.length()<3072)
									tmp_desc=tmp_desc+"<"+rateDetail.getB_rate_id()+":"+rateDetail.getSegment_id()+":"+rateDetail.getC_desc()+":"
											+rateDetail.getRate_val()+":"+rateDetail.getCycle_unit()+">,";
								
								int rate_val=rateDetail.getRate_val();
								int cycle_unit=rateDetail.getCycle_unit();
								
								if(segment_val.length()<3072)
									segment_val=segment_val+rateDetail.getA_pkg_id()+":"+rateDetail.getSegment_id()+":"+rateDetail.getStart_val()
											+":"+rateDetail.getRate_val()+"|";
								if(rateDetail.getSegment_id()==1 && rateDetail.getStart_val()==-2)//分时段费率
								{
									usual=false;
								}else if(rateDetail.getSegment_id()==1 && rateDetail.getStart_val()!=-2){
									usual=true;
								}
									
								if(usual){
									if(rateDetail.getSegment_id()>1){
										continue;
									}
									if(tmp_minrate>rate_val/cycle_unit){
										tmp_minrate=rate_val/cycle_unit;
										tmp_rateval=rate_val;
										tmp_cycleunit=cycle_unit;
										minrate=tmp_minrate+":"+tmp_rateval+"/"+tmp_cycleunit+":"+
												rateDetail.getB_rate_id();
									}
								}else{
									if(rateDetail.getSegment_id()==2){//忙时费率
										if(tmp_busy_minrate>rate_val/cycle_unit)
										{
											tmp_busy_minrate=rate_val/cycle_unit;
											tmp_busy_rateval=rate_val;
											tmp_busy_cycleunit=cycle_unit;
											tmp_start_val=rateDetail.getStart_val();
											tmp_end_val=rateDetail.getEnd_val();
											busy_minrate=tmp_busy_minrate+":"+tmp_busy_rateval+"/"+tmp_busy_cycleunit+":"+
														 rateDetail.getB_rate_id();
										}
									}else{//闲时费率
										if(tmp_free_minrate>rate_val/cycle_unit)
										{
											tmp_free_minrate=rate_val/cycle_unit;
											tmp_free_rateval=rate_val;
											tmp_free_cycleunit=cycle_unit;
											free_minrate=tmp_free_minrate+":"+tmp_free_rateval+"/"+tmp_free_cycleunit+":"+
														 rateDetail.getB_rate_id();
										}
									}
								}
							}
						}else{
							RateDetail rateDetail=itemList.get(0);
							if(tmp_desc.length()<3072)
								tmp_desc=tmp_desc+"<"+rateDetail.getB_rate_id()+":"+rateDetail.getSegment_id()+":"+rateDetail.getC_desc()+":"
										+rateDetail.getRate_val()+":"+rateDetail.getCycle_unit()+">,";
							if(segment_val.length()<3072)
								segment_val=segment_val+rateDetail.getA_pkg_id()+":"+rateDetail.getSegment_id()+":"+rateDetail.getStart_val()
										+":"+rateDetail.getRate_val()+"|";
							
							int rate_val=rateDetail.getRate_val();
							int cycle_unit=rateDetail.getCycle_unit();
							
							if(tmp_minrate>rate_val/cycle_unit){
								tmp_minrate=rate_val/cycle_unit;
								tmp_rateval=rate_val;
								tmp_cycleunit=cycle_unit;
								minrate=tmp_minrate+":"+tmp_rateval+"/"+tmp_cycleunit+":"+
										rateDetail.getB_rate_id();
							}
						}
						rateMin=new RateDetailProdItem(-1,-1,"-1",-1,-1,"-1",-1,-1,"-1",-1,-1,"-1","-1",-1,-1);
						rateMin.setA_prod_id(itemList.get(0).getA_prod_id());
						rateMin.setB_item_code(itemList.get(0).getB_item_code());
						rateMin.setMinrate(minrate);
						rateMin.setRate_val(tmp_rateval);
						rateMin.setCycle_unit(tmp_cycleunit);
						
						rateMin.setFree_minrate(free_minrate);
						rateMin.setFree_rate_val(tmp_free_rateval);
						rateMin.setFree_cycle_unit(tmp_free_cycleunit);
						
						rateMin.setBusy_minrate(busy_minrate);
						rateMin.setBusy_rate_val(tmp_busy_rateval);
						rateMin.setBusy_cycle_unit(tmp_busy_cycleunit);
						rateMin.setSegment_val(segment_val);
						rateMin.setAll_desc(tmp_desc);
						rateMin.setStart_val(tmp_start_val);
						rateMin.setEnd_val(tmp_end_val);
						//update
						try {
							rateDAO.updateRateDetailInProd(rateMin);
						} catch (SQLException e) {
							System.out.println("更新错误");;
						}
						itemList.clear();
					}
				}
				prodList.clear();
			}
		}
		
		List<RateDetailProdItem> needList =new ArrayList<RateDetailProdItem>();
		try {
			needList=rateDAO.queryRateDetailInProd();
			for(int i=0;i<needList.size();i++){
				rateDAO.insertRateDetailInProd(needList.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
