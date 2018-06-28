import java.util.*;
/**
 * 描述员工信息的类
 * @version 1.13 2018-06-28
 * @author Jiamin Pan
 */
public class Employee {
    private String employeeID;
    private String employeeName;
    private String departName;
    private int basicSalary;
    private int extraSalary;
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
             
    /**
     * constructor
     * @param employeeID employee's id
     * @param employeeName employee's name
     */
    public Employee(String employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.setEmployeeName(employeeName); 
        this.setBasicSalary(0);
        this.setExtraSalary(0);
        this.timeInfo = new HashMap<>();
        timeInfo.put("SickOffDays", 0);
        timeInfo.put("BusyOffDays", 0);
        timeInfo.put("LateDays", 0);
        timeInfo.put("OvertimeDays", 0);
    }

	/**
	 * @return the employeeID
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * @return the ename
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the ename to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

    /**
	 * @return the departName
	 */
	public String getDepartName() {
		return departName;
	}

	/**
	 * @param departName the departName to set
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
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
		return extraSalary;
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
        // 收税方法似乎应该更加复杂一些
		this.taxMoney = (int) (basicSalary * 0.05);
	}
    
    /**
     * @param days the days of sickness dayoff
     */
    public void setSickOffDays(int days) {
        Integer Days = new Integer(days);
        Integer preValue = new Integer(0);
        if (days >= 0) {
            preValue = this.timeInfo.replace("SickOffDays", Days);
        }
        else {
            // 这里应该是参数报错的部分，根据网页进行处理
            System.out.println("时间必须为正整数");
        }
    }

    /**
     * @param days the days of business dayoff
     */
    public void setBusyOffDays(int days) {
        Integer Days = new Integer(days);
        Integer preValue = new Integer(0);
        if (days >= 0) {
            preValue = this.timeInfo.replace("BasyOffDays", Days);
        }
        else {
            // 这里应该是参数报错的部分，根据网页进行处理
            System.out.println("时间必须为正整数");
        }
    }

    /**
     * @param days the days of being late
     */
    public void setLateDays(int days) {
        Integer Days = new Integer(days);
        Integer preValue = new Integer(0);
        if (days >= 0) {
            preValue = this.timeInfo.replace("LateDays", Days);
        }
        else {
            // 这里应该是参数报错的部分，根据网页进行处理
            System.out.println("时间必须为正整数");
        }
    }    

    /**
     * @param days the days of overtime days
     */
    public void setOvertimeDays(int days) {
        Integer Days = new Integer(days);
        Integer preValue = new Integer(0);
        if (days >= 0) {
            preValue = this.timeInfo.replace("OvertimeDays", Days);
        }
        else {
            // 这里应该是参数报错的部分，根据网页进行处理
            System.out.println("时间必须为正整数");
        }
    }

    /**
     * @return the days of sickoff
     */
    public int getSickOffDays() {
        return timeInfo.get("SickOffDays").intValue();
    }

    /**
     * @return the days of business off
     */
    public int getBusyOffDays() {
        return timeInfo.get("BusyOffDays").intValue();
    }

    /**
     * @return the days of being late
     */
    public int getLateDays() {
        return timeInfo.get("LateDays").intValue();
    }    

    /**
     * @return the days of overtime working
     */
    public int getOvertimeDays() {
        return timeInfo.get("OvertimeDays").intValue();
    }

    /**
     * @return the money of sickoff
     */
    public int getSickOffMoney() {
        return moneyOfSick * this.getSickOffDays();
    }

    /**
     * @return the money of business off
     */
    public int getBusyOffMoney() {
        return moneyOfBusy * this.getBusyOffDays();
    }

    /**
     * @return the money of being late
     */
    public int getLateMoney() {
        return moneyOfLate * this.getLateDays();
    }    

    /**
     * @return the money of overtime working
     */
    public int getOvertimeMoney() {
        return moneyOfOver * this.getOvertimeDays();
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
            + this.getOvertimeMoney();
        int outcome_1 = this.getSickOffMoney() + this.getBusyOffMoney() 
            + this.getLateMoney();
        int outcome_2 = this.getPensionByE() + this.getMedicByE() 
            + this.getUnemployByE() + this.getProFundByE();
        return income - outcome_1 - outcome_2 - this.taxMoney;
    }
}
