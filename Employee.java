import java.util.*;
/**
 * 描述员工信息的类
 * @version 1.11 2018-06-27
 * @author Jiamin Pan
 */
public class Employee {
    private String Eid;
    private String Ename;
    private String Dname;
    private int basicSalary = 0;
    private int extraSalary = 0;
    private int taxMoney;
    private Map<String, Integer> timeInfo;
    private final int heatSubsidy = 100;
    private final int moneyOfSick = 20;
    private final int moneyOfBusy = 50;
    private final int moneyOfLate = 10;
    private final int moneyOfOver = 100;
    private final double pensionRateByE = 0.08;
    private final double pensionRateByC = 0.21;
    private final double medicRateByE = 0.02;
    private final double medicRateByC = 0.09;
    private final double unempRateByE = 0.01;
    private final double unempRateByC = 0.02;
    private final double injuryRateByC = 0.005;
    private final double fertiRateByC = 0.008;
    private final double proFundRateByE = 0.08;
    private final double proFundRateByC = 0.08;
             

    public Employee(String Eid, String Ename) {
        this.setEid(Eid);
        this.setEname(Ename); 
        this.timeInfo = new HashMap<>();
        timeInfo.put("SickOffDays", 0);
        timeInfo.put("BusyOffDays", 0);
        timeInfo.put("LateDays", 0);
        timeInfo.put("OvertimeDays", 0);
    }

	/**
	 * @return the eid
	 */
	public String getEid() {
		return Eid;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return Ename;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.Ename = ename;
	}

    /**
	 * @return the dname
	 */
	public String getDname() {
		return Dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.Dname = dname;
	}

    /**
	 * @return the basicSalary
	 */
	public int getBasicSalary() {
		return basicSalary;
	}

	/**
	 * @param basicSalary the basicSalary to set
	 */
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

 	/**
	 * @return the extraSalary
	 */
	public int getExtraSalary() {
		return basicSalary;
	}

	/**
	 * @param extraSalary the extraSalary to set
	 */
	public void setExtraSalary(int extraSalary) {
		this.extraSalary = extraSalary;
    }
    
    /**
	 * @return the taxMoney
	 */
	public int getTaxMoney() {
		return taxMoney;
	}

	/**
	 * @param none
	 */
	public void setTaxMoney() {
		this.taxMoney = (int) (basicSalary * 0.05);
	}
    
    /**
     * @param days the days of sickness dayoff
     */
    public int setSickOffDays(int days) {
        if (days >= 0) {
            return this.timeInfo.replace("SickOffDays", days).intValue();
        }
    }

    /**
     * @param days the days of business dayoff
     */
    public int setBusyOffDays(int days) {
        if (days >= 0) {
            return this.timeInfo.replace("BasyOffDays", days).intValue();
        }
    }

    /**
     * @param days the days of being late
     */
    public int setLateDays(int days) {
        if (days >= 0) {
            return this.timeInfo.replace("LateDays", days).intValue();
        }
    }    

    /**
     * @param days the days of overtime days
     */
    public int setOvertimeDays(int days) {
        if (days >= 0) {
            return this.timeInfo.replace("OvertimeDays", days).intValue();
        }
    }

    /**
     * @return the money of sickoff
     */
    public int getSickOffMoney() {
        return moneyOfSick * timeInfo.get("SickOffDays").intValue();
    }

    /**
     * @return the money of business off
     */
    public int getBusyOffMoney() {
        return moneyOfBusy * timeInfo.get("BusyOffDays").intValue();
    }

    /**
     * @return the money of being late
     */
    public int getLateMoney() {
        return moneyOfLate * timeInfo.get("LateDays").intValue();
    }    

    /**
     * @return the money of overtime working
     */
    public int getOvertimeMoney() {
        return moneyOfOvertime * timeInfo.get("OvertimeDays").intValue();
    }

    /**
     * @return the money of pension insurance by employee
     */
    public int getPensionByE() {
        return (int)(this.basicSalary * pensionRateByE);
    }

    /**
     * @return the money of pension insurance by company
     */
    public int getPensionByC() {
        return (int)(this.basicSalary * pensionRateByC);
    }

    /**
     * @return the money of medical insurance by employee
     */
    public int getMedicByE() {
        return (int)(this.basicSalary * medicRateByE);
    }

    /**
     * @return the money of medical insurance by company
     */
    public int getMedicByC() {
        return (int)(this.basicSalary * medicRateByC);
    }

    /**
     * @return the money of unemployment insurance by employee
     */
    public int getUnemployByE() {
        return (int)(this.basicSalary * unempRateByE);
    }

    /**
     * @return the money of medical insurance by company
     */
    public int getUnemployByC() {
        return (int)(this.basicSalary * unempRateByC);
    }

    /**
     * @return the money of injury insurance by company
     */
    public int getInjuryByC() {
        return (int)(this.basicSalary * injuryRateByC);
    }

    /**
     * @return the money of fertility insurance by company
     */
    public int getFertiByC() {
        return (int)(this.basicSalary * fertiRateByC);
    }

    /**
     * @return the money of house provident fund by employee
     */
    public int getProFundByE() {
        return (int)(this.basicSalary * proFundRateByE);
    }

    /**
     * @return the money of house provident fund by company
     */
    public int getProFundByC() {
        return (int)(this.basicSalary * proFundRateByC);
    }

    /**
     * @return the money of salary in total
     */
    public int getSalary() {
        int income = this.basicSalary + this.extraSalary + this.heatSubsidy
            + getOvertimeMoney();
        int outcome_1 = getSickOffMoney() + getBusyOffMoney() + getLateMoney();
        int outcome_2 = getPensionByE() + getMedicByE() + getUnemployByE()
            + getProFundByE();
        return income - outcome_1 - outcome_2 - this.taxMoney;
    }
}