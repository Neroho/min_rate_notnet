package entity;

import java.util.Date;

public class RateDetail {
	private int a_prod_id;			
	private int a_pkg_id;	
	private int b_rate_id;
	private int b_item_code;
	private int c_rate_id;
	private int c_curve_id;
	private String c_desc;
	private long row_id;
	private int curve_id;		
	private int segment_id;	
	private int start_val;
	private int end_val;
	private int base_val;
	private int rate_val;	
	private int cycle_unit;
	private int tail_unit;
	private int tail_round;
	private int tail_rate;			
	private String description;
	private Date modify_date;	
	private int calc_type;
	private int formula_id;
	private int share_num;	
	private int tail_precision;	
	private Date create_date;
	private String del_flag;		
	private int creater;		
	private int modifier;
	public int getA_prod_id() {
		return a_prod_id;
	}
	public void setA_prod_id(int a_prod_id) {
		this.a_prod_id = a_prod_id;
	}
	public int getA_pkg_id() {
		return a_pkg_id;
	}
	public void setA_pkg_id(int a_pkg_id) {
		this.a_pkg_id = a_pkg_id;
	}
	public int getB_rate_id() {
		return b_rate_id;
	}
	public void setB_rate_id(int b_rate_id) {
		this.b_rate_id = b_rate_id;
	}
	public int getB_item_code() {
		return b_item_code;
	}
	public void setB_item_code(int b_item_code) {
		this.b_item_code = b_item_code;
	}
	public int getC_rate_id() {
		return c_rate_id;
	}
	public void setC_rate_id(int c_rate_id) {
		this.c_rate_id = c_rate_id;
	}
	public int getC_curve_id() {
		return c_curve_id;
	}
	public void setC_curve_id(int c_curve_id) {
		this.c_curve_id = c_curve_id;
	}
	public String getC_desc() {
		return c_desc;
	}
	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	public long getRow_id() {
		return row_id;
	}
	public void setRow_id(long row_id) {
		this.row_id = row_id;
	}
	public int getCurve_id() {
		return curve_id;
	}
	public void setCurve_id(int curve_id) {
		this.curve_id = curve_id;
	}
	public int getSegment_id() {
		return segment_id;
	}
	public void setSegment_id(int segment_id) {
		this.segment_id = segment_id;
	}
	public int getStart_val() {
		return start_val;
	}
	public void setStart_val(int start_val) {
		this.start_val = start_val;
	}
	public int getEnd_val() {
		return end_val;
	}
	public void setEnd_val(int end_val) {
		this.end_val = end_val;
	}
	public int getBase_val() {
		return base_val;
	}
	public void setBase_val(int base_val) {
		this.base_val = base_val;
	}
	public int getRate_val() {
		return rate_val;
	}
	public void setRate_val(int rate_val) {
		this.rate_val = rate_val;
	}
	public int getCycle_unit() {
		return cycle_unit;
	}
	public void setCycle_unit(int cycle_unit) {
		this.cycle_unit = cycle_unit;
	}
	public int getTail_unit() {
		return tail_unit;
	}
	public void setTail_unit(int tail_unit) {
		this.tail_unit = tail_unit;
	}
	public int getTail_round() {
		return tail_round;
	}
	public void setTail_round(int tail_round) {
		this.tail_round = tail_round;
	}
	public int getTail_rate() {
		return tail_rate;
	}
	public void setTail_rate(int tail_rate) {
		this.tail_rate = tail_rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public int getCalc_type() {
		return calc_type;
	}
	public void setCalc_type(int calc_type) {
		this.calc_type = calc_type;
	}
	public int getFormula_id() {
		return formula_id;
	}
	public void setFormula_id(int formula_id) {
		this.formula_id = formula_id;
	}
	public int getShare_num() {
		return share_num;
	}
	public void setShare_num(int share_num) {
		this.share_num = share_num;
	}
	public int getTail_precision() {
		return tail_precision;
	}
	public void setTail_precision(int tail_precision) {
		this.tail_precision = tail_precision;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public int getCreater() {
		return creater;
	}
	public void setCreater(int creater) {
		this.creater = creater;
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public RateDetail(int a_prod_id, int a_pkg_id, int b_rate_id, int b_item_code, int c_rate_id, int c_curve_id,
			String c_desc, long row_id, int curve_id, int segment_id, int start_val, int end_val, int base_val,
			int rate_val, int cycle_unit, int tail_unit, int tail_round, int tail_rate, String description,
			Date modify_date, int calc_type, int formula_id, int share_num, int tail_precision, Date create_date,
			String del_flag, int creater, int modifier) {
		super();
		this.a_prod_id = a_prod_id;
		this.a_pkg_id = a_pkg_id;
		this.b_rate_id = b_rate_id;
		this.b_item_code = b_item_code;
		this.c_rate_id = c_rate_id;
		this.c_curve_id = c_curve_id;
		this.c_desc = c_desc;
		this.row_id = row_id;
		this.curve_id = curve_id;
		this.segment_id = segment_id;
		this.start_val = start_val;
		this.end_val = end_val;
		this.base_val = base_val;
		this.rate_val = rate_val;
		this.cycle_unit = cycle_unit;
		this.tail_unit = tail_unit;
		this.tail_round = tail_round;
		this.tail_rate = tail_rate;
		this.description = description;
		this.modify_date = modify_date;
		this.calc_type = calc_type;
		this.formula_id = formula_id;
		this.share_num = share_num;
		this.tail_precision = tail_precision;
		this.create_date = create_date;
		this.del_flag = del_flag;
		this.creater = creater;
		this.modifier = modifier;
	}
	
	
	
}
