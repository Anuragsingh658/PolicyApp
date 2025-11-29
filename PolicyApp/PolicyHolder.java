public class PolicyHolder {
    private String policyId;
    private String name;
    private double investAmount;
    private int yearsInForce;

    public PolicyHolder(String policyId, String name, double investAmount, int yearsInForce) {
        this.policyId = policyId;
        this.name = name;
        this.investAmount = investAmount;
        this.yearsInForce = yearsInForce;
    }

    // Getters and Setters
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(double investAmount) {
        this.investAmount = investAmount;
    }

    public int getYearsInForce() {
        return yearsInForce;
    }

    public void setYearsInForce(int yearsInForce) {
        this.yearsInForce = yearsInForce;
    }
}

