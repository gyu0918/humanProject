package carManagerProject;

public class RepairHistory {
    private String repairDate;
    private String repairContent;
    private String repairCarNumber;

    public String getRepairCarNumber() {
        return repairCarNumber;
    }

    public void setRepairCarNumber(String repairCarNumber) {
        this.repairCarNumber = repairCarNumber;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }
}
