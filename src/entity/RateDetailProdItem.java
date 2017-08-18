package entity;

public class RateDetailProdItem {
	private int a_prod_id;
	private int b_item_code;
	private int seg_id;
	private String minrate;
	private int rate_val;
	private int cycle_unit;
	private String free_minrate;
	private int free_rate_val;
	private int free_cycle_unit;
	private String busy_minrate;
	private int busy_rate_val;
	private int busy_cycle_unit;
	private String segment_val;
	private String all_desc;
	private int start_val;
	private int end_val;
	
	public int getA_prod_id() {
		return a_prod_id;
	}


	public void setA_prod_id(int a_prod_id) {
		this.a_prod_id = a_prod_id;
	}


	public int getB_item_code() {
		return b_item_code;
	}


	public void setB_item_code(int b_item_code) {
		this.b_item_code = b_item_code;
	}

	
	public int getSeg_id() {
		return seg_id;
	}


	public void setSeg_id(int seg_id) {
		this.seg_id = seg_id;
	}


	public String getMinrate() {
		return minrate;
	}


	public void setMinrate(String minrate) {
		this.minrate = minrate;
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


	public String getFree_minrate() {
		return free_minrate;
	}


	public void setFree_minrate(String free_minrate) {
		this.free_minrate = free_minrate;
	}


	public int getFree_rate_val() {
		return free_rate_val;
	}


	public void setFree_rate_val(int free_rate_val) {
		this.free_rate_val = free_rate_val;
	}


	public int getFree_cycle_unit() {
		return free_cycle_unit;
	}


	public void setFree_cycle_unit(int free_cycle_unit) {
		this.free_cycle_unit = free_cycle_unit;
	}


	public String getBusy_minrate() {
		return busy_minrate;
	}


	public void setBusy_minrate(String busy_minrate) {
		this.busy_minrate = busy_minrate;
	}


	public int getBusy_rate_val() {
		return busy_rate_val;
	}


	public void setBusy_rate_val(int busy_rate_val) {
		this.busy_rate_val = busy_rate_val;
	}


	public int getBusy_cycle_unit() {
		return busy_cycle_unit;
	}


	public void setBusy_cycle_unit(int busy_cycle_unit) {
		this.busy_cycle_unit = busy_cycle_unit;
	}


	public String getSegment_val() {
		return segment_val;
	}


	public void setSegment_val(String segment_val) {
		this.segment_val = segment_val;
	}


	public String getAll_desc() {
		return all_desc;
	}


	public void setAll_desc(String all_desc) {
		this.all_desc = all_desc;
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

	
	public RateDetailProdItem(int a_prod_id, int b_item_code, int seg_id, String minrate, int rate_val, int cycle_unit,
			String free_minrate, int free_rate_val, int free_cycle_unit, String busy_minrate, int busy_rate_val,
			int busy_cycle_unit, String segment_val, String all_desc, int start_val, int end_val) {
		super();
		this.a_prod_id = a_prod_id;
		this.b_item_code = b_item_code;
		this.seg_id = seg_id;
		this.minrate = minrate;
		this.rate_val = rate_val;
		this.cycle_unit = cycle_unit;
		this.free_minrate = free_minrate;
		this.free_rate_val = free_rate_val;
		this.free_cycle_unit = free_cycle_unit;
		this.busy_minrate = busy_minrate;
		this.busy_rate_val = busy_rate_val;
		this.busy_cycle_unit = busy_cycle_unit;
		this.segment_val = segment_val;
		this.all_desc = all_desc;
		this.start_val = start_val;
		this.end_val = end_val;
	}


	public RateDetailProdItem(int a_prod_id, int b_item_code, String minrate, int rate_val, int cycle_unit,
			String free_minrate, int free_rate_val, int free_cycle_unit, String busy_minrate, int busy_rate_val,
			int busy_cycle_unit, String segment_val, String all_desc, int start_val, int end_val) {
		super();
		this.a_prod_id = a_prod_id;
		this.b_item_code = b_item_code;
		this.minrate = minrate;
		this.rate_val = rate_val;
		this.cycle_unit = cycle_unit;
		this.free_minrate = free_minrate;
		this.free_rate_val = free_rate_val;
		this.free_cycle_unit = free_cycle_unit;
		this.busy_minrate = busy_minrate;
		this.busy_rate_val = busy_rate_val;
		this.busy_cycle_unit = busy_cycle_unit;
		this.segment_val = segment_val;
		this.all_desc = all_desc;
		this.start_val = start_val;
		this.end_val = end_val;
	}


	public RateDetailProdItem() {
	}
	
	
	
	
}
