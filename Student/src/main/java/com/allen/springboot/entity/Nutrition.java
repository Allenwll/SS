package com.allen.springboot.entity;

import java.util.Date;

public class Nutrition {
	 private Long nid;          // 编号         输入框只读

	    private String sportname;     // 运动员账号     文本

	    private Date testdate;        //测试日期     日期

	    private String teachername;    // 教练账号     文本

	    private Float height;

	    private Float weight;

	    private Float emptyweight;

	    private Float rightarmFat;

	    private Float rightFat;

	    private Float bellyfat;

	    private Float bodyfatpercent;

	    private Float fat;

	    private Float leanweight;

	    private Float bodyMoisture;

	    private Float bMI;

	    private Float bMD;

	    private Float boneMineralContent;

	    private String conclusion;

	    public Long getNid() {
	        return nid;
	    }

	    public void setNid(Long nid) {
	        this.nid = nid;
	    }

	    public String getSportname() {
	        return sportname;
	    }

	    public void setSportname(String sportname) {
	        this.sportname = sportname;
	    }

	    public Date getTestdate() {
	        return testdate;
	    }

	    public void setTestdate(Date testdate) {
	        this.testdate = testdate;
	    }

	    public String getTeachername() {
	        return teachername;
	    }

	    public void setTeachername(String teachername) {
	        this.teachername = teachername;
	    }

	    public Float getHeight() {
	        return height;
	    }

	    public void setHeight(Float height) {
	        this.height = height;
	    }

	    public Float getWeight() {
	        return weight;
	    }

	    public void setWeight(Float weight) {
	        this.weight = weight;
	    }

	    public Float getEmptyweight() {
	        return emptyweight;
	    }

	    public void setEmptyweight(Float emptyweight) {
	        this.emptyweight = emptyweight;
	    }

	    public Float getRightarmFat() {
	        return rightarmFat;
	    }

	   

	    public Float getBellyfat() {
	        return bellyfat;
	    }

	    public void setBellyfat(Float bellyfat) {
	        this.bellyfat = bellyfat;
	    }

		public Float getRightFat() {
			return rightFat;
		}

		public void setRightFat(Float rightFat) {
			this.rightFat = rightFat;
		}

		
		public void setRightarmFat(Float rightarmFat) {
			this.rightarmFat = rightarmFat;
		}

		public Float getBodyfatpercent() {
			return bodyfatpercent;
		}

		public void setBodyfatpercent(Float bodyfatpercent) {
			this.bodyfatpercent = bodyfatpercent;
		}

		public Float getFat() {
			return fat;
		}

		public void setFat(Float fat) {
			this.fat = fat;
		}

		public Float getLeanweight() {
			return leanweight;
		}

		public void setLeanweight(Float leanweight) {
			this.leanweight = leanweight;
		}

		public Float getBodyMoisture() {
			return bodyMoisture;
		}

		public void setBodyMoisture(Float bodyMoisture) {
			this.bodyMoisture = bodyMoisture;
		}

		public Float getbMI() {
			return bMI;
		}

		public void setbMI(Float bMI) {
			this.bMI = bMI;
		}

		public Float getbMD() {
			return bMD;
		}

		public void setbMD(Float bMD) {
			this.bMD = bMD;
		}

		public Float getBoneMineralContent() {
			return boneMineralContent;
		}

		public void setBoneMineralContent(Float boneMineralContent) {
			this.boneMineralContent = boneMineralContent;
		}

		public String getConclusion() {
			return conclusion;
		}

		public void setConclusion(String conclusion) {
			this.conclusion = conclusion;
		}
	
	public Nutrition() {
	}
	
	public Nutrition(final Long nid, final String sportname, final Date testdate, final String teachername, final Float height, final Float weight, final Float emptyweight,
		final Float rightarmFat, final Float rightFat, final Float bellyfat, final Float bodyfatpercent, final Float fat, final Float leanweight, final Float bodyMoisture,
		final Float bMI, final Float bMD, final Float boneMineralContent, final String conclusion) {
		this.nid = nid;
		this.sportname = sportname;
		this.testdate = testdate;
		this.teachername = teachername;
		this.height = height;
		this.weight = weight;
		this.emptyweight = emptyweight;
		this.rightarmFat = rightarmFat;
		this.rightFat = rightFat;
		this.bellyfat = bellyfat;
		this.bodyfatpercent = bodyfatpercent;
		this.fat = fat;
		this.leanweight = leanweight;
		this.bodyMoisture = bodyMoisture;
		this.bMI = bMI;
		this.bMD = bMD;
		this.boneMineralContent = boneMineralContent;
		this.conclusion = conclusion;
	}
	
	@Override
		public String toString() {
			return "Nutrition [nid=" + nid + ", sportname=" + sportname + ", testdate=" + testdate
					+ ", teachername=" + teachername + ", height=" + height + ", weight=" + weight
					+ ", emptyweight=" + emptyweight + ", rightarmFat=" + rightarmFat
					+ ", rightFat=" + rightFat + ", bellyfat=" + bellyfat + ", bodyfatpercent="
					+ bodyfatpercent + ", fat=" + fat + ", leanweight=" + leanweight
					+ ", bodyMoisture=" + bodyMoisture + ", bMI=" + bMI + ", bMD=" + bMD
					+ ", boneMineralContent=" + boneMineralContent + ", conclusion=" + conclusion
					+ "]";
		}
		
		

}